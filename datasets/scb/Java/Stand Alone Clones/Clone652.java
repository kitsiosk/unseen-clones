public class Clone652 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2044033
*  Stack Overflow answer #:2044236
*  And Stack Overflow answer#:2046285
*/
public static void main (String [] args) {
    String set = new java.util.BitSet () {
        {
            set (1, 100 + 1);
        }
    }
    .toString ();
    System.out.append (set, 1, set.length () - 1);
}

public static void main (String [] args) {
    final int max = 100;
    new java.util.concurrent.Semaphore (max) {
        void go () {
            acquireUninterruptibly ();
            System.err.println (max - availablePermits ());
            go ();
        }}
    .go ();
}

}
