public class Clone135 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:37263771
*  Stack Overflow answer #:37264286
*  And Stack Overflow answer#:37264543
*/
public static int [] [] getRows (int i, int j, int [] [] array) {
    int [] [] ret = new int [j - i] [];
    for (int k = i;
    k < j; k ++) {
        ret [k - i] = new int [array [k].length];
        for (int m = 0;
        m < ret [k - i].length; m ++) {
            ret [k - i] [m] = array [k] [m];
        }
    }
    return ret;
}

public static int [] [] getRows (int i, int j, int [] [] array) {
    int [] [] another = new int [j - i + 1] [];
    while (i <= j) {
        for (int k = 0;
        k < another.length; k ++) {
            another [k] = array [i];
            i ++;
        }
    }
    return another;
}

}
