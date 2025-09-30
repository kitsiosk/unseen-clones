public class Clone288 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33454269
*  Stack Overflow answer #:33454536
*  And Stack Overflow answer#:33514863
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

public Object [] tokenizer (String value, String [] delimeters) {
    List < String > list = new ArrayList < String > ();
    for (String s : delimeters) {
        if (value.contains (s)) {
            String [] strArr = value.split ("\\" + s);
            for (String str : strArr) {
                list.add (str);
                if (! list.contains (s)) {
                    list.add (s);
                }
            }
        }
    }
    Object [] newValues = list.toArray ();
    return newValues;
}

}
