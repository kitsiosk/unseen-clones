public class Clone184 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8880286
*  Stack Overflow answer #:8883630
*  And Stack Overflow answer#:8880501
*/
public void run () {
    System.out.println ("Outer launched");
    System.out.println ("Obtaining lock");
    synchronized (lock) {
        Thread inner = new Thread (new InnerTask (lock), "inner");
        inner.start ();
        try {
            inner.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
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
