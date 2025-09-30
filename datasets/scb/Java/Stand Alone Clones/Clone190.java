public class Clone190 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16075763
*  Stack Overflow answer #:16075842
*  And Stack Overflow answer#:16075871
*/
public static void printSquare (int min, int max) {
    int x = max - min + 1;
    for (int i = min;
    i <= max; i ++) {
        int counter = i;
        for (int j = 0;
        j < x; j ++) {
            System.out.print (counter);
            counter = counter >= max ? min : counter + 1;
        }
        System.out.println ();
    }
}

public void printSquare (int min, int max) {
    for (int i = min;
    i <= max; i ++) {
        for (int j = i;
        j <= max; j ++) {
            System.out.print (j);
        }
        for (int k = min;
        k < i; k ++) {
            System.out.print (k);
        }
        System.out.println ();
    }
}

}
