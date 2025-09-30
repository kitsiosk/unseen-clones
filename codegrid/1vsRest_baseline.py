from tqdm import tqdm
from gensim.models import Word2Vec
from config import CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY
from config import W2V_VECTOR_DIM, NUM_WORKERS, W2V_WINDOWS_SIZE, W2V_MIN_TOKEN_LEN, NUM_EPOCHS, W2V_TRAINING_SEED
import time
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
sys.path.append('../utilities')
from bcb_utilities import get_functionality_data
from utilities_baseline import beautify_and_tokenize_code, process_embedding_core, get_X_y

grid_method = 'word2vec'
cache_dir   = 'data/'    

tqdm.pandas()
torch.multiprocessing.set_sharing_strategy('file_system')
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

### Load BCB data
data_bcb = get_functionality_data()
print("Total dataset length (incl. all functionalities): %d" % len(data_bcb))
sys.stdout.flush()

### Tokenize data
fname_tokenized = cache_dir + "data_bcb_v2_sampled_bf_tokenized.pickle"
if os.path.isfile(fname_tokenized):
    data_bcb = pd.read_pickle(fname_tokenized)
    print("Loaded tokenized pairs from cache")
else:
    data_bcb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"1"]] = data_bcb.progress_apply(lambda row: beautify_and_tokenize_code(row['code1']), axis=1, result_type='expand')
    data_bcb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"2"]] = data_bcb.progress_apply(lambda row: beautify_and_tokenize_code(row['code2']), axis=1, result_type='expand')
    data_bcb.to_pickle(fname_tokenized)

### Get embeddings model and dimensions of embeddings
dim = W2V_VECTOR_DIM
w2v_model_path = cache_dir + 'word2vec_bcb_v2_sampled_bf.bin'
if os.path.isfile(w2v_model_path):
    token_embeddings_model = Word2Vec.load(w2v_model_path)
    print("Loaded Word2Vec model from cache")
else:
    task_data1 = data_bcb[CODE_RAW_TOKENS_KEY+"1"].tolist()
    task_data2 = data_bcb[CODE_RAW_TOKENS_KEY+"2"].tolist()
    task_data  = task_data1 + task_data2
    
    print("Training Word2Vec model...")
    token_embeddings_model = Word2Vec(sentences=task_data, vector_size=dim, window=W2V_WINDOWS_SIZE, min_count=W2V_MIN_TOKEN_LEN, workers=NUM_WORKERS, seed=W2V_TRAINING_SEED, epochs=NUM_EPOCHS)
    token_embeddings_model.save(w2v_model_path)

# Initialize CodeGrid model
model = CodeGridClassificationModel(dim, num_classes=1)
# Remove last layer
model = nn.Sequential(*list(model.children())[:-1])
if torch.cuda.is_available():
    model = torch.nn.DataParallel(model)
    model = model.to(device)

### Extract features
fname_features = cache_dir + "data_bcb_v2_sampled_bf_features_baseline.pickle"
if os.path.isfile(fname_features):
    data_bcb = pd.read_pickle(fname_features)
    print("Loaded pairs with features from cache")
else:
    data_bcb['feature'] = data_bcb.progress_apply(lambda row: process_embedding_core(row['code_raw_tokens1'], row['code_raw_tokens2'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_bcb.to_pickle(fname_features)

### Training loop
functionality_ids = data_bcb['functionality_id'].unique().tolist()
functionality_ids.sort()

# Dict to keep track of results
result = {'fcn_id':[], 'f1':[], 'p':[], 'r':[], 'a':[], 'test_size':[]}
time_now = time.strftime("%Y%m%d-%H%M%S")
for ii in functionality_ids:
    print("[%d] Starting" % ii)
    sys.stdout.flush()

    ### Training
    data_train = data_bcb[data_bcb['functionality_id'] != ii]
    data_test =  data_bcb[data_bcb['functionality_id'] == ii]
    print("Train length %d" % len(data_train))
    print("Test length %d" % len(data_test))
    X_train, y_train = get_X_y(data_train)
    X_test,  y_test  = get_X_y(data_test)
    print("%0.2f %% is 1s in y_train" % (sum(y_train)/len(y_train)))
    print("%0.2f %% is 1s in y_test" % (sum(y_test)/len(y_test)))
    sys.stdout.flush()
    # Train a SVM classifier with rbf kernel which performed better in the CodeGrid paper
    kernel = 'rbf'
    clf    = svm.SVC(kernel=kernel, class_weight='balanced')
    clf.fit(X_train, y_train)
    
    ### Evaluation
    y_pred      = clf.predict(X_test)
    P, R, F1, _ = precision_recall_fscore_support(y_test, y_pred, average='binary')
    acc         = sum(y_pred==y_test)/len(y_pred)
    print("Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f" % (acc, F1, P, R))
    sys.stdout.flush()

    result['fcn_id'].append(ii)
    result['f1'].append(F1)
    result['p'].append(P)
    result['r'].append(R)
    result['a'].append(acc)
    result['test_size'].append(len(data_test))

    fname_results = 'result-codegrid-baseline-%s.pickle'%(time_now)
    print(fname_results)
    with open(fname_results, 'wb') as handle:
        pickle.dump(result, handle)
