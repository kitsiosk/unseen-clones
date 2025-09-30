public class Clone763 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:362424
*  Stack Overflow answer #:2026058
*  And Stack Overflow answer#:362443
*/
public static final void main (String...args) {
    new Thread () {
        private String message = null;
        Thread initialise (String message) {
            this.message = message;
            return this;
        } public void run () {
            System.out.println (message);
        }}
    .initialise (args [0]).start ();
}

public static void main (String [] args) throws Exception {
    final int fakeConstructorArg = 10;
    Object a = new Object () {
        {
            System.out.println ("arg = " + fakeConstructorArg);
        }
    }
    ;
}

}
