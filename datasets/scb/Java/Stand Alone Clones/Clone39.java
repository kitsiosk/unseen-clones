public class Clone39 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1519736
*  Stack Overflow answer #:26730292
*  And Stack Overflow answer#:19333201
*/
public void shuffle (T [] ar) {
    for (int i = ar.length - 1;
    i > 0; i --) {
        int index = rnd.nextInt (i + 1);
        T a = ar [index];
        ar [index] = ar [i];
        ar [i] = a;
    }
}

public static void shuffle (int [] array) {
    if (random == null) random = new Random ();
    int count = array.length;
    for (int i = count;
    i > 1; i --) {
        swap (array, i - 1, random.nextInt (i));
    }
}

}
