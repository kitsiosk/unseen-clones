public class Clone767 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:22579054
*  Stack Overflow answer #:30639588
*  And Stack Overflow answer#:31589437
*/
public int solution (int [] A) {
    final Set perm = new HashSet ();
    final int size = A.length;
    for (int number : A) {
        if (number > size) return 0;
        perm.add (number);
    }
    if (perm.size () == A.length) return 1;
    else return 0;
}

public int solution (int [] A) {
    int [] mark = new int [A.length + 1];
    int counter = 0;
    for (int i = 0;
    i < A.length; ++ i) {
        int value = A [i];
        if (value >= mark.length) {
            return NOT_PERMUTATION;
        }
        if (mark [value] == 0) {
            mark [value] = 1;
            ++ counter;
        } else {
            return NOT_PERMUTATION;
        }
    }
    return counter == A.length ? PERMUTATION : NOT_PERMUTATION;
}

}
