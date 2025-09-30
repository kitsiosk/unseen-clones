public class Clone305 {
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
    try (ByteArrayOutputStream result = new ByteArrayOutputStream ()) {
        byte [] buffer = new byte [1024];
        int length;
        while ((length = inputStream.read (buffer)) != - 1) {
            result.write (buffer, 0, length);
        }
        return result.toString (UTF_8);
    }
}

}
