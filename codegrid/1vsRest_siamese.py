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
import numpy as np
from torch.utils.data import Dataset, DataLoader
sys.path.append('../utilities')
from bcb_utilities import get_functionality_data
from utilities_baseline import beautify_and_tokenize_code
from utilities_siamese import process_embedding_siam, get_X_y_siamese, SiameseDataset, SiameseNetworkContrastive, ContrastiveLoss

learning_rate = 1e-2
margin = 50
early_stopping = True
grid_method = 'word2vec'
cache_dir   = 'data/'
torch.manual_seed(11)

tqdm.pandas()
torch.multiprocessing.set_sharing_strategy('file_system')
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

### Load BCB data
data_bcb = get_functionality_data()
print("Total dataset length (incl. all functionalities): %d" % len(data_bcb))
print("Total number of functionalities in dataset: %d" % len(data_bcb.groupby('functionality_id').size()))

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


fname_features_siamese = cache_dir + "data_bcb_v2_sampled_bf_features_siamese.pickle"
if os.path.isfile(fname_features_siamese):
    data_bcb = pd.read_pickle(fname_features_siamese)
else:
    data_bcb['feature1'] = data_bcb.progress_apply(lambda row: process_embedding_siam(row['code_raw_tokens1'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_bcb['feature2'] = data_bcb.progress_apply(lambda row: process_embedding_siam(row['code_raw_tokens2'], grid_method, model, token_embeddings_model, dim), axis=1)
    data_bcb.to_pickle(fname_features_siamese)

functionality_ids = data_bcb['functionality_id'].unique().tolist()
functionality_ids.sort()

# Contrastive loss assumes 1--> non-clones and 0-->clones
data_bcb['label'] = 1 - data_bcb['label']

# Dict to keep track of results
result = {'fcn_id':[], 'f1':[], 'p':[], 'r':[], 'a':[], 'test_size':[]}
time_now = time.strftime("%Y%m%d-%H%M%S")
for ii in functionality_ids:
    print("[%d] Starting functionality" % ii)
    
    data_train = data_bcb[data_bcb['functionality_id'] != ii]
    data_test =  data_bcb[data_bcb['functionality_id'] == ii]
    print("Train length %d" % len(data_train))
    print("Test length %d" % len(data_test))
    X_train1, X_train2, y_train = get_X_y_siamese(data_train)
    X_test1 , X_test2 , y_test  = get_X_y_siamese(data_test)
    print("%0.2f %% is 1s in y_train" % (sum(y_train)/len(y_train)))
    print("%0.2f %% is 1s in y_test" % (sum(y_test)/len(y_test)))
    
    # Instantiate the model, loss function, and optimizer
    model_contrastive = SiameseNetworkContrastive(X_train1.shape[1])
    criterion_contrastive = ContrastiveLoss(margin)
    optimizer_contrastive = torch.optim.Adam(model_contrastive.parameters(), lr=learning_rate)
    
    # Create datasets and data loaders
    train_dataset_contrastive = SiameseDataset(X_train1, X_train2, y_train)
    val_dataset_contrastive = SiameseDataset(X_test1, X_test2, y_test)
    train_loader_contrastive = DataLoader(train_dataset_contrastive, batch_size=64, shuffle=True)
    val_loader_contrastive = DataLoader(val_dataset_contrastive, batch_size=64, shuffle=False)
    
    # Training loop
    num_epochs = 15
    best_epoch_f1 = 0
    best_epoch_p  = 0
    best_epoch_r  = 0
    best_epoch_a  = 0
    for epoch in range(num_epochs):
        model_contrastive.train()
        for X1, X2, y in train_loader_contrastive:
            optimizer_contrastive.zero_grad()
            output1, output2 = model_contrastive(X1, X2)
            loss = criterion_contrastive(output1, output2, y)
            loss.backward()
            optimizer_contrastive.step()
        
        # Validation
        model_contrastive.eval()
        similarity_scores_cosine = []

        trues = []
        with torch.no_grad():
            for X1, X2, y in val_loader_contrastive:
                output1, output2 = model_contrastive(X1, X2)
                similarity_score_cosine = torch.nn.functional.cosine_similarity(output1, output2)
                similarity_scores_cosine.extend(similarity_score_cosine)
                trues.extend(1 - y.cpu().numpy())
        
        y_pred = np.array(similarity_scores_cosine) > 0.5
        P, R, F1, _ = precision_recall_fscore_support(trues, y_pred, average='binary')
        acc         = sum(y_pred==trues)/len(y_pred)
        print("Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f" % (acc, F1, P, R))

        if F1 < best_epoch_f1 and early_stopping:
            break
        else:
            best_epoch_f1 = F1
            best_epoch_p  = P
            best_epoch_r  = R
            best_epoch_a  = acc

    result['fcn_id'].append(ii)
    result['f1'].append(best_epoch_f1)
    result['p'].append(best_epoch_p)
    result['r'].append(best_epoch_r)
    result['a'].append(best_epoch_a)
    result['test_size'].append(len(data_test))

    print()
    
    fname_results = 'result-codegrid-siamese-%s.pickle'%(time_now)
    with open(fname_results, 'wb') as handle:
        pickle.dump(result, handle)