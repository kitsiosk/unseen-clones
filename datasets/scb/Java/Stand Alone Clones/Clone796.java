public class Clone796 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32697798
*  Stack Overflow answer #:32698096
*  And Stack Overflow answer#:32698106
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

private static String merge (String...strings) {
    StringBuilder sb = new StringBuilder ();
    int adv;
    boolean edited;
    adv = 0;
    edited = true;
    while (edited) {
        edited = false;
        for (String s : strings) {
            if (adv < s.length ()) {
                sb.append (s.charAt (adv));
                edited = true;
            }
        }
        adv ++;
    }
    return sb.toString ();
}

}
