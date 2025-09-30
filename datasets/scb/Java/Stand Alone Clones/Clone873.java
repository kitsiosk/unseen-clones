public class Clone873 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21972212
*  Stack Overflow answer #:21972496
*  And Stack Overflow answer#:21972526
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
    Scanner input = new Scanner (System.in);
    System.out.print ("Insert the admin pass: ");
    String test = input.nextLine ();
    if (pass.equals (test)) {
        System.out.print ("Access granted");
    } else {
        for (int i = 1;
        i < 3; i ++) {
            System.out.print ("You have " + i + " try(es): ");
            test = input.nextLine ();
            if (pass.equals (test)) {
                System.out.print ("Access granted");
                break;
            } else if (i == 2) {
                System.out.print ("Access denied");
            }
        }
    }
}

}
