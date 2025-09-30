import torch
import torch.optim as optim
import sys
sys.path.append('../utilities')
from bcb_utilities import get_functionality_data
from utilities_siamese import SiameseNetwork, contrastive_loss, tokenize_code, create_dataloader, evaluate_siamese
import time
import pickle


### Hyperparameters and paths. Adjust accordingly
margin          = 50
batch_size      = 2
learning_rate   = 2e-5
model_name      = "microsoft/codebert-base"
num_epochs      = 10
early_stopping  = True

print("Margin: %d"  % margin)
print("Batch size: %d"  % batch_size)
print("Learning rate: %f"  % learning_rate)
sys.stdout.flush()

### Load BCB data
data_bcb = get_functionality_data()
print("Total dataset length (incl. all functionalities): %d" % len(data_bcb))
sys.stdout.flush()
# Rename the 'func' column to 'func2'
data_bcb.rename(columns={'code1': 'func1', 'code2':'func2'}, inplace=True)
# Contrastive loss function assumes 1-->negative and 0-->positive
data_bcb["label"] = 1 - data_bcb["label"]
# Tokenize data
data_bcb = tokenize_code(data_bcb, model_name)

# Check if CUDA is available
device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
print("Running on %s" % device)
sys.stdout.flush()

### Start training loop
functionality_ids = data_bcb['functionality_id'].unique().tolist()
functionality_ids.sort()

# Dict to keep track of results
result = {'fcn_id':[], 'f1':[], 'p':[], 'r':[], 'a':[], 'test_size':[]}
time_now = time.strftime("%Y%m%d-%H%M%S")
print(time_now)
for ii in functionality_ids:

    # ii--> functionality to leave-out each time
    data_train        = data_bcb[data_bcb["functionality_id"] != ii].reset_index()
    train_data_loader = create_dataloader(data_train, batch_size)

    data_test         = data_bcb[data_bcb["functionality_id"] == ii].reset_index()
    test_data_loader  = create_dataloader(data_test, batch_size)

    print("[%d] Train size: %d | Test size: %d" % (ii, len(data_train), len(data_test)))
    sys.stdout.flush()
    # Initialize a Siamese model
    model = SiameseNetwork(model_name, use_batch_norm=False)
    model = model.to(device)

    # Define an optimizer for fine-tuning
    optimizer = optim.AdamW(model.parameters(), lr=learning_rate)
    
    # Training loop
    best_F1, best_P, best_R, best_acc = 0, 0, 0, 0
    for epoch in range(num_epochs):
        for (i, batch) in enumerate(train_data_loader):
                    
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
        sys.stdout.flush()
        F1, P, R, acc = evaluate_siamese(model, test_data_loader)
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

    fname_results = 'result-codebert-siamese-%s.pickle'%(time_now)
    with open(fname_results, 'wb') as handle:
        pickle.dump(result, handle)

    print()

