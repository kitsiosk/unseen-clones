public class Clone222 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19459197
*  Stack Overflow answer #:39779422
*  And Stack Overflow answer#:30351219
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
    int len = A.length;
    if (X > len) {
        return - 1;
    }
    int [] isFilled = new int [X];
    int jumped = 0;
    Arrays.fill (isFilled, 0);
    for (int i = 0;
    i < len; i ++) {
        int x = A [i];
        if (x <= X) {
            if (isFilled [x - 1] == 0) {
                isFilled [x - 1] = 1;
                jumped += 1;
                if (jumped == X) {
                    return i;
                }
            }
        }
    }
    return - 1;
}

}
