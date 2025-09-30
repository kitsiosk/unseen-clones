import torch
import torch.optim as optim
import sys
import torch.optim as optim
import time
import pickle
sys.path.append('../utilities')
from bcb_utilities import get_functionality_data
from utilities_baseline import tokenize_code_baseline, create_dataloader_baseline, Codebert_Clone_Baseline, evaluate_baseline

batch_size      = 2    # from replication paper
learning_rate   = 2e-5 # from replication paper
model_name      = "microsoft/codebert-base"
num_epochs      = 10
early_stopping  = True
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
print("Learning rate %f" % learning_rate)

### Load BCB data
data_bcb = get_functionality_data()
print("Total BCB dataset length (incl. all functionalities): %d" % len(data_bcb))
sys.stdout.flush()
# Rename the 'func' column to 'func2'
data_bcb.rename(columns={'code1': 'func1', 'code2':'func2'}, inplace=True)
# Tokenize data
data_bcb = tokenize_code_baseline(data_bcb, model_name)


functionality_ids = data_bcb['functionality_id'].unique().tolist()
functionality_ids.sort()
result = {'fcn_id':[], 'f1':[], 'p':[], 'r':[], 'a':[], 'test_size':[]}
time_now = time.strftime("%Y%m%d-%H%M%S")
print(time_now)
for ii in functionality_ids:
    print(ii)
    sys.stdout.flush()

    model     = Codebert_Clone_Baseline(model_name)
    model.to(device)
    optimizer = optim.AdamW(model.parameters(), lr=learning_rate) # from replication paper
    criterion = torch.nn.BCEWithLogitsLoss()

    data_train       = data_bcb[data_bcb["functionality_id"] != ii].reset_index()
    dataloader_train = create_dataloader_baseline(data_train, batch_size)
    data_test        = data_bcb[data_bcb["functionality_id"] == ii].reset_index()
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
            break
        else:
            best_F1, best_P, best_R, best_acc = F1, P, R, acc

    result['fcn_id'].append(ii)
    result['f1'].append(best_F1)
    result['p'].append(best_P)
    result['r'].append(best_R)
    result['a'].append(best_acc)
    result['test_size'].append(len(data_test))

    fname_results = 'result-codebert-baseline-%s.pickle'%(time_now)
    with open(fname_results, 'wb') as handle:
        pickle.dump(result, handle)
    print()
