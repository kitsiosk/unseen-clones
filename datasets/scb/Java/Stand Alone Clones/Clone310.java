public class Clone310 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13923442
*  Stack Overflow answer #:13923475
*  And Stack Overflow answer#:13923620
*/
public static void CountbyChar (String s) {
    int [] arr = new int [256];
    for (char c : s.toCharArray ()) {
        if (c < 256) {
            arr [c] ++;
        }
    }
    for (int i = 0;
    i != 256; i ++) {
        if (arr [i] != 0) {
            System.out.print ((char) i);
            System.out.print (" : ");
            System.out.println (arr [i]);
        }
    }
}

public static void CountbyChar (String s) {
    HashMap < Character, Integer > letterCountMap = new HashMap < Character, Integer > ();
    char [] c = s.toCharArray ();
    for (int i = 0;
    i < c.length; i ++) {
        Integer count = 0;
        if (letterCountMap.containsKey (c [i])) {
            count = letterCountMap.get (c [i]) + 1;
        } else {
            count = 1;
        }
        letterCountMap.put (c [i], count);
    }
    for (Map.Entry < String, String > entry : letterCountMap.entrySet ()) {
        System.out.println (entry.getValue () + "( for" + entry.getKey () + " )");
    }
}

}
