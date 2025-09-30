public class Clone800 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3316674
*  Stack Overflow answer #:3316795
*  And Stack Overflow answer#:3316696
*/
public static String shuffle (String s) {
    String shuffledString = "";
    while (s.length () != 0) {
        int index = (int) Math.floor (Math.random () * s.length ());
        char c = s.charAt (index);
        s = s.substring (0, index) + s.substring (index + 1);
        shuffledString += c;
    }
    return shuffledString;
}

public void shuffle (String input) {
    List < Character > characters = new ArrayList < Character > ();
    for (char c : input.toCharArray ()) {
        characters.add (c);
    }
    StringBuilder output = new StringBuilder (input.length ());
    while (characters.size () != 0) {
        int randPicker = (int) (Math.random () * characters.size ());
        output.append (characters.remove (randPicker));
    }
    System.out.println (output.toString ());
}

}
