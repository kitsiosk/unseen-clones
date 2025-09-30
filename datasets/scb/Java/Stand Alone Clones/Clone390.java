public class Clone390 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20891176
*  Stack Overflow answer #:20891807
*  And Stack Overflow answer#:20891548
*/
public static void main (String [] args) {
    final AtomicInteger sequencer = new AtomicInteger (1);
    final Set < Integer > integers = new HashSet < Integer > ();
    final Runnable task = new Runnable () {
        @Override
        public void run () {
            int next = sequencer.getAndIncrement ();
            synchronized (integers) {
                if (integers.contains (next)) {
                    System.out.println ("duplicate detected " + next);
                }
                integers.add (next);
            }
        }}
    ;
    for (int j = 0;
    j < 1000; j ++) {
        System.out.print ("testing " + j + " ");
        sequencer.set (0);
        integers.clear ();
        List < Thread > threads = new ArrayList < Thread > (10000);
        for (int i = 0;
        i < 1000; i ++) {
            Thread t = new Thread (task);
            threads.add (t);
            t.start ();
        }
        for (Thread t : threads) {
            try {
                t.join ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ("integers size " + integers.size ());
    }
}

public static void main (String [] args) throws Exception {
    final AtomicInteger sequencer = new AtomicInteger (1);
    final int [] integers = new int [1000];
    final Runnable task = new Runnable () {
        @Override
        public void run () {
            int next = sequencer.getAndIncrement ();
            integers [next - 1] ++;
        }}
    ;
    List < Thread > threads = new ArrayList < > ();
    for (int i = 0;
    i < 1000; i ++) {
        Thread t = new Thread (task);
        t.start ();
        threads.add (t);
    }
    for (Thread t : threads) {
        t.join ();
    }
    for (int i = 0;
    i < 1000; i ++) {
        if (integers [i] != 1) System.out.println (i + " -> " + integers [i]);
    }
}

}
