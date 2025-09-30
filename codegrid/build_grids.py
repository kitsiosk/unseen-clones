
import pandas as pd
import numpy as np
import pickle

from tqdm import tqdm
from gensim.models import Word2Vec, KeyedVectors
from utils import get_tokens_coordinates, tokens_to_code, display_image


import torch
from torch.autograd import Variable
from torch.nn import CrossEntropyLoss
from torch.optim import Adam
import torch.multiprocessing

import gc

torch.multiprocessing.set_sharing_strategy('file_system')
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score

import sys

from config import W2V_VECTOR_DIM, CODE2VEC_VECTOR_DIM, INNITIAL_PROCESSED_DATASET_FOLDER, GRIDDED_DATASET_FOLDER, DATA_FILENAME
from config import CODE_RAW_TOKENS_KEY, COLOR_GRID_KEY, CODE2VEC_GRID_KEY, WORD2VEC_GRID_KEY, TRAINING_DATASETS
from config import MODELS_FOLDER, W2V_MODEL_NAME, COLOR_MODEL_NAME, CODE2VEC_MODEL_NAME, SAVE_PLOT, BATCH_SIZE, NUM_WORKERS
from config import SKIP_TOKENS_EMBEDDING, SAMPLE_WIDTH, SAMPLE_HEIGHT, NUM_EPOCHS, bcolors

tqdm.pandas()

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
                except:
                    # print(token, x, y)
                    # print(tokens_to_code(tokens))
                    # display_image(grid)
                    # exit()
                    pass
    # if method == 'color':
    #     display_image(grid)
    #     exit()
    return grid

if __name__ == '__main__':
    # Same for all tasks
    print(bcolors.BOLD + f'\tLoading Code2Vec Vectorizer...' + bcolors.ENDC)
    code2vec_model = KeyedVectors.load_word2vec_format(str(MODELS_FOLDER / CODE2VEC_MODEL_NAME), binary=False)

    for ds in TRAINING_DATASETS:
        embedded_filename = GRIDDED_DATASET_FOLDER / ds / DATA_FILENAME
        embedded_filename.parent.mkdir(parents=True, exist_ok=True)
        if SKIP_TOKENS_EMBEDDING and embedded_filename.is_file():
            print(bcolors.BOLD + f'\tLoading Data From Cache...' + bcolors.ENDC)
            try:
                data = pickle.load(open(embedded_filename, mode='rb'))
                continue
            except:
                pass
        
        processed_filename = INNITIAL_PROCESSED_DATASET_FOLDER / ds / DATA_FILENAME
        ds_name = ds.replace('_', ' ')
        ds_name = ds_name.capitalize()
        print(bcolors.HEADER + f'Embedding {ds_name} Tokens...' + bcolors.ENDC)

        print(bcolors.BOLD + f'\tLoading Data Preprocessed...' + bcolors.ENDC)
        data = pickle.load(open(str(processed_filename), mode='rb'))



        print(bcolors.BOLD + f'\tLoading Color Vectorizer...' + bcolors.ENDC)
        color_model_path = MODELS_FOLDER / str(ds + COLOR_MODEL_NAME)
        token2color_model = pickle.load(open(str(color_model_path), mode='rb'))

        print(bcolors.BOLD + f'\tLoading Word2Vec Vectorizer...' + bcolors.ENDC)
        w2v_model_path = MODELS_FOLDER / str(ds + W2V_MODEL_NAME)
        w2v_model = Word2Vec.load(str(w2v_model_path))



        print(bcolors.BOLD + f'\tEmbedding Using Color Vectorizer...' + bcolors.ENDC)
        data[COLOR_GRID_KEY] = data[CODE_RAW_TOKENS_KEY].progress_apply(lambda tokens: construct_grid(token2color_model, tokens, method='color', dim=3))

        print(bcolors.BOLD + f'\tEmbedding Using Word2Vec Vectorizer...' + bcolors.ENDC)
        data[WORD2VEC_GRID_KEY] = data[CODE_RAW_TOKENS_KEY].progress_apply(lambda tokens: construct_grid(w2v_model, tokens, method='word2vec', dim=W2V_VECTOR_DIM))
        
        print(bcolors.BOLD + f'\tEmbedding Using Code2Vec Vectorizer...' + bcolors.ENDC)
        data[CODE2VEC_GRID_KEY] = data[CODE_RAW_TOKENS_KEY].progress_apply(lambda tokens: construct_grid(code2vec_model, tokens, method='code2vec', dim=CODE2VEC_VECTOR_DIM))



        print(f'\tSaving Embedded Data...')
        data.to_pickle(embedded_filename)