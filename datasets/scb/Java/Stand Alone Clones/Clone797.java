public class Clone797 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32697798
*  Stack Overflow answer #:32698096
*  And Stack Overflow answer#:32698018
*/
public static String merge (String...s) {
    int maxLen = 0;
    for (String str : s) {
        maxLen = Math.max (maxLen, str.length ());
    }
    StringBuilder b = new StringBuilder ();
    for (int i = 0;
    i < maxLen; ++ i) {
        for (String str : s) {
            if (str.length () > i) {
                b.append (str.charAt (i));
            }
        }
    }
    return b.toString ();
}

public static String merge (String...strings) {
    int maxLength = 0;
    StringBuilder sb = new StringBuilder ();
    for (String s : strings) if (s.length () > maxLength) maxLength = s.length ();
    for (int i = 0;
    i < maxLength; i ++) for (String s : strings) if (s.length () > i) sb.append (s.charAt (i));
    return sb.toString ();
}

}
