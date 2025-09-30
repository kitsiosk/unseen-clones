public class Clone943 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4644415
*  Stack Overflow answer #:4644459
*  And Stack Overflow answer#:25541876
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

public static void main (String [] args) {
    BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
    System.out.print ("Please enter user name : ");
    String username = null;
    try {
        username = reader.readLine ();
    } catch (IOException e) {
        e.printStackTrace ();
    }
    System.out.println ("You entered : " + username);
    Scanner in = new Scanner (System.in);
    System.out.print ("Please enter user name : ");
    username = in.nextLine ();
    System.out.println ("You entered : " + username);
    Console console = System.console ();
    username = console.readLine ("Please enter user name : ");
    System.out.println ("You entered : " + username);
}

}
