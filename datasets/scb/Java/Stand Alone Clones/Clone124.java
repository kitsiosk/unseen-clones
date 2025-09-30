public class Clone124 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:886955
*  Stack Overflow answer #:886979
*  And Stack Overflow answer#:23786300
*/
public static void main (String [] args) {
    outerloop : for (int i = 0;
    i < 5; i ++) {
        for (int j = 0;
        j < 5; j ++) {
            if (i * j > 6) {
                System.out.println ("Breaking");
                break outerloop;
            }
            System.out.println (i + " " + j);
        }
    }
    System.out.println ("Done");
}

public static void main (String [] args) {
    for (int i = 0;
    i < 9; i ++) {
        for (int j = 0;
        j < 9; j ++) {
            for (int k = 0;
            k < 9; k ++) {
                if (condition1) {
                    System.out.println ("Breaking from Loop K and J");
                    k = 9;
                    j = 9;
                }
                if (condition2) {
                    System.out.println ("Breaking from Loop K, J and I");
                    k = 9;
                    j = 9;
                    i = 9;
                }
            }
        }
    }
    System.out.println ("End of I , J , K");
}

}
