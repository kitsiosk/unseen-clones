public class Clone538 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27101258
*  Stack Overflow answer #:27101401
*  And Stack Overflow answer#:27101730
*/
public static String validName (Scanner input, Scanner histogram) {
    String user = "";
    String name = input.next ();
    String tmp = "";
    boolean test = false;
    while (histogram.hasNext ()) {
        user = histogram.next ();
        tmp += user + " ";
        if (name.equalsIgnoreCase (user)) {
            test = true;
            break;
        } else {
            test = false;
        }
    }
    if (! test) {
        System.out.println ("Name not found");
        user = validName (input, new Scanner (tmp));
    }
    return user;
}

public static String validName (Scanner input, Scanner histogram) {
    String user = "";
    String name = input.next ();
    if (histogram.findInLine (name) != null) {
        System.out.println ("This name exist");
    } else {
        System.out.println ("Name not found");
        user = validName (input, histogram);
    }
    return user;
}

}
