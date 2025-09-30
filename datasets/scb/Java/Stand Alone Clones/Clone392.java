public class Clone392 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8935367
*  Stack Overflow answer #:8935416
*  And Stack Overflow answer#:8935384
*/
public static int mode (int [] [] arr) {
    int [] oneDArray = new int [arr.length * arr.length];
    for (int i = 0;
    i < arr.length; i ++) {
        for (int s = 0;
        s < arr.length; s ++) {
            oneDArray [(i * arr.length) + s] = arr [i] [s];
        }
    }
}

public static int mode (int [] [] arr) {
    List < Integer > list = new ArrayList < Integer > ();
    for (int i = 0;
    i < arr.length; i ++) {
        for (int j = 0;
        j < arr [i].length; j ++) {
            list.add (arr [i] [j]);
        }
    }
    int [] vector = new int [list.size ()];
    for (int i = 0;
    i < vector.length; i ++) {
        vector [i] = list.get (i);
    }
}

}
