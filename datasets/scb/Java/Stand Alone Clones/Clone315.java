public class Clone315 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13942701
*  Stack Overflow answer #:53356326
*  And Stack Overflow answer#:28527047
*/
public static void main (String [] args) {
    try {
        String input = "";
        char c = (char) System.in.read ();
        while (c != '\n') {
            input += c;
            c = (char) System.in.read ();
        }
        System.out.println (input);
    } catch (Exception e) {
        System.out.println (e);
    }
}

public static void main (String [] args) {
    Scanner kb = new Scanner (System.in);
    String name;
    int age;
    char bloodGroup;
    float height;
    System.out.println ("Enter Your Name");
    name = kb.nextLine ();
    System.out.println ("Enter Your Age");
    age = kb.nextInt ();
    System.out.println ("Enter Your BloodGroup : A/B/O only");
    bloodGroup = kb.next ().charAt (0);
    System.out.println ("Enter Your Height in Meters");
    height = kb.nextFloat ();
    kb.close ();
    System.out.println ("Name : " + name);
    System.out.println ("Age : " + age);
    System.out.println ("BloodGroup : " + bloodGroup);
    System.out.println ("Height : " + height + " m");
}

}
