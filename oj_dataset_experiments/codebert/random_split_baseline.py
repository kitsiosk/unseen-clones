import torch
import torch.optim as optim
import sys
import torch.optim as optim
from sklearn.model_selection import train_test_split
sys.path.append('../utilities')
sys.path.append('../../codebert')
from oj_utilities import get_functionality_data
from utilities_baseline import tokenize_code_baseline, create_dataloader_baseline, Codebert_Clone_Baseline, evaluate_baseline

batch_size      = 2
learning_rate   = 1e-2 
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

model     = Codebert_Clone_Baseline(model_name, use_batch_norm=True)
model.to(device)
optimizer = optim.AdamW(model.parameters(), lr=learning_rate)
criterion = torch.nn.BCEWithLogitsLoss()

data_train, data_test = train_test_split(data_oj, test_size=0.2, random_state=42)
data_train = data_train.reset_index()
data_test = data_test.reset_index()
dataloader_train = create_dataloader_baseline(data_train, batch_size)
dataloader_test  = create_dataloader_baseline(data_test, batch_size)

print("Train dataset size: %d | Test dataset size: %d" % (len(data_train), len(data_test)))
sys.stdout.flush()

# Fine-tuning loop
best_F1, best_P, best_R, best_acc = 0, 0, 0, 0
for epoch in range(num_epochs):
    model.train()

    for batch in dataloader_train:
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
    F1, P, R, acc = evaluate_baseline(model, dataloader_test)
    sys.stdout.flush()

    if F1 <= best_F1 and early_stopping:
        print("Worse F1 than previous iteration, early stopping...")
        break
    else:
        best_F1, best_P, best_R, best_acc = F1, P, R, acc
