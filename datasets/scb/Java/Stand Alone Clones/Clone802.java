public class Clone802 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3316674
*  Stack Overflow answer #:3316795
*  And Stack Overflow answer#:23537258
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
