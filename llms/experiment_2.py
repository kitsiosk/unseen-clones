import pandas as pd
import argparse
import re
import math
from lib import *
import sys
sys.path.append('../utilities')
from bcb_utilities import get_functionality_data
sys.path.append('../oj_dataset_experiments/utilities')
from oj_utilities import get_functionality_data as get_functionality_data_oj

parser = argparse.ArgumentParser(description="Provide model")
parser.add_argument(
	"--model",
	type=str,
	required=True,
	help="Specify the model name (e.g., 'llama3.1', 'llama3.2', 'llama3.3', 'gpt-4o-mini-2024-07-18', 'gpt-3.5-turbo-0125', 'o3-mini-2025-01-31', 'gpt-4o-2024-08-06')"
)
parser.add_argument(
	"--n_examples",
	type=int,
	default=1,
	help="Specify how many examples per functionality; default is 2."
)
parser.add_argument(
	"--random_state",
	type=int,
	default=42,
	help="Default is 42."
)
parser.add_argument(
	"--sample_size",
	type=int,
	default=600,
	help="Default is 600."
)
parser.add_argument(
	"--dataset",
	type=str,
	default="bcb",
	help="Either bcb or oj."
)
args = parser.parse_args()

dataset = args.dataset
if dataset == "bcb":
	incontext_df = pd.read_csv('llm_data.csv')
	df = get_functionality_data()
elif dataset == "oj":
	incontext_df = pd.read_csv('llm_data_oj.csv')
	df = get_functionality_data_oj()
	# rename to be on par with bcb
	df['functionality_id'] = df['functionality_id1']
elif dataset == "oj-counterfactual":
	incontext_df = pd.read_csv('llm_data_oj.csv')
	df = get_functionality_data_oj()
	df['code1'] =  df['code1'].apply(lambda x: create_counterfactual(x))
	df['code2'] =  df['code2'].apply(lambda x: create_counterfactual(x))
	# rename to be on par with bcb
	df['functionality_id'] = df['functionality_id1']

half_size = args.sample_size // 2
# Drop duplicates first to ensure unique (code1, code2) pairs
df_clones = df[df['label'] == 1].drop_duplicates(subset=['code1', 'code2'])
df_nonclones = df[df['label'] == 0].drop_duplicates(subset=['code1', 'code2'])
# Sample required number of unique rows from each subset
df_clones_sampled = df_clones.sample(n=half_size, random_state=args.random_state)
df_nonclones_sampled = df_nonclones.sample(n=half_size, random_state=args.random_state)
# Concatenate the two subsets to form the final dataframe
df = pd.concat([df_clones_sampled, df_nonclones_sampled]).reset_index(drop=True)


results_dir = './results/%s/experiment_2' % dataset
os.makedirs(results_dir, exist_ok=True)

model = args.model
if model.startswith('gpt') or model.startswith('o1') or model.startswith('o3'):
	api_key = os.getenv('OPENAI_API_KEY')
	base_url = "https://api.openai.com/v1"
	parallelise = True
elif model in ['deepseek-r1-distill-qwen-32b','llama-3.3-70b-versatile','mixtral-8x7b-32768']:
	api_key = os.getenv('GROQ_API_KEY')
	base_url = "https://api.groq.com/openai/v1"
	parallelise = True
else:
	api_key ='ollama' # required, but unused
	base_url = 'http://localhost:11434/v1'
	parallelise = False

llm_options = {
	'model': model,
	'temperature': 0,
	'top_p': 0,
	'api_key': api_key,
	'base_url': base_url,
	'parallelise': parallelise,
}

# ----------------------------
# 2. Process the scenarios
# ----------------------------

system_instruction = (
	"When responding, your answer must be formatted exactly as follows:\n"
	"Explanation: <a clear explanation of your classification here>\n"
	"Classification: <your classification here: either Clone or Not Clone>\n"
	"Make sure to follow this format strictly without any additional text or formatting."
)

decision_pattern = r'[*#\s"\'()\n]*Classification[*#\s"\'()\n]*[:\n][*#\s"\'\n]*([^\n]+)[*#\s"\']*'
explanation_pattern = r'[*#\s"\'()\n]*Explanation[*#\s"\'()\n]*[:\n][*#\s"\'\n]*([^\n]+)[*#\s"\']*'

def get_decision_and_explanation_from_output(gpai_output):
	# Find all matches for the decision pattern
	cs_matches = list(re.finditer(decision_pattern, gpai_output.replace('Answer','Classification').replace('Option:','Classification:')))
	# Extract the last match if it exists
	decision = cs_matches[-1].group(1).strip().strip('.*') if cs_matches else None
	# Find all matches for the explanation pattern
	se_matches = list(re.finditer(explanation_pattern, gpai_output))
	# Extract the last match if it exists
	explanation = se_matches[-1].group(1).strip().strip('.*') if se_matches else ''
	if not decision:
		# print(decision)
		raise ValueError(f'Cannot get a decision for: {gpai_output}')
	return decision, explanation

