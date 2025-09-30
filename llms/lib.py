import os
import pandas as pd
import json
import pickle
from tqdm import tqdm
import multiprocessing
from more_itertools import unique_everseen
import concurrent.futures
import copy
import ollama
import openai

def create_cache(file_name, create_fn):
	print(f'Creating cache <{file_name}>..')
	result = create_fn()
	with open(file_name, 'wb') as f:
		pickle.dump(result, f)
	return result

def load_cache(file_name):
	if os.path.isfile(file_name):
		print(f'Loading cache <{file_name}>..')
		with open(file_name,'rb') as f:
			return pickle.load(f)
	return None

def load_or_create_cache(file_name, create_fn):
	result = load_cache(file_name)
	if result is None:
		result = create_cache(file_name, create_fn)
	return result

def get_cached_values(value_list, cache, fetch_fn, cache_name=None, key_fn=lambda x:x, empty_is_missing=True, **args):
	missing_values = tuple(
		q 
		for q in unique_everseen(filter(lambda x:x, value_list), key=key_fn) 
		if key_fn(q) not in cache or (empty_is_missing and not cache[key_fn(q)])
	)
	if len(missing_values) > 0:
		cache.update({
			key_fn(q): v
			for q,v in fetch_fn(missing_values)
		})
		if cache_name:
			create_cache(cache_name, lambda: cache)
	return [
		cache[key_fn(q)] if q else None 
		for q in value_list
	]

_loaded_caches = {}
def instruct_model(prompts, model='llama3.2', api_key=None, **kwargs):
	# if api_key == 'ollama':
	# 	return instruct_ollama_model(prompts, api_key=api_key, model=model, **kwargs)
	return instruct_openai_model(prompts, api_key=api_key, model=model, **kwargs)
			
def instruct_ollama_model(prompts, system_instructions=None, model='llama3.1', options=None, temperature=0.5, top_p=1, output_to_input_proportion=2, non_influential_prompt_size=0, cache_path='cache/', **args):
	max_tokens = 4096
	if options is None:
		# For Mistral: https://www.reddit.com/r/LocalLLaMA/comments/16v820a/mistral_7b_temperature_settings/
		options = { # https://github.com/ollama/ollama/blob/main/docs/modelfile.md#valid-parameters-and-values
			"seed": 42, # Sets the random number seed to use for generation. Setting this to a specific number will make the model generate the same text for the same prompt. (Default: 0)
			"num_predict": max_tokens, # Maximum number of tokens to predict when generating text. (Default: 128, -1 = infinite generation, -2 = fill context)
			"top_k": 40, # Reduces the probability of generating nonsense. A higher value (e.g. 100) will give more diverse answers, while a lower value (e.g. 10) will be more conservative. (Default: 40)
			"top_p": 0.95, # Works together with top-k. A higher value (e.g., 0.95) will lead to more diverse text, while a lower value (e.g., 0.5) will generate more focused and conservative text. (Default: 0.9)
			"temperature": 0.7, # The temperature of the model. Increasing the temperature will make the model answer more creatively. (Default: 0.8)
			"repeat_penalty": 1., # Sets how strongly to penalize repetitions. A higher value (e.g., 1.5) will penalize repetitions more strongly, while a lower value (e.g., 0.9) will be more lenient. (Default: 1.1)
			"tfs_z": 1, # Tail free sampling is used to reduce the impact of less probable tokens from the output. A higher value (e.g., 2.0) will reduce the impact more, while a value of 1.0 disables this setting. (default: 1)
			"num_ctx": 2**13,  # Sets the size of the context window used to generate the next token. (Default: 2048)
			"repeat_last_n": 64, # Sets how far back for the model to look back to prevent repetition. (Default: 64, 0 = disabled, -1 = num_ctx)
			# "num_gpu": 0, # The number of layers to send to the GPU(s). Set to 0 to disable.
		}
	else:
		options = copy.deepcopy(options) # required to avoid side-effects
	options.update({
		"temperature": temperature,
		"top_p": top_p,
	})
	def fetch_fn(instruction_prompt):
		system_instruction, missing_prompt = instruction_prompt
		_options = copy.deepcopy(options) # required to avoid side-effects
		if _options.get("num_predict",-2) == -2:
			prompt_tokens = 2*(len(missing_prompt.split(' '))-non_influential_prompt_size)
			_options["num_predict"] = int(output_to_input_proportion*prompt_tokens)
		response = ollama.generate(
			model=model,
			prompt=missing_prompt,
			stream=False,
			options=_options,
			keep_alive='1h',
			system=system_instruction,
		)
		# print(missing_prompt, response['response'])
		# return also the missing_prompt otherwise asynchronous prompting will shuffle the outputs
		return instruction_prompt, response['response']
	def parallel_fetch_fn(missing_prompt_list):
		n_processes = 1
		with concurrent.futures.ThreadPoolExecutor(max_workers=max(1,n_processes)) as executor:
			futures = [executor.submit(fetch_fn, prompt) for prompt in missing_prompt_list]
			for future in tqdm(concurrent.futures.as_completed(futures), total=len(missing_prompt_list), desc="Sending prompts to Ollama"):
				i,o=future.result()
				yield i,o
	os.makedirs(cache_path, exist_ok=True)
	ollama_cache_name = os.path.join(cache_path, f"_{model.replace('-','_')}_cache.pkl")
	if ollama_cache_name not in _loaded_caches:
		_loaded_caches[ollama_cache_name] = load_or_create_cache(ollama_cache_name, lambda: {})
	__ollama_cache = _loaded_caches[ollama_cache_name]
	cache_key = json.dumps(options,indent=4)
	return get_cached_values(
		list(zip(system_instructions if system_instructions else [None]*len(prompts), prompts)), 
		__ollama_cache, 
		parallel_fetch_fn, 
		# key_fn=lambda x: (x,model,n,temperature,top_p,frequency_penalty,presence_penalty), 
		key_fn=lambda x: (x,model,cache_key),  
		empty_is_missing=True,
		cache_name=ollama_cache_name,
	)

