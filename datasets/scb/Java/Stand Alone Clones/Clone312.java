public class Clone312 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18282060
*  Stack Overflow answer #:18282123
*  And Stack Overflow answer#:18283267
*/
public static void main (String [] args) {
    final Map < Integer, Integer > map = new HashMap < > ();
    final CountDownLatch readLatch = new CountDownLatch (1);
    final CountDownLatch writeLatch = new CountDownLatch (1);
    for (int i = 0;
    i < 100; i ++) {
        map.put (i, i);
    }
    new Thread (new Runnable () {
        @Override
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
        }}
    ).start ();
    new Thread (new Runnable () {
        @Override
        public void run () {
            try {
                writeLatch.await ();
                map.put (150, 150);
                readLatch.countDown ();
            } catch (InterruptedException e) {
                Thread.currentThread ().interrupt ();
            }
        }}
    ).start ();
}

public static void main (String [] args) {
    Runnable get = new Runnable () {
        @Override
        public void run () {
            for (int i = 0;
            ; i ++) {
                if (i % 1000 == 0) {
                    System.out.printf ("get: %d\n", i);
                }
                Map < K, String > m2 = new HashMap < > (map);
            }
        }}
    new Thread (get).start ();
    for (int i = 0;
    ; i ++) {
        if (i % 1000 == 0) {
            System.out.printf ("put: %d\n", i);
        }
        String s = Integer.toString (1000 + i);
        map.put (new K (s), s);
    }
}

}
