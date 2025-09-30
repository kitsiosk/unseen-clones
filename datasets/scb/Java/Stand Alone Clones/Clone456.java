public class Clone456 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25922372
*  Stack Overflow answer #:25925208
*  And Stack Overflow answer#:25922614
*/
public static void main (String [] args) throws InterruptedException {
    final AtomicInteger outputCount = new AtomicInteger (0);
    ExecutorService threadPool = Executors.newFixedThreadPool (THREADS);
    Collection < Callable < Object > > tasks = new ArrayList < > (THREADS);
    for (int i = 0;
    i < THREADS; i ++) {
        tasks.add (new Callable < Object > () {
            private SecureRandom rand = new SecureRandom ();
            private String task () {
                return rand.nextDouble () > 0.5 ? Thread.currentThread ().getName () : null;
            }@Override
            public Object call () {
                for (int i;
                (i = outputCount.get ()) < TASKS;) {
                    String output = task ();
                    if (output != null) {
                        if ((i = outputCount.incrementAndGet ()) < TASKS) {
                            System.out.println (output + ": " + i);
                        }
                    }
                }
                return null;
            }}
        );
    }
    threadPool.invokeAll (tasks);
    threadPool.shutdownNow ();
    System.out.println ("done");
}

public static void main (String [] args) throws InterruptedException {
    BlockingQueue < Object > expensiveObjects = new LinkedBlockingQueue < > ();
    expensiveObjects.put (new Object ());
    expensiveObjects.put (new Object ());
    expensiveObjects.put (new Object ());
    expensiveObjects.put (new Object ());
    ExecutorService executorService = Executors.newFixedThreadPool (4);
    for (int i = 0;
    i < 4; i ++) {
        executorService.execute (new MyRunnable (expensiveObjects));
    }
    executorService.shutdown ();
    executorService.awaitTermination (5, TimeUnit.SECONDS);
    System.out.println ("Final: " + outputCount.get ());
}

}
