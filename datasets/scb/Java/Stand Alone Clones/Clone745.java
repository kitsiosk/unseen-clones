public class Clone745 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33289212
*  Stack Overflow answer #:33289337
*  And Stack Overflow answer#:33290045
*/
public static int evenDigits (int n) {
    int res = 0;
    int mag = 0;
    while (n > 9) {
        int digit = n % 10;
        n /= 10;
        if (digit % 2 == 0) {
            res += Math.pow (10, mag) * digit;
            mag ++;
        }
    }
    return res;
}

public static int evenDigits (int n) {
    if ((n & 1) != 0) {
        return evenDigits (n / 10);
    }
    if (n < 10) {
        return n;
    }
    return n % 10 + evenDigits (n / 10) * 10;
}

}
