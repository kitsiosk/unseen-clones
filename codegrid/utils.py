import re
import tempfile
import subprocess
import itertools

from config import LINE_BREAK_TOKEN, SPACE_TOKEN, TAB_TOKEN, TOKEN_SPLIT_PATTERN, DEFAULT_TAB_LEN, ASTYLE_BIN

def tokenize_code(code):
    code = code.replace('\n', LINE_BREAK_TOKEN)
    code = code.replace('     ', TAB_TOKEN)
    code = code.split()
    code = ' '.join(code)
    code = code.replace(' ', SPACE_TOKEN)
    tokens = re.split(pattern=TOKEN_SPLIT_PATTERN, string=code)
    tokens = [t for t in tokens if len(t.strip()) > 0] # removing whitespaces
    output_tokens = []
    for i, token in enumerate(tokens):
        if token == SPACE_TOKEN.strip() and next_token(i, tokens) in [LINE_BREAK_TOKEN.strip(), TAB_TOKEN.strip()]:
            continue
        if previous_token(i, tokens) in [LINE_BREAK_TOKEN.strip(), TAB_TOKEN.strip()] and token == SPACE_TOKEN.strip():
            continue
        output_tokens.append(token)
    return output_tokens

def tokens_to_code(tokens):
    code = ''.join(tokens)
    code = code.replace(LINE_BREAK_TOKEN.strip(), '\n')
    code = code.replace(TAB_TOKEN.strip(), '\t')
    code = code.replace(SPACE_TOKEN.strip(), ' ')
    return code

def get_tokens_coordinates(tokens):
    tokens_positions = []
    x, y = -1, 0
    for token in tokens:
        position = dict()
        position[token] = []
        token_len = len(token) if token not in [SPACE_TOKEN.strip(), LINE_BREAK_TOKEN.strip()] else 1
        if token == TAB_TOKEN.strip():
            token_len = DEFAULT_TAB_LEN
        for i in range(token_len):
            x = x + 1
            position[token].append((x, y))
        tokens_positions.append(position)
        if token == LINE_BREAK_TOKEN.strip():
            y = y + 1
            x = -1
    return tokens_positions
        
def remove_comments(code):
    def replacer(match):
        s = match.group(0)
        if s.startswith('/'):
            return ""
        else:
            return s
    pattern = re.compile(
        r'(?<!\:)//.*?$|/\`*.*?\*/', # |\'(?:\\.|[^\\\'])*\'|"(?:\\.|[^\\"])*"
        re.DOTALL | re.MULTILINE
    )
    code = re.sub(pattern, replacer, code)
    return '\n'.join([line for line in code.split('\n') if len(line.strip()) > 0])

def compute_brigtness(rgb_color):
    (r, g, b) = rgb_color
    return 0.2126 * r + 0.7152 * g + 0.0722 * b

def MidSort(lst):
    if len(lst) <= 1:
        return lst
    i = int(len(lst)/2)
    ret = [lst.pop(i)]
    left = MidSort(lst[0:i])
    right = MidSort(lst[i:])
    interleaved = [item for items in itertools.zip_longest(left, right)
    for item in items if item != None]
    ret.extend(interleaved)
    return ret

def generate_colors(n):
    # Build list of points on a line (0 to 255) to use as color 'ticks'
    n = n + 1
    max = 255
    segs = int(n ** (1.0 / 3))
    step = int(max / segs)
    p = [(i * step) for i in range(1, segs)]
    points = [0, max]
    points.extend(MidSort(p))

    rgb_values, hex_values, brightness = [], [], []

    r = 0
    total = 1
    while total < n and r < len(points):
        r += 1
        for c0 in range(r):
            for c1 in range(r):
                for c2 in range(r):
                    if total >= n:
                        break
                    c = "%02X%02X%02X" % (points[c0], points[c1], points[c2])
                    if c not in hex_values:
                        hex_values.append(c)
                        rgb_color = (points[c0], points[c1], points[c2])
                        rgb_values.append(rgb_color)
                        brightness.append(compute_brigtness(rgb_color))
                        total += 1

    return [rgb_values, hex_values, brightness]

def next_token(current_position, tokens):
    if current_position < len(tokens) - 1:
        n_token = tokens[current_position + 1]
        return n_token
    else:
        return None

def previous_token(current_position, tokens):
    if current_position > 0:
        p_token = tokens[current_position - 1]
        return p_token
    else:
        return None

def beautify_code(code, method='gnu-indent', output='/dev/stdout', language='c'):
    if method == 'gnu-indent':
        code = code.replace('\n', ' ')
        code = code.replace('\t', ' ')
        results = code
        cli_tool = ['indent']
        options = ['-bc', '-di1', '-nbc']
        with tempfile.NamedTemporaryFile() as f:
            f.write(str.encode(code))
            f.flush()

            inputs = [f.name]
            command = cli_tool + options + inputs + [output]
            results = subprocess.run(command, capture_output=True)
            if results.returncode == 0:
                try:
                    results = results.stdout.decode("utf-8")
                except:
                    results = code
            else:
                print(results.stderr)
                results = code
        return results
    elif method == 'astyle':
        results = code
        cli_tool = [f'{str(ASTYLE_BIN)}']
        options = [f'--mode={language}']
        with tempfile.NamedTemporaryFile() as f:
            f.write(str.encode(code))
            f.flush()

            inputs = [f.name]
            command = cli_tool + options + inputs # + [output]
            results = subprocess.run(command, capture_output=True)
            if results.returncode == 0:
                f.flush()
                results = subprocess.run(['cat', f.name], capture_output=True)
                if results.returncode == 0:
                    try:
                        results = results.stdout.decode("utf-8")
                    except:
                        results = code
                else:
                    print(results.stderr)
                    results = code
                return results
            else:
                return code
    elif method == 'manual':
        trigger_line_break_characters = ['{', ';', '}']
        not_trigger_space_characters = ['.', ',', ';', '[', ']', '(', ')', ',']
        not_trigger_space_characters = ['.', ',', '[', ']', '(', ')', ',']

        lines = code.split('\n')
        code = []
        for line in lines:
            code.append(line.strip())
        code = '\n'.join(code)
        tokens = tokenize_code(code)
        tokens = [t for t in tokens if t not in [LINE_BREAK_TOKEN.strip(), TAB_TOKEN.strip(), SPACE_TOKEN.strip()]]
        beautiful_code = []
        line_start = True
        for i, token in enumerate(tokens):
            if i == 0 or token in trigger_line_break_characters:
                line_start = True
            else:
                line_start = False
            add_space = False
            if token in trigger_line_break_characters:
                beautiful_code.append(token)
                beautiful_code.append(LINE_BREAK_TOKEN.strip())
                beautiful_code.append(TAB_TOKEN.strip())
            else:
                beautiful_code.append(token)
                if next_token(i, tokens) == token:
                    add_space = False
                else:
                    add_space = True
                if next_token(i, tokens) in not_trigger_space_characters:
                    add_space = False
                if token in not_trigger_space_characters:
                    add_space = False
                if add_space:
                    beautiful_code.append(SPACE_TOKEN.strip())
                
        beautiful_code = tokens_to_code(beautiful_code)
        return beautiful_code

def display_image(image):
    plt.imshow(image)
    plt.show()

if __name__ == '__main__':
    code = """int main() { 
int n, i, j; 
cin >> n; 
char str[100][81]; 
cin.get(); 
for (i = 0; i < n; i++) { 
  cin.getline(str[i], 81);
  if (int a == 0) {
    printf("Hello WOrld");
  }
}
return 0; 
 }"""
    print(code)
    o = beautify_code(code, method='astyle')
    print(o)