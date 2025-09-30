public class Clone360 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18525474
*  Stack Overflow answer #:34649561
*  And Stack Overflow answer#:28312886
*/
public static void main (String args []) {
    int [] arr = new int [10];
    Scanner in = new Scanner (System.in);
    int i, min = 0, max = 0;
    for (i = 0; i <= arr.length; i ++) {
        System.out.print ("Enter any number: ");
        arr [i] = in.nextInt ();
    }
    min = arr [0];
    for (i = 0; i <= 9; i ++) {
        if (arr [i] > max) {
            max = arr [i];
        }
        if (arr [i] < min) {
            min = arr [i];
        }
    }
    System.out.println ("Maximum is: " + max);
    System.out.println ("Minimum is: " + min);
}

public static void main (String [] args) {
    System.out.println ("Main Method Started");
    Scanner in = new Scanner (System.in);
    System.out.println ("Enter the size of the arr");
    int size = in.nextInt ();
    System.out.println ("Enter the maximum value of the arr");
    int max = in.nextInt ();
    int [] arr = initializeArr (max, size);
    print (arr);
    findMinMax (arr);
    System.out.println ("Main Method Ended");
}

}
