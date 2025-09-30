import pandas as pd
import os
import sys
sys.path.append('../../astnn')
import warnings
from tqdm.auto import tqdm

tqdm.pandas()
warnings.filterwarnings('ignore')

def check_or_create(path):
    if not os.path.exists(path):
        os.mkdir(path)

class Pipeline:
    def __init__(self, root):
        self.language = 'c'
        self.root = root
        self.sources = None
        self.blocks = None
        self.pairs = None
        self.train_file_path = None
        self.dev_file_path = None
        self.test_file_path = None
        self.size = None

    # parse source code
    def get_parsed_source(self, input_file: str,
                          output_file: str = None) -> pd.DataFrame:
        """Parse code using pycparser

        If the user doesn't provide `output_file`, the method reads the
        a DataFrame containing the columns id, code (C/Java code parsed
        by pycparser) and label. Otherwise it reads a Dataframe from
        `input_file` containing the columns id, code (input C/Java code)
        and label, applies the c_parser/javalang to the code column and
        stores the resulting dataframe into `output_file`

        Args:
            input_file (str): Path to the input file
            output_file (str): Path to the output file

        Returns:
            pd.DataFrame: DataFrame with the columns id, code (C/Java code
                parsed by pycparser/javalang) and label.
        """
        input_path = os.path.join(self.root, self.language, input_file)
        if output_file is None:
            source = pd.read_pickle(input_path)
        else:
            output_path = os.path.join(self.root, self.language, output_file)
            check_or_create(os.path.join(self.root, self.language))
            from pycparser import c_parser
            parser = c_parser.CParser()
            source = pd.read_pickle(input_path)
            source.columns = ['id', 'code']
            source['code'] = source['code'].progress_apply(parser.parse)
            source.to_pickle(output_path)
        self.sources = source
        return source

    def read_pairs(self, filename: str):
        """Create clone pairs

        Args:
            filename (str): [description]
        """
        pairs = pd.read_pickle(os.path.join(self.root, self.language, filename))
        self.pairs = pairs

    # construct dictionary and train word embedding
    def dictionary_and_embedding(self, input_file, size):
        self.size = size
        data_path = self.root+'/'+self.language+'/'
        if not input_file:
            input_file = self.train_file_path
        pairs = pd.read_pickle(input_file)
        
        train_ids = pd.concat([pairs['id1'], pairs['id2']]).unique()
        common_ids = list(set(train_ids).intersection(self.sources['id']))
        
        trees = self.sources.set_index('id', drop=False).loc[common_ids]
        if not os.path.exists(data_path+'oj_and_scb/embedding'):
            os.mkdir(data_path+'oj_and_scb/embedding')

        from prepare_data import get_sequences as func

        def trans_to_sequences(ast):
            sequence = []
            func(ast, sequence)
            return sequence
        corpus = trees['code'].apply(trans_to_sequences)
        str_corpus = [' '.join(c) for c in corpus]
        trees['code'] = pd.Series(str_corpus)
        # trees.to_csv(data_path+'train/programs_ns.tsv')

        from gensim.models.word2vec import Word2Vec
        w2v = Word2Vec(corpus, vector_size=size, workers=16, sg=1,
                       max_final_vocab=3000)
        w2v.save(data_path+'oj_and_scb/embedding/node_w2v_' + str(size))

    # generate block sequences with index representations
    def generate_block_seqs(self):
        from prepare_data import get_blocks as func
        from gensim.models.word2vec import Word2Vec

        word2vec = Word2Vec.load(
            self.root + '/'+ self.language+'/oj_and_scb/embedding/node_w2v_' +
            str(self.size)
        ).wv

        key_to_index = word2vec.key_to_index
        max_token = word2vec.vectors.shape[0]

        def tree_to_index(node):
            token = node.token
            result = [key_to_index[token] if token in key_to_index else max_token]
            children = node.children
            for child in children:
                result.append(tree_to_index(child))
            return result

        def trans2seq(r):
            blocks = []
            func(r, blocks)
            tree = []
            for b in blocks:
                btree = tree_to_index(b)
                tree.append(btree)
            return tree
        trees = pd.DataFrame(self.sources, copy=True)
        trees['code'] = trees['code'].apply(trans2seq)
        if 'label' in trees.columns:
            trees.drop('label', axis=1, inplace=True)
        self.blocks = trees

    # merge pairs
    def merge(self, data_path, blocks_path):
        pairs = pd.read_pickle(data_path)
        pairs['id1'] = pairs['id1'].astype(int)
        pairs['id2'] = pairs['id2'].astype(int)
        df = pd.merge(pairs, self.blocks, how='left', left_on='id1', right_on='id')
        df = pd.merge(df, self.blocks, how='left', left_on='id2', right_on='id')
        df.drop(['id_x', 'id_y'], axis=1, inplace=True)

        df.dropna(inplace=True, subset={'code_x', 'code_y'})

        df.to_pickle(blocks_path)

    # run for processing data to train
    def run(self):
        print('parse source code...')

        input_file = 'oj_and_scb/programs.pkl' 

        if os.path.exists(os.path.join(self.root, self.language, 'oj_and_scb', 'ast.pkl')):
            print('Loading ASTs from cache')
            self.get_parsed_source(input_file='oj_and_scb/ast.pkl')
        else:
            self.get_parsed_source(input_file=input_file, output_file='oj_and_scb/ast.pkl')

        print('read id pairs...')
        self.read_pairs('oj_and_scb/pair_ids.pkl')


        path_all = self.root+'/'+self.language+'/oj_and_scb/'
        pairs_file = path_all + 'pairs.pickle'
        check_or_create(path_all)
        self.pairs.to_pickle(pairs_file)

        print('train word embedding...')
        self.dictionary_and_embedding(pairs_file, 128)

        print('generate block sequences...')
        self.generate_block_seqs()

        print('merge pairs and blocks...')
        self.merge(pairs_file, path_all + 'blocks.pickle')


def main():
    ppl = Pipeline('data')
    ppl.run()


if __name__ == "__main__":
    main()
