public class Clone326 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12379253
*  Stack Overflow answer #:12465936
*  And Stack Overflow answer#:12379513
*/
public void run () {
    count ++;
    if (Thread.currentThread ().getName ().compareTo ("one") == 0) {
        synchronized (a.class) {
            try {
                for (int i = 0;
                i < 5; i ++) {
                    while (time.equals ("Tock")) {
                        a.class.wait ();
                    }
                    System.out.println ("Now running thread " + Thread.currentThread ().getName () + " with count " + count);
                    time = "Tock";
                    System.out.println (time);
                    a.class.notify ();
                }
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    } else if (Thread.currentThread ().getName ().compareTo ("two") == 0) {
        synchronized (a.class) {
            try {
                for (int j = 0;
                j < 5; j ++) {
                    while (time.equals ("Tick")) {
                        a.class.wait ();
                    }
                    System.out.println ("Now running thread " + Thread.currentThread ().getName () + " with count " + count);
                    time = "Tick";
                    System.out.println (time);
                    a.class.notify ();
                }
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
}

public void run () {
    try {
        synchronized (lock) {
            for (int i = 0;
            i < 5; i ++) {
                while (id != token % N) lock.wait ();
                System.out.println (id + " " + i);
                token ++;
                lock.notifyAll ();
            }
        }
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }
}

}
