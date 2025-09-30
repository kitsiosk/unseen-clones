public class Clone72 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:12480136
*  And Stack Overflow answer#:6264829
*/
public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    String formatedSource = source.subSequence (start, end).toString ();
    String destPrefix = dest.subSequence (0, dstart).toString ();
    String destSuffix = dest.subSequence (dend, dest.length ()).toString ();
    String result = destPrefix + formatedSource + destSuffix;
    result = result.replace (",", ".");
    Matcher matcher = mPattern.matcher (result);
    if (matcher.matches ()) {
        return null;
    }
    return "";
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
