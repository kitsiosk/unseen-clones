public class Clone36 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1519736
*  Stack Overflow answer #:18456998
*  And Stack Overflow answer#:21454317
*/
private static void shuffleArray (int [] array) {
    int index;
    Random random = new Random ();
    for (int i = array.length - 1;
    i > 0; i --) {
        index = random.nextInt (i + 1);
        if (index != i) {
            array [index] ^= array [i];
            array [i] ^= array [index];
            array [index] ^= array [i];
        }
    }
}

public static void shuffleArray (int [] array) {
    List < Integer > list = new ArrayList < > ();
    for (int i : array) {
        list.add (i);
    }
    Collections.shuffle (list);
    for (int i = 0;
    i < list.size (); i ++) {
        array [i] = list.get (i);
    }
}

}
