public class Clone695 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:50067169
*  Stack Overflow answer #:50067539
*  And Stack Overflow answer#:50171292
*/
private static void sort (int [] arr) {
    int index = 0;
    int n = arr.length;
    while (index < n) {
        if (index == 0) index ++;
        if (compare (arr [index], arr [index - 1])) index ++;
        else {
            int temp = arr [index];
            arr [index] = arr [index - 1];
            arr [index - 1] = temp;
            index --;
        }
    }
}

static int [] sort (int arr []) {
    for (int i = 0;
    i < arr.length; i ++) {
        for (int j = i;
        j < arr.length; j ++) {
            if (arr [j] < arr [i]) {
                int temp = arr [i];
                arr [i] = arr [j];
                arr [j] = temp;
            }
        }
    }
    return arr;
}

}
