public class Clone661 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11544843
*  Stack Overflow answer #:14466771
*  And Stack Overflow answer#:14466771
*/
public void run () {
    int i = 1;
    while (true) {
        System.out.println (i);
        try {
            Thread.sleep (1000);
            cb.await ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } catch (BrokenBarrierException e) {
            e.printStackTrace ();
        }
        i = i + 3;
    }
}

public void run () {
    System.out.println (i);
    try {
        cb.await ();
        i = i + 3;
        Thread.sleep (1000);
    } catch (InterruptedException e) {
        e.printStackTrace ();
    } catch (BrokenBarrierException e) {
        e.printStackTrace ();
    }
}

}
