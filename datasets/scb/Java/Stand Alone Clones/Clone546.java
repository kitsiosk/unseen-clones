public class Clone546 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:21553499
*  And Stack Overflow answer#:46804638
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

public boolean isAnagram (String s1, String s2) {
    StringBuilder sb1 = new StringBuilder ();
    StringBuilder sb2 = new StringBuilder ();
    if (s1.length () != s2.length ()) return false;
    char arr1 [] = s1.toCharArray ();
    char arr2 [] = s2.toCharArray ();
    Arrays.sort (arr1);
    Arrays.sort (arr2);
    for (char c : arr1) {
        sb1.append (c);
    }
    for (char c : arr2) {
        sb2.append (c);
    }
    System.out.println (sb1.toString ());
    System.out.println (sb2.toString ());
    if (sb1.toString ().equals (sb2.toString ())) return true;
    else return false;
}

}
