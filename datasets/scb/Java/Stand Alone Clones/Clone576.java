public class Clone576 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13954848
*  Stack Overflow answer #:13955194
*  And Stack Overflow answer#:13954911
*/
public static void stars (int size) {
    for (int i = 0;
    i < size * size; i ++) {
        int y = i / size, x = i % size;
        System.out.print ((x >= y && x < size - y) || (x >= size - y - 1 && x <= y) ? '*' : ' ');
        if (x == size - 1) System.out.println ();
    }
}

static void stars () {
    final int MAX_WIDTH = 7;
    for (int i = 0;
    i < 7; ++ i) {
        int width;
        if (i < 3) width = MAX_WIDTH - i * 2;
        else if (i > 3) width = (i - 3) * 2 + 1;
        else width = 1;
        for (int j = 0;
        j < (MAX_WIDTH - width) / 2; ++ j) {
            System.out.print (" ");
        }
        for (int j = 0;
        j < width; ++ j) {
            System.out.print ("*");
        }
        for (int j = 0;
        j < (MAX_WIDTH - width) / 2; ++ j) {
            System.out.print (" ");
        }
        System.out.println ();
    }
}

}
