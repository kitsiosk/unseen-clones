public class Clone764 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7520432
*  Stack Overflow answer #:22213322
*  And Stack Overflow answer#:40691102
*/
public static void main (String args []) {
    String s1 = new String ("Test");
    String s2 = new String ("Test");
    System.out.println ("\n1 - PRIMITIVES ");
    System.out.println (s1 == s2);
    System.out.println (s1.equals (s2));
    A a1 = new A ();
    A a2 = new A ();
    System.out.println ("\n2 - OBJECT TYPES / STATIC VARIABLE");
    System.out.println (a1 == a2);
    System.out.println (a1.s == a2.s);
    System.out.println (a1.s.equals (a2.s));
    B b1 = new B ();
    B b2 = new B ();
    System.out.println ("\n3 - OBJECT TYPES / NON-STATIC VARIABLE");
    System.out.println (b1 == b2);
    System.out.println (b1.getS () == b2.getS ());
    System.out.println (b1.getS ().equals (b2.getS ()));
}

public static void main (String [] args) {
    String s1 = "Cat";
    String s2 = "Cat";
    String s3 = new String ("Cat");
    if (s1 == s2) {
        System.out.println ("true");
    } else {
        System.out.println ("false");
    }
    if (s1 == s3) {
        System.out.println ("true");
    } else {
        System.out.println ("false");
    }
    if (s1.equals (s3)) {
        System.out.println ("true");
    } else {
        System.out.println ("False");
    }
}

}
