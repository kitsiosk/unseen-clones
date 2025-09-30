import torch
import torch.optim as optim
import sys
import argparse
sys.path.append('../utilities')
from bcb_utilities import get_functionality_data
from scb_utilities import get_data_scb
from utilities_siamese import SiameseNetwork, contrastive_loss, tokenize_code, create_dataloader, evaluate_siamese

# Required command line argument `train_on` with possible values "BCB" or "SCB":
# Controls whether we run the `train-bcb-test-scb`` or the `train-scb-test-bcb` experiment
parser = argparse.ArgumentParser(description='CodeBERT siamese')
parser.add_argument('-t', '--train_on', type=str, help='Which dataset to use for training, "BCB" or "SCB"')
args = parser.parse_args()
train_on = args.train_on
assert train_on in ["bcb", "scb"]

### Hyperparameters
margin          = 50
batch_size      = 2
learning_rate   = 2e-5
model_name      = "microsoft/codebert-base"
num_epochs      = 10
print("Train on: %s" % train_on)
print("Margin: %d"  % margin)
print("Batch size: %d"  % batch_size)
print("Learning rate: %f"  % learning_rate)
sys.stdout.flush()

### Load BCB data
data_bcb = get_functionality_data()
print("Total dataset length (incl. all functionalities): %d" % len(data_bcb))
# Rename the 'func' column to 'func2'
data_bcb.rename(columns={'code1': 'func1', 'code2':'func2'}, inplace=True)
# Contrastive loss function assumes 1-->negative and 0-->positive
data_bcb["label"] = 1 - data_bcb["label"]
# Tokenize data
data_bcb = tokenize_code(data_bcb, model_name)
# Create dataloader
dataloader_bcb = create_dataloader(data_bcb, batch_size)

### Load SCB data
data_scb = get_data_scb()
data_scb["label"] = 1-data_scb["label"]
data_scb = data_scb.rename(columns={'code1':'func1', 'code2':'func2'})
data_scb = tokenize_code(data_scb, model_name)
dataloader_scb = create_dataloader(data_scb, batch_size)

# Check if CUDA is available
device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
print("Running on %s" % device)
sys.stdout.flush()

# Initialize a Siamese model
model = SiameseNetwork(model_name)
model = model.to(device)

# Define an optimizer for fine-tuning
optimizer = optim.Adam(model.parameters(), lr=learning_rate)

if train_on == "bcb":
    data_train = dataloader_bcb
    data_test  = dataloader_scb
else:
    data_train = dataloader_scb
    data_test  = dataloader_bcb

# Training loop
for epoch in range(num_epochs):
    for (i, batch) in enumerate(data_train):
                
        input_ids_A, attention_mask_A, input_ids_B, attention_mask_B, labels = batch
        input_ids_A      = input_ids_A.to(device)
        attention_mask_A = attention_mask_A.to(device)
        input_ids_B      = input_ids_B.to(device)
        attention_mask_B = attention_mask_B.to(device)
        labels           = labels.to(device)
    
        embeddings_A = model(input_ids_A, attention_mask_A)
        embeddings_B = model(input_ids_B, attention_mask_B)

        loss = contrastive_loss(embeddings_A, embeddings_B, labels, margin=margin)
        
        optimizer.zero_grad()
        loss.backward()
        optimizer.step()
            
    print("Epoch %d:" % epoch)
    F1, P, R, acc = evaluate_siamese(model, data_test)
    sys.stdout.flush()