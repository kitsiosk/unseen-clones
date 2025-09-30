public class Clone128 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8071363
*  Stack Overflow answer #:45178514
*  And Stack Overflow answer#:32225878
*/
int pow (int a, int p) {
    int res = 1;
    int i1 = 31 - Integer.numberOfLeadingZeros (p);
    for (int i = i1;
    i >= 0; -- i) {
        res *= res;
        if ((p & (1 << i)) > 0) res *= a;
    }
    return res;
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
