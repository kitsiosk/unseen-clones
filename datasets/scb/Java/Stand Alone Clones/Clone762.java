public class Clone762 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6457826
*  Stack Overflow answer #:6458141
*  And Stack Overflow answer#:6458208
*/
public IntList get (int i) {
    IntList current = this;
    for (int k = 0;
    k < i - 1; k ++) {
        if (current.next != null) {
            current = current.next;
        }
    }
    return current;
}

public IntList get (int i) {
    if (i < 0) {
        throw new IndexOutOfBoundsException ("Index is negative!");
    }
    if (i == 0) {
        return this;
    } else if (next != null) {
        return next.get (i - 1);
    }
    throw new IndexOutOfBoundsException ("Index exceeds bounds");
}

}
