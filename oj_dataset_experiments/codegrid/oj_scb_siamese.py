import sys
sys.path.append('../utilities')
sys.path.append('../../codegrid')
from tqdm import tqdm
from gensim.models import Word2Vec
from config import CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY
from config import W2V_VECTOR_DIM, NUM_WORKERS, W2V_WINDOWS_SIZE, W2V_MIN_TOKEN_LEN, NUM_EPOCHS, W2V_TRAINING_SEED
import pandas as pd
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
from sklearn.metrics import precision_recall_fscore_support
import sys
from config import W2V_VECTOR_DIM
from config import W2V_TRAINING_SEED, NUM_WORKERS
from config import NUM_EPOCHS
from models import CodeGridClassificationModel
import torch
import torch.nn as nn
import os
import numpy as np
from torch.utils.data import DataLoader
import argparse
from utilities_baseline import beautify_and_tokenize_code
from utilities_siamese import process_embedding_siam, get_X_y_siamese, SiameseDataset, SiameseNetworkContrastive, ContrastiveLoss
from scb_utilities import get_data_scb
from oj_utilities import get_functionality_data


### Hyperparameters and paths. Adjust accordingly
# Required command line argument `train_on` with possible values "oj" or "scb":
# Controls whether we run the `train-oj-test-scb`` or the `train-scb-test-oj` experiment
parser = argparse.ArgumentParser(description='CodeGrid baseline')
parser.add_argument('-t', '--train_on', type=str, help='Which dataset to use for training, "oj" or "scb"')
args = parser.parse_args()
train_on = args.train_on
assert train_on in ["oj", "scb"]
print("Training on %s" % train_on)
learning_rate = 1e-2
margin = 50
early_stopping = True
grid_method = 'word2vec'
cache_dir   = 'data/'
torch.manual_seed(11)

    
tqdm.pandas()
torch.multiprocessing.set_sharing_strategy('file_system')
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

### Tokenize data
fname_tokenized = cache_dir + "data_oj_tokenized.pickle"
if os.path.isfile(fname_tokenized):
    data_oj = pd.read_pickle(fname_tokenized)
    print("Loaded tokenized pairs from cache")
else:
    data_oj = get_functionality_data()

    data_oj[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"1"]] = data_oj.progress_apply(lambda row: beautify_and_tokenize_code(row['code1']), axis=1, result_type='expand')
    data_oj[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"2"]] = data_oj.progress_apply(lambda row: beautify_and_tokenize_code(row['code2']), axis=1, result_type='expand')
    data_oj.to_pickle(fname_tokenized)

### Get SCB data
fname_tokenized_scb = cache_dir + "data_scb_tokenized.pickle"
if os.path.isfile(fname_tokenized_scb):
    data_scb = pd.read_pickle(fname_tokenized_scb)
    print("loaded tokenized SCB data from cache")
else:
    data_scb = get_data_scb()

    data_scb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"1"]] = data_scb.progress_apply(lambda row: beautify_and_tokenize_code(row['code1']), axis=1, result_type='expand')
    data_scb[[CODE_WITHOUT_COMMENTS_KEY, CODE_RAW_TOKENS_KEY+"2"]] = data_scb.progress_apply(lambda row: beautify_and_tokenize_code(row['code2']), axis=1, result_type='expand')
    data_scb.to_pickle(fname_tokenized_scb)

dim = W2V_VECTOR_DIM
w2v_model_path = cache_dir + ('word2vec_oj_and_scb.bin')
if os.path.isfile(w2v_model_path):
    token_embeddings_model = Word2Vec.load(w2v_model_path)
    print("Loaded Word2Vec model from cache")
else:
    task_data1 = data_oj[CODE_RAW_TOKENS_KEY+"1"].tolist()
    task_data2 = data_oj[CODE_RAW_TOKENS_KEY+"2"].tolist()
    task_data3 = data_scb[CODE_RAW_TOKENS_KEY+"1"].tolist()
    task_data4 = data_scb[CODE_RAW_TOKENS_KEY+"2"].tolist()
    task_data  = task_data1 + task_data2 + task_data3 + task_data4
    
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

