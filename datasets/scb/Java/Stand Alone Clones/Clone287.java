public class Clone287 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33454269
*  Stack Overflow answer #:33454536
*  And Stack Overflow answer#:33643403
*/
private static String [] tokenizer (String subject, String [] delimiters) {
    Arrays.sort (delimiters, new Comparator < String > () {
        @Override
        public int compare (String s1, String s2) {
            return s2.length () - s1.length ();
        }}
    );
    List < String > tokens = new ArrayList < String > ();
    tokens.add (subject);
    for (int i = 0;
    i < delimiters.length; i ++) {
        tokens = splitStrings (tokens, delimiters, i);
    }
    return tokens.toArray (new String [] {});
}

public static String [] tokenizer (String text, String [] delims) {
    for (String delim : delims) {
        int i = text.indexOf (delim);
        if (i >= 0) {
            String [] tail = tokenizer (text.substring (i + delim.length ()), delims);
            String [] list = new String [tail.length + 2];
            list [0] = text.substring (0, i);
            list [1] = delim;
            System.arraycopy (tail, 0, list, 2, tail.length);
            return list;
        }
    }
    return new String [] {text};
}

}
