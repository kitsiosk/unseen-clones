public class Clone81 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:24632346
*  And Stack Overflow answer#:6264829
*/
public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    String replacement = source.subSequence (start, end).toString ();
    String newVal = dest.subSequence (0, dstart).toString () + replacement + dest.subSequence (dend, dest.length ()).toString ();
    Matcher matcher = mPattern.matcher (newVal);
    if (matcher.matches ()) return null;
    if (TextUtils.isEmpty (source)) return dest.subSequence (dstart, dend);
    else return "";
}

public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    int dotPos = - 1;
    int len = dest.length ();
    for (int i = 0;
    i < len; i ++) {
        char c = dest.charAt (i);
        if (c == '.' || c == ',') {
            dotPos = i;
            break;
        }
    }
    if (dotPos >= 0) {
        if (source.equals (".") || source.equals (",")) {
            return "";
        }
        if (dend <= dotPos) {
            return null;
        }
        if (len - dotPos > decimalDigits) {
            return "";
        }
    }
    return null;
}

}
