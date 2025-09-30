public class Clone130 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29676713
*  Stack Overflow answer #:29676970
*  And Stack Overflow answer#:29680524
*/
public static void main (String [] args) {
    BigInteger acc = BigInteger.ZERO;
    for (int k = 1;
    k <= 1000; k ++) {
        BigInteger pow = BigInteger.valueOf (k).pow (k);
        acc = acc.add (pow);
    }
    System.out.println (acc);
}

public static void main (String [] args) {
    long twoTo10 = 1024;
    long sum210 = 0;
    for (long i = 1;
    i <= 1000; i ++) {
        sum210 += pow (i, i, twoTo10);
        sum210 %= twoTo10;
    }
    long fiveTo10 = 9_765_625;
    long sum510 = 0;
    for (long i = 1;
    i <= 1000; i ++) {
        sum510 += pow (i, i, fiveTo10);
        sum510 %= fiveTo10;
    }
    long tenTo10 = 10_000_000_000L;
    long answer = sum210 * inverse (fiveTo10, twoTo10) * fiveTo10 + sum510 * inverse (twoTo10, fiveTo10) * twoTo10;
    answer %= tenTo10;
    System.out.println (answer);
}

}
