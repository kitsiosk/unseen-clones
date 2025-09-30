public class Clone574 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:46667342
*  Stack Overflow answer #:46667343
*  And Stack Overflow answer#:46669187
*/
public static String replaceHostInUrl (String url, String newHost) {
    if (url == null || newHost == null) {
        return url;
    }
    try {
        URL originalURL = new URL (url);
        boolean hostHasPort = newHost.indexOf (":") != - 1;
        int newPort = originalURL.getPort ();
        if (hostHasPort) {
            URL hostURL = new URL ("http://" + newHost);
            newHost = hostURL.getHost ();
            newPort = hostURL.getPort ();
        } else {
            newPort = - 1;
        }
        boolean isHttps = originalURL.getProtocol ().equals ("https");
        boolean useDefaultPort = (newPort == 443 && isHttps) || (newPort == 80 && ! isHttps);
        newPort = useDefaultPort ? - 1 : newPort;
        URL newURL = new URL (originalURL.getProtocol (), newHost, newPort, originalURL.getFile ());
        String result = newURL.toString ();
        return result;
    } catch (MalformedURLException e) {
        throw new RuntimeException ("Couldnt replace host in url, originalUrl=" + url + ", newHost=" + newHost);
    }
}

public static String replaceHostInUrl (String originalURL, String newAuthority) throws URISyntaxException, MalformedURLException {
    URI uri = new URI (originalURL);
    uri = new URI (uri.getScheme ().toLowerCase (Locale.US), newAuthority, uri.getPath (), uri.getQuery (), uri.getFragment ());
    int port = uri.getPort ();
    if (port > 0 && port == uri.toURL ().getDefaultPort ()) {
        uri = new URI (uri.getScheme (), uri.getUserInfo (), uri.getHost (), - 1, uri.getPath (), uri.getQuery (), uri.getFragment ());
    }
    return uri.toString ();
}

}
