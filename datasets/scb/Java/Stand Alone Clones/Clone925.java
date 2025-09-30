public class Clone925 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2385909
*  Stack Overflow answer #:26700216
*  And Stack Overflow answer#:41946443
*/
public static boolean isPrime (int num) {
    for (int i = 2;
    i <= num / i; i ++) {
        if (num % i == 0) {
            return false;
        }
    }
    return num > 1;
}

public static boolean isPrime (int n) {
    if ((n & 1) == 0) {
        return n == 2;
    }
    if (n < 9) {
        return n > 1;
    }
    return isStrongProbablePrime (n, 2) && isStrongProbablePrime (n, 7) && isStrongProbablePrime (n, 61);
}

}
