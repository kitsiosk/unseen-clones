import pandas as pd
import torch
import time
import numpy as np
import warnings
from gensim.models.word2vec import Word2Vec
from model_baseline import BatchProgramCC
from torch.autograd import Variable
warnings.filterwarnings('ignore')
import sys
import pickle
from utilities import get_batch, eval_model_baseline

root = 'data/'
lang = 'java'
early_stopping = True
HIDDEN_DIM = 100
ENCODE_DIM = 128
LABELS = 1
EPOCHS = 10
BATCH_SIZE = 32
USE_GPU = torch.cuda.is_available()

all_data = pd.read_pickle(root+lang+'/bcb_v2_sampled_bf/blocks.pickle').sample(frac=1, random_state=42)
word2vec = Word2Vec.load(root+lang+"/bcb_v2_sampled_bf/embedding/node_w2v_128").wv
MAX_TOKENS = word2vec.vectors.shape[0]
EMBEDDING_DIM = word2vec.vectors.shape[1]
embeddings = np.zeros((MAX_TOKENS + 1, EMBEDDING_DIM), dtype="float32")
embeddings[:word2vec.vectors.shape[0]] = word2vec.vectors


precision, recall, f1 = 0, 0, 0
print('Start training...')
sys.stdout.flush()
all_functionalities = all_data['functionality_id'].unique()
all_functionalities.sort()
# Dict to keep track of results
result = {'fcn_id':[], 'f1':[], 'p':[], 'r':[], 'a':[], 'test_size':[]}
time_now = time.strftime("%Y%m%d-%H%M%S")
print(time_now)
for ii in all_functionalities:
    # Initialize model
    model = BatchProgramCC(EMBEDDING_DIM,HIDDEN_DIM,MAX_TOKENS+1,ENCODE_DIM,LABELS,BATCH_SIZE,
                                USE_GPU, embeddings)
    if USE_GPU:
        model.cuda()

    parameters = model.parameters()
    optimizer = torch.optim.Adamax(parameters)
    loss_function = torch.nn.BCELoss()

    train_data_t = all_data[all_data['functionality_id'] != ii]
    test_data_t = all_data[all_data['functionality_id'] == ii]
    print()
    print("Starting %d. Size train: %d | Size test: %d" % (ii, len(train_data_t), len(test_data_t)))
    sys.stdout.flush()

    # training procedure
    best_f1, best_p, best_r, best_acc = 0, 0, 0, 0
    best_predicted_labels = []
    for epoch in range(EPOCHS):
        print(epoch)
        sys.stdout.flush()

        start_time = time.time()
        # training epoch
        total_acc = 0.0
        total_loss = 0.0
        total = 0.0
        i = 0
        while i < len(train_data_t):
            batch = get_batch(train_data_t, i, BATCH_SIZE)
            i += BATCH_SIZE
            train1_inputs, train2_inputs, train_labels = batch
            if USE_GPU:
                train1_inputs, train2_inputs, train_labels = train1_inputs, train2_inputs, train_labels.cuda()

            model.zero_grad()
            model.batch_size = len(train_labels)
            model.hidden = model.init_hidden()
            output = model(train1_inputs, train2_inputs)

            loss = loss_function(output, Variable(train_labels))
            loss.backward()
            optimizer.step()

        ###### Start evaluation
        f, p, r, acc, predicted_labels = eval_model_baseline(model, test_data_t, BATCH_SIZE, USE_GPU)
        model.train()

        if early_stopping and f<=best_f1:
            fname_manual_inspection = 'data_for_manual_inspection_baseline_%s'%ii
            data_for_manual_inspection = {
                'predicted': best_predicted_labels,
                'test_data': test_data_t
            }
            with open(fname_manual_inspection, 'wb') as handle:
                pickle.dump(data_for_manual_inspection, handle)

            print("Lower F1 than prevous epoch. Early stopping...")
            sys.stdout.flush()
            break
        else:
            best_f1, best_p, best_r, best_acc, best_predicted_labels = f, p, r, acc, predicted_labels

    result['fcn_id'].append(ii)
    result['f1'].append(best_f1)
    result['p'].append(best_p)
    result['r'].append(best_r)
    result['a'].append(best_acc)
    result['test_size'].append(len(test_data_t))

    fname_results = 'result-astnn-baseline-%s.pickle'%(time_now)
    with open(fname_results, 'wb') as handle:
        pickle.dump(result, handle)

