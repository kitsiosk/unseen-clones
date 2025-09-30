import pandas as pd
import os

def get_functionality_data():
    fname1 = '../../datasets/oj/oj_clone_ids.pkl'
    fname2 = '../../datasets/oj/programs.pkl'
    if not os.path.isfile(fname1):
        fname1 = '../datasets/oj/oj_clone_ids.pkl' # llm experiments
        fname2 = '../datasets/oj/programs.pkl'

    d1 = pd.read_pickle(fname1)
    d2  = pd.read_pickle(fname2)

    data_oj = d1.merge(d2, left_on='id1', right_on=0, how='inner')

    data_oj = data_oj.rename(columns={1:'code1', 2:'functionality_id1'})

    data_oj = data_oj.drop(0, axis=1)

    data_oj = data_oj.merge(d2, left_on='id2', right_on=0, how='inner')

    data_oj = data_oj.rename(columns={1:'code2', 2:'functionality_id2'})

    data_oj = data_oj.drop(0, axis=1)


    return data_oj