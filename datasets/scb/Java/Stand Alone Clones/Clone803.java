public class Clone803 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3316674
*  Stack Overflow answer #:3316696
*  And Stack Overflow answer#:3316743
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

static String shuffle (String text) {
    if (text.length () <= 1) return text;
    int split = text.length () / 2;
    String temp1 = shuffle (text.substring (0, split));
    String temp2 = shuffle (text.substring (split));
    if (Math.random () > 0.5) return temp1 + temp2;
    else return temp2 + temp1;
}

}
