public class Clone147 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31085200
*  Stack Overflow answer #:31085335
*  And Stack Overflow answer#:31085334
*/
public static String replace (String old, String newWord, String input) {
    int i = input.indexOf (old);
    if (i < 0) {
        return input;
    }
    String partBefore = input.substring (0, i);
    String partAfter = input.substring (i + old.length ());
    return partBefore + newWord + replace (old, newWord, partAfter);
}

public static String replace (String oldStr, String newStr, String input) {
    StringBuilder sb = new StringBuilder ();
    int i;
    int prev = 0;
    while ((i = input.indexOf (oldStr, prev)) >= 0) {
        sb.append (input.substring (prev, i)).append (newStr);
        prev = i + oldStr.length ();
    }
    sb.append (input.substring (prev));
    return sb.toString ();
}

}
