public class Clone459 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25922372
*  Stack Overflow answer #:25922612
*  And Stack Overflow answer#:25922614
*/
public void run () {
    while (true) {
        String output = task ();
        if (output != null) {
            int count = counter.getAndIncrement ();
            System.out.println (output);
            if (count >= 100) {
                break;
            }
        }
    }
}

public void run () {
    while (true) {
        try {
            Object expensiveObject = expensiveObjects.take ();
            String output = task ();
            expensiveObjects.put (expensiveObject);
            if (output != null) {
                int counter = outputCount.getAndIncrement ();
                System.out.println (counter);
                if (counter >= 100) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println ("Error!");
        }
    }
}

}
