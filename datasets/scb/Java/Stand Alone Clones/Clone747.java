public class Clone747 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:40993093
*  Stack Overflow answer #:40998629
*  And Stack Overflow answer#:40995018
*/
static int countClamps (int [] arr) {
    int result = 0;
    for (int i = 1;
    i < arr.length; ++ i) {
        if (arr [i] == arr [i - 1] && (i == arr.length - 1 || arr [i] != arr [i + 1])) {
            ++ result;
        }
    }
    return result;
}

static int countClamps (int [] arr) {
    int result = 0;
    int prev = 0;
    boolean same = false;
    for (int i = 0;
    i < arr.length; i ++) {
        if (i == 0) {
            prev = arr [i];
        } else {
            if (arr [i] == prev) {
                if (! same) {
                    result ++;
                    same = true;
                }
            } else {
                prev = arr [i];
                same = false;
            }
        }
    }
    return result;
}

}
