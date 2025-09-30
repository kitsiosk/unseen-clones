public class Clone938 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12488990
*  Stack Overflow answer #:12489307
*  And Stack Overflow answer#:12489727
*/
public String join (String a, String b, String separator) {
    if (! isEmpty (a) && ! isEmpty (b)) {
        return a + separator + b;
    }
    if (! isEmpty (a)) {
        return a;
    }
    if (! isEmpty (b)) {
        return b;
    }
    return "";
}

private static String join (String delimiter, String...parts) {
    StringBuilder builder = new StringBuilder ();
    for (String part : parts) {
        if (! isEmpty (part)) {
            if (builder.length () > 0) {
                builder.append (delimiter);
            }
            builder.append (part);
        }
    }
    return builder.toString ();
}

}
