# Detecting Semantic Clones of Unseen Functionality
This is the replication package for the paper titled [Detecting Semantic Clones of Unseen Functionality](https://arxiv.org/pdf/2510.04143) that will be presented at ASE '25.

### Table of Contents
- [Structure](#structure)
- [Setup](#setup)
- [Evaluating on Unseen Functionalities (RQ1)](#evaluating-on-unseen-functionalities-rq-1)
- [Improvements with Contrastive Learning (RQ2)](#improvements-with-contrastive-learning-rq-2)
- [Generative LLM Experiments (RQ1 + RQ2)](#generative-llm-experiments-rq1--rq2)


### Structure
The three task-specific models we use in our main experiments are CodeBERT [1], ASTNN [2], and CodeGrid [3], and each of them has its own folder (`codebert/`, `astnn/`, and `codegrid/` respectively). Functions are shared between the models (mainly data loading) are in the `utilities/` folder, while all the datasets used are available in the `datasets/` folder. The `oj_datasets_experiments/` folder contains code for our additional experiments of Section IV.C. (*Evaluating on Strict Clones*), and it also contains a dedicated `README.md` on how to run these experiments. Finally, the code, results, and prompts for the generative LLM experiments can be found in the `llms/` directory. 

Finally, the introduced dataset `BCBs'` can be found in `datasets/bcb_v2_sampled_bf/data_bcb_v2_sampled_bf.pickle`, while the script to reproduce the sampling that leads to this dataset is in `utilities/bcb_utilities.py`.



### Setup
We tested the code on `macOS Sonoma 14` and `Ubuntu` with `Python 3.9.6`. To run the code, first create a virtual environment

```sh
python3.9 -m venv .env
source .env/bin/activate
```

and install the requirements

```sh
pip install -r requirements.txt
```

### Evaluating on Unseen Functionalities (RQ1)
In Research Question (RQ) 1, we evaluate the three models on functionalities unseen during training; we compare their performance to the performance reported in their original papers. We use three evaluation methods, namely *one-vs-rest*, *train-bcb-test-scb*, and *train-scb-test-bcb*. To run the experiments for RQ2 (for the task-specific models, for the LLMs see below), follow these instructions.

###### CodeBERT
```sh
cd codebert
python 1vsRest_baseline.py
python bcb_scb_baseline.py --train_on bcb
python bcb_scb_baseline.py --train_on scb
```

###### ASTNN
```sh
cd ../astnn
python pipeline_1vsRest.py
python pipeline_bcb_scb.py
python 1vsRest_baseline.py
python bcb_scb_baseline.py --train_on bcb
python bcb_scb_baseline.py --train_on scb
```

###### CodeGrid
```sh
cd ../codegrid
python 1vsRest_baseline.py
python bcb_scb_baseline.py --train_on bcb
python bcb_scb_baseline.py --train_on scb
```


###### Slurm
Some experiments are computationally intensive, especially the `1vsRest___.py` scripts that involve a sequence of experiments. For convenience, we also provide the Slurm files that we used to run these experiments in a Slurm cluster. They can be found under the `slurm/` folder of each model's directory. However, the code runs without Slurm as well.

### Improvements with Contrastive Learning (RQ2)
In RQ2, we replace the final classifier of the three models with a contrastive classifier (for detailed architecture see our paper) and re-evaluate. We compare their performance to their performance in RQ2, to test whether and by how much contrastive learning improves performance on unseen functionalities. To run the experiments for RQ2 (for the task-specific models, for the LLMs see below), follow these instructions.

###### CodeBERT
```sh
cd codebert
python 1vsRest_siamese.py
python bcb_scb_siamese.py --train_on bcb
python bcb_scb_siamese.py --train_on scb
```

###### ASTNN
```sh
cd ../astnn
python 1vsRest_siamese.py
python bcb_scb_siamese.py --train_on bcb
python bcb_scb_siamese.py --train_on scb
```

###### CodeGrid
```sh
cd ../codegrid
python 1vsRest_siamese.py
python bcb_scb_siamese.py --train_on bcb
python bcb_scb_siamese.py --train_on scb
```

### Generative LLM Experiments (RQ1 + RQ2)
Executing `run_all_experiments.sh` will run all the experiments mentioned in the paper that involve generative LLMs. An OpenAI API key is required for the OpenAI models and a Groq key for DeepSeek, which you can set by running `export OPENAI_API_KEY=xxx` and `export GROQ_API_KEY=xxx` respectively.

