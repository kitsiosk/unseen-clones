public class Clone197 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2920315
*  Stack Overflow answer #:2920349
*  And Stack Overflow answer#:14444037
*/
public Object next () throws NoSuchElementException {
    formNextPermutation ();
    int i = size - 1;
    while (permutation [i] > permutation [i + 1]) i --;
    if (i == 0) {
        next = false;
        for (int j = 0;
        j < size + 1; j ++) {
            permutation [j] = j;
        }
        return ar;
    }
    int j = size;
    while (permutation [i] > permutation [j]) j --;
    swap (i, j);
    int r = size;
    int s = i + 1;
    while (r > s) {
        swap (r, s);
        r --;
        s ++;
    }
    return ar;
}

public E [] next () {
    if (! has_next) throw new NoSuchElementException ();
    for (int i = 0;
    i < ind.length; i ++) {
        output [i] = arr [ind [i]];
    }
    has_next = false;
    for (int tail = ind.length - 1;
    tail > 0; tail --) {
        if (ind [tail - 1] < ind [tail]) {
            int s = ind.length - 1;
            while (ind [tail - 1] >= ind [s]) s --;
            swap (ind, tail - 1, s);
            for (int i = tail, j = ind.length - 1;
            i < j; i ++, j --) {
                swap (ind, i, j);
            }
            has_next = true;
            break;
        }
    }
    return output;
}

}
