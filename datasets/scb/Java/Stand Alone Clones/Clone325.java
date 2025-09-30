public class Clone325 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3607010
*  Stack Overflow answer #:3607227
*  And Stack Overflow answer#:3607156
*/
public int read (char [] charBuf) {
    char [] temp = new char [charBuf.length];
    int charsRead = reader.read (temp);
    int index = - 1;
    if (! (charsRead == - 1)) {
        for (char c : temp) {
            if (! blacklist.contains (c)) {
                charBuf [index] = c;
                index ++;
            }
        }
    }
    return index;
}

public int read (char [] cbuf, int off, int len) throws IOException {
    int read = super.read (cbuf, off, len);
    if (read == - 1) {
        return - 1;
    }
    int pos = off - 1;
    for (int readPos = off;
    readPos < off + read; readPos ++) {
        if (read == '@') {
            continue;
        } else {
            pos ++;
        }
        if (pos < readPos) {
            cbuf [pos] = cbuf [readPos];
        }
    }
    return pos - off + 1;
}

}
