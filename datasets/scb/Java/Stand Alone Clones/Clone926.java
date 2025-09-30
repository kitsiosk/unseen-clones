public class Clone926 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16098134
*  Stack Overflow answer #:45612563
*  And Stack Overflow answer#:16098412
*/
public static void main (String args []) {
    Scanner sc = new Scanner (System.in);
    ArrayList < Integer > al2 = new ArrayList < Integer > ();
    System.out.println ("enter the item in list");
    while (sc.hasNextInt ()) {
        al2.add (sc.nextInt ());
    }
    Iterator it1 = al2.iterator ();
    while (it1.hasNext ()) {
        System.out.println (it1.next ());
    }
}

public static void main (String [] args) {
    Scanner scan = new Scanner (System.in);
    ArrayList < Integer > list = new ArrayList < Integer > ();
    System.out.print ("Enter integers please ");
    System.out.println ("(EOF or non-integer to terminate): ");
    while (scan.hasNextInt ()) {
        list.add (scan.nextInt ());
    }
    Integer [] nums = list.toArray (new Integer [0]);
    for (int i = 0;
    i < nums.length; i ++) {
        System.out.println (nums [i]);
    }
}

}
