public class Clone597 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2850203
*  Stack Overflow answer #:9161032
*  And Stack Overflow answer#:18816371
*/
public static int countLines (String str) {
    if (str == null || str.length () == 0) return 0;
    int lines = 1;
    int len = str.length ();
    for (int pos = 0;
    pos < len; pos ++) {
        char c = str.charAt (pos);
        if (c == '\r') {
            lines ++;
            if (pos + 1 < len && str.charAt (pos + 1) == '\n') pos ++;
        } else if (c == '\n') {
            lines ++;
        }
    }
    return lines;
}

public static int countLines (String str) {
    if (str == null || str.isEmpty ()) {
        return 0;
    }
    int lines = 1;
    int pos = 0;
    while ((pos = str.indexOf ("\n", pos) + 1) != 0) {
        lines ++;
    }
    return lines;
}

}
