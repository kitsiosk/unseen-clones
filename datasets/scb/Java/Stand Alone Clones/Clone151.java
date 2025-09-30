public class Clone151 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23936945
*  Stack Overflow answer #:23937100
*  And Stack Overflow answer#:23938574
*/
public int maxBlock (String str) {
    Pattern pattern = Pattern.compile ("(.)(\\1)*");
    Matcher matcher = pattern.matcher (str);
    int max = 0;
    while (matcher.find ()) {
        max = Math.max (max, matcher.group ().length ());
    }
    return max;
}

public int maxBlock (String str) {
    int max = 0;
    int count = 1;
    char o = ' ';
    for (int i = 0;
    i < str.length (); i ++) {
        char c = str.charAt (i);
        if (c == o) {
            count ++;
            if (count > max) {
                max = count;
            }
        } else {
            count = 1;
            if (count > max) {
                max = count;
            }
        }
        o = c;
    }
    return max;
}

}
