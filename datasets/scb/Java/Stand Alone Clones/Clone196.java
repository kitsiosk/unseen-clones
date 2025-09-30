public class Clone196 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:858980
*  Stack Overflow answer #:38235210
*  And Stack Overflow answer#:13342961
*/
public static byte [] readBytes (InputStream inputStream) throws IOException {
    byte [] b = new byte [1024];
    ByteArrayOutputStream os = new ByteArrayOutputStream ();
    int c;
    while ((c = inputStream.read (b)) != - 1) {
        os.write (b, 0, c);
    }
    return os.toByteArray ();
}

public static byte [] readBytes (InputStream inputStream) throws IOException {
    byte [] buffer = new byte [32 * 1024];
    int bufferSize = 0;
    for (;;) {
        int read = inputStream.read (buffer, bufferSize, buffer.length - bufferSize);
        if (read == - 1) {
            return Arrays.copyOf (buffer, bufferSize);
        }
        bufferSize += read;
        if (bufferSize == buffer.length) {
            buffer = Arrays.copyOf (buffer, bufferSize * 2);
        }
    }
}

}
