public class Clone40 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1519736
*  Stack Overflow answer #:26730292
*  And Stack Overflow answer#:38957563
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

public static void shuffle (Object [] a) {
    int n = a.length;
    for (int i = 0;
    i < n; i ++) {
        int r = i + (int) (Math.random () * (n - i));
        Object swap = a [r];
        a [r] = a [i];
        a [i] = swap;
    }
}

}
