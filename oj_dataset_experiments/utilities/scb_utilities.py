import pandas as pd
import os


def remove_comments(c_code):
    start_index = c_code.find('/*')
    end_index = c_code.find('*/', start_index)

    if start_index != -1 and end_index != -1:
        result_code = c_code[:start_index] + c_code[end_index + 2:]
    else:
        result_code = c_code
        
    result_code = result_code.strip()

    return result_code


def combine_to_create_false_pairs(data_scb):
    false_pairs = []
    # Iterate over the first half of the original DataFrame
    for i in range(len(data_scb) // 2):
        # Combine "code1" of the current row with "code1" of the corresponding row in the second half
        new_code1 = data_scb.at[i, 'code1']
        # Get "code2" of the current row
        new_code2 = data_scb.at[i + len(data_scb) // 2, 'code1']

        # Combine "code1" of the current row with "code1" of the corresponding row in the second half
        new_code3 = data_scb.at[i, 'code2']
        # Get "code2" of the current row
        new_code4 = data_scb.at[i + len(data_scb) // 2, 'code2']
        
        # Set label to 0
        label = 0
        
        # Append a new row to the new DataFrame
        false_pairs.append({'code1': new_code1, 'code2': new_code2, 'label': label})
        false_pairs.append({'code1': new_code3, 'code2': new_code4, 'label': label})

    data_scb_false_pairs = pd.DataFrame(false_pairs)

    data_scb = pd.concat([data_scb, data_scb_false_pairs]).reset_index()

    return data_scb


def get_data_scb(create_false_pairs=True):
    # Path to the folder containing C files
    folder_path = "../../datasets/scb/C/Stand Alone Clones"

    # List to store data
    c_data = []

    # Iterate through each file in the folder
    for filename in os.listdir(folder_path):
        file_path = os.path.join(folder_path, filename)
        
        # Read the content of the c file
        with open(file_path, 'r') as file:
            c_code = file.read()

        c_code = remove_comments(c_code)
        t = c_code.split('\n\n')

        if len(t) != 2:
            print(t)
            continue

        c_data.append({'filename':filename, 'code1':t[0], 'code2':t[1], 'label':1})
            

    # Create a DataFrame
    data_scb = pd.DataFrame(c_data)
    if create_false_pairs:
        data_scb = combine_to_create_false_pairs(data_scb)

    return data_scb

