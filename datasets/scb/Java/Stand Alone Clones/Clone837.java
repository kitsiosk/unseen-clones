public class Clone837 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:47029935
*  Stack Overflow answer #:47029985
*  And Stack Overflow answer#:47030059
*/
public static boolean isPrime (int n) {
    int i;
    for (i = 2; i * i <= n; i ++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}

bool isPrime (int number) {
    if (number < 2) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;
    for (int i = 3;
    (i * i) <= number; i += 2) {
        if (number % i == 0) return false;
    }
    return true;
}

}
