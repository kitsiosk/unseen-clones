public class Clone11 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19167750
*  Stack Overflow answer #:30675580
*  And Stack Overflow answer#:19232030
*/
public void replaceSelection (String text) {
    if (! characters.equals ("")) {
        if (validateCh (text)) {
            text = check (text);
            super.replaceSelection (text);
            if (max > 0) verifyLengh ();
        }
    } else {
        text = check (text);
        super.replaceSelection (text);
        if (max > 0) verifyLengh ();
    }
}

public void replaceSelection (String text) {
    String oldValue = getText ();
    if (! text.matches ("[A-Za-z]") && ! text.matches ("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
        super.replaceSelection (text);
    }
    if (getText ().length () > 2) {
        setText (oldValue);
    }
}

}
