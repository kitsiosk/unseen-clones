public class Clone189 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8880286
*  Stack Overflow answer #:8880928
*  And Stack Overflow answer#:8880354
*/
public static void main (String [] args) {
    Thread [] threads = new Thread [2];
    CountDownLatch latch = new CountDownLatch (threads.length);
    for (int i = 0;
    i < threads.length; ++ i) {
        threads [i] = new Thread (new BadRunnable (latch));
        threads [i].start ();
    }
}

public static void main (String [] args) {
    final Friend alphonse = new Friend ("Alphonse");
    final Friend gaston = new Friend ("Gaston");
    new Thread (new Runnable () {
        public void run () {
            alphonse.bow (gaston);
        }}
    ).start ();
    new Thread (new Runnable () {
        public void run () {
            gaston.bow (alphonse);
        }}
    ).start ();
}

}
