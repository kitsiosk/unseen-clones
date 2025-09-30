public class Clone409 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19538431
*  Stack Overflow answer #:19539136
*  And Stack Overflow answer#:19541585
*/
public static void main (String [] args) throws URISyntaxException, MalformedURLException {
    URLBuilder urlb = new URLBuilder ("www.example.com");
    urlb.setConnectionType ("http");
    urlb.addSubfolder ("somesub");
    urlb.addSubfolder ("anothersub");
    urlb.addParameter ("param lol", "unknown");
    urlb.addParameter ("paramY", "known");
    String url = urlb.getURL ();
    System.out.println (url);
    urlb = new URLBuilder ();
    urlb.addSubfolder ("servlet");
    urlb.addSubfolder ("jsp");
    urlb.addSubfolder ("somesub");
    urlb.addSubfolder ("anothersub");
    urlb.addParameter ("param lol", "unknown");
    urlb.addParameter ("paramY", "known");
    String relUrl = urlb.getRelativeURL ();
    System.out.println (relUrl);
}

public static void main (String args []) {
    try {
        URLBuilder url = new URLBuilder ();
        System.out.println (url.toString ());
        url.setFragment ("fragment");
        System.out.println (url.toString ());
        url.setHost ("host.com");
        System.out.println (url.toString ());
        url.addPath ("APath");
        System.out.println (url.toString ());
        url.addPath ("AnotherPath");
        System.out.println (url.toString ());
        url.addQuery ("query1", "param1");
        System.out.println (url.toString ());
        url.addQuery ("query 2", "param 2");
        System.out.println (url.toString ());
        url.addQuery ("file", new File ("Hello World.txt"));
        System.out.println (url.toString ());
    } catch (Throwable t) {
        t.printStackTrace (System.err);
    }
}

}