def instruct_openai_model(prompts, system_instructions=None, api_key=None, base_url=None, model='gpt-4o-mini', n=1, temperature=1, top_p=1, frequency_penalty=0, presence_penalty=0, cache_path='cache/', parallelise=True, **kwargs):
	chatgpt_client = openai.OpenAI(api_key=api_key, base_url=base_url)
	max_tokens = None
	adjust_max_tokens = True
	if '32k' in model:
		max_tokens = 32768
	elif '16k' in model:
		max_tokens = 16385
	elif model=='gpt-4o' or 'preview' in model or 'turbo' in model:
		max_tokens = 4096 #128000
		adjust_max_tokens = False
	if not max_tokens:
		if model.startswith('gpt-4'):
			max_tokens = 8192
		else:
			max_tokens = 4096
			adjust_max_tokens = False
	# print('max_tokens', max_tokens)
	def fetch_fn(instruction_prompt):
		system_instruction, missing_prompt = instruction_prompt
		if system_instruction:
			messages = [ 
				{"role": "system", "content": system_instruction},
			]
		else:
			messages = []
		messages += [ 
			{"role": "user", "content": missing_prompt} 
		]
		prompt_max_tokens = max_tokens
		if adjust_max_tokens:
			prompt_max_tokens -= int(3*len(missing_prompt.split(' \n')))
		if prompt_max_tokens < 1:
			return instruction_prompt, None
		try:
			if model.startswith("o"): # some params not available in reasoning models
				response = chatgpt_client.chat.completions.create(
					model=model,
					messages=messages,
					max_completion_tokens=prompt_max_tokens,
					n=n,
					stop=None,
					frequency_penalty=frequency_penalty, 
					presence_penalty=presence_penalty
				)
			else:
				response = chatgpt_client.chat.completions.create(
					model=model,
					messages=messages,
					max_tokens=prompt_max_tokens,
					n=n,
					stop=None,
					temperature=temperature,
					top_p=top_p,
					frequency_penalty=frequency_penalty, 
					presence_penalty=presence_penalty
				)
			# print(response.choices)
			result = [
				r.message.content.strip() 
				for r in response.choices 
				if r.message.content != 'Hello! It seems like your message might have been cut off. How can I assist you today?'
			]
			if len(result) == 1:
				result = result[0]
			return instruction_prompt, result # return also the missing_prompt otherwise asynchronous prompting will shuffle the outputs
		except Exception as e:
			print(f'OpenAI returned this error: {e}')
			return instruction_prompt, None
	def parallel_fetch_fn(missing_prompt_list):
		n_processes = multiprocessing.cpu_count() if parallelise else 1
		# Using ThreadPoolExecutor to run queries in parallel with tqdm for progress tracking
		with concurrent.futures.ThreadPoolExecutor(max_workers=max(1,n_processes)) as executor:
			futures = [executor.submit(fetch_fn, prompt) for prompt in missing_prompt_list]
			for e,future in enumerate(tqdm(concurrent.futures.as_completed(futures), total=len(missing_prompt_list), desc="Sending prompts to OpenAI")):
				i,o=future.result()
				yield i,o
	os.makedirs(cache_path, exist_ok=True)
	openai_cache_name = os.path.join(cache_path, f"_{model.replace('-','_')}_cache.pkl")
	if openai_cache_name not in _loaded_caches:
		_loaded_caches[openai_cache_name] = load_or_create_cache(openai_cache_name, lambda: {})
	__openai_cache = _loaded_caches[openai_cache_name]
	return get_cached_values(
		list(zip(system_instructions if system_instructions else [None]*len(prompts), prompts)), 
		__openai_cache, 
		parallel_fetch_fn, 
		# key_fn=lambda x: (x,model,n,temperature,top_p,frequency_penalty,presence_penalty), 
		key_fn=lambda x: (x,model,temperature,top_p,frequency_penalty,presence_penalty,n), 
		empty_is_missing=True,
		cache_name=openai_cache_name,
	)

