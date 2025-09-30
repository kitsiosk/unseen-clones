public class Clone537 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27101258
*  Stack Overflow answer #:27101731
*  And Stack Overflow answer#:27101730
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
    if (histogram.findInLine (name) != null) {
        System.out.println ("This name exist");
    } else {
        System.out.println ("Name not found");
        user = validName (input, histogram);
    }
    return user;
}

}
