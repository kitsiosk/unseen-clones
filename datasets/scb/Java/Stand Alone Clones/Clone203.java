public class Clone203 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13692221
*  Stack Overflow answer #:13692333
*  And Stack Overflow answer#:13692305
*/
public static boolean isAnagram (String s1, String s2) {
    if (s1.length () != s2.length ()) return false;
    char [] c1 = s1.toCharArray ();
    char [] c2 = s2.toCharArray ();
    Arrays.sort (c1);
    Arrays.sort (c2);
    for (int i = 0;
    i < c1.length; i ++) {
        if (c1 [i] != c2 [i]) return false;
    }
    return true;
}

public static boolean isAnagram (String s1, String s2) {
    if (s1.length () != s2.length ()) {
        return false;
    }
    s1 = s1.toLowerCase ();
    s2 = s2.toLowerCase ();
    char [] c1 = s1.toCharArray ();
    char [] c2 = s2.toCharArray ();
    Arrays.sort (c1);
    Arrays.sort (c2);
    String sc1 = new String (c1);
    String sc2 = new String (c2);
    return sc1.equals (sc2);
}

}