def construct_clone_detection_prompt(entry, df, n_examples=2, i=0):
	"""
	Constructs a prompt with few-shot examples for clone detection.
	
	Parameters:
		entry (pd.Series): A row from df representing the target entry.
		df (pd.DataFrame): The DataFrame containing entries with same functionality.
		n_examples (int): Number of examples to sample from each category (clones and non-clones).
	
	Returns:
		prompt (str): A string prompt for the LLM.
	"""
	functionality_id = entry['functionality_id']
	
	# Filter the DataFrame to the same functionality and exclude the current entry
	subset = df[(df['functionality_id'] != functionality_id) & 
						   (df.index != entry.name)]
	
	# Separate examples by label
	clones = subset[subset['label'] == 1]
	non_clones = subset[subset['label'] == 0]

	# Sample a few examples from each group, if available
	if non_clones.empty:
		print("Empty")
	if clones.empty:
		print("Clones empty")

	sample_clones = clones.sample(n=n_examples, random_state=i) if not clones.empty else pd.DataFrame()
	sample_non_clones = non_clones.sample(n=n_examples, random_state=i) if not non_clones.empty else pd.DataFrame()
	
	# Build the prompt as a multi-line string
	prompt_lines = []

	# Present the target entry for classification.
	prompt_lines.append("You are an experienced software developer, tasked to determine whether the following code pair is a semantic clone or not, based on the definition below.")

	# Provide a definition of clone.
	prompt_lines.append("### Definition of Semantic Clone:")
	prompt_lines.append("Two pieces of code form a semantic clone if they implement the same functionality; Two pieces of code form a semantic clone even if the first piece implements functionality F and the second snippet implements functionality F plus additional functionalities, so the two pieces do no have to have 100% match in functionality, but to implement at least some shared functionality.")
	prompt_lines.append("A functionality is a non-obvious sequence of code statements to accomplish a clearly and compactly definable task. Examples of functionalities are Fibonacci, Greatest Common Divisor, or Test Palindrome.")
	prompt_lines.append("Even if the two code segments differ significantly in structure or syntax, they may still be semantic clones, which differentiates semantic clones from syntactic clones.\n")
	
	prompt_lines.append("### Code Pair to Analyze:")
	prompt_lines.append("Code1: " + entry['code1'])
	prompt_lines.append("Code2: " + entry['code2'])
	# Append the few-shot examples after the entry.
	prompt_lines.append("Below you can find one example of a clone pair and one example of a non-clone pair for reference. ")

	
	# Add clone examples.
	if not sample_clones.empty:
		for _, row in sample_clones.iterrows():
			prompt_lines.append("### Example (Clone):")
			prompt_lines.append("Code1: " + row['code1'])
			prompt_lines.append("Code2: " + row['code2'])
			prompt_lines.append("Classification: Clone\n")
	
	# Add non-clone examples.
	if not sample_non_clones.empty:
		for _, row in sample_non_clones.iterrows():
			prompt_lines.append("### Example (Not Clone):")
			prompt_lines.append("Code1: " + row['code1'])
			prompt_lines.append("Code2: " + row['code2'])
			prompt_lines.append("Classification: Not Clone\n")
	
	prompt_text = "\n".join(prompt_lines)
	return prompt_text

entries = list(df.iterrows()) 

prompts=[]
i=0
for idx, row in entries:
	prompts.append(
		construct_clone_detection_prompt(row, incontext_df, n_examples=args.n_examples, i=i)
	)
	i+=1

results = []
total_n = 0
tn = fn = tp = fp = 0
model_outputs = instruct_model(prompts, system_instructions=[system_instruction]*len(prompts), **llm_options)

for (idx, row),output in zip(entries,model_outputs):
	try:
		decision, explanation = get_decision_and_explanation_from_output(output)
	except Exception as e:
		# print(output, e)
		continue
	results.append({
		'decision': decision,
		'explanation': explanation,
		'ground_truth': row['label'],
		'functionality_id': row['functionality_id'],
		'code1': row['code1'],
		'code2': row['code2'],
		'idx': idx,
	})
	if decision.casefold() == 'Not Clone'.casefold():
		if row['label'] == 0:
			tn += 1
		else:
			fn += 1
	if decision.casefold() == 'Clone'.casefold():
		if row['label'] == 1:
			tp += 1
		else:
			fp += 1		
	total_n += 1

# print(prompts[0])
precision = tp/(tp+fp) if tp+fp > 0 else 0
recall = tp/(tp+fn) if tp+fn > 0 else 0
f1 = 2*(precision*recall)/(precision+recall) if precision+recall > 0 else 0
mcc = ((tp*tn) - (fp*fn))/math.sqrt((tp+fp)*(tp+fn)*(tn+fp)*(tn+fn)) if (tp+fp)*(tp+fn)*(tn+fp)*(tn+fn) > 0 else 0

# Define the filename for the CSV file
short_llm_options = {key: llm_options[key] for key in ['model', 'temperature', 'top_p'] if key in llm_options}

results_str = '\n'.join((
	f'Samples: {total_n}',
	f'\t- Positives: {tp+fn}',
	f'\t- Negatives: {tn+fp}',
	f'Scores:',
	f'\t- Accuracy: {(tp+tn)/total_n if total_n > 0 else 0:.2f}',
	f'\t- Precision: {precision:.2f}',
	f'\t- Recall: {recall:.2f}',
	f'\t- F1: {f1:.2f}',
	f'\t- MCC: {mcc:.2f}',
))
# Save the string to a file named "results.txt"
with open(os.path.join(results_dir, f'scores_{"_".join(map(lambda x: f"{x[0]}-{x[1]}", short_llm_options.items()))}.txt'), 'w') as f:
    f.write(results_str)
print(results_str)

# print(prompts[0])
# print('-'*20)
# print(prompts[1])

df_res = pd.DataFrame(results)
csv_filename = os.path.join(results_dir, f'decisions_{"_".join(map(lambda x: f"{x[0]}-{x[1]}", short_llm_options.items()))}.csv')
# Save the DataFrame to a CSV file
df_res.to_csv(csv_filename, index=False)

# print(json.dumps(results, indent=4))

