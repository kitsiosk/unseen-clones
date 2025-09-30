public class Clone43 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51097162
*  Stack Overflow answer #:51097253
*  And Stack Overflow answer#:51097196
*/
public int sum13 (int [] nums) {
    int sum = 0;
    boolean skipNext = false;
    for (int num : nums) {
        if (num == 13) {
            skipNext = true;
        } else {
            if (! skipNext) {
                sum += num;
            }
            skipNext = false;
        }
    }
    return sum;
}

public int sum13 (int [] nums) {
    int sum = 0;
    for (int i = 0;
    i < nums.length; i ++) {
        if (nums [i] != 13) {
            sum += nums [i];
        } else {
            i ++;
        }
    }
    return sum;
}

}