def stratified_sample(df, total_samples=600, random_state=42):
	# Get unique label values and count how many there are.
	labels = df['label'].unique()
	num_labels = len(labels)
	print(num_labels)
	
	# Calculate how many samples per label ideally
	samples_per_label = total_samples // num_labels
	print(samples_per_label)
	# Collect samples for each label
	stratified_samples = []
	for lbl in labels:
		group = df[df['label'] == lbl]
		print(len(group))
		# If the group has fewer entries than samples_per_label, take all; otherwise sample the desired number.
		if len(group) < samples_per_label:
			stratified_samples.append(group)
		else:
			stratified_samples.append(group.sample(n=samples_per_label, random_state=random_state))
	
	print(len(stratified_samples[0]))
	print(len(stratified_samples[1]))

	# Combine stratified samples
	combined_sample = pd.concat(stratified_samples)
	
	# If there is a remainder (total_samples not evenly divisible), sample additional rows from the remaining ones.
	remaining_needed = total_samples - len(combined_sample)
	if remaining_needed > 0:
		# Exclude already sampled entries.
		remaining = df.drop(combined_sample.index)
		if len(remaining) >= remaining_needed:
			additional = remaining.sample(n=remaining_needed, random_state=random_state)
		else:
			additional = remaining  # take all if not enough remain
		combined_sample = pd.concat([combined_sample, additional])
	
	# Shuffle the final sample for randomness
	combined_sample = combined_sample.sample(frac=1, random_state=random_state).reset_index(drop=True)
	
	return combined_sample

def create_counterfactual(code):
    # source: https://github.com/niklasrisse/USENIX_2024/blob/main/scripts/VulnPatchPairs/transformations.py
    begin_of_function = code.index('{')

    text_to_insert = '\n    help_func();'

    code = code[0:begin_of_function + 1] + text_to_insert + code[begin_of_function + 1:]
    
    func_to_insert = 'void helpfunc() {\n'
        
    for i in range(150):
        func_to_insert += "return;\n"
        
    func_to_insert += ' } \n'

    code = code + "\n\n" + func_to_insert
    
    return code