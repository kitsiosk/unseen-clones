public class Clone61 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:44990340
*  Stack Overflow answer #:44990456
*  And Stack Overflow answer#:44990735
*/
static int findMIN (int [] A, int c) {
    int first = c;
    int id = c;
    int x = A [c];
    while (c < A.length) {
        if (x > A [c]) {
            x = A [c];
            id = c;
        }
        c ++;
    }
    int tmp = A [first];
    A [first] = A [id];
    A [id] = tmp;
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
