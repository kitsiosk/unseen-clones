public class Clone860 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4111210
*  Stack Overflow answer #:4111242
*  And Stack Overflow answer#:4111242
*/
public static int score (final String gene1, final String gene2) {
    final char [] a;
    final char [] b;
    final int s;
    a = gene1.toCharArray ();
    b = gene2.toCharArray ();
    s = score (a, b, 0, 0);
    return (s);
}

private static int score (final char [] a, final char [] b, final int idxA, final int idxB) {
    final int value;
    if (idxA >= a.length || idxB >= b.length) {
        value = 0;
    } else if (a [idxA] == b [idxB]) {
        value = 1 + score (a, b, idxA + 1, idxB + 1);
    } else {
        final int x;
        final int y;
        x = score (a, b, idxA + 1, idxB);
        y = score (a, b, idxB, idxB + 1);
        value = max (x, y);
    }
    return (value);
}

}
