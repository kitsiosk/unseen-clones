public class Clone900 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28164990
*  Stack Overflow answer #:30487456
*  And Stack Overflow answer#:28165241
*/
public static void main (String [] args) throws InterruptedException {
    int n = 1000;
    int tn = 10;
    int from = 1;
    int to;
    int sum = 0;
    Sum [] sumArray = new Sum [tn];
    final CountDownLatch latch = new CountDownLatch (tn);
    for (int i = 0;
    i < tn; i ++) {
        to = from + n / tn;
        Sum s = new Sum (from, to, latch);
        sumArray [i] = s;
        s.start ();
        from = to;
    }
    latch.await ();
    for (int i = 0;
    i < tn; i ++) {
        sum += sumArray [i].getSum ();
    }
    System.out.println (sum);
}

public static void main (String...args) {
    final CountDownLatch latch = new CountDownLatch (28);
    for (int i = 0;
    i < 28; i ++) {
        Thread t = new Thread (new Runnable () {
            public void run () {
                try {
                } finally {
                    latch.countDown ();
                }
            }}
        );
        t.start ();
    }
    latch.await ();
}

}
