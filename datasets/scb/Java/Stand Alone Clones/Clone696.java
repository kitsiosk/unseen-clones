public class Clone696 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29523701
*  Stack Overflow answer #:29524146
*  And Stack Overflow answer#:29524082
*/
public static String interleave (String you, String me) {
    StringBuilder result = new StringBuilder ();
    for (int i = 0;
    i < Math.max (you.length (), me.length ()); i ++) {
        if (i < you.length ()) {
            result.append (you.charAt (i));
        }
        if (i < me.length ()) {
            result.append (me.charAt (i));
        }
    }
    return result.toString ();
}

public static String interleave (String you, String me) {
    char [] a = you.toCharArray ();
    char [] b = me.toCharArray ();
    StringBuilder out = new StringBuilder ();
    int maxLength = Math.max (a.length, b.length);
    for (int i = 0;
    i < maxLength; i ++) {
        if (i < a.length) out.append (a [i]);
        if (i < b.length) out.append (b [i]);
    }
    return out.toString ();
}

}
