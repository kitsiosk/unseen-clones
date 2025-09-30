public class Clone722 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:42614070
*  Stack Overflow answer #:42614362
*  And Stack Overflow answer#:42614253
*/
private static int [] removeEven (int [] k, int n) {
    for (int i = 0;
    i < n; i ++) {
        if (k [i] % 2 == 0) {
            for (int j = i + 1;
            j < n; j ++) {
                if (k [j] % 2 != 0) {
                    k [i] = k [i] + k [j];
                    k [j] = k [i] - k [j];
                    k [i] = k [i] - k [j];
                    break;
                }
            }
        }
    }
    return k;
}

private static void removeEven (int [] k, int n) {
    int counter = 0;
    for (int i = 0;
    i < n; i ++) if (k [i] % 2 == 1) k [counter ++] = k [i];
    for (int i = counter;
    i < n; i ++) k [i] = 0;
}

}
