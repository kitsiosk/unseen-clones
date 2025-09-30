public class Clone60 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:44990340
*  Stack Overflow answer #:44990538
*  And Stack Overflow answer#:44990735
*/
static int findMIN (int [] A, int c) {
    int x = A [c];
    int min_index = c;
    for (int i = c;
    i < A.length; i ++) {
        if (x > A [i]) {
            x = A [i];
            min_index = i;
        }
    }
    A [min_index] = A [c];
    A [c] = A [min_index];
    return x;
}

static int findMIN (int [] A, int c) {
    int x = A [c];
    int position = c;
    while (c < A.length) {
        if (x > A [c]) {
            x = A [c];
            position = c;
        }
        c ++;
    }
    return position;
}

}
