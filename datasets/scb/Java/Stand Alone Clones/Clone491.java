public class Clone491 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13000679
*  Stack Overflow answer #:13000719
*  And Stack Overflow answer#:13000725
*/
public void run () {
    try {
        synchronized (signal) {
            while (true) {
                while (current.equals (info)) signal.wait ();
                System.out.println (info);
                current = info;
                signal.notify ();
            }
        }
    } catch (Exception e) {
    }
}

public synchronized void run () {
    try {
        while (true) {
            System.out.println (info);
            wait ();
        }
    } catch (Exception e) {
    }
}

}
