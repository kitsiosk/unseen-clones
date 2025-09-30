public class Clone906 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2598129
*  Stack Overflow answer #:26372240
*  And Stack Overflow answer#:10473835
*/
private static void removeDuplicates (char [] str) {
    if (str == null || str.length < 2) {
        return;
    }
    int tail = 0;
    for (int i = 0;
    i < str.length; i ++) {
        boolean found = false;
        for (int j = 0;
        j < i; j ++) {
            if (str [j] == str [i]) {
                found = true;
                break;
            }
        }
        if (found) {
            continue;
        }
        str [tail] = str [i];
        tail ++;
    }
    str [tail] = '\0';
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
