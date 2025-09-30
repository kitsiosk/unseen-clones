public class Clone471 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7071281
*  Stack Overflow answer #:34266367
*  And Stack Overflow answer#:26117646
*/
private static String capitalize (String str) {
    if (TextUtils.isEmpty (str)) {
        return str;
    }
    char [] arr = str.toCharArray ();
    boolean capitalizeNext = true;
    String phrase = "";
    for (char c : arr) {
        if (capitalizeNext && Character.isLetter (c)) {
            phrase += Character.toUpperCase (c);
            capitalizeNext = false;
            continue;
        } else if (Character.isWhitespace (c)) {
            capitalizeNext = true;
        }
        phrase += c;
    }
    return phrase;
}

private String capitalize (String s) {
    if (s == null || s.length () == 0) {
        return "";
    }
    char first = s.charAt (0);
    if (Character.isUpperCase (first)) {
        return s;
    } else {
        return Character.toUpperCase (first) + s.substring (1);
    }
}

}
