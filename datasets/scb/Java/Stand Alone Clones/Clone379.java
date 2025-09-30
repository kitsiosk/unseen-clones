public class Clone379 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:24247776
*  Stack Overflow answer #:24249661
*  And Stack Overflow answer#:24248120
*/
public void run () {
    int emptyCycleCounter = 0;
    while (true) {
        int i = counter.get ();
        if (i > MAX_COUNTER) {
            break;
        }
        if (i % 2 == (odd ? 1 : 0)) {
            System.out.println (i + (odd ? " odd" : " even"));
            counter.incrementAndGet ();
        } else {
            emptyCycleCounter ++;
            Thread.yield ();
        }
    }
    System.out.println ("Finished" + (odd ? " odd" : " even") + " with " + emptyCycleCounter + " empty cycles.");
}

public void run () {
    for (int i = 0;
    i <= 10; i += 2) {
        synchronized (o) {
            try {
                while (turn) {
                    o.wait ();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace ();
            } finally {
                System.out.println (i);
                turn = ! turn;
                o.notifyAll ();
            }
        }
    }
}

}
