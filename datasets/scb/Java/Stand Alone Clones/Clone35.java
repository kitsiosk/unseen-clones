public class Clone35 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1519736
*  Stack Overflow answer #:18456998
*  And Stack Overflow answer#:1520212
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

static void shuffleArray (int [] ar) {
    Random rnd = ThreadLocalRandom.current ();
    for (int i = ar.length - 1;
    i > 0; i --) {
        int index = rnd.nextInt (i + 1);
        int a = ar [index];
        ar [index] = ar [i];
        ar [i] = a;
    }
}

}
