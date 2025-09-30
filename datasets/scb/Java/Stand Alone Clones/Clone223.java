public class Clone223 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19459197
*  Stack Overflow answer #:39779422
*  And Stack Overflow answer#:25526428
*/
public static final int solution (final int X, final int [] A) {
    if (A.length < ARRAY_SIZE_LOWER || A.length > ARRAY_SIZE_UPPER) {
        throw new RuntimeException ("Array size out of bounds");
    }
    Set set = new Set (X);
    int ai;
    int counter = X;
    final int NUMBER_REAL_UPPER = min (NUMBER_UPPER, X);
    for (int i = 0;
    i < A.length; i ++) {
        if ((ai = A [i]) < NUMBER_LOWER || ai > NUMBER_REAL_UPPER) {
            throw new RuntimeException ("Number out of bounds");
        } else if (ai <= X && ! set.contains (ai)) {
            counter --;
            if (counter == 0) {
                return i;
            }
            set.put (ai);
        }
    }
    return - 1;
}

public int solution (int X, int [] A) {
    Set < Integer > set = new HashSet < Integer > ();
    int sum1 = 0, sum2 = 0;
    for (int i = 0;
    i <= X; i ++) {
        sum1 += i;
    }
    for (int i = 0;
    i < A.length; i ++) {
        if (set.contains (A [i])) continue;
        set.add (A [i]);
        sum2 += A [i];
        if (sum1 == sum2) return i;
    }
    return - 1;
}

}
