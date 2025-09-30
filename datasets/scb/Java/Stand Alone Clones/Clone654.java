public class Clone654 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2044033
*  Stack Overflow answer #:2044423
*  And Stack Overflow answer#:2046285
*/
public static void main (String...args) {
    Runnable r1 = new Runnable () {
        int n;
        public void run () {
            System.out.println (++ n);
        }}
    ;
    fourTimes (fiveTimes (fiveTimes (r1))).run ();
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
