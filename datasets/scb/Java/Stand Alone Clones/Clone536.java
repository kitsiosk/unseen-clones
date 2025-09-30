public class Clone536 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27101258
*  Stack Overflow answer #:27101731
*  And Stack Overflow answer#:27101401
*/
public static String validName (Scanner input, Scanner histogram) {
    HashSet < String > validInputs = new HashSet < > ();
    while (histogram.hasNext ()) validInputs.add (histogram.next ());
    while (true) {
        String userInput = input.next ();
        if (validInputs.contains (userInput)) return userInput;
        System.out.println ("invalid input");
    }
}

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

}
