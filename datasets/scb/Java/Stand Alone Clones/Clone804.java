public class Clone804 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3316674
*  Stack Overflow answer #:3316696
*  And Stack Overflow answer#:23537258
*/
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

public static String shuffle (String text) {
    char [] characters = text.toCharArray ();
    for (int i = 0;
    i < characters.length; i ++) {
        int randomIndex = (int) (Math.random () * characters.length);
        char temp = characters [i];
        characters [i] = characters [randomIndex];
        characters [randomIndex] = temp;
    }
    return new String (characters);
}

}
