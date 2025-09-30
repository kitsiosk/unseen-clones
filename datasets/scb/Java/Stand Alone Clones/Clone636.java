public class Clone636 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3618733
*  Stack Overflow answer #:3618789
*  And Stack Overflow answer#:3619201
*/
public static String toJavaMethodName (String xmlmethodName) {
    StringBuilder nameBuilder = new StringBuilder (xmlmethodName.length ());
    boolean capitalizeNextChar = false;
    for (char c : xmlMethodName.toCharArray ()) {
        if (c == '-') {
            capitalizeNextChar = true;
            continue;
        }
        if (capitalizeNextChar) {
            nameBuilder.append (Character.toUpperCase (c));
        } else {
            nameBuilder.append (c);
        }
        capitalizeNextChar = false;
    }
    return nameBuilder.toString ();
}

public static String toJavaMethodName (final String nonJavaMethodName) {
    final StringBuilder nameBuilder = new StringBuilder ();
    boolean capitalizeNextChar = false;
    boolean first = true;
    for (int i = 0;
    i < nonJavaMethodName.length (); i ++) {
        final char c = nonJavaMethodName.charAt (i);
        if (! Character.isLetterOrDigit (c)) {
            if (! first) {
                capitalizeNextChar = true;
            }
        } else {
            nameBuilder.append (capitalizeNextChar ? Character.toUpperCase (c) : Character.toLowerCase (c));
            capitalizeNextChar = false;
            first = false;
        }
    }
    return nameBuilder.toString ();
}

}
