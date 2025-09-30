public class Clone642 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1515437
*  Stack Overflow answer #:1515453
*  And Stack Overflow answer#:7393955
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

private String join (String [] input, String delimiter) {
    StringBuilder sb = new StringBuilder ();
    for (String value : input) {
        sb.append (value);
        sb.append (delimiter);
    }
    int length = sb.length ();
    if (length > 0) {
        sb.setLength (length - delimiter.length ());
    }
    return sb.toString ();
}

}
