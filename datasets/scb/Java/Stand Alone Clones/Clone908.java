public class Clone908 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2598129
*  Stack Overflow answer #:2598209
*  And Stack Overflow answer#:10473835
*/
public static void removeDuplicates (char [] str) {
    if (str == null) return;
    int len = str.length;
    if (len < 2) return;
    int tail = 1;
    for (int i = 1;
    i < len; ++ i) {
        int j;
        for (j = 0; j < tail; ++ j) {
            if (str [i] == str [j]) break;
        }
        if (j == tail) {
            str [tail] = str [i];
            ++ tail;
        }
    }
    str [tail] = 0;
}

public static void removeDuplicates (char [] str) {
    int map = 0;
    for (int i = 0;
    i < str.length; i ++) {
        if ((map & (1 << (str [i] - 'a'))) > 0) str [i] = 0;
        else map |= 1 << (str [i] - 'a');
    }
}

}
