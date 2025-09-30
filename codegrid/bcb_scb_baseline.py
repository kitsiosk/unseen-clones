from tqdm import tqdm
from gensim.models import Word2Vec
from config import CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY
from config import W2V_VECTOR_DIM, NUM_WORKERS, W2V_WINDOWS_SIZE, W2V_MIN_TOKEN_LEN, NUM_EPOCHS, W2V_TRAINING_SEED
import pandas as pd
import pickle
from tqdm import tqdm
from gensim.models import Word2Vec
import torch
import torch.multiprocessing
import sys
from config import W2V_VECTOR_DIM
from config import CODE_RAW_TOKENS_KEY
from config import NUM_WORKERS
from config import NUM_EPOCHS
import pickle
from tqdm import tqdm
from gensim.models import Word2Vec
import torch
import torch.multiprocessing
from sklearn import svm
from sklearn.metrics import precision_recall_fscore_support
import sys
from config import W2V_VECTOR_DIM
from config import W2V_TRAINING_SEED, NUM_WORKERS
from config import NUM_EPOCHS
from models import CodeGridClassificationModel
import torch
import torch.nn as nn
import os
import argparse
sys.path.append('../utilities')
from bcb_utilities import get_functionality_data
from utilities_baseline import beautify_and_tokenize_code, process_embedding_core, get_X_y
from scb_utilities import get_data_scb

# Required command line argument `train_on` with possible values "BCB" or "SCB":
# Controls whether we run the `train-bcb-test-scb`` or the `train-scb-test-bcb` experiment
parser = argparse.ArgumentParser(description='CodeGrid baseline')
parser.add_argument('-t', '--train_on', type=str, help='Which dataset to use for training, "BCB" or "SCB"')
args = parser.parse_args()
train_on = args.train_on
print("Training on %s" % train_on)

grid_method = 'word2vec'
cache_dir   = 'data/'    
tqdm.pandas()
torch.multiprocessing.set_sharing_strategy('file_system')
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

### Load BCB data
data_bcb = get_functionality_data()
print("Total dataset length (incl. all functionalities): %d" % len(data_bcb))

### Tokenize data
fname_tokenized = cache_dir + "data_bcb_v2_sampled_bf_tokenized.pickle"
if os.path.isfile(fname_tokenized):
    data_bcb = pd.read_pickle(fname_tokenized)
    print("Loaded tokenized pairs from cache")
else:
    data_bcb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"1"]] = data_bcb.progress_apply(lambda row: beautify_and_tokenize_code(row['code1']), axis=1, result_type='expand')
    data_bcb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"2"]] = data_bcb.progress_apply(lambda row: beautify_and_tokenize_code(row['code2']), axis=1, result_type='expand')
    data_bcb.to_pickle(fname_tokenized)

### Get SCB data
data_scb = get_data_scb()
fname_tokenized_scb = cache_dir + "data_scb_tokenized.pickle"
if os.path.isfile(fname_tokenized_scb):
    data_scb = pd.read_pickle(fname_tokenized_scb)
    print("loaded SCB data with features from cache")
else:
    data_scb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"1"]] = data_scb.progress_apply(lambda row: beautify_and_tokenize_code(row['code1']), axis=1, result_type='expand')
    data_scb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"2"]] = data_scb.progress_apply(lambda row: beautify_and_tokenize_code(row['code2']), axis=1, result_type='expand')
    data_scb.to_pickle(fname_tokenized_scb)

### Get embeddings model and dimensions of embeddings
dim = W2V_VECTOR_DIM
w2v_model_path = cache_dir + 'word2vec_bcb_v2_sampled_bf_and_scb.bin'
if os.path.isfile(w2v_model_path):
    print("Loading Word2Vec model from cache...")
    token_embeddings_model = Word2Vec.load(w2v_model_path)
else:
    task_data1 = data_bcb[CODE_RAW_TOKENS_KEY+"1"].tolist()
    task_data2 = data_bcb[CODE_RAW_TOKENS_KEY+"2"].tolist()
    task_data3 = data_scb[CODE_RAW_TOKENS_KEY+"1"].tolist()
    task_data4 = data_scb[CODE_RAW_TOKENS_KEY+"2"].tolist()
    task_data  = task_data1 + task_data2 + task_data3 + task_data4
    
    print("Training Word2Vec model...")
    token_embeddings_model = Word2Vec(sentences=task_data, vector_size=dim, window=W2V_WINDOWS_SIZE, min_count=W2V_MIN_TOKEN_LEN, workers=NUM_WORKERS, seed=W2V_TRAINING_SEED, epochs=NUM_EPOCHS)
    token_embeddings_model.save(w2v_model_path)
sys.stdout.flush()

# Initialize CodeGrid model
model = CodeGridClassificationModel(dim, num_classes=1)
# Remove last layer
model = nn.Sequential(*list(model.children())[:-1])
if torch.cuda.is_available():
    model = torch.nn.DataParallel(model)
    model = model.to(device)

### Extract features
fname_features = cache_dir + "data_bcb_v2_sampled_bf_features_with_scb_word2vec_baseline.pickle"
if os.path.isfile(fname_features):
    data_bcb = pd.read_pickle(fname_features)
    print("Loaded pairs with features from cache")
else:
    data_bcb['feature'] = data_bcb.progress_apply(lambda row: process_embedding_core(row['code_raw_tokens1'], row['code_raw_tokens2'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_bcb.to_pickle(fname_features)

fname_features_scb = cache_dir + "data_scb_features_with_bcb_v2_sampled_bf_word2vec_baseline.pickle"
if os.path.isfile(fname_features_scb):
    data_scb = pd.read_pickle(fname_features_scb)
    print("loaded SCB data with features from cache")
else:
    data_scb['feature'] = data_scb.progress_apply(lambda row: process_embedding_core(row['code_raw_tokens1'], row['code_raw_tokens2'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_scb.to_pickle(fname_features_scb)

if train_on == "bcb":
    X_train, y_train = get_X_y(data_bcb)
    X_test , y_test  = get_X_y(data_scb)
else:
    X_train, y_train = get_X_y(data_scb)
    X_test , y_test  = get_X_y(data_bcb)

kernel = 'rbf' # 'linear'
clf    = svm.SVC(kernel=kernel)
clf.fit(X_train, y_train)
y_pred = clf.predict(X_test)
precision, recall, f1, _ = precision_recall_fscore_support(y_test, y_pred, average='binary')
acc = sum(y_pred==y_test)/len(y_pred)
print("Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f" % (acc, f1, precision, recall))