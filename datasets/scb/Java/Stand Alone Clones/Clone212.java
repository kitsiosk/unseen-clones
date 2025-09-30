public class Clone212 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1102891
*  Stack Overflow answer #:13955940
*  And Stack Overflow answer#:43306526
*/
public static boolean isNumber (String s) {
    boolean isNumber = true;
    for (int i = 0;
    i < s.length () && isNumber; i ++) {
        char c = s.charAt (i);
        isNumber = isNumber & ((c >= '0' && c <= '9') || (c == '.') || (c == 'e') || (c == 'E') || (c == ''));
    }
    return isInteger;
}

public static boolean isNumber (String str) {
    int i = 0, len = str.length ();
    boolean a = false, b = false, c = false, d = false;
    if (i < len && (str.charAt (i) == '+' || str.charAt (i) == '-')) i ++;
    while (i < len && isDigit (str.charAt (i))) {
        i ++;
        a = true;
    }
    if (i < len && (str.charAt (i) == '.')) i ++;
    while (i < len && isDigit (str.charAt (i))) {
        i ++;
        b = true;
    }
    if (i < len && (str.charAt (i) == 'e' || str.charAt (i) == 'E') && (a || b)) {
        i ++;
        c = true;
    }
    if (i < len && (str.charAt (i) == '+' || str.charAt (i) == '-') && c) i ++;
    while (i < len && isDigit (str.charAt (i))) {
        i ++;
        d = true;
    }
    return i == len && (a || b) && (! c || (c && d));
}

}
