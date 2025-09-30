public class Clone161 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2131997
*  Stack Overflow answer #:25799957
*  And Stack Overflow answer#:17632262
*/
public static boolean isPermutation (String s1, String s2) {
    if (s1.length () != s2.length ()) return false;
    int checker = 0;
    for (int i = 0;
    i < s1.length (); i ++) {
        checker ^= s1.charAt (i) ^ s2.charAt (i);
    }
    return checker == 0;
}

public static boolean isPermutation (String str1, String str2) {
    char [] x = str1.toCharArray ();
    char [] y = str2.toCharArray ();
    Arrays.sort (x);
    Arrays.sort (y);
    if (Arrays.equals (x, y)) return true;
    return false;
}

}
