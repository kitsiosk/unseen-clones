public class Clone14 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:453018
*  Stack Overflow answer #:35435739
*  And Stack Overflow answer#:39232425
*/
static long countLines (InputStream is) throws IOException {
    try (LineNumberReader lnr = new LineNumberReader (new InputStreamReader (is))) {
        char [] buf = new char [8192];
        int n, previousN = - 1;
        while ((n = lnr.read (buf)) != - 1) {
            previousN = n;
        }
        int ln = lnr.getLineNumber ();
        if (previousN == - 1) {
            return 0;
        } else {
            char lastChar = buf [previousN - 1];
            if (lastChar == '\n' || lastChar == '\r') {
                return ln;
            }
        }
        return ln + 1;
    }
}

public static int countLines (File input) throws IOException {
    try (InputStream is = new FileInputStream (input)) {
        int count = 1;
        for (int aChar = 0;
        aChar != - 1; aChar = is.read ()) count += aChar == '\n' ? 1 : 0;
        return count;
    }
}

}
