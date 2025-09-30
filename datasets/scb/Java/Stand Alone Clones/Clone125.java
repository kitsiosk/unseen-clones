public class Clone125 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8154366
*  Stack Overflow answer #:47004854
*  And Stack Overflow answer#:8155547
*/
public static String center (String text, int len) {
    if (len <= text.length ()) return text.substring (0, len);
    int before = (len - text.length ()) / 2;
    if (before == 0) return String.format ("%-" + len + "s", text);
    int rest = len - before;
    return String.format ("%" + before + "s%-" + rest + "s", "", text);
}

public static String center (String s, int size, char pad) {
    if (s == null || size <= s.length ()) return s;
    StringBuilder sb = new StringBuilder (size);
    for (int i = 0;
    i < (size - s.length ()) / 2; i ++) {
        sb.append (pad);
    }
    sb.append (s);
    while (sb.length () < size) {
        sb.append (pad);
    }
    return sb.toString ();
}

}
