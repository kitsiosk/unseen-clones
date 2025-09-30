public class Clone736 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8664705
*  Stack Overflow answer #:11665098
*  And Stack Overflow answer#:26765051
*/
public void findPrevLine () throws IOException {
    currentLineEnd = currentLineStart;
    if (currentLineEnd == 0) {
        currentLineEnd = - 1;
        currentLineStart = - 1;
        currentPos = - 1;
        return;
    }
    long filePointer = currentLineStart - 1;
    while (true) {
        filePointer --;
        if (filePointer < 0) {
            break;
        }
        in.seek (filePointer);
        int readByte = in.readByte ();
        if (readByte == 0xA && filePointer != lastPosInFile) {
            break;
        }
    }
    currentLineStart = filePointer + 1;
    currentPos = currentLineStart;
}

private void findPrevLine () throws IOException {
    if (lastChar == - 1) {
        in.seek (lastPosInFile);
        lastChar = in.readByte ();
    }
    currentLineEnd = currentLineStart;
    if (currentLineEnd == 0) {
        currentLineEnd = - 1;
        currentLineStart = - 1;
        currentPos = - 1;
        return;
    }
    long filePointer = currentLineStart - 1;
    while (true) {
        filePointer --;
        if (filePointer < 0) {
            break;
        }
        in.seek (filePointer);
        int readByte = in.readByte ();
        if (readByte == 0xA && filePointer != lastPosInFile) {
            break;
        }
    }
    currentLineStart = filePointer + 1;
    currentPos = currentLineStart;
}

}
