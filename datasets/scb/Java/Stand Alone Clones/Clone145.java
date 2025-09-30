public class Clone145 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13727030
*  Stack Overflow answer #:23311527
*  And Stack Overflow answer#:13727872
*/
private static void merge (int [] a, int [] b, int [] all) {
    int i = 0, j = 0, k = 0;
    while (i < a.length && j < b.length) {
        if (a [i] < b [j]) {
            all [k] = a [i];
            i ++;
        } else {
            all [k] = b [j];
            j ++;
        }
        k ++;
    }
    while (i < a.length) {
        all [k ++] = a [i ++];
    }
    while (j < b.length) {
        all [k ++] = b [j ++];
    }
}

static void merge (int [] a, int [] l, int [] r) {
    int totElem = l.length + r.length;
    int i, li, ri;
    i = li = ri = 0;
    while (i < totElem) {
        if ((li < l.length) && (ri < r.length)) {
            if (l [li] < r [ri]) {
                a [i] = l [li];
                i ++;
                li ++;
            } else {
                a [i] = r [ri];
                i ++;
                ri ++;
            }
        } else {
            if (li >= l.length) {
                while (ri < r.length) {
                    a [i] = r [ri];
                    i ++;
                    ri ++;
                }
            }
            if (ri >= r.length) {
                while (li < l.length) {
                    a [i] = l [li];
                    li ++;
                    i ++;
                }
            }
        }
    }
}

}
