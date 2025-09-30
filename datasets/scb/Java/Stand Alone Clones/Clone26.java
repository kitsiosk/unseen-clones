public class Clone26 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20916333
*  Stack Overflow answer #:20916369
*  And Stack Overflow answer#:20916521
*/
public static void main (String [] args) {
    int x = 123456789;
    System.out.println ("x = " + x);
    int hi = x, n = 0;
    while (hi > 9) {
        hi /= 10;
        ++ n;
    }
    for (int i = 0;
    i < n; i ++) hi *= 10;
    x -= hi;
    System.out.println ("x with high digit removed = " + x);
}

public static void main (String [] argv) {
    final int x = 123456789;
    int newX = x;
    final double originalLog = Math.floor (Math.log10 (x));
    final int getRidOf = (int) Math.pow (10, originalLog);
    while (originalLog == Math.floor (Math.log10 (newX))) {
        newX -= getRidOf;
    }
    System.out.println (newX);
}

}
