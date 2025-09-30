public class Clone945 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4644415
*  Stack Overflow answer #:4644459
*  And Stack Overflow answer#:33106892
*/
public static void main (String [] args) throws Exception {
    Console console = System.console ();
    if (console == null) {
        System.out.println ("Unable to fetch console");
        return;
    }
    String line = console.readLine ();
    console.printf ("I saw this line: %s", line);
}

public static void main (final String [] args) throws IOException {
    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    System.out.println ("Enter some text, or '" + EXIT_COMMAND + "' to quit");
    while (true) {
        System.out.print ("><![CDATA[ ");
        String input = br.readLine ();
        System.out.println (input);
        if (input.length () == EXIT_COMMAND.length () && input.toLowerCase ().equals (EXIT_COMMAND)) {
            System.out.println ("Exiting.");
            return;
        }
        System.out.println ("...response goes here...");
    }
}

}
