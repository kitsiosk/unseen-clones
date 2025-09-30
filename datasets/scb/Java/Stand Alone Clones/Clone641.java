public class Clone641 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1515437
*  Stack Overflow answer #:1515453
*  And Stack Overflow answer#:14592693
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

public static String join (String delimiter, String...inStr) {
    StringBuilder sb = new StringBuilder ();
    if (inStr.length > 0) {
        sb.append (inStr [0]);
        for (int i = 1;
        i < inStr.length; i ++) {
            sb.append (delimiter);
            sb.append (inStr [i]);
        }
    }
    return sb.toString ();
}

}
