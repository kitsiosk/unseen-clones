public class Clone314 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18282060
*  Stack Overflow answer #:18282123
*  And Stack Overflow answer#:18283267
*/
public void run () {
    try {
        writeLatch.await ();
        map.put (150, 150);
        readLatch.countDown ();
    } catch (InterruptedException e) {
        Thread.currentThread ().interrupt ();
    }
}

public void run () {
    for (int i = 0;
    ; i ++) {
        if (i % 1000 == 0) {
            System.out.printf ("get: %d\n", i);
        }
        Map < K, String > m2 = new HashMap < > (map);
    }
}

}
