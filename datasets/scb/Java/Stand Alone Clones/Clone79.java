public class Clone79 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5357455
*  Stack Overflow answer #:24014006
*  And Stack Overflow answer#:32374585
*/
public void afterTextChanged (Editable s) {
    if (! mRestoringPreviousValueFlag) {
        if (! isValid (s.toString ())) {
            mRestoringPreviousValueFlag = true;
            restorePreviousValue ();
        }
    } else {
        mRestoringPreviousValueFlag = false;
    }
}

public synchronized void afterTextChanged (final Editable text) {
    String cost = text.toString ().trim ();
    if (! cost.endsWith (".") && cost.contains (".")) {
        String numberBeforeDecimal = cost.split ("\\.") [0];
        String numberAfterDecimal = cost.split ("\\.") [1];
        if (numberAfterDecimal.length () > 2) {
            numberAfterDecimal = numberAfterDecimal.substring (0, 2);
        }
        cost = numberBeforeDecimal + "." + numberAfterDecimal;
    }
    costEditText.removeTextChangedListener (this);
    costEditText.setText (cost);
    costEditText.setSelection (costEditText.getText ().toString ().trim ().length ());
    costEditText.addTextChangedListener (this);
}

}
