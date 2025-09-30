public class Clone801 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3316674
*  Stack Overflow answer #:3316795
*  And Stack Overflow answer#:3316743
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

static String shuffle (String text) {
    if (text.length () <= 1) return text;
    int split = text.length () / 2;
    String temp1 = shuffle (text.substring (0, split));
    String temp2 = shuffle (text.substring (split));
    if (Math.random () > 0.5) return temp1 + temp2;
    else return temp2 + temp1;
}

}
