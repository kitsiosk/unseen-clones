public class Clone129 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8071363
*  Stack Overflow answer #:20984477
*  And Stack Overflow answer#:32225878
*/
long pow (long a, int b) {
    if (b == 0) return 1;
    if (b == 1) return a;
    if (isEven (b)) return pow (a * a, b / 2);
    else return a * pow (a * a, b / 2);
}

private static int pow (int x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    if (n < 0) {
        if (x == 1 || (x == 2 && n == - 1)) return 1;
        else return 0;
    }
    if ((n & 1) == 0) {
        long num = pow (x * x, n / 2);
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) num;
    } else {
        long num = x * pow (x * x, n / 2);
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) num;
    }
}

}
