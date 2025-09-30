import torch
from transformers import AutoModel, AutoTokenizer
import numpy as np
from torch.utils.data import DataLoader, Dataset, TensorDataset
import torch.nn as nn
from sklearn.metrics import precision_recall_fscore_support

torch.manual_seed(11)

def tokenize_code_baseline(data, model_name):
    # Tokenize function to apply to each row of the DataFrame
    def tokenize_code(row):
        code1 = row['func1']
        code2 = row['func2']

        # Tokenize and format input data
        tokens = tokenizer.encode_plus(code1, code2, add_special_tokens=True, return_tensors="pt", truncation=True, padding="max_length")

        # Extract tensors from BatchEncoding
        input_ids = tokens['input_ids'].squeeze()
        attention_mask = tokens['attention_mask'].squeeze()

        return input_ids, attention_mask
    
    tokenizer = AutoTokenizer.from_pretrained(model_name)
    data['tokens'] = data.apply(tokenize_code, axis=1)
    return data


# Create a dataloader for the given dataset
def create_dataloader_baseline(data, batch_size):
    input_ids      = torch.cat(data['tokens'].apply(lambda x: x[0]).tolist(), dim=0).view(-1, 512)
    attention_mask = torch.cat(data['tokens'].apply(lambda x: x[1]).tolist(), dim=0).view(-1, 512)
    labels         = torch.tensor(data['label'])

    dataset = TensorDataset(input_ids, attention_mask, labels)

    dataloader = DataLoader(dataset, batch_size=batch_size, shuffle=True)

    return dataloader

def evaluate_baseline(model, dataloader, max_batches=1e6):
    model.eval()
    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    model = model.to(device)

    with torch.no_grad():
        i_batch = 0
        probs  = []
        y_test = []
        for batch in dataloader:
            i_batch += 1

            batch_input_ids, batch_attention_mask, batch_labels = batch
            batch_input_ids, batch_attention_mask, batch_labels = batch_input_ids.to(device), batch_attention_mask.to(device), batch_labels.to(device)
            batch_labels = batch_labels.float().view(-1, 1)  # Reshape to match the shape of logits

            logits = model.forward(batch_input_ids, batch_attention_mask)
            probabilities = torch.sigmoid(logits).float()
            probs.extend(probabilities.to('cpu').numpy())
            y_test.extend(batch_labels.to('cpu').numpy())

            if i_batch > max_batches:
                break

        true_labels = np.array(y_test)
        predicted_labels = (np.array(probs) > 0.5)
        acc         = 1-np.sum(np.abs(predicted_labels-true_labels))/true_labels.shape[0]
        P, R, F1, _ = precision_recall_fscore_support(predicted_labels, true_labels, average='binary')
        print(f"Accuracy: %0.3f | F1: %0.3f | Precision: %0.3f | Recall: %0.3f for similarity threshold 0.5" % (acc, F1, P, R))

    model.train()
    return F1, P, R, acc

class Codebert_Clone_Baseline(nn.Module):
    def __init__(self, model_name, max_sequence_length=512, use_batch_norm=False):
        super(Codebert_Clone_Baseline, self).__init__()
        
        device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

        self.model = AutoModel.from_pretrained(model_name)
        self.max_sequence_length = max_sequence_length
        self.device = torch.device(device)

        classification_head = nn.Linear(self.model.config.hidden_size, 1)
        self.model.classifier = classification_head
        self.model.to(self.device)
        self.model.classifier.to(self.device)

        # Add Batch Normalization layer
        self.batch_norm = nn.BatchNorm1d(self.model.config.hidden_size)
        self.use_batch_norm = use_batch_norm

        # Freeze all layers except the last one
        for param in self.model.parameters():
            param.requires_grad = False
        for param in self.model.encoder.layer[-1].parameters():
            param.requires_grad = True

    def forward(self, input_ids, attention_mask):
        outputs = self.model(input_ids=input_ids, attention_mask=attention_mask)
        outputs = outputs.last_hidden_state[:, 0, :]

        if self.use_batch_norm:
            outputs = self.batch_norm(outputs)

        logits = self.model.classifier(outputs)
        return logits