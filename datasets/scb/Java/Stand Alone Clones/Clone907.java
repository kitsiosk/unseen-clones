public class Clone907 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2598129
*  Stack Overflow answer #:26372240
*  And Stack Overflow answer#:2598434
*/
private static void removeDuplicates (char [] str) {
    if (str == null || str.length < 2) {
        return;
    }
    int tail = 0;
    for (int i = 0;
    i < str.length; i ++) {
        boolean found = false;
        for (int j = 0;
        j < i; j ++) {
            if (str [j] == str [i]) {
                found = true;
                break;
            }
        }
        if (found) {
            continue;
        }
        str [tail] = str [i];
        tail ++;
    }
    str [tail] = '\0';
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
