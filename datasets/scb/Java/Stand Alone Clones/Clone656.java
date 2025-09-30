public class Clone656 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:52609409
*  Stack Overflow answer #:52609735
*  And Stack Overflow answer#:52609634
*/
public static String myTrim (String input, String list) {
    StringBuilder result = new StringBuilder ();
    char c;
    for (int i = 0;
    i < input.length (); i ++) {
        c = input.charAt (i);
        if (list.indexOf (c) < 0) result.append (c);
    }
    return result.toString ();
}

public static String myTrim (String input, String list) {
    String r = "";
    for (int i = 0;
    i < input.length (); i ++) {
        int k = 0;
        for (; k < list.length (); k ++) {
            if (input.charAt (i) == list.charAt (k)) {
                break;
            }
        }
        if (k == list.length ()) r += input.charAt (i);
    }
    return r;
}

}
