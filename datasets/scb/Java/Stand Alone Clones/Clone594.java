public class Clone594 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:48918439
*  Stack Overflow answer #:48918496
*  And Stack Overflow answer#:48918482
*/
public static int [] front11 (int [] a, int [] b) {
    if (a.length > 0 && b.length > 0) return new int [] {a [0], b [0]};
    if (a.length > 0) return new int [] {a [0]};
    if (b.length > 0) return new int [] {b [0]};
    return new int [0];
}

public static int [] front11 (int [] a, int [] b) {
    int alen = (a != null) ? a.length : 0, blen = (b != null) ? b.length : 0;
    if (alen > 0 && blen > 0) {
        return new int [] {a [0], b [0]};
    } else if (alen > 0) {
        return new int [] {a [0]};
    } else if (blen > 0) {
        return new int [] {b [0]};
    } else {
        return new int [0];
    }
}

}
