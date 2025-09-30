public class Clone500 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6565862
*  Stack Overflow answer #:40530762
*  And Stack Overflow answer#:38419180
*/
public static void main (String [] args) {
    Scanner s = new Scanner (System.in);
    int n = Integer.parseInt (s.nextLine ());
    int [] [] a = new int [n] [n];
    for (int i = 0;
    i < n; i ++) {
        String str = s.nextLine ();
        String [] tempArray = str.split (" ");
        for (int j = 0;
        j < n; j ++) {
            a [i] [j] = Integer.parseInt (tempArray [j]);
        }
    }
    int x = 0;
    int y = 0;
    int sum = 0;
    for (int i = 0;
    i < n; i ++) {
        x += a [i] [i];
    }
    for (int p = 0;
    p < n; p ++) {
        int k = a.length - p - 1;
        y += a [p] [a.length - p - 1];
        k += - 1;
    }
    sum = x - y;
    System.out.println (Math.abs (sum));
}

public static void main (String [] args) {
    Scanner in = new Scanner (System.in);
    int n = in.nextInt ();
    int a [] [] = new int [n] [n];
    for (int a_i = 0;
    a_i < n; a_i ++) {
        for (int a_j = 0;
        a_j < n; a_j ++) {
            a [a_i] [a_j] = in.nextInt ();
        }
    }
    int l_sum = 0;
    for (int i = 0;
    i < n; i ++) {
        l_sum += a [i] [i];
    }
    int r_sum = 0;
    for (int j = 0;
    j < n; j ++) {
        r_sum += a [j] [n - 1 - j];
    }
    int sum = l_sum + r_sum;
    System.out.println (sum);
}

}
