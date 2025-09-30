public class Clone275 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35999040
*  Stack Overflow answer #:36000351
*  And Stack Overflow answer#:36000351
*/
static GenericType parse (String s) {
    StreamTokenizer tokenizer = new StreamTokenizer (new StringReader (s));
    tokenizer.wordChars ('.', '.');
    try {
        tokenizer.nextToken ();
        return parse (tokenizer);
    } catch (IOException e) {
        throw new RuntimeException ();
    }
}

static GenericType parse (StreamTokenizer tokenizer) throws IOException {
    String baseName = tokenizer.sval;
    tokenizer.nextToken ();
    List < GenericType > params = new ArrayList < > ();
    if (tokenizer.ttype == '<') {
        do {
            tokenizer.nextToken ();
            params.add (parse (tokenizer));
        } while (tokenizer.ttype == ',');
        tokenizer.nextToken ();
    }
    return new GenericType (baseName, params);
}

}
