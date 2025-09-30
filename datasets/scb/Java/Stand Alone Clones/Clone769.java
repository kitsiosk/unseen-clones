public class Clone769 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8444710
*  Stack Overflow answer #:26229188
*  And Stack Overflow answer#:27495012
*/
public boolean isPalindrome (String original) {
    int i = original.length () - 1;
    int j = 0;
    while (i > j) {
        if (original.charAt (i) != original.charAt (j)) {
            return false;
        }
        i --;
        j ++;
    }
    return true;
}

public static boolean isPalindrome (String str) {
    str = str.toUpperCase ();
    char [] strChars = str.toCharArray ();
    List < Character > word = new ArrayList < > ();
    for (char c : strChars) {
        word.add (c);
    }
    while (true) {
        if ((word.size () == 1) || (word.size () == 0)) {
            return true;
        }
        if (word.get (0) == word.get (word.size () - 1)) {
            word.remove (0);
            word.remove (word.size () - 1);
        } else {
            return false;
        }
    }
}

}
