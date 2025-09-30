public class Clone458 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25922372
*  Stack Overflow answer #:25928966
*  And Stack Overflow answer#:25922614
*/
public static void main (String [] args) throws InterruptedException {
    CountDownLatch theLatch = new CountDownLatch (100);
    List < String > output = Collections.synchronizedList (new ArrayList < String > ());
    SecureRandom random = new SecureRandom ();
    ExecutorService service = Executors.newCachedThreadPool ();
    for (int i = 0;
    i < 4; i ++) {
        service.execute (new CountDownTask (theLatch, output, random));
    }
    theLatch.await (1, TimeUnit.MINUTES);
    service.shutdown ();
    System.out.println (output.size ());
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
