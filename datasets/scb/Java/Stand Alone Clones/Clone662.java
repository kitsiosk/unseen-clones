public class Clone662 {
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

public void run () {
    int i = 1;
    while (i < 50) {
        while (s.getState () != 3) {
            synchronized (s) {
                try {
                    s.wait ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
        synchronized (s) {
            if (s.getState () == 3) System.out.println ("t1 " + i);
            s.setState (1);
            i = i + 3;
            s.notifyAll ();
        }
    }
}

}
