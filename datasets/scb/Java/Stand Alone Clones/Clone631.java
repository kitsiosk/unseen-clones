public class Clone631 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6470651
*  Stack Overflow answer #:50042877
*  And Stack Overflow answer#:18544736
*/
public void run () {
    IntStream.range (0, 500).forEach (value -> {
        final Map < String, Integer > map = pseudoQueryDatabase ();
        final int index = new Random ().nextInt (MAP_SIZE);
        for (Map.Entry < String, Integer > entry : map.entrySet ()) {
            if (entry.getValue ().equals (index)) {
                holdersCache.add (new EntryHolder (entry));
                break;
            }
        }
        try {
            Thread.sleep (500);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    });
}

public void run () {
    Object o = object;
    for (;;) {
        try {
            sleep (Long.MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }
}

}
