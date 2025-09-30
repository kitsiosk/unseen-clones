public class Clone17 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21748970
*  Stack Overflow answer #:21749327
*  And Stack Overflow answer#:21749318
*/
public String longestSequenceOfChar (String str) {
    String result = "";
    for (int i = 0;
    i < str.length (); i ++) {
        int j = i;
        while (j < str.length () && str.charAt (j) == str.charAt (i)) {
            j ++;
        }
        if (j - i > result.length ()) {
            result = str.substring (i, j);
        }
    }
    return result;
}

public String longestSequenceOfChar (String str) {
    String interimresult = "";
    String result = "";
    for (int i = 0;
    i < str.length (); i ++) {
        char ch = str.charAt (i);
        interimresult += ch;
        for (int j = i + 1;
        j < str.length (); j ++) {
            char ch1 = str.charAt (j);
            if (ch != ch1) {
                break;
            }
            interimresult += ch;
        }
        if (interimresult.length () > result.length ()) result = interimresult;
        interimresult = "";
    }
    return result;
}

}
