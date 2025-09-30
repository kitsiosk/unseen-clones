public class Clone898 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3766020
*  Stack Overflow answer #:29154417
*  And Stack Overflow answer#:14314921
*/
public int sqrt (int x) {
    if (x == 0 || x == 1) {
        return x;
    }
    int start = 1, end = x / 2;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (mid == x / mid) {
            return mid;
        }
        if (mid < x / mid) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return start - 1;
}

public static double sqrt (int n) {
    double low = 0;
    double high = n;
    double mid = (high - low) / 2;
    while (Math.abs ((mid * mid) - n) > 0.000000000001) {
        if ((mid * mid) > n) {
            high = mid;
            mid = (high - low) / 2;
        } else {
            low = mid;
            mid = mid + ((high - low) / 2);
        }
    }
    return mid;
}

}
