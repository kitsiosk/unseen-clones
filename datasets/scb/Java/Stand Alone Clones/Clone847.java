public class Clone847 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11871520
*  Stack Overflow answer #:34549731
*  And Stack Overflow answer#:29325825
*/
public static void main (String args []) {
    int a;
    float b;
    String s;
    Scanner in = new Scanner (System.in);
    System.out.println ("Enter a string");
    s = in.nextLine ();
    System.out.println ("You entered string " + s);
    System.out.println ("Enter an integer");
    a = in.nextInt ();
    System.out.println ("You entered integer " + a);
    System.out.println ("Enter a float");
    b = in.nextFloat ();
    System.out.println ("You entered float " + b);
}

public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    final int valid = 6;
    Scanner one = new Scanner (System.in);
    System.out.println ("Enter your username: ");
    String s = one.nextLine ();
    if (s.length () < valid) {
        System.out.println ("Enter a valid username");
        System.out.println ("User name must contain " + valid + " characters");
        System.out.println ("Enter again: ");
        s = one.nextLine ();
    }
    System.out.println ("Username accepted: " + s);
    Scanner two = new Scanner (System.in);
    System.out.println ("Enter your age: ");
    int a = two.nextInt ();
    System.out.println ("Age accepted: " + a);
    Scanner three = new Scanner (System.in);
    System.out.println ("Enter your sex: ");
    String sex = three.nextLine ();
    System.out.println ("Sex accepted: " + sex);
}

}
