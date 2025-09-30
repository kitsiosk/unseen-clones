public class Clone714 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:43187360
*  Stack Overflow answer #:43188007
*  And Stack Overflow answer#:43187625
*/
public static void main (String [] args) {
    int n = 7;
    int mid = n / 2;
    for (int i = 0;
    i < n; i ++) {
        for (int j = 0;
        j < Math.abs (mid - i) + 1; j ++) {
            System.out.print ("*");
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
