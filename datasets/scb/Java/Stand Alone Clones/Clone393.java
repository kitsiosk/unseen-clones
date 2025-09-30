public class Clone393 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7863362
*  Stack Overflow answer #:19032324
*  And Stack Overflow answer#:7863418
*/
public static String getLongestSubstring (String s) {
    int length = 1;
    String longestString = "";
    for (int i = 0;
    i < s.length (); i ++) {
        StringBuilder str = new StringBuilder ();
        str.append (s.charAt (i));
        for (int j = i + 1;
        j < s.length (); j ++) {
            if (s.charAt (i) == s.charAt (j)) {
                str.append (s.charAt (j));
            } else {
                break;
            }
        }
        if (length < str.length ()) {
            length = str.length ();
            longestString = str.toString ();
        }
    }
    return longestString;
}

public String getLongestSubstring (String s) {
    if (s.length () == 0) return null;
    char currentChar = s.charAt (0);
    String longestString = "" + currentChar;
    String runningString = "" + currentChar;
    int currentLongestLength = 1;
    for (int i = 1;
    i < s.length (); i ++) {
        if (s.charAt (i) == currentChar) {
            runningString = runningString + currentChar;
            if (runningString.length () > longestString.length ()) {
                currentLongestLength ++;
                longestString = runningString;
            }
        } else {
            runningString = "" + s.charAt (i);
        }
    }
    return longestString;
}

}
