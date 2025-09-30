public class Clone370 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16963405
*  Stack Overflow answer #:16964065
*  And Stack Overflow answer#:16964055
*/
public void run () {
    try {
        for (int i = 0;
        i < 5; i ++) {
            world.acquire ();
            System.out.println ("  World!");
            hello.release ();
        }
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }
}

public void run () {
    for (int i = 0;
    i < sayThisManyTimes; i ++) {
        while (! saidHello.get ()) {
        }
        System.out.println ("World!");
        saidHello.set (false);
    }
}

}
