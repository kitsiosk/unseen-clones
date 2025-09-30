public class Clone76 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:5368816
*  And Stack Overflow answer#:24632346
*/
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

public CharSequence filter (CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    String replacement = source.subSequence (start, end).toString ();
    String newVal = dest.subSequence (0, dstart).toString () + replacement + dest.subSequence (dend, dest.length ()).toString ();
    Matcher matcher = mPattern.matcher (newVal);
    if (matcher.matches ()) return null;
    if (TextUtils.isEmpty (source)) return dest.subSequence (dstart, dend);
    else return "";
}

}
