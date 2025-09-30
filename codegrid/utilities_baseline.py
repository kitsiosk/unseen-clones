from utils import remove_comments, beautify_code, tokenize_code
import numpy as np
from utils import get_tokens_coordinates
import torch
import torch.multiprocessing
from config import SAMPLE_WIDTH, SAMPLE_HEIGHT
import numpy as np
import torch
import torch.multiprocessing
from config import SAMPLE_WIDTH, SAMPLE_HEIGHT
import torch

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
np.random.seed(11)

def beautify_and_tokenize_code(code):
    code_no_comment = remove_comments(code)
    beautiful_code = beautify_code(code_no_comment, method='gnu-indent')
    tokens = tokenize_code(code_no_comment)
    return beautiful_code, tokens

def process_embedding_core(v1, v2, grid_method, model, token_embeddings_model, dim):
    v1 = construct_grid(token_embeddings_model, v1, method=grid_method, dim=dim)
    v1 = v1.reshape(dim, 224, 224)
    v2 = construct_grid(token_embeddings_model, v2, method=grid_method, dim=dim)
    v2 = v2.reshape(dim, 224, 224)

    v1 = np.expand_dims(v1, axis=0)
    v2 = np.expand_dims(v2, axis=0)
    v1 = torch.from_numpy(v1).float()
    v2 = torch.from_numpy(v2).float()

    with torch.no_grad():
        f1 = model(v1).flatten()
        f2 = model(v2).flatten()

        f1 = f1.to("cpu")
        f2 = f2.to("cpu")
        return np.absolute(f1 - f2).numpy()
    
def construct_grid(encoder, tokens, method, width=SAMPLE_WIDTH, height=SAMPLE_HEIGHT, dim=3):
    grid = np.zeros((height, width, dim), dtype="float32")
    tokens_positions = get_tokens_coordinates(tokens)
    for token_position in tokens_positions:
        for token, positions in token_position.items():
            if method == 'color':
                try:
                    vector = encoder[token]
                    vector = tuple(ti / 255 for ti in vector)
                except:
                    vector = None # <UNK> vector
            elif method == 'word2vec':
                try:
                    vector = encoder.wv[token]
                except:
                    vector = np.random.rand(dim) # <UNK> vector
                    print(token)
            elif method == 'code2vec':
                try:
                    vector = encoder.get_vector(token)
                except:
                    vector = np.random.rand(dim) # <UNK> vector
            else:
                vectors = None

            
            for position in positions:
                (x, y) = position
                try:
                    grid[y, x] = vector
                except: # For grids larger that 224x224
                    # print(token, x, y)
                    # print(tokens_to_code(tokens))
                    # display_image(grid)
                    # exit()
                    pass
    # if method == 'color':
    #     display_image(grid)
    #     exit()
    return grid

def get_X_y(data_pairs):
    # Keep only feature and label
    X = data_pairs['feature']
    y = data_pairs['label']
    
    # Shuffle dataset    
    indices = np.arange(y.shape[0])
    np.random.shuffle(indices)
    X = X.to_numpy()[indices].tolist()
    y = y.to_numpy()[indices].tolist()

    return X, y
