import torch
from transformers import AutoModel, AutoTokenizer
import numpy as np
from torch.utils.data import DataLoader, Dataset
import torch.nn as nn
from sklearn.metrics import precision_recall_fscore_support

device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
torch.manual_seed(11)

### Define auxiliary classes and functions
class CustomDataset(Dataset):
    def __init__(self, input_ids1, attention_mask1, input_ids2, attention_mask2, labels):
        self.input_ids1      = input_ids1
        self.attention_mask1 = attention_mask1
        self.input_ids2      = input_ids2
        self.attention_mask2 = attention_mask2
        self.labels          = labels

    def __len__(self):
        return len(self.labels)

    def __getitem__(self, idx):
        return self.input_ids1[idx], self.attention_mask1[idx], self.input_ids2[idx], self.attention_mask2[idx], self.labels[idx]
    
class SiameseNetwork(nn.Module):
    def __init__(self, model_name, use_batch_norm=True, dropout_prob=0.0):
        super(SiameseNetwork, self).__init__()
        
        # Load the CodeBERT model and tokenizer
        self.bert = AutoModel.from_pretrained(model_name)
        self.tokenizer = AutoTokenizer.from_pretrained(model_name)

        # Add Dropout layer
        self.dropout = nn.Dropout(p=dropout_prob)

        # Add Batch Normalization layer
        self.batch_norm = nn.BatchNorm1d(self.bert.config.hidden_size)
        self.use_batch_norm = use_batch_norm

        # Freeze all layers except the last one
        for param in self.bert.parameters():
            param.requires_grad = False
        for param in self.bert.encoder.layer[-1].parameters():
            param.requires_grad = True

    def forward(self, input_ids, attention_mask):
        # Pass the input through the CodeBERT model
        output = self.bert(input_ids, attention_mask)
        output = output.last_hidden_state[:, 0, :] # Extract representation of the [CLS] token in the beginnning

        # Apply Dropout
        output = self.dropout(output)

        # Apply Batch Normalization
        if self.use_batch_norm:
            output = self.batch_norm(output)

        return output
    
# Contrastive loss function
def contrastive_loss(embedding1, embedding2, label, margin=1.0):
    distance = torch.nn.functional.pairwise_distance(embedding1, embedding2)

    loss = torch.mean((1 - label) * 0.5 * torch.pow(distance, 2) +
                      label * 0.5 * torch.pow(torch.clamp(margin - distance, min=0.0), 2))
    return loss

def tokenize_code(data, model_name):
    def tokenize_code_(code):
        tokens = tokenizer.encode_plus(code, add_special_tokens=True, return_tensors="pt", truncation=True, padding="max_length")

        # Extract tensors from BatchEncoding
        input_ids = tokens['input_ids'].squeeze()
        attention_mask = tokens['attention_mask'].squeeze()

        return input_ids, attention_mask
        
    # Load the tokenizer
    tokenizer = AutoTokenizer.from_pretrained(model_name)

    if model_name != "microsoft/codebert-base":
        print("Warning: Using tokenizer of max length 512")


    # Tokenize and encode 'func1' and 'func2'
    data["input_ids1"] = data["func1"].apply(lambda x: tokenize_code_(x))
    data["input_ids2"] = data["func2"].apply(lambda x: tokenize_code_(x))

    return data

# Create a dataloader for the given dataset
def create_dataloader(data, batch_size):
    label_tensor      = torch.tensor(data["label"].tolist())
    
    input_ids1_tensor = torch.cat(data['input_ids1'].apply(lambda x: x[0]).tolist(), dim=0).view(-1, 512)
    attention_mask1   = torch.cat(data['input_ids1'].apply(lambda x: x[1]).tolist(), dim=0).view(-1, 512)

    input_ids2_tensor = torch.cat(data['input_ids2'].apply(lambda x: x[0]).tolist(), dim=0).view(-1, 512)
    attention_mask2   = torch.cat(data['input_ids2'].apply(lambda x: x[1]).tolist(), dim=0).view(-1, 512)
    
    my_dataset        = CustomDataset(input_ids1_tensor, attention_mask1, input_ids2_tensor, attention_mask2, label_tensor)
    my_dataloader     = DataLoader(my_dataset, batch_size=batch_size, shuffle=True)

    return my_dataloader

# Evaluate the given "model" in the test dataset defined by "test_data_loader"
def evaluate_siamese(model, test_data_loader, max_num_of_batches=1e6):
    # Set the model to evaluation mode (important for models with dropout, batch normalization, etc.)
    model.eval()
    
    similarity_scores = []
    true_labels       = []
    # Iterate through the test dataset using the test dataloader
    for (j, batch_test) in enumerate(test_data_loader):

        input_ids_A, attention_mask_A, input_ids_B, attention_mask_B, labels = batch_test
        input_ids_A      = input_ids_A.to(device)
        attention_mask_A = attention_mask_A.to(device)
        input_ids_B      = input_ids_B.to(device)
        attention_mask_B = attention_mask_B.to(device)
        labels           = labels.to(device)
    
        # Generate embeddings for code snippets A and B
        with torch.no_grad():
            embeddings_A = model(input_ids_A, attention_mask_A)
            embeddings_B = model(input_ids_B, attention_mask_B)
    
        # Calculate the distance metric (cosine similarity here)
        similarity_score = torch.nn.functional.cosine_similarity(embeddings_A, embeddings_B)
        similarity_scores.extend(similarity_score.to('cpu').numpy())

        # For the evaluation we want label=1 to mean clones and label=0 to mean non-clones
        true_labels.extend(1 - labels.to('cpu').numpy())

        # Break if optional threshold is specified
        if j == max_num_of_batches:
            break

    predicted_labels = (np.array(similarity_scores) > 0.5)
    acc         = 1-np.sum(np.abs(predicted_labels-true_labels))/len(true_labels)
    P, R, F1, _ = precision_recall_fscore_support(predicted_labels, true_labels, average='binary')
    print(f"Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f for similarity threshold: 0.5" % (acc, F1, P, R))
    
    # Set model back to training mode
    model.train()

    return F1, P, R, acc
