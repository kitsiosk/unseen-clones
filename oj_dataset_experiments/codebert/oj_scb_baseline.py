import torch
import torch.nn as nn
import torch.optim as optim
import sys
import numpy as np
from transformers import AutoModel, AutoTokenizer
import torch.optim as optim
from torch.utils.data import DataLoader, TensorDataset
import argparse
sys.path.append('../../codebert')
sys.path.append('../utilities')
from oj_utilities import get_functionality_data
from scb_utilities import get_data_scb
from utilities_baseline import tokenize_code_baseline, create_dataloader_baseline, Codebert_Clone_Baseline, evaluate_baseline


# Required command line argument `train_on` with possible values "oj" or "scb":
# Controls whether we run the `train-oj-test-scb`` or the `train-scb-test-oj` experiment
parser = argparse.ArgumentParser(description='CodeBERT baseline')
parser.add_argument('-t', '--train_on', type=str, help='Which dataset to use for training, "oj" or "scb"')
args = parser.parse_args()
train_on = args.train_on
assert train_on in ["oj", "scb"]
print("Training on %s" % train_on)
batch_size      = 2     # from replication paper
learning_rate   = 2e-5  # from replication paper
model_name      = "microsoft/codebert-base"
num_epochs      = 10
early_stopping  = True
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
print("Learning rate %f" % learning_rate)

### Load oj data
data_oj = get_functionality_data()
print("Total oj dataset length (incl. all functionalities): %d" % len(data_oj))
sys.stdout.flush()
# Rename the 'code' to 'func'
data_oj.rename(columns={'code1': 'func1', 'code2':'func2'}, inplace=True)
data_oj = data_oj.reset_index()
# Tokenize data
data_oj = tokenize_code_baseline(data_oj, model_name)
data_oj = data_oj.reset_index()
# Create dataloader
dataloader_oj = create_dataloader_baseline(data_oj, batch_size)

### Load SCB data
data_scb = get_data_scb()
data_scb = data_scb.rename(columns={'code1':'func1', 'code2':'func2'})
# Tokenize data
data_scb = tokenize_code_baseline(data_scb, model_name)
dataloader_scb = create_dataloader_baseline(data_scb, batch_size)

# Load pre-trained CodeBERT model and tokenizer using AutoModel and AutoTokenizer
model     = Codebert_Clone_Baseline(model_name)
model.to(device)
optimizer = optim.AdamW(model.parameters(), lr=learning_rate) # from replication paper
criterion = torch.nn.BCEWithLogitsLoss()

if train_on == "oj":
    data_train = dataloader_oj
    data_test  = dataloader_scb
else:
    data_train = dataloader_scb
    data_test  = dataloader_oj

# Fine-tuning loop
best_f1 = 0
for epoch in range(num_epochs):
    model.train()

    for batch in data_train:
        batch_input_ids, batch_attention_mask, batch_labels = batch
        batch_input_ids, batch_attention_mask, batch_labels = batch_input_ids.to(device), batch_attention_mask.to(device), batch_labels.to(device)

        optimizer.zero_grad()

        # Forward pass
        logits = model(input_ids=batch_input_ids, attention_mask=batch_attention_mask)

        batch_labels = batch_labels.float().view(-1, 1)  # Reshape to match the shape of logits
        loss = criterion(logits, batch_labels)

        # Backward pass and optimization step
        loss.backward()
        optimizer.step()

    print(f"Epoch {epoch + 1} evaluation:")
    sys.stdout.flush()
    F1 = evaluate_baseline(model, data_test)
    if F1 < best_f1 and early_stopping:
        break
    else:
        best_f1 = F1
    sys.stdout.flush()




