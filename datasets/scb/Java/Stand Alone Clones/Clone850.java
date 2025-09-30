public class Clone850 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33396604
*  Stack Overflow answer #:33397152
*  And Stack Overflow answer#:33396815
*/
private static int countZeros (int [] f) {
    for (int i = f.length - 1;
    i >= 0; i --) {
        if (f [i] != 0 && i > 0 && f [i - 1] == 0) {
            i --;
            int count = 0;
            while (i >= 0 && f [i] == 0) {
                i --;
                count ++;
            }
            if (i == 0) return null;
            else return count;
        }
    }
    return null;
}

private static int countZeros (int [] f) {
    int start = 0, end = 0, cnt = 0;
    for (int i = 1;
    i < f.length; i ++) {
        if (f [i - 1] != 0 && f [i] == 0) {
            start = i;
        } else if (f [i - 1] == 0 && f [i] != 0 && start > 0) {
            end = i;
            cnt += end - start;
        }
    }
    return cnt;
}

}