fname_features_siamese = cache_dir + "data_oj_features_with_scb_word2vec_siamese.pickle"
if os.path.isfile(fname_features_siamese):
    data_oj = pd.read_pickle(fname_features_siamese)
else:
    data_oj['feature1'] = data_oj.progress_apply(lambda row: process_embedding_siam(row['code_raw_tokens1'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_oj['feature2'] = data_oj.progress_apply(lambda row: process_embedding_siam(row['code_raw_tokens2'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_oj.to_pickle(fname_features_siamese)

fname_features_scb = cache_dir + "data_scb_features_with_oj_word2vec_siamese.pickle"
if os.path.isfile(fname_features_scb):
    data_scb = pd.read_pickle(fname_features_scb)
    print("loaded SCB data with features from cache")
else:
    data_scb['feature1'] = data_scb.progress_apply(lambda row: process_embedding_siam(row['code_raw_tokens1'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_scb['feature2'] = data_scb.progress_apply(lambda row: process_embedding_siam(row['code_raw_tokens2'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_scb.to_pickle(fname_features_scb)
    
data_oj['label'] = 1 - data_oj['label']
data_scb['label'] = 1 - data_scb['label']

if train_on == "oj":
    X_train1, X_train2, y_train = get_X_y_siamese(data_oj)
    X_test1 , X_test2 , y_test  = get_X_y_siamese(data_scb)
else:
    X_train1, X_train2, y_train = get_X_y_siamese(data_scb)
    X_test1 , X_test2 , y_test  = get_X_y_siamese(data_oj)
print("Training on %s" % train_on)

print("%0.2f %% is 1s in y_train" % (sum(y_train)/len(y_train)))
print("%0.2f %% is 1s in y_test" % (sum(y_test)/len(y_test)))

# Instantiate the model, loss function, and optimizer
model_contrastive = SiameseNetworkContrastive(X_train1.shape[1], use_batch_norm=True)
criterion_contrastive = ContrastiveLoss(margin=margin)
optimizer_contrastive = torch.optim.Adam(model_contrastive.parameters(), lr=learning_rate)

# Create datasets and data loaders
train_dataset_contrastive = SiameseDataset(X_train1, X_train2, y_train)
val_dataset_contrastive = SiameseDataset(X_test1, X_test2, y_test)

train_loader_contrastive = DataLoader(train_dataset_contrastive, batch_size=64, shuffle=True)
val_loader_contrastive = DataLoader(val_dataset_contrastive, batch_size=64, shuffle=False)

# Training loop
num_epochs = 25
best_epoch_f1 = 0
best_epoch_p  = 0
best_epoch_r  = 0
best_epoch_a  = 0
for epoch in range(num_epochs):
    print(epoch)
    model_contrastive.train()
    for X1, X2, y in train_loader_contrastive:
        optimizer_contrastive.zero_grad()
        output1, output2 = model_contrastive(X1, X2)
        loss = criterion_contrastive(output1, output2, y)
        loss.backward()
        optimizer_contrastive.step()
    
    print("Starting evaluation")
    # Validation
    model_contrastive.eval()
    similarity_scores_cosine = []

    trues = []
    with torch.no_grad():
        for X1, X2, y in val_loader_contrastive:
            output1, output2 = model_contrastive(X1, X2)
            loss_contrastive = criterion_contrastive(output1, output2, y)
            similarity_score_cosine = torch.nn.functional.cosine_similarity(output1, output2)
            similarity_scores_cosine.extend(similarity_score_cosine)
            trues.extend(1 - y.cpu().numpy())

    y_pred = np.array(similarity_scores_cosine) > 0.5
    acc    = sum(y_pred==trues)/len(y_pred)

    P, R, F1, _ = precision_recall_fscore_support(trues, y_pred, average='weighted')
    print("Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f (weighted)" % (acc, F1, P, R))

    P, R, F1, _ = precision_recall_fscore_support(trues, y_pred, average='binary')
    print("Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f (binary)" % (acc, F1, P, R))

    if early_stopping and F1 < best_epoch_f1:
        break
    else:
        best_epoch_f1 = F1
        best_epoch_p  = P
        best_epoch_r  = R
        best_epoch_a  = acc

print()