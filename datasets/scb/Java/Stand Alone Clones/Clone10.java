public class Clone10 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19167750
*  Stack Overflow answer #:30675580
*  And Stack Overflow answer#:19232030
*/
public void replaceText (int start, int end, String text) {
    if (! characters.equals ("")) {
        if (validateCh (text)) {
            text = check (text);
            super.replaceText (start, end, text);
            if (max > 0) verifyLengh ();
        }
    } else {
        text = check (text);
        super.replaceText (start, end, text);
        if (max > 0) verifyLengh ();
    }
}

public void replaceText (int start, int end, String text) {
    String oldValue = getText ();
    if (! text.matches ("[A-Za-z]") && ! text.matches ("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
        super.replaceText (start, end, text);
    }
    if (getText ().length () > 2) {
        setText (oldValue);
    }
}

}
