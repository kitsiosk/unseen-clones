public class Clone544 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:21553499
*  And Stack Overflow answer#:39319386
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

public static Boolean isAnagram (String word, String anagram_word) {
    if (word.length () != anagram_word.length ()) {
        return false;
    }
    char [] words_char = word.toCharArray ();
    char [] anagram_word_char = anagram_word.toCharArray ();
    int words_char_num = 1;
    int anagram_word_num = 1;
    Map < Character, Integer > wordPrimeMap = wordPrimeMap ();
    for (int i = 0;
    i < words_char.length; i ++) {
        words_char_num *= wordPrimeMap.get (words_char [i]);
    }
    for (int i = 0;
    i < anagram_word_char.length; i ++) {
        anagram_word_num *= wordPrimeMap.get (anagram_word_char [i]);
    }
    return anagram_word_num == words_char_num;
}

}
