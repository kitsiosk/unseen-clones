public class Clone70 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:12480136
*  And Stack Overflow answer#:5368816
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
    CharSequence out = super.filter (source, start, end, dest, dstart, dend);
    if (out != null) {
        source = out;
        start = 0;
        end = out.length ();
    }
    int len = end - start;
    if (len == 0) {
        return source;
    }
    int dlen = dest.length ();
    for (int i = 0;
    i < dstart; i ++) {
        if (dest.charAt (i) == '.') {
            return (dlen - (i + 1) + len > digits) ? "" : new SpannableStringBuilder (source, start, end);
        }
    }
    for (int i = start;
    i < end; ++ i) {
        if (source.charAt (i) == '.') {
            if ((dlen - dend) + (end - (i + 1)) > digits) return "";
            else break;
        }
    }
    return new SpannableStringBuilder (source, start, end);
}

}
