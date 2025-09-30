public class Clone655 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2044033
*  Stack Overflow answer #:2044675
*  And Stack Overflow answer#:2046285
*/
public static void main (String [] args) {
    Object [] numbers = new Object [100];
    Arrays.fill (numbers, new Object () {
        private int count = 0;
        @Override
        public String toString () {
            return Integer.toString (++ count);
        }}
    );
    System.out.println (Arrays.toString (numbers));
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
