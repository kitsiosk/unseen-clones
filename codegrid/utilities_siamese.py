import numpy as np
import torch
import torch.multiprocessing
import numpy as np
import torch
import torch.multiprocessing
import torch
import torch.nn as nn
import torch
import torch.nn as nn
from torch.utils.data import Dataset
from utilities_baseline import construct_grid

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
np.random.seed(11)

def process_embedding_siam(v1, grid_method, model, token_embeddings_model, dim):
    v1 = construct_grid(token_embeddings_model, v1, method=grid_method, dim=dim)
    v1 = v1.reshape(dim, 224, 224)

    v1 = np.expand_dims(v1, axis=0)
    v1 = torch.from_numpy(v1).float()

    with torch.no_grad():
        f1 = model(v1).flatten()
        f1 = f1.to('cpu')
        return f1.numpy()
    


def get_X_y_siamese(data_pairs):
    # Keep only feature and label
    X1 = data_pairs['feature1']
    X2 = data_pairs['feature2']
    y  = data_pairs['label']
    
    # Shuffle dataset    
    indices = np.arange(y.shape[0])
    np.random.shuffle(indices)
    X1 = X1.to_numpy()[indices].tolist()
    X2 = X2.to_numpy()[indices].tolist()
    y = y.to_numpy()[indices].tolist()

    return torch.tensor(X1, dtype=torch.float32), torch.tensor(X2, dtype=torch.float32), torch.tensor(y, dtype=torch.float32)

# Custom Siamese Dataset
class SiameseDataset(Dataset):
    def __init__(self, X1, X2, y):
        self.X1 = X1
        self.X2 = X2
        self.y = y

    def __len__(self):
        return len(self.y)

    def __getitem__(self, idx):
        return self.X1[idx], self.X2[idx], self.y[idx]

# Siamese Network Model with Contrastive Loss
class SiameseNetworkContrastive(nn.Module):
    def __init__(self, input_dim, use_batch_norm=False):
        super(SiameseNetworkContrastive, self).__init__()
        self.shared_embedding = nn.Sequential(
            nn.Linear(input_dim, 128),
            nn.Tanh()
        )

        self.use_batch_norm = use_batch_norm
        self.batch_norm = nn.BatchNorm1d(128)

    def forward_one(self, x):
        return self.shared_embedding(x)

    def forward(self, x1, x2):
        out1 = self.forward_one(x1)
        if self.use_batch_norm:
            out1 = self.batch_norm(out1)

        out2 = self.forward_one(x2)
        if self.use_batch_norm:
            out2 = self.batch_norm(out2)
        
        return out1, out2

# Contrastive Loss Function
class ContrastiveLoss(nn.Module):
    def __init__(self, margin=50.0):
        super(ContrastiveLoss, self).__init__()
        self.margin = margin

    def forward(self, output1, output2, target):
        euclidean_distance = nn.functional.pairwise_distance(output1, output2)
        loss_contrastive = torch.mean((1 - target) * torch.pow(euclidean_distance, 2) +
                                      (target) * torch.pow(torch.clamp(self.margin - euclidean_distance, min=0.0), 2))
        return loss_contrastive