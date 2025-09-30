public class Clone570 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32395648
*  Stack Overflow answer #:32395987
*  And Stack Overflow answer#:32396370
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

public static void main (String args []) {
    int i;
    int largestSize = 4;
    int array [] = {33, 55, 13, 46, 87, 42, 10, 34};
    int large [] = Arrays.copyOf (array, largestSize);
    int smallest = large [0];
    int smallestIndex = 0;
    for (int j = 1;
    j < large.length; ++ j) {
        if (smallest > large [j]) {
            smallest = large [j];
            smallestIndex = j;
        }
    }
    for (i = large.length; i < array.length; i ++) {
        if (smallest < array [i]) {
            large [smallestIndex] = array [i];
            smallest = large [0];
            smallestIndex = 0;
            for (int j = 1;
            j < large.length; ++ j) {
                if (smallest > large [j]) {
                    smallest = large [j];
                    smallestIndex = j;
                }
            }
        }
    }
    for (int j = 0;
    j < large.length; j ++) {
        System.out.println ("Largest 5 : " + large [j]);
    }
    System.out.println ();
    System.out.println ("Largest is: " + getHighest (large));
}

}
