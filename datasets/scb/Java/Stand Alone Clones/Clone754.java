public class Clone754 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:36485062
*  Stack Overflow answer #:36485519
*  And Stack Overflow answer#:36485167
*/
public static void main (String [] args) {
    int [] arr = new int [10];
    arr [0] = 2;
    for (int i = 1;
    i < arr.length; i ++) arr [i] = arr [i - 1] + 2;
    for (int i = 0;
    i < arr.length; i ++) System.out.print (arr [i] + " ");
    System.out.println ();
    for (int i = 0;
    i < arr.length; i ++) System.out.print (arr [9 - i] + " ");
}

public static void main (String [] args) throws Exception {
    int [] values = new int [10];
    values [0] = 2;
    System.out.print (values [0]);
    for (int i = 1;
    i < values.length; i ++) {
        values [i] = values [i - 1] + 2;
        System.out.print (" " + values [i]);
    }
}

}
