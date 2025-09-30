public class Clone518 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17358806
*  Stack Overflow answer #:17527661
*  And Stack Overflow answer#:17509923
*/
static int search (int [] A, int K) {
    int l = - 1;
    int u = A.length;
    int m;
    while (l + 1 < u) {
        m = l + (u - l) / 2;
        if (A [m] < K) {
            l = m;
        } else {
            u = m;
        }
    }
    if ((u == A.length) || (A [u] != K)) return - 1;
    return u;
}

static int search (int [] A, int K) {
    int l = 0;
    int u = A.length - 1;
    int m;
    while (l <= u) {
        m = (u - l) / 2 + l;
        if (A [m] < K) l = m + 1;
        else if (A [m] == K) return m;
        else u = m - 1;
    }
    return - 1;
}

}
