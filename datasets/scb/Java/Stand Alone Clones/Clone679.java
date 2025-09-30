public class Clone679 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11544843
*  Stack Overflow answer #:31668619
*  And Stack Overflow answer#:48617304
*/
public synchronized void run () {
    int i = 2;
    while (i < 50) {
        while (s.getState () != 1) {
            synchronized (s) {
                try {
                    s.wait ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
        synchronized (s) {
            if (s.getState () == 1) System.out.println ("t2 " + i);
            s.setState (2);
            i = i + 3;
            s.notifyAll ();
        }
    }
}

public void run () {
    try {
        for (int i = 0;
        i < 2; i ++) {
            System.out.println ("tic");
        }
    } catch (Exception e) {
        e.getStackTrace ();
    }
}

}
