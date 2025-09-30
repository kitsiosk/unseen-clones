public class Clone865 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:47391549
*  Stack Overflow answer #:47392416
*  And Stack Overflow answer#:47392215
*/
public static int findArray (int [] array, int [] subArray) {
    int count = 0;
    for (int i = 0;
    i < array.length; i ++) {
        for (int j = 0;
        j < subArray.length; j ++) {
            if (array [i] == subArray [j]) {
                if (array.length > (i + 1) && subArray.length > (j + 1)) {
                    if (array [i + 1] == subArray [j + 1]) {
                        count += 1;
                        continue;
                    }
                } else if (subArray.length == j + 1) {
                    count += 1;
                    continue;
                }
            }
        }
    }
    if (count < subArray.length) {
        return - 1;
    }
    return count;
}

public static int findArray (int [] array, int [] subArray) {
    int index = - 1;
    arrayLoop : for (int i = 0;
    i < array.length; i ++) {
        if (array [i] == subArray [0]) {
            for (int j = 1;
            j < subArray.length; j ++) {
                if (i + j > array.length - 1 || array [i + j] != subArray [j]) continue arrayLoop;
            }
            index = i;
        }
    }
    return index;
}

}
