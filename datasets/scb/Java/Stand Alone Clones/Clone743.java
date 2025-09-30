public class Clone743 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:50361758
*  Stack Overflow answer #:50361797
*  And Stack Overflow answer#:50361840
*/
public static long factorial (int n) {
    try {
        System.out.println ("factorial(" + n + ")");
        if (n == 1) {
            System.out.println ("return 1");
            return 1;
        }
        return n * factorial (n - 1);
    } finally {
        System.out.println ("return " + n);
    }
}

private static long factorial (int n, int depth) {
    String spaces = repeat (' ', depth);
    System.out.print (spaces);
    System.out.println ("factorial(" + n + ")");
    if (n <= 1) {
        System.out.println (spaces + " return 1");
        return 1;
    }
    long fac = factorial (n - 1, depth + 1);
    System.out.print (spaces);
    System.out.printf ("return %d * %d = %d%n", n, fac, n * fac);
    return n * fac;
}

}
