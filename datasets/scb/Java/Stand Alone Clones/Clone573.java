public class Clone573 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:22458575
*  Stack Overflow answer #:29485294
*  And Stack Overflow answer#:29690553
*/
public static void main (String arg []) {
    Scanner sc = new Scanner (System.in);
    System.out.println ("enter string for c");
    String c = sc.next ();
    System.out.println ("c is " + c);
    System.out.println ("enter string for d");
    String d = sc.next ();
    System.out.println ("d is " + d);
}

public static void main (String [] args) {
    Scanner sc = new Scanner (System.in);
    int cases = sc.nextInt ();
    String [] str = new String [cases];
    for (int i = 0;
    i < cases; i ++) {
        str [i] = sc.next ();
    }
}

}
