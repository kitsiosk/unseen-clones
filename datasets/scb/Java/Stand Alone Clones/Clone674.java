public class Clone674 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11544843
*  Stack Overflow answer #:14466771
*  And Stack Overflow answer#:31668619
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
    State s = new State ();
    Thread t1 = new Thread (new T1 (s));
    Thread t2 = new Thread (new T2 (s));
    Thread t3 = new Thread (new T3 (s));
    t1.start ();
    t2.start ();
    t3.start ();
}

}
