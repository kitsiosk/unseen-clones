public class Clone617 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25805385
*  Stack Overflow answer #:25805790
*  And Stack Overflow answer#:25805567
*/
public static boolean contains (String a, String b) {
    String temp = b;
    for (int i = 0;
    i < a.length (); i ++) {
        temp = temp.replaceFirst (Pattern.quote (a.substring (i, i + 1)), "");
        if (b.length () - temp.length () != i + 1) return false;
    }
    return true;
}

public static boolean contains (String a, String b) {
    int diff = a.length () - b.length ();
    while (a.length () > 0) {
        b = b.replace (a.substring (0, 1), "");
        a = a.replace (a.substring (0, 1), "");
        if (diff != a.length () - b.length ()) return false;
    }
    return true;
}

}
