public class Clone942 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27591043
*  Stack Overflow answer #:42456249
*  And Stack Overflow answer#:42456249
*/
public void run () {
    synchronized (list) {
        for (int i = 0;
        i < 10; i ++) {
            if (list.size () >= 1) {
                try {
                    System.out.println ("producer is waiting ");
                    list.wait ();
                } catch (InterruptedException ex) {
                    ex.printStackTrace ();
                }
            }
            System.out.println ("produce=" + i);
            list.add (i);
            list.notifyAll ();
            try {
                Thread.sleep (500);
            } catch (InterruptedException ex) {
                ex.printStackTrace ();
            }
        }
    }
}

public void run () {
    synchronized (list) {
        for (int i = 0;
        i < 10; i ++) {
            while (list.isEmpty ()) {
                System.out.println ("Consumer is waiting");
                try {
                    list.wait ();
                } catch (InterruptedException ex) {
                    ex.printStackTrace ();
                }
            }
            int k = list.remove (0);
            System.out.println ("consume=" + k);
            list.notifyAll ();
            try {
                Thread.sleep (500);
            } catch (InterruptedException ex) {
                ex.printStackTrace ();
            }
        }
    }
}

}
