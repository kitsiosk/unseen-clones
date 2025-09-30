public class Clone186 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8880286
*  Stack Overflow answer #:8880660
*  And Stack Overflow answer#:8880928
*/
public void run () {
    synchronized (obj1) {
        latch.countDown ();
        try {
            latch.await ();
        } catch (InterruptedException e) {
            throw new RuntimeException ();
        }
        synchronized (obj2) {
            System.out.println ("Thread finished");
        }
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
