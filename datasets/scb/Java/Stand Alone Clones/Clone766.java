public class Clone766 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:40917393
*  Stack Overflow answer #:40917640
*  And Stack Overflow answer#:40917924
*/
public String removeAdjacentDuplicates (String s) {
    StringBuilder resultBuilder = new StringBuilder ();
    char previous = s.charAt (0);
    resultBuilder.append (previous);
    for (int i = 1;
    i < s.length (); i ++) {
        char current = s.charAt (i);
        if (previous != current) {
            resultBuilder.append (current);
            previous = current;
        }
    }
    return resultBuilder.toString ();
}

public static String removeAdjacentDuplicates (String input) {
    if (input.length () <= 1) {
        return input;
    }
    StringBuilder sb = new StringBuilder ();
    sb.append (input.charAt (0));
    IntStream.range (1, input.length ()).mapToObj (i -> input.charAt (i) != input.charAt (i - 1) ? input.charAt (i) : "").forEach (sb :: append);
    return sb.toString ();
}

}
