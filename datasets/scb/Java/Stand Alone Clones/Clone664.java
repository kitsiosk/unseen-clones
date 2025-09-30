public class Clone664 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11544843
*  Stack Overflow answer #:14466771
*  And Stack Overflow answer#:31668619
*/
public void run () {
    int i = 1;
    while (true) {
        System.out.println (i);
        try {
            Thread.sleep (1000);
            cb.await ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } catch (BrokenBarrierException e) {
            e.printStackTrace ();
        }
        i = i + 3;
    }
}

public synchronized void run () {
    int i = 3;
    while (i < 50) {
        while (s.getState () != 2) {
            synchronized (s) {
                try {
                    s.wait ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
        synchronized (s) {
            if (s.getState () == 2) System.out.println ("t3 " + i);
            i = i + 3;
            s.setState (3);
            s.notifyAll ();
        }
    }
}

}
