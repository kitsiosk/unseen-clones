public class Clone306 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:309424
*  Stack Overflow answer #:48775964
*  And Stack Overflow answer#:48775964
*/
public String inputStreamToString (InputStream in) throws IOException {
    ReadableByteChannel channel = Channels.newChannel (in);
    ByteBuffer byteBuffer = ByteBuffer.allocate (1024 * 16);
    ByteArrayOutputStream bout = new ByteArrayOutputStream ();
    WritableByteChannel outChannel = Channels.newChannel (bout);
    while (channel.read (byteBuffer) > 0 || byteBuffer.position () > 0) {
        byteBuffer.flip ();
        outChannel.write (byteBuffer);
        byteBuffer.compact ();
    }
    channel.close ();
    outChannel.close ();
    return bout.toString (UTF_8);
}

public String inputStreamToString (InputStream inputStream) throws IOException {
    String newLine = System.getProperty ("line.separator");
    BufferedReader reader = new BufferedReader (new InputStreamReader (inputStream));
    StringBuilder result = new StringBuilder (UTF_8);
    String line;
    boolean flag = false;
    while ((line = reader.readLine ()) != null) {
        result.append (flag ? newLine : "").append (line);
        flag = true;
    }
    return result.toString ();
}

}
