public class Clone281 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4449096
*  Stack Overflow answer #:38990042
*  And Stack Overflow answer#:40227336
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
    return new ServletInputStream () {
        ByteArrayInputStream bais = new ByteArrayInputStream (body);
        @Override
        public int read () throws IOException {
            return bais.read ();
        }}
    ;
}

}
