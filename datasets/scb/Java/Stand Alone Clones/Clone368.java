public class Clone368 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16963405
*  Stack Overflow answer #:27650365
*  And Stack Overflow answer#:16964055
*/
public static void main (String [] args) throws InterruptedException {
    for (int i = 0;
    i < 6; i ++) {
        Runnable helloTask = new Runnable () {
            @Override
            public void run () {
                new ThreadSeq ().printHello ();
            }}
        ;
        Runnable worldTask = new Runnable () {
            @Override
            public void run () {
                new ThreadSeq ().printWorld ();
            }}
        ;
        Thread t1 = new Thread (helloTask);
        Thread t2 = new Thread (worldTask);
        t1.start ();
        t1.join ();
        t2.start ();
        t2.join ();
    }
}

public static void main (String [] args) {
    int sayThisManyTimes = 5;
    AtomicBoolean saidHello = new AtomicBoolean (false);
    MyThread mt = new MyThread (sayThisManyTimes, saidHello);
    mt.start ();
    for (int i = 0;
    i < sayThisManyTimes; i ++) {
        while (saidHello.get ()) {
        }
        System.out.println ("Hello ");
        saidHello.set (true);
    }
}

}
