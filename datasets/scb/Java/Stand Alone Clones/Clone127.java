public class Clone127 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8071363
*  Stack Overflow answer #:45178514
*  And Stack Overflow answer#:20984477
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

long pow (long a, int b) {
    if (b == 0) return 1;
    if (b == 1) return a;
    if (isEven (b)) return pow (a * a, b / 2);
    else return a * pow (a * a, b / 2);
}

}
