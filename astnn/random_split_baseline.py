import pandas as pd
import torch
import numpy as np
from gensim.models.word2vec import Word2Vec
from model_baseline import BatchProgramCC
from torch.autograd import Variable
import sys
from sklearn.model_selection import train_test_split
from utilities import get_batch, eval_model_baseline


lang           = "java"
HIDDEN_DIM     = 100
ENCODE_DIM     = 128
LABELS         = 1
EPOCHS         = 10
BATCH_SIZE     = 32
early_stopping = True
USE_GPU        = torch.cuda.is_available()

root     = 'data/'
data_bcb = pd.read_pickle(root+lang+'/bcb_v2_sampled_bf/blocks.pickle')

word2vec = Word2Vec.load(root+lang+"/bcb_v2_sampled_bf/embedding/node_w2v_128").wv
MAX_TOKENS = word2vec.vectors.shape[0]
EMBEDDING_DIM = word2vec.vectors.shape[1]
embeddings = np.zeros((MAX_TOKENS + 1, EMBEDDING_DIM), dtype="float32")
embeddings[:word2vec.vectors.shape[0]] = word2vec.vectors

# Initialize model
model = BatchProgramCC(EMBEDDING_DIM,HIDDEN_DIM,MAX_TOKENS+1,ENCODE_DIM,LABELS,BATCH_SIZE,
                            USE_GPU, embeddings)
if USE_GPU:
    model.cuda()

parameters = model.parameters()
optimizer = torch.optim.Adamax(parameters)
loss_function = torch.nn.BCELoss()


data_train, data_test = train_test_split(data_bcb, test_size=0.2, random_state=42)



best_f1, best_p, best_r, best_acc = 0, 0, 0, 0
for epoch in range(EPOCHS):
    print("Starting epoch %d" % epoch)
    sys.stdout.flush()
    i = 0
    while i < len(data_train):
        model.train()
        batch = get_batch(data_train, i, BATCH_SIZE)
        train1_inputs, train2_inputs, train_labels = batch
        if USE_GPU:
            train1_inputs, train2_inputs, train_labels = train1_inputs, train2_inputs, train_labels.cuda()
    
        model.zero_grad()
        model.batch_size = len(train_labels)
        model.hidden     = model.init_hidden()
    
        output = model(train1_inputs, train2_inputs)
    
        loss = loss_function(output, Variable(train_labels))
        loss.backward()
        optimizer.step()
        i += BATCH_SIZE

    
    print("Starting evaluation after epoch %d" % epoch)
    sys.stdout.flush()
    f, p, r, acc = eval_model_baseline(model, data_test, BATCH_SIZE, USE_GPU)
    sys.stdout.flush()

    if early_stopping and f<best_f1:
        print("Lower F1 than previous epoch. Early stopping...")
        sys.stdout.flush()
        break
    else:
        best_f1, best_p, best_r, best_acc = f, p, r, acc
