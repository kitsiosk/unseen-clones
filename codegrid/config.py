from pathlib import Path

class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

SPACE_TOKEN = ' codegridspace '
LINE_BREAK_TOKEN = ' codegridlinebreak '
TAB_TOKEN = ' codegridtab '
UNK_TOKEN = '<unk>'

DEFAULT_TAB_LEN = 4

TOKEN_SPLIT_PATTERN = r'([^\w_])'

CODE_CLASSIFICATION = 'code_classification'
CODE_CLONE_DETECTION = 'code_clone_detection'
CODE_COMPLETION = 'code_completion'
VULNERABILITY_DETECTION = 'vulnerability_detection'

TRAINING_DATASETS = [CODE_CLASSIFICATION, CODE_CLONE_DETECTION, CODE_COMPLETION, VULNERABILITY_DETECTION]
DATA_FILENAME = 'fragments.pkl'

BASE_PATH = Path.cwd() / '../' # by KK
ASTYLE_BIN = BASE_PATH / 'code' / 'bin' / 'astyle'
DATASET_BASE_FOLDER = BASE_PATH / 'datasets'
RAW_DATASET_FOLDER = DATASET_BASE_FOLDER / 'raw'
INNITIAL_PROCESSED_DATASET_FOLDER = DATASET_BASE_FOLDER / 'initial_processed'
GRIDDED_DATASET_FOLDER = DATASET_BASE_FOLDER / 'grids'

MODELS_FOLDER = BASE_PATH / 'models'

W2V_MODEL_NAME = '_codegrid_w2v_model.bin'
COLOR_MODEL_NAME = '_codegrid_t2c_model.pkl'
CODE2VEC_MODEL_NAME = 'code2vec/tokens_with_vectors.txt'

CODE_WITHOUT_COMMENTS_KEY = 'code_w/o_comments'
CODE_RAW_TOKENS_KEY = 'code_raw_tokens'
CODE_TOKENS_VECTORS_KEY = 'code_tokens_vectors'
COLOR_GRID_KEY = 'color_grid'
CODE2VEC_GRID_KEY = 'code2vec'
WORD2VEC_GRID_KEY = 'word2vec_grid'

SKIP_INITIAL_PROCESS = True
SKIP_TOKENS_EMBEDDING = True
SKIP_ENCODING_PROCESS = True
SAVE_PLOT = True

W2V_VECTOR_DIM = 4 # 100
W2V_VECTOR_SIZE = W2V_VECTOR_DIM
W2V_TRAINING_SEED = 42
W2V_WINDOWS_SIZE = 3
NUM_WORKERS = 4
W2V_MIN_TOKEN_LEN = 1
NUM_EPOCHS = 100

CODE2VEC_VECTOR_DIM = 128

SAMPLE_WIDTH = 224 # 71
SAMPLE_HEIGHT = 224 # 71
BATCH_SIZE = 4
