public class Clone717 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1837698
*  Stack Overflow answer #:39564331
*  And Stack Overflow answer#:1837741
*/
public int [] zeroFront (int [] nums) {
    Stack stack = new Stack ();
    int [] nums2 = new int [nums.length];
    for (int i = 0;
    i < nums.length; i ++) {
        if (nums [i] != 0) {
            stack.push (nums [i]);
        }
    }
    for (int i = 0;
    i < nums.length; i ++) {
        if (nums [i] == 0) {
            stack.push (nums [i]);
        }
    }
    for (int i = 0;
    i < nums.length; i ++) {
        nums2 [i] = (Integer) stack.pop ();
    }
    return nums2;
}

public int [] zeroFront (int [] nums) {
    if (nums == null) {
        return null;
    }
    int [] result = new int [nums.length];
    int zeroesPos = 0;
    int othersPos = result.length - 1;
    for (int i = 0;
    i < nums.length; ++ i) {
        if (nums [i] == 0) {
            result [zeroesPos] = 0;
            ++ zeroesPos;
        } else {
            result [othersPos] = nums [i];
            -- othersPos;
        }
    }
    return result;
}

}
