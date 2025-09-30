public class Clone909 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2598129
*  Stack Overflow answer #:2598209
*  And Stack Overflow answer#:2598434
*/
public static void removeDuplicates (char [] str) {
    if (str == null) return;
    int len = str.length;
    if (len < 2) return;
    int tail = 1;
    for (int i = 1;
    i < len; ++ i) {
        int j;
        for (j = 0; j < tail; ++ j) {
            if (str [i] == str [j]) break;
        }
        if (j == tail) {
            str [tail] = str [i];
            ++ tail;
        }
    }
    str [tail] = 0;
}

static String removeDuplicates (String s) {
    StringBuilder noDupes = new StringBuilder ();
    for (int i = 0;
    i < s.length (); i ++) {
        String si = s.substring (i, i + 1);
        if (noDupes.indexOf (si) == - 1) {
            noDupes.append (si);
        }
    }
    return noDupes.toString ();
}

}
