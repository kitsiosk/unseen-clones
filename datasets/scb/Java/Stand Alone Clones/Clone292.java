public class Clone292 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3732109
*  Stack Overflow answer #:52847756
*  And Stack Overflow answer#:20261540
*/
public void handle (HttpExchange t) throws IOException {
    String response = "This is the response";
    long threadId = Thread.currentThread ().getId ();
    System.out.println ("I am thread " + threadId);
    response = response + "Thread Id = " + threadId;
    t.sendResponseHeaders (200, response.length ());
    OutputStream os = t.getResponseBody ();
    os.write (response.getBytes ());
    os.close ();
}

public void handle (final HttpExchange ex) throws IOException {
    byte [] inBytes = getBytes (ex.getRequestBody ());
    ex.getRequestBody ().close ();
    final ByteArrayInputStream newInput = new ByteArrayInputStream (inBytes);
    final ServletInputStream is = new ServletInputStream () {
        @Override
        public int read () throws IOException {
            return newInput.read ();
        }}
    ;
    Map < String, String [] > parsePostData = new HashMap < > ();
    try {
        parsePostData.putAll (HttpUtils.parseQueryString (ex.getRequestURI ().getQuery ()));
        parsePostData.putAll (HttpUtils.parsePostData (inBytes.length, is));
    } catch (IllegalArgumentException e) {
        newInput.reset ();
    }
    final Map < String, String [] > postData = parsePostData;
    RequestWrapper req = new RequestWrapper (createUnimplementAdapter (HttpServletRequest.class), ex, postData, is);
    ResponseWrapper resp = new ResponseWrapper (createUnimplementAdapter (HttpServletResponse.class), ex);
    try {
        servlet.service (req, resp);
        resp.complete ();
    } catch (ServletException e) {
        throw new IOException (e);
    }
}

}
