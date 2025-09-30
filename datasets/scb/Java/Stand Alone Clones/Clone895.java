public class Clone895 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:44435790
*  Stack Overflow answer #:44436717
*  And Stack Overflow answer#:44435820
*/
public static void main (String [] args) {
    CountDownLatch latch = new CountDownLatch (1);
    System.out.println ("Start server");
    ServerModule serverModule = new ServerModule (latch);
    serverModule.start ();
    try {
        latch.await ();
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }
    System.out.println ("Server is done");
}

public static void main (String [] args) throws InterruptedException {
    Thread t = new Thread (() -> {
        try {
            Thread.sleep (5000L);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    });
    System.out.println ("Starting Server!");
    t.start ();
    t.join ();
    System.out.println ("Server is done!");
}

}
