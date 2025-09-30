public class Clone841 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1978933
*  Stack Overflow answer #:23939390
*  And Stack Overflow answer#:13878279
*/
public static String join (String separator, String...values) {
    StringBuilder sb = new StringBuilder (128);
    int end = 0;
    for (String s : values) {
        if (s != null) {
            sb.append (s);
            end = sb.length ();
            sb.append (separator);
        }
    }
    return sb.substring (0, end);
}

public static String join (String separator, String...values) {
    if (values.length == 0) return "";
    char [] sep = separator.toCharArray ();
    int totalSize = (values.length - 1) * sep.length;
    for (int i = 0;
    i < values.length; i ++) {
        if (values [i] == null) values [i] = "";
        else totalSize += values [i].length ();
    }
    char [] joined = new char [totalSize];
    int pos = 0;
    for (int i = 0, end = values.length - 1;
    i < end; i ++) {
        System.arraycopy (values [i].toCharArray (), 0, joined, pos, values [i].length ());
        pos += values [i].length ();
        System.arraycopy (sep, 0, joined, pos, sep.length);
        pos += sep.length;
    }
    System.arraycopy (values [values.length - 1].toCharArray (), 0, joined, pos, values [values.length - 1].length ());
    return new String (joined);
}

}
