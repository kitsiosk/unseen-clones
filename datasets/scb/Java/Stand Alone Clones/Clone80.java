public class Clone80 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:24632346
*  And Stack Overflow answer#:23816494
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
    String lsStart = "";
    String lsInsert = "";
    String lsEnd = "";
    String lsText = "";
    Log.d ("debug", moPattern.toString ());
    Log.d ("debug", "source: " + source + ", start: " + start + ", end:" + end + ", dest: " + dest + ", dstart: " + dstart + ", dend: " + dend);
    lsText = dest.toString ();
    if (lsText.length () > 0) {
        lsStart = lsText.substring (0, dstart);
        Log.d ("debug", "lsStart : " + lsStart);
        if (source != "") {
            lsInsert = source.toString ();
            Log.d ("debug", "lsInsert: " + lsInsert);
        }
        lsEnd = lsText.substring (dend);
        Log.d ("debug", "lsEnd   : " + lsEnd);
        lsText = lsStart + lsInsert + lsEnd;
        Log.d ("debug", "lsText  : " + lsText);
    }
    Matcher loMatcher = moPattern.matcher (lsText);
    Log.d ("debug", "loMatcher.matches(): " + loMatcher.matches () + ", lsText: " + lsText);
    if (! loMatcher.matches ()) {
        return "";
    }
    return null;
}

}
