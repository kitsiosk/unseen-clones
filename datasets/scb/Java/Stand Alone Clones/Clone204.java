public class Clone204 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13692221
*  Stack Overflow answer #:52659787
*  And Stack Overflow answer#:13692305
*/
static boolean isAnagram (String a, String b) {
    a = a.toLowerCase ();
    b = b.toLowerCase ();
    if (a.length () != b.length ()) {
        return false;
    }
    char [] chars = a.toCharArray ();
    for (char c : chars) {
        int index = b.indexOf (c);
        if (index != - 1) {
            b = b.substring (0, index) + b.substring (index + 1, b.length ());
        } else {
            return false;
        }
    }
    return b.isEmpty ();
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
