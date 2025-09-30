public class Clone280 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4449096
*  Stack Overflow answer #:38990042
*  And Stack Overflow answer#:22553740
*/
public ServletInputStream getInputStream () throws IOException {
    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream (body);
    return new ServletInputStream () {
        @Override
        public int read () throws IOException {
            return byteArrayInputStream.read ();
        }@Override
        public boolean isFinished () {
            return false;
        }@Override
        public boolean isReady () {
            return false;
        }@Override
        public void setReadListener (ReadListener arg0) {
        }}
    ;
}

public ServletInputStream getInputStream () throws IOException {
    final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream (body.getBytes ());
    ServletInputStream inputStream = new ServletInputStream () {
        public int read () throws IOException {
            return byteArrayInputStream.read ();
        }}
    ;
    return inputStream;
}

}
