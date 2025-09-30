public class Clone857 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19012677
*  Stack Overflow answer #:19012919
*  And Stack Overflow answer#:19012918
*/
public static int binarySearch (int [] a, int start, int end, int target) {
    int middle = (start + end) / 2;
    if (end < start) {
        return - 1;
    }
    if (target == a [middle]) {
        return middle;
    } else if (target < a [middle]) {
        return binarySearch (a, start, middle - 1, target);
    } else {
        return binarySearch (a, middle + 1, end, target);
    }
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
