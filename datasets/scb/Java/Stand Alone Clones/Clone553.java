public class Clone553 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15045640
*  Stack Overflow answer #:36217106
*  And Stack Overflow answer#:18100878
*/
static boolean areAnagrams (CharSequence a, CharSequence b) {
    int len = a.length ();
    if (len != b.length ()) return false;
    Map < Integer, Integer > ocr = new HashMap < > (64);
    a.codePoints ().forEach (c -> ocr.merge (c, 1, Integer :: sum));
    for (int i = 0, c = 0;
    i < len; i += Character.charCount (c)) {
        int cc = ocr.getOrDefault ((c = Character.codePointAt (b, i)), 0);
        if (cc == 0) return false;
        ocr.put (c, cc - 1);
    }
    return true;
}

public static boolean areAnagrams (String one, String two) {
    if (one.length () == two.length ()) {
        String s0 = one.toLowerCase ();
        String s1 = two.toLowerCase ();
        HashMap < Character, Integer > chars = new HashMap < Character, Integer > (one.length ());
        Integer count;
        for (char c : s0.toCharArray ()) {
            count = chars.get (c);
            count = Integer.valueOf (count != null ? count + 1 : 1);
            chars.put (c, count);
        }
        for (char c : s1.toCharArray ()) {
            count = chars.get (c);
            if (count == null) {
                return false;
            } else {
                count --;
                chars.put (c, count);
            }
        }
        for (Integer i : chars.values ()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    } else {
        return false;
    }
}

}
