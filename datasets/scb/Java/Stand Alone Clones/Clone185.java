public class Clone185 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8880286
*  Stack Overflow answer #:9286697
*  And Stack Overflow answer#:8880928
*/
public void run () {
    try {
        Thread t = new Thread (new Lock ());
        t.start ();
        t.join ();
    } catch (InterruptedException ex) {
        System.out.println ("won't see me");
    }
}

public void run () {
    System.out.println ("Thread " + Thread.currentThread ().getId () + " starting");
    synchronized (BadRunnable.class) {
        System.out.println ("Thread " + Thread.currentThread ().getId () + " acquired the monitor on BadRunnable.class");
        latch.countDown ();
        while (true) {
            try {
                latch.await ();
            } catch (InterruptedException ex) {
                continue;
            }
            break;
        }
    }
    System.out.println ("Thread " + Thread.currentThread ().getId () + " released the monitor on BadRunnable.class");
    System.out.println ("Thread " + Thread.currentThread ().getId () + " ending");
}

}
