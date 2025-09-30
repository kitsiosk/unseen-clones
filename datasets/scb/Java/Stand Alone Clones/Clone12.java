public class Clone12 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:453018
*  Stack Overflow answer #:1647015
*  And Stack Overflow answer#:35435739
*/
public int countLines (String filename) throws IOException {
    LineNumberReader reader = new LineNumberReader (new FileReader (filename));
    int cnt = 0;
    String lineRead = "";
    while ((lineRead = reader.readLine ()) != null) {
    }
    cnt = reader.getLineNumber ();
    reader.close ();
    return cnt;
}

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

}
