public class Clone313 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18282060
*  Stack Overflow answer #:18282123
*  And Stack Overflow answer#:18283267
*/
public void run () {
    try {
        for (Map.Entry < Integer, Integer > entry : map.entrySet ()) {
            if (entry.getKey ().equals (Integer.valueOf (10))) {
                try {
                    writeLatch.countDown ();
                    readLatch.await ();
                } catch (InterruptedException e) {
                    Thread.currentThread ().interrupt ();
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace ();
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
