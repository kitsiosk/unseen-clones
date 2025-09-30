public class Clone851 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:43440102
*  Stack Overflow answer #:43440220
*  And Stack Overflow answer#:43440213
*/
public static double [] [] amountOTP (double [] [] a, int x) {
    if (x > a.length) return a;
    for (double [] arr : a) if (arr.length < x) return a;
    double [] [] newArray = new double [x] [x];
    for (int i = 0;
    i < x; i ++) for (int j = 0;
    j < x; j ++) newArray [i] [j] = a [i] [j];
    return newArray;
}

public static double [] [] amountOTP (double [] [] a, int x) {
    double [] [] b = new double [x] [x];
    x = Math.min (x, a.length);
    for (int i = 0;
    i < x; i ++) for (int j = 0;
    j < x; j ++) b [i] [j] = a [i] [j];
    return b;
}

}
