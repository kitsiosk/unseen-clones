public class Clone858 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19012677
*  Stack Overflow answer #:43847052
*  And Stack Overflow answer#:19012918
*/
private int binarySearch (int [] a, int x, int low, int high) {
    if (low > high) return - 1;
    int mid = (low + high) / 2;
    if (a [mid] == x) return mid;
    else if (a [mid] < x) return binarySearch (a, x, mid + 1, high);
    else return binarySearch (a, x, low, mid - 1);
}

public static int binarySearch (int intToSearch, int [] sortedArray) {
    int lower = 0;
    int upper = sortedArray.length - 1;
    while (lower <= upper) {
        int mid = lower + (upper - lower) / 2;
        if (intToSearch < sortedArray [mid]) upper = mid - 1;
        else if (intToSearch > sortedArray [mid]) lower = mid + 1;
        else return mid;
    }
    return - 1;
}

}
