public class Clone675 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11544843
*  Stack Overflow answer #:14466771
*  And Stack Overflow answer#:48617304
*/
public static void main (String args []) {
    Runnable threePrinter = new Runnable () {
        int i = 3;
        public void run () {
            System.out.println (i);
            i = i + 3;
        }}
    ;
    CyclicBarrier bar2 = new CyclicBarrier (1, threePrinter);
    two twoPrinter = new two (bar2);
    CyclicBarrier bar1 = new CyclicBarrier (1, twoPrinter);
    Thread onePrinter = new Thread (new one (bar1));
    onePrinter.start ();
}

public static void main (String [] args) {
    try {
        Tic tic = new Tic ();
        Tac tac = new Tac ();
        Toe toe = new Toe ();
        Thread t1 = new Thread (tic);
        Thread t2 = new Thread (tac);
        Thread t3 = new Thread (toe);
        t1.start ();
        t1.join ();
        if (! t1.isAlive ()) {
            t2.start ();
        }
        t2.join ();
        if (! t2.isAlive ()) {
            t3.start ();
        }
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }
}

}
