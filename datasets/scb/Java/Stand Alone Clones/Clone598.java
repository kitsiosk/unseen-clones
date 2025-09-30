public class Clone598 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20529935
*  Stack Overflow answer #:20530057
*  And Stack Overflow answer#:20530148
*/
public boolean haveThree (int [] nums) {
    int count = 0;
    for (int i = 0;
    i < nums.length - 1; i ++) {
        if (nums [i] == 3 && nums [i + 1] == 3) {
            return false;
        }
        if ((nums [i] == 3)) {
            count ++;
        }
    }
    if (nums [nums.length - 1] == 3) {
        count ++;
    }
    return count == 3;
}

public boolean haveThree (int [] nums) {
    int count = 0;
    boolean flag = false;
    for (int i = 0;
    i < nums.length; i ++) {
        if (nums [i] == 3) {
            if (flag) {
                return false;
            } else {
                count ++;
                flag = true;
            }
        } else {
            flag = false;
        }
    }
    return count == 3;
}

}
