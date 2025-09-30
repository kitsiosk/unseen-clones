public class Clone276 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16088994
*  Stack Overflow answer #:50023147
*  And Stack Overflow answer#:16089042
*/
public static int [] bubbleSort (int [] a) {
    int n = a.length;
    int j = 0;
    boolean swap = true;
    while (swap) {
        swap = false;
        for (int j = 1;
        j < n; j ++) {
            if (a [j - 1] > a [j]) {
                j = a [j - 1];
                a [j - 1] = a [j];
                a [j] = j;
                swap = true;
            }
        }
        n = n - 1;
    }
    return a;
}

public static void bubbleSort (int [] numArray) {
    int n = numArray.length;
    int temp = 0;
    for (int i = 0;
    i < n; i ++) {
        for (int j = 1;
        j < (n - i); j ++) {
            if (numArray [j - 1] > numArray [j]) {
                temp = numArray [j - 1];
                numArray [j - 1] = numArray [j];
                numArray [j] = temp;
            }
        }
    }
}

}
