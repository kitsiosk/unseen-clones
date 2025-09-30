public class Clone735 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6575114
*  Stack Overflow answer #:41137749
*  And Stack Overflow answer#:41137749
*/
private static String getProtocol (final String source) {
    assert source != null;
    String protocol = null;
    try {
        final URI uri = new URI (source);
        if (uri.isAbsolute ()) {
            protocol = uri.getScheme ();
        } else {
            final URL url = new URL (source);
            protocol = url.getProtocol ();
        }
    } catch (final Exception e) {
        if (source.startsWith ("//")) {
            throw new IllegalArgumentException ("Relative context: " + source);
        } else {
            final File file = new File (source);
            protocol = getProtocol (file);
        }
    }
    return protocol;
}

private static String getProtocol (final File file) {
    String result;
    try {
        result = file.toURI ().toURL ().getProtocol ();
    } catch (Exception e) {
        result = "unknown";
    }
    return result;
}

}
