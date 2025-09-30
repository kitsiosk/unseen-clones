public class Clone205 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13692221
*  Stack Overflow answer #:52659787
*  And Stack Overflow answer#:32150902
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

static boolean isAnagram (String s1, String s2) {
    if (s1.length () != s2.length ()) return false;
    int n = s1.length ();
    int [] charMap = new int [256];
    for (int i = 0;
    i < n; i ++) {
        char c1 = s1.charAt (i);
        charMap [c1] ++;
        char c2 = s2.charAt (i);
        charMap [c2] --;
    }
    for (int i = 0;
    i < charMap.length; i ++) {
        if (charMap [i] != 0) return false;
    }
    return true;
}

}
