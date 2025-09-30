public class Clone357 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23465798
*  Stack Overflow answer #:23465971
*  And Stack Overflow answer#:23465863
*/
public static void main (String [] args) {
    int [] A = {9, 5, 4, 3, 2, 1, 34, 53};
    int [] B = new int [A.length];
    int [] C = new int [A.length];
    int t = 4;
    int j = 0, k = 0;
    for (int i = 0;
    i < A.length; i ++) {
        if (A [i] <= t) {
            B [j] = A [i];
            j ++;
        } else {
            C [k] = A [i];
            k ++;
        }
    }
    for (int i = 0;
    i < j; i ++) {
        System.out.println ("B = " + B [i]);
    }
    for (int i = 0;
    i < k; i ++) {
        System.out.println ("C = " + C [i]);
    }
}

public static void main (String [] args) {
    int [] A = {9, 5, 4, 3, 2, 1, 34, 53};
    int [] B = new int [A.length];
    int [] C = new int [A.length];
    int t = 4;
    int countb = 0;
    int countc = 0;
    for (int i = 0;
    i < A.length; i ++) {
        if (A [i] <= t) {
            B [countb ++] = A [i];
        } else {
            C [countc ++] = A [i];
        }
    }
    System.out.println (Arrays.toString (B));
    System.out.println (Arrays.toString (C));
}

}
