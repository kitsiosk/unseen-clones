public class Clone490 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:70324
*  Stack Overflow answer #:42949189
*  And Stack Overflow answer#:2523233
*/
public static void main (String args []) {
    class Local {
        public void name () {
            System.out.println ("Example of Local class in Java");
        }}
    Local local = new Local ();
    local.name ();
    Thread anonymous = new Thread () {
        @Override
        public void run () {
            System.out.println ("Anonymous class example in java");
        }}
    ;
    anonymous.start ();
    InnerClassTest test = new InnerClassTest ();
    InnerClassTest.Inner inner = test.new Inner ();
    inner.name ();
}

static public void main (String [] argv) {
    System.out.println ("start");
    new C0 ();
    try {
        System.out.println ("retrieve item: " + nested.innerItem);
    } catch (Exception e) {
        System.out.println ("failed to retrieve item: " + e.toString ());
    }
    System.out.println ("finish");
}

}
