import torch
import numpy as np
from sklearn.metrics import precision_recall_fscore_support
import sys
import pickle

def get_batch(dataset, idx, bs):
    tmp = dataset.iloc[idx: idx+bs]
    x1, x2, labels = [], [], []
    for _, item in tmp.iterrows():
        x1.append(item['code_x'])
        x2.append(item['code_y'])
        labels.append([item['label']])
    return x1, x2, torch.FloatTensor(labels)

# Contrastive loss function
def contrastive_loss(embedding1, embedding2, label, margin=1.0):
    distance = torch.nn.functional.pairwise_distance(embedding1, embedding2)

    loss = torch.mean((1 - label) * 0.5 * torch.pow(distance, 2) +
                      label * 0.5 * torch.pow(torch.clamp(margin - distance, min=0.0), 2))
    return loss


def eval_model_baseline(model, test_data_t, batch_size, use_gpu):
    model.eval()
    trues = []
    similarity_scores = []
    i = 0
    while i < len(test_data_t):
        batch = get_batch(test_data_t, i, batch_size)
        i += batch_size
        test1_inputs, test2_inputs, test_labels = batch
        if use_gpu:
            test_labels = test_labels.cuda()

        model.batch_size = len(test_labels)
        model.hidden = model.init_hidden()
        output = model(test1_inputs, test2_inputs)

        # calculate testing acc
        similarity_scores.extend(output.data.cpu().numpy())
        trues.extend(test_labels.cpu().numpy())

    trues = np.array(trues)
    predicted_labels = np.array(similarity_scores) > 0.5

    p, r, f, _ = precision_recall_fscore_support(trues, predicted_labels, average='binary')
    acc = 1-np.sum(np.abs(predicted_labels-trues))/trues.shape[0]
    print("Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f for similarity threshold 0.5" % (acc, f, p, r))
    sys.stdout.flush()
    model.train()

    return f, p, r, acc, predicted_labels

def eval_model_siamese(model, test_data_t, batch_size, use_gpu):
    model.eval()
    similarity_scores = []
    trues = []
    iTest = 0
    
    while iTest < len(test_data_t):
        batch = get_batch(test_data_t, iTest, batch_size)
        iTest += batch_size
        test1_inputs, test2_inputs, test_labels = batch
        if use_gpu:
            test_labels = test_labels.cuda()
    
        model.batch_size = len(test_labels)
        model.hidden = model.init_hidden()
        with torch.no_grad():
            embeddings1 = model(test1_inputs)
            embeddings2 = model(test2_inputs)
        similarity_score = torch.nn.functional.cosine_similarity(embeddings1, embeddings2)
        
        # calculate testing acc
        similarity_scores.extend(similarity_score.cpu())
        trues.extend(1 - test_labels.cpu().numpy())
    
    
    trues = np.array(trues)

    predicted_labels = np.array(similarity_scores) > 0.5

    p, r, f, _ = precision_recall_fscore_support(trues, predicted_labels, average='binary')
    acc = 1-np.sum(np.abs(predicted_labels-np.transpose(trues)))/trues.shape[0]
    print("Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f for similarity threshold 0.5" % (acc, f, p, r))

    sys.stdout.flush()
    model.train()

    return f, p, r, acc, predicted_labels