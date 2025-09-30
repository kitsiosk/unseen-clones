public class Clone849 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11871520
*  Stack Overflow answer #:18301717
*  And Stack Overflow answer#:29325825
*/
public static void main (String [] args) {
    int number1, number2, sum;
    Scanner input = new Scanner (System.in);
    System.out.println ("Enter First multiple");
    number1 = input.nextInt ();
    System.out.println ("Enter second multiple");
    number2 = input.nextInt ();
    sum = number1 * number2;
    System.out.printf ("The product of both number is %d", sum);
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
