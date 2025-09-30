public class Clone545 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:21553499
*  And Stack Overflow answer#:21447112
*/
public boolean isAnagram (String leftString, String rightString) {
    if (leftString == null || rightString == null) {
        return false;
    } else if (leftString.length () != rightString.length ()) {
        return false;
    }
    char letters [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    Map < Character, Integer > occurrencesMap = new HashMap < > ();
    for (char l : letters) {
        occurrencesMap.put (l, 0);
    }
    for (int i = 0;
    i < leftString.length (); i ++) {
        char charFromLeft = leftString.charAt (i);
        Integer nrOfCharsInLeft = occurrencesMap.get (charFromLeft);
        occurrencesMap.put (charFromLeft, ++ nrOfCharsInLeft);
        char charFromRight = rightString.charAt (i);
        Integer nrOfCharsInRight = occurrencesMap.get (charFromRight);
        occurrencesMap.put (charFromRight, -- nrOfCharsInRight);
    }
    for (Integer occurrencesNr : occurrencesMap.values ()) {
        if (occurrencesNr != 0) {
            return false;
        }
    }
    return true;
}

public static boolean isAnagram (String first, String second) {
    String positive = first.toLowerCase ();
    String negative = second.toLowerCase ();
    if (positive.length () != negative.length ()) {
        return false;
    }
    int [] counts = new int [26];
    int diff = 0;
    for (int i = 0;
    i < positive.length (); i ++) {
        int pos = (int) positive.charAt (i) - 97;
        if (counts [pos] >= 0) {
            diff ++;
        } else {
            diff --;
        }
        counts [pos] ++;
        int neg = (int) negative.charAt (i) - 97;
        if (counts [neg] <= 0) {
            diff ++;
        } else {
            diff --;
        }
        counts [neg] --;
    }
    return diff == 0;
}

}
