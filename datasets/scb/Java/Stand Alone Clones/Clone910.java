public class Clone910 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4446326
*  Stack Overflow answer #:4446647
*  And Stack Overflow answer#:4446448
*/
public static void main (String [] args) {
    char [] num1 = "127".toCharArray ();
    char [] num2 = "32".toCharArray ();
    int [] intermediate = new int [num1.length];
    for (int i = 0;
    i < num1.length; i ++) {
        for (int j = 0;
        j < num2.length; j ++) {
            int d1 = num1 [num1.length - i - 1] - '0';
            int d2 = num2 [num2.length - j - 1] - '0';
            intermediate [i] += d1 * d2 * (int) Math.pow (10, j);
            System.out.printf ("  %d X %d = %d\n", d1, d2, intermediate [i]);
        }
        intermediate [i] *= (int) Math.pow (10, i);
        System.out.println (" intermediate : " + intermediate [i]);
    }
    int sum = 0;
    for (int i : intermediate) {
        sum += i;
    }
    System.out.println ("Sum is = " + sum);
}

public static void main (String [] args) {
    String number1 = "108";
    String number2 = "84";
    char [] n1 = number1.toCharArray ();
    char [] n2 = number2.toCharArray ();
    int result = 0;
    for (int i = 0;
    i < n1.length; i ++) {
        for (int j = 0;
        j < n2.length; j ++) {
            result += (n1 [i] - '0') * (n2 [j] - '0') * (int) Math.pow (10, n1.length + n2.length - (i + j + 2));
        }
    }
    System.out.println (result);
}

}
