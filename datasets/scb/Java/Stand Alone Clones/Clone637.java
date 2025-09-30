public class Clone637 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:295579
*  Stack Overflow answer #:295678
*  And Stack Overflow answer#:333510
*/
int isPerfectSquare (int n) {
    int h = n & 0xF;
    if (h > 9) return 0;
    if (h != 2 && h != 3 && h != 5 && h != 6 && h != 7 && h != 8) {
        int t = (int) floor (sqrt ((double) n) + 0.5);
        return t * t == n;
    }
    return 0;
}

boolean isPerfectSquare (long number) {
    if (number < 0) return false;
    if (number < 2) return true;
    for (int i = 0;
    ; i ++) {
        long square = squareTable [i];
        if (square > number) return false;
        while (number % square == 0) {
            number /= square;
        }
        if (number == 1) return true;
    }
}

}
