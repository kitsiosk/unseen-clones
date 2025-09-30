public class Clone361 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18525474
*  Stack Overflow answer #:34649561
*  And Stack Overflow answer#:41659499
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

public static void main (String args []) {
    int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    System.out.println ("Enter the number of elements: ");
    Scanner sc = new Scanner (System.in);
    int [] arr = new int [sc.nextInt ()];
    System.out.println ("Enter the elements: ");
    for (int i = 0;
    i < arr.length; i ++) {
        int next = sc.nextInt ();
        arr [i] = next;
    }
    for (int j = 0;
    j < arr.length; j ++) {
        if (arr [j] > max) max = arr [j];
        else if (arr [j] < min) min = arr [j];
    }
    System.out.println ("Highest Value in array: " + max);
    System.out.println ("Smallest Value in array: " + min);
}

}
