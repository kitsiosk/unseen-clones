public class Clone152 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23936945
*  Stack Overflow answer #:23937100
*  And Stack Overflow answer#:23937331
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

public static int maxBlock (String str) {
    int maxCounter = 1;
    int counter = 1;
    if (str.length () == 0) {
        return 0;
    }
    for (int i = 1;
    i < str.length (); i ++) {
        if (str.charAt (i - 1) == str.charAt (i)) {
            counter ++;
        } else {
            if (counter > maxCounter) {
                maxCounter = counter;
            }
            counter = 1;
        }
    }
    return Math.max (maxCounter, counter);
}

}
