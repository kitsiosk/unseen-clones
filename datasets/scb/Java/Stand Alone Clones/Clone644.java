public class Clone644 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1515437
*  Stack Overflow answer #:1515453
*  And Stack Overflow answer#:8692882
*/
public static String join (Collection s, String delimiter) {
    StringBuffer buffer = new StringBuffer ();
    Iterator iter = s.iterator ();
    while (iter.hasNext ()) {
        buffer.append (iter.next ());
        if (iter.hasNext ()) {
            buffer.append (delimiter);
        }
    }
    return buffer.toString ();
}

public static String join (String r [], String d) {
    if (r.length == 0) return "";
    StringBuilder sb = new StringBuilder ();
    int i;
    for (i = 0; i < r.length - 1; i ++) {
        sb.append (r [i]);
        sb.append (d);
    }
    sb.append (r [i]);
    return sb.toString ();
}

}
