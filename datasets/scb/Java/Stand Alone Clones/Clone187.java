public class Clone187 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8880286
*  Stack Overflow answer #:8880660
*  And Stack Overflow answer#:8880501
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
    String threadName = Thread.currentThread ().getName ();
    try {
        first.lock ();
        latch.countDown ();
        System.out.println (threadName + ": locked first lock");
        latch.await ();
        System.out.println (threadName + ": attempting to lock second lock");
        second.lock ();
        System.out.println (threadName + ": never reached");
    } catch (InterruptedException e) {
        throw new RuntimeException (e);
    }
}

}
