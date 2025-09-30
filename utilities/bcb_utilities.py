import pandas as pd
import os

# How many clone pairs per functionality in the resulting dataset. The number of
# non-clone pairs will be the same, so total 2*MAX_CLONES_PER_FUNCTIONALITY pairs
# per functionality in the dataset
MAX_CLONES_PER_FUNCTIONALITY = 100

# Fetches at most N=MAX_CLONES_PER_FUNCTIONALITY rows for each functionality ID. 
# If a functionality ID has only M<N rows, it is not included in the dataset.
# The rows could be either clones (fetch_clones=True) or non-clones (fetch_clones=False). 
# Resulting table has columns
# code1 | code2 | label (0/1) | functionality_id
def fetch_functionality_data(fetch_clones=True):
    import psycopg2

    # Database connection parameters. The database is downloaded from https://github.com/clonebench/BigCloneBench
    db_params = {
        "host"    : "localhost",
        "database": "bcb",
        "user"    : "<your-user-name>",
        "password": "<your-password>"
    }

    # Establish connection
    conn = psycopg2.connect(**db_params)

    if fetch_clones:
        tableName   = "clones"
        label_value = 1
    else:
        tableName   = "false_positives"
        label_value = 0

    # Partition by functionality ID to obtain a row number that resets when functionality changes. Then,
    # fetch all rows with row_num<N
    query = """
    SELECT setseed(0.42);
    
    WITH RandomizedRows AS (
      SELECT
        function_id_one, function_id_two, functionality_id, %d as label,
        ROW_NUMBER() OVER (PARTITION BY functionality_id ORDER BY random()) AS row_num
      FROM %s
      WHERE syntactic_type=3    
    )
    SELECT
      f1.text AS code1, f2.text AS code2, R.label, R.functionality_id
    FROM
      RandomizedRows AS R
      INNER JOIN
      pretty_printed_functions AS f1 ON R.function_id_one=f1.function_id
      INNER JOIN 
      pretty_printed_functions AS f2 ON R.function_id_two=f2.function_id
    WHERE R.row_num <= %d;
    """ % (label_value, tableName, MAX_CLONES_PER_FUNCTIONALITY)
    
    data = pd.read_sql_query(query, conn)
    return data

def get_functionality_data():
    data_bcb_fname = '../datasets/bcb_v2_sampled_bf/data_bcb_v2_sampled_bf.pickle'
    if os.path.isfile(data_bcb_fname):
        data_bcb = pd.read_pickle(data_bcb_fname)
        print("Loaded %s from cache..." % (data_bcb_fname))
    else:
        data_true      = fetch_functionality_data(fetch_clones=True , MAX_CLONES_PER_FUNCTIONALITY=MAX_CLONES_PER_FUNCTIONALITY)
        data_false     = fetch_functionality_data(fetch_clones=False, MAX_CLONES_PER_FUNCTIONALITY=MAX_CLONES_PER_FUNCTIONALITY)

        # Find common functionality_ids
        common_functionality_ids = set(data_true['functionality_id']).intersection(set(data_false['functionality_id']))

        # For each functionality_id, keep N true pairs and N false pairs where N is the
        # minimum number of occurences of functionality_id in "data_true" and "data_false". E.g., 
        # if for functionality_id=1 we fetched 30 true clones and 20 false clones, we will keep
        # min(20,30)=20 ture clones and 20 false clones so that the dataset is balanced
        data_bcb = pd.concat([
            data_true[data_true['functionality_id'] == func_id].head(
                min(
                    data_true['functionality_id'].value_counts().get(func_id, 0),
                    data_false['functionality_id'].value_counts().get(func_id, 0)
                )
            )
            for func_id in common_functionality_ids
        ] + [
            data_false[data_false['functionality_id'] == func_id].head(
                min(
                    data_true['functionality_id'].value_counts().get(func_id, 0),
                    data_false['functionality_id'].value_counts().get(func_id, 0)
                )
            )
            for func_id in common_functionality_ids
        ], ignore_index=True)

        # Keep only functionalities with at least 2*MAX_CLONES_PER_FUNCTIONALITY pairs
        for f,i in data_bcb.groupby('functionality_id').size().items():
            if i < 2*MAX_CLONES_PER_FUNCTIONALITY:
                data_bcb = data_bcb[data_bcb.functionality_id != f]

        data_bcb.to_pickle(data_bcb_fname)

    return data_bcb