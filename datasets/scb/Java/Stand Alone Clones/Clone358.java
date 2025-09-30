public class Clone358 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23465798
*  Stack Overflow answer #:23465971
*  And Stack Overflow answer#:23467628
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
    int t = 4;
    int count = 0;
    for (int i = 0;
    i < A.length; i ++) {
        if (A [i] <= t) {
            count ++;
        }
    }
    int [] B = new int [count];
    int [] C = new int [A.length - count];
    for (int i = 0, j = 0, k = 0;
    i < A.length; i ++) {
        if (A [i] <= t) {
            B [j] = A [i];
            System.out.println ("B = " + B [j]);
            j ++;
        } else {
            C [k] = A [i];
            System.out.println ("C = " + C [k]);
            k ++;
        }
    }
}

}
