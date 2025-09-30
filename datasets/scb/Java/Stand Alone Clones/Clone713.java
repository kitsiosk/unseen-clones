public class Clone713 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:43187360
*  Stack Overflow answer #:43187706
*  And Stack Overflow answer#:43187625
*/
public static void main (String [] args) {
    int n = 7;
    for (int i = 0;
    i < 7; i ++) {
        for (int j = 0;
        j < 4; j ++) {
            if (i + j <= n - 4 || j == 0 || i == n - 1) System.out.print ("*");
            else if (i - j >= n - 4) System.out.print ("*");
            else System.out.print (" ");
        }
        System.out.println ();
    }
}

public static void main (String [] args) {
    for (int row = 1;
    row <= 7; row += 2) {
        for (int space = 7;
        space >= row; space -= 2) {
            System.out.print ("*");
        }
        for (int i = 1;
        i <= row; i ++) {
            System.out.print (" ");
        }
        System.out.print ("\n");
    }
    for (int row = 5;
    row >= 1; row -= 2) {
        for (int space = 7;
        space >= row; space -= 2) {
            System.out.print ("*");
        }
        for (int i = 1;
        i <= row; i ++) {
            System.out.print (" ");
        }
        System.out.print ("\n");
    }
}

}
