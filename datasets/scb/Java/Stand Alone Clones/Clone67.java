public class Clone67 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19190297
*  Stack Overflow answer #:32417797
*  And Stack Overflow answer#:19192510
*/
public static void main (String [] args) {
    String name1;
    String name2;
    String name3;
    Scanner keyboard = new Scanner (System.in);
    System.out.print ("Please Enter First Name ");
    name1 = keyboard.nextLine ();
    System.out.print ("Please Enter Second Name ");
    name2 = keyboard.nextLine ();
    System.out.print ("Please Enter Third Name ");
    name3 = keyboard.nextLine ();
    if ((name1.compareTo (name2) < 0) && (name1.compareTo (name3) < 0)) {
        System.out.println (name1);
        if (name2.compareTo (name3) < 0) {
            System.out.println (name2);
            System.out.println (name3);
        } else {
            System.out.println (name3);
            System.out.println (name2);
        }
    } else if ((name1.compareTo (name2) > 0) && (name2.compareTo (name3) < 0)) {
        System.out.println (name2);
        if (name1.compareTo (name3) < 0) {
            System.out.println (name1);
            System.out.println (name3);
        } else {
            System.out.println (name3);
            System.out.println (name1);
        }
    } else {
        System.out.println (name3);
        if (name1.compareTo (name2) < 0) {
            System.out.println (name1);
            System.out.println (name2);
        } else {
            System.out.println (name2);
            System.out.println (name1);
        }
    }
}

public static void main (final String [] args) {
    final Console console = System.console ();
    if (console != null) {
        final SortNames sortNames = new SortNames (console);
        sortNames.run ();
    } else {
        System.err.println ("Sorry, no console.");
        System.exit (1);
    }
}

}
