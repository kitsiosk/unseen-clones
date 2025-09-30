public class Clone571 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32395648
*  Stack Overflow answer #:32395987
*  And Stack Overflow answer#:32396398
*/
public static void main (String args []) {
    int i;
    int large [] = new int [5];
    int array [] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    int max = 0, index;
    for (int j = 0;
    j < 5; j ++) {
        max = array [0];
        index = 0;
        for (i = 1; i < array.length; i ++) {
            if (max < array [i]) {
                max = array [i];
                index = i;
            }
        }
        large [j] = max;
        array [index] = Integer.MIN_VALUE;
        System.out.println ("Largest " + j + " : " + large [j]);
    }
}

public static void main (String [] args) {
    int large [] = new int [10];
    int array [] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    int k = 0;
    for (int i = 0;
    i < array.length; i ++) {
        large [k ++] = getMax (0, array);
    }
    System.out.println ("Largest 5 is: " + Arrays.toString (Arrays.copyOf (large, 5)));
}

}
