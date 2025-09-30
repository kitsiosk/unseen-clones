public class Clone309 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21357980
*  Stack Overflow answer #:21358123
*  And Stack Overflow answer#:21358183
*/
public static void main (String [] args) {
    int [] array = {1, 2, 3, 3, 2, 2, 4, 4, 5, 4};
    int count = 0;
    int maxCount = 10;
    int [] results = new int [array.length];
    int k = 0;
    for (int i = 0;
    i < results.length; i ++) {
        results [i] = - 1;
    }
    for (int i = 0;
    i < array.length; i ++) {
        for (int j = 0;
        j < array.length; j ++) {
            if (array [j] == array [i]) {
                count ++;
            }
        }
        if (count <= maxCount) {
            maxCount = count;
            results [k ++] = array [i];
        }
        count = 0;
    }
    for (int i : results) {
        if (i != - 1) {
            System.out.println ("Element: " + i + ", Number of occurences: " + maxCount);
        }
    }
}

public static void main (String [] args) {
    int [] array = {1, 2, 3, 3, 2, 2, 4, 4, 5, 4};
    Map < Integer, Integer > counts = new HashMap < > ();
    for (Integer i : array) {
        if (counts.get (i) == null) {
            counts.put (i, 1);
        } else {
            counts.put (i, counts.get (i) + 1);
        }
    }
    List < Integer > cs = new ArrayList < Integer > (counts.values ());
    Collections.sort (cs);
    int minVal = cs.get (0);
    List < Integer > minElements = new ArrayList < > ();
    for (Entry < Integer, Integer > entry : counts.entrySet ()) {
        if (entry.getValue () == minVal) {
            minElements.add (entry.getKey ());
        }
    }
    for (Integer i : minElements) {
        System.out.println ("Element: " + i + " Number of occurences: " + minVal);
    }
}

}
