public class Clone855 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:45372939
*  Stack Overflow answer #:45373352
*  And Stack Overflow answer#:45373221
*/
public static void main (String [] args) {
    int a [] [] = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
    int multiplier = 1;
    for (int i = 0;
    i < a.length; i ++) {
        multiplier = multiplier * a [i] [i];
    }
    System.out.println (multiplier);
}

public static void main (String [] args) throws Exception {
    int [] [] matrix = new int [3] [];
    matrix [0] = new int [] {1, 2, 2};
    matrix [1] = new int [] {2, 2, 3};
    matrix [2] = new int [] {0, 1, 2};
    int resultL2R = 1;
    int resultR2L = 1;
    for (int i = 0;
    i < matrix.length; i ++) {
        resultL2R *= matrix [i] [i];
        resultR2L *= matrix [i] [matrix.length - 1 - i];
    }
    System.out.println ("left-to-right: " + resultL2R);
    System.out.println ("right-to-left: " + resultR2L);
}

}
