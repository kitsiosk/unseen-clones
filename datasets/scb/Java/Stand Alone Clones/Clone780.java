public class Clone780 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12468251
*  Stack Overflow answer #:12468361
*  And Stack Overflow answer#:12468343
*/
public static int binarySearch (int anArray [], int first, int last, int value) {
    int index;
    int done = 0;
    while (done == 0) {
        if (first > last) {
            index = - 1;
            done = 1;
        } else {
            int mid = (first + last) / 2;
            if (value == anArray [mid]) {
                index = mid;
                done = 1;
            } else if (value < anArray [mid]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
    }
    return index;
}

public static int binarySearch (int anArray [], int first, int last, int value) {
    do {
        if (first > last) {
            return - 1;
        } else {
            int mid = (first + last) / 2;
            if (value == anArray [mid]) {
                return mid;
            } else if (value < anArray [mid]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
    } while (true);
}

}
