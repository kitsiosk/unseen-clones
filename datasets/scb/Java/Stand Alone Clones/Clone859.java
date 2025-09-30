public class Clone859 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4111210
*  Stack Overflow answer #:4111239
*  And Stack Overflow answer#:4111242
*/
private static int score (char [] a, char [] b, int i, int j) {
    if (i == a.length || j == b.length) {
        return 0;
    } else if (a [i] == b [j]) {
        return 1 + score (a, b, i + 1, j + 1);
    } else {
        return max (score (a, b, i + 1, j), score (a, b, i, j + 1));
    }
}

public static int score (final String gene1, final String gene2) {
    final char [] a;
    final char [] b;
    final int s;
    a = gene1.toCharArray ();
    b = gene2.toCharArray ();
    s = score (a, b, 0, 0);
    return (s);
}

}
