public class Clone922 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19455058
*  Stack Overflow answer #:25190025
*  And Stack Overflow answer#:25826906
*/
int solution (int A [], int N) {
    int i, leftSum, rightSum, last_minimum, current_min;
    leftSum = A [0];
    rightSum = 0;
    i = 1;
    while (i < N) {
        rightSum += A [i];
        i ++;
    }
    last_minimum = abs (leftSum - rightSum);
    if (last_minimum == 0) return last_minimum;
    i = 2;
    while (i < N) {
        leftSum += A [i - 1];
        rightSum -= A [i - 1];
        current_min = abs (leftSum - rightSum);
        if (current_min == 0) return current_min;
        if (last_minimum > current_min) last_minimum = current_min;
        i ++;
    }
    return last_minimum;
}

public int solution (int [] A) {
    if (A.length == 2) return Math.abs (A [0] - A [1]);
    int [] s1 = new int [A.length - 1];
    s1 [0] = A [0];
    for (int i = 1;
    i < A.length - 1; i ++) {
        s1 [i] = s1 [i - 1] + A [i];
    }
    int [] s2 = new int [A.length - 1];
    s2 [A.length - 2] = A [A.length - 1];
    for (int i = A.length - 3;
    i >= 0; i --) {
        s2 [i] = s2 [i + 1] + A [i + 1];
    }
    int finalSum = Integer.MAX_VALUE;
    for (int j = 0;
    j < s1.length; j ++) {
        int sum = Math.abs (s1 [j] - s2 [j]);
        if (sum < finalSum) finalSum = sum;
    }
    return finalSum;
}

}
