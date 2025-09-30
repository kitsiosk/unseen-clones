public class Clone71 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:12480136
*  And Stack Overflow answer#:23816494
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
