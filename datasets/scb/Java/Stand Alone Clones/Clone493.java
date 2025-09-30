public class Clone493 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:54110161
*  Stack Overflow answer #:54110244
*  And Stack Overflow answer#:54110952
*/
public static void main (String...args) {
    int [] [] bino = new int [15] [];
    for (int i = 0;
    i < bino.length; i ++) {
        bino [i] = new int [i + 1];
        for (int j = 0;
        j < i + 1; j ++) {
            bino [i] [j] = nOverk (i, j);
        }
    }
}

public static void main (String [] args) {
    int n = 15;
    int [] [] pascal = new int [n + 1] [];
    pascal [1] = new int [1 + 2];
    pascal [1] [1] = 1;
    for (int i = 2;
    i <= n; i ++) {
        pascal [i] = new int [i + 2];
        for (int j = 1;
        j < pascal [i].length - 1; j ++) pascal [i] [j] = pascal [i - 1] [j - 1] + pascal [i - 1] [j];
    }
    for (int i = 1;
    i <= n; i ++) {
        for (int j = 1;
        j < pascal [i].length - 1; j ++) {
            System.out.print (pascal [i] [j] + " ");
        }
        System.out.println ();
    }
}

}
