public class Clone856 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:45372939
*  Stack Overflow answer #:45373221
*  And Stack Overflow answer#:45373120
*/
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

public static void main (String [] args) {
    int [] [] matrix = new int [] [] {{1, 2, 2}, {2, 2, 3}, {0, 1, 2}};
    int result = 1;
    for (int i = 0;
    i < matrix.length; i ++) {
        result = result * matrix [i] [i];
    }
    System.out.println ("Result: " + result);
}

}
