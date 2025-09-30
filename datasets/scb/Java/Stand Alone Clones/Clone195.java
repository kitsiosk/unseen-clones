public class Clone195 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:858980
*  Stack Overflow answer #:859483
*  And Stack Overflow answer#:859233
*/
private byte [] read (final File file) {
    if (file.isDirectory ()) throw new RuntimeException ("Unsupported operation, file " + file.getAbsolutePath () + " is a directory");
    if (file.length () > Integer.MAX_VALUE) throw new RuntimeException ("Unsupported operation, file " + file.getAbsolutePath () + " is too big");
    Throwable pending = null;
    FileInputStream in = null;
    final byte buffer [] = new byte [(int) file.length ()];
    try {
        in = new FileInputStream (file);
        in.read (buffer);
    } catch (Exception e) {
        pending = new RuntimeException ("Exception occured on reading file " + file.getAbsolutePath (), e);
    } finally {
        if (in != null) {
            try {
                in.close ();
            } catch (Exception e) {
                if (pending == null) {
                    pending = new RuntimeException ("Exception occured on closing file" + file.getAbsolutePath (), e);
                }
            }
        }
        if (pending != null) {
            throw new RuntimeException (pending);
        }
    }
    return buffer;
}

public byte [] read (File file) throws IOException, FileTooBigException {
    if (file.length () > MAX_FILE_SIZE) {
        throw new FileTooBigException (file);
    }
    ByteArrayOutputStream ous = null;
    InputStream ios = null;
    try {
        byte [] buffer = new byte [4096];
        ous = new ByteArrayOutputStream ();
        ios = new FileInputStream (file);
        int read = 0;
        while ((read = ios.read (buffer)) != - 1) {
            ous.write (buffer, 0, read);
        }
    } finally {
        try {
            if (ous != null) ous.close ();
        } catch (IOException e) {
        }
        try {
            if (ios != null) ios.close ();
        } catch (IOException e) {
        }
    }
    return ous.toByteArray ();
}

}
