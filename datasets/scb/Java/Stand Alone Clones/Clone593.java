public class Clone593 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16113588
*  Stack Overflow answer #:16113923
*  And Stack Overflow answer#:16113859
*/
public static void main (String [] args) throws Exception {
    String strA = "1234567890";
    String strB = "1234567890";
    char [] charA = getBackingArray (strA);
    char [] charB = getBackingArray (strB);
    char [] subA1 = getBackingArray (strA.substring (1));
    char [] subA2 = getBackingArray (strA.substring (0, 9));
    System.out.println ("charA address: " + System.identityHashCode (charA));
    System.out.println ("charB address: " + System.identityHashCode (charB));
    System.out.println ("subA1 address: " + System.identityHashCode (subA1));
    System.out.println ("subA2 address: " + System.identityHashCode (subA2));
    System.out.println ("charA == charB: " + (charA == charB));
    System.out.println ("charA == subA1: " + (charA == subA1));
    System.out.println ("charA == subA2: " + (charA == subA2));
}

public static void main (String args []) {
    Object sharedObject = new Object ();
    MyClass sampleA = new MyClass ();
    sampleA.myObject = sharedObject;
    MyClass sampleB = new MyClass ();
    sampleB.myObject = sharedObject;
    System.out.println (sampleA.sharedObject == sampleB.sharedObject);
    System.out.println (sampleA == sampleB);
}

}
