#!/bin/bash

SCRIPT_PATH="$( cd "$(dirname "$0")" ; pwd -P )"

source ../.env/bin/activate

N=1   # how many examples to use for in-context learning
S=450 # dataset size

#################################
### Experiment 1
#################################
python experiment_1.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N
python experiment_1.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N
python experiment_1.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N
python experiment_1.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N
python experiment_1.py --model deepseek-r1-distill-qwen-32b  --sample_size $S --n_examples $N 
# python experiment_1.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N 

#################################
### Experiment 2
#################################
python experiment_2.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N
python experiment_2.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N
python experiment_2.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N
python experiment_2.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N
python experiment_2.py --model deepseek-r1-distill-qwen-32b --sample_size $S --n_examples $N 
# python experiment_2.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N 

#################################
### Experiment 3
#################################
python experiment_3.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N
python experiment_3.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N
python experiment_3.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N
python experiment_3.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N
python experiment_3.py --model deepseek-r1-distill-qwen-32b  --sample_size $S --n_examples $N 
# python experiment_3.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N 

#################################
### Experiment OJ 1
#################################
python experiment_1.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N --dataset oj
python experiment_1.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N --dataset oj
python experiment_1.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N 
python experiment_1.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N --dataset oj
python experiment_1.py --model deepseek-r1-distill-qwen-32b  --sample_size $S --n_examples $N --dataset oj
# python experiment_1.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N --dataset oj

#################################
### Experiment OJ 2
#################################
python experiment_2.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N --dataset oj
python experiment_2.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N --dataset oj
python experiment_2.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N 
python experiment_2.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N --dataset oj
python experiment_2.py --model deepseek-r1-distill-qwen-32b --sample_size $S --n_examples $N --dataset oj
# python experiment_2.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N --dataset oj

#################################
### Experiment OJ 3
#################################
python experiment_3.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N --dataset oj
python experiment_3.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N --dataset oj
python experiment_3.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N --dataset oj
python experiment_3.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N --dataset oj
python experiment_3.py --model deepseek-r1-distill-qwen-32b  --sample_size $S --n_examples $N --dataset oj
# python experiment_3.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N --dataset oj


#################################
### Experiment OJ Counterfactual 1
#################################
python experiment_1.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_1.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_1.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N 
python experiment_1.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_1.py --model deepseek-r1-distill-qwen-32b  --sample_size $S --n_examples $N --dataset oj-counterfactual
# python experiment_1.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N --dataset oj-counterfactual

#################################
### Experiment OJ Counterfactual 2
#################################
python experiment_2.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_2.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_2.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N 
python experiment_2.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_2.py --model deepseek-r1-distill-qwen-32b --sample_size $S --n_examples $N --dataset oj-counterfactual
# python experiment_2.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N --dataset oj-counterfactual

#################################
### Experiment OJ Counterfactual 3
#################################
python experiment_3.py --model gpt-3.5-turbo-0125 --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_3.py --model gpt-4o-2024-08-06 --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_3.py --model gpt-4o-mini-2024-07-18 --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_3.py --model llama-3.3-70b-versatile --sample_size $S --n_examples $N --dataset oj-counterfactual
python experiment_3.py --model deepseek-r1-distill-qwen-32b  --sample_size $S --n_examples $N --dataset oj-counterfactual
# python experiment_3.py --model o3-mini-2025-01-31 --sample_size $S --n_examples $N --dataset oj-counterfactual
