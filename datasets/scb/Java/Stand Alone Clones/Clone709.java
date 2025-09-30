public class Clone709 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:41323554
*  Stack Overflow answer #:41326917
*  And Stack Overflow answer#:41331425
*/
public static int [] sort (int [] numbers, int digit) {
    if (numbers.length == 0 || digit <= 0) return numbers;
    int [] [] space = new int [10] [0];
    int [] len = new int [10];
    int i, j;
    for (j = 0; j < numbers.length; j ++) {
        i = (numbers [j] / digit) % 10;
        len [i] ++;
        space [i] = putInBucket (space [i], numbers [j]);
    }
    for (i = 0; i < 10; i ++) {
        space [i] = sort (space [i], digit / 10);
    }
    int k = 0;
    for (i = 0; i < 10; i ++) {
        for (j = 0; j < len [i]; j ++) {
            numbers [k] = space [i] [j];
            k ++;
        }
    }
    return numbers;
}

public static int [] sort (int [] numbers, int digit) {
    if (numbers.length == 0 || digit <= 0) return numbers;
    int [] [] space = new int [10] [1];
    int [] len = new int [10];
    int i, j = 0;
    for (j = 0; j < numbers.length; j ++) {
        i = (numbers [j] / digit) % 10;
        len [i] ++;
        space [i] = putInBucket (space [i], numbers [j]);
    }
    for (i = 0; i < 10; i ++) {
        int [] bucket = new int [len [i]];
        for (int k = 0;
        k < len [i]; k ++) bucket [k] = space [i] [k];
        space [i] = sort (bucket, digit / 10);
    }
    int k = 0;
    for (i = 0; i < 10; i ++) {
        for (j = 0; j < len [i]; j ++) {
            numbers [k] = space [i] [j];
            k ++;
        }
    }
    return numbers;
}

}
