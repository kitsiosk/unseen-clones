public class Clone872 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21972212
*  Stack Overflow answer #:21972496
*  And Stack Overflow answer#:21972539
*/
public static void main (String [] args) {
    String pass = "admin";
    Scanner input = new Scanner (System.in);
    for (int i = 0;
    i < 3; i ++) {
        System.out.print ("Insert the admin pass: ");
        String test = input.nextLine ();
        if (pass.equals (test)) {
            System.out.print ("Access granted");
            i = 3;
        } else {
            System.out.println ("Incorrect password, you have " + (2 - i) + " attempts remaining");
        }
    }
}

public static void main (String [] args) {
    String pass = "admin";
    int maxTry = 3;
    boolean success = false;
    Scanner input = new Scanner (System.in);
    System.out.print ("Insert the admin pass: ");
    String test = input.nextLine ();
    while (maxTry > 0) {
        maxTry --;
        if (! pass.equals (test)) {
            System.out.print ("You have " + maxTry + " try(es): ");
            test = input.nextLine ();
        } else {
            success = true;
            break;
        }
    }
    if (success) {
        System.out.println ("Access granted");
    } else {
        System.out.println ("Access denied");
    }
}

}
