public class Clone303 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23867836
*  Stack Overflow answer #:23868077
*  And Stack Overflow answer#:23868215
*/
public static int loneSum (int a, int b, int c) {
    if (a == b && b == c) {
        a = 0;
        b = 0;
        c = 0;
    }
    if (a == b) {
        a = 0;
        b = 0;
    }
    if (a == c) {
        a = 0;
        c = 0;
    }
    if (b == c) {
        b = 0;
        c = 0;
    }
    return a + b + c;
}

public int loneSum (int a, int b, int c) {
    int sum = 0;
    boolean ab = a != b;
    boolean ac = a != c;
    boolean bc = b != c;
    if (ab && ac) sum += a;
    if (ab && bc) sum += b;
    if (bc && ac) sum += c;
    return sum;
}

}
