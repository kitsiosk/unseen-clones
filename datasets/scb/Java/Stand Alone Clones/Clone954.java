public class Clone954 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29520702
*  Stack Overflow answer #:29521706
*  And Stack Overflow answer#:29520822
*/
boolean isPrime (long n) {
    if (n < 2) return false;
    if (n == 2 || n == 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    long sqrtN = (long) Math.sqrt (n) + 1;
    for (long i = 6L;
    i <= sqrtN; i += 6) {
        if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
    }
    return true;
}

public boolean isPrime () {
    int sqrt = (int) Math.sqrt ((double) value);
    for (int i = 2;
    i <= sqrt; i ++) {
        if (value % i == 0) return false;
    }
    return true;
}

}
