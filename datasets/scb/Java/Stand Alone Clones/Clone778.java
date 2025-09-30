public class Clone778 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16006901
*  Stack Overflow answer #:16006960
*  And Stack Overflow answer#:16007031
*/
public static boolean twoDuplicates (int [] values) {
    boolean twoDuplicate = false;
    int counter = 0;
    Arrays.sort (values);
    int old = values [0];
    boolean numberSeen = false;
    for (int i = 0;
    i < values.length; i ++) {
        if (values [i] == old) {
            if (! numberSeen) {
                counter ++;
                numberSeen = true;
            }
        } else {
            numberSeen = false;
            old = values [i];
        }
    }
    if (counter == 2) twoDuplicate = true;
    return twoDuplicate;
}

public static boolean twoDuplicates (int [] values) {
    for (int i = 0;
    i < values.length; i ++) {
        int counter = 0;
        for (int z = i + 1;
        z <= values.length - 1; z ++) {
            if (values [i] == values [z]) {
                counter ++;
                if (counter == 2) return true;
            }
        }
    }
    return false;
}

}
