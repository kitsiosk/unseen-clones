public class Clone34 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:53569304
*  Stack Overflow answer #:53569350
*  And Stack Overflow answer#:53571264
*/
public static boolean isPrime (long num) {
    if (num > 2 && num % 2 == 0) {
        System.out.println (num + " is not prime");
        return false;
    }
    int top = (int) Math.sqrt (num) + 1;
    for (int i = 3;
    i < top; i += 2) {
        if (num % i == 0) {
            System.out.println (num + " is not prime");
            return false;
        }
    }
    System.out.println (num + " is prime");
    return true;
}

boolean isPrime (int x) {
    for (int i = 2;
    i * i <= x; i ++) {
        if (x % i == 0) {
            return false;
        }
    }
    return true;
}

}
