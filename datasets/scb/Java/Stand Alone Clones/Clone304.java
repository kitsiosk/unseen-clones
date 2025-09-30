public class Clone304 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:309424
*  Stack Overflow answer #:48775964
*  And Stack Overflow answer#:2857414
*/
public static void main (String...args) {
    log ("App started");
    byte [] bytes = new byte [1024 * 1024];
    new Random ().nextBytes (bytes);
    log ("Stream is ready\n");
    try {
        test (bytes);
    } catch (IOException e) {
        e.printStackTrace ();
    }
}

public static void main (String [] args) {
    InputStream is = StringFromFileFast.class.getResourceAsStream ("file.txt");
    InputStreamReader input = new InputStreamReader (is);
    final int CHARS_PER_PAGE = 5000;
    final char [] buffer = new char [CHARS_PER_PAGE];
    StringBuilder output = new StringBuilder (CHARS_PER_PAGE);
    try {
        for (int read = input.read (buffer, 0, buffer.length);
        read != - 1; read = input.read (buffer, 0, buffer.length)) {
            output.append (buffer, 0, read);
        }
    } catch (IOException ignore) {
    }
    String text = output.toString ();
    System.out.println (text);
}

}
