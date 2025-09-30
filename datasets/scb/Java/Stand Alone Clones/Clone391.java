public class Clone391 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27449526
*  Stack Overflow answer #:27451145
*  And Stack Overflow answer#:27451145
*/
public static void printArray (int [] [] arr) {
    System.out.println ("[");
    int rows = 3;
    int columns = 4;
    int i, j;
    for (i = 0; i < rows; i ++) {
        for (j = 0; j < columns; j ++) {
            System.out.print (arr [i] [j] + " ");
        }
        System.out.println ();
    }
    System.out.println ("]");
}

public static final void printArray (int [] arr) {
    System.out.print ("[");
    for (int i = 0;
    i < arr.length; i ++) {
        if (i == arr.length - 1) System.out.print (arr [i]);
        else System.out.print (arr [i] + ", ");
    }
    System.out.println ("]");
}

}
