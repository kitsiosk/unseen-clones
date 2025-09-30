public class Clone842 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31258430
*  Stack Overflow answer #:31258702
*  And Stack Overflow answer#:31259151
*/
public static String sequenceNums (int [] nums) {
    StringBuilder sb = new StringBuilder ();
    int rangeStart = nums [0];
    int previous = nums [0];
    int current;
    int expected = previous + 1;
    int size = nums.length;
    for (int i = 1;
    i < size; i ++) {
        current = nums [i];
        expected = previous + 1;
        if (current != expected) {
            addRange (sb, rangeStart, previous);
            rangeStart = current;
        }
        previous = current;
    }
    addRange (sb, rangeStart, nums [size - 1]);
    return sb.toString ();
}

public static String sequenceNums (int [] nums) {
    StringBuilder sb = new StringBuilder ();
    int rangeStart = nums [0];
    int previous = nums [0];
    int current;
    int expected = previous + 1;
    for (int i = 1;
    i < nums.length; i ++) {
        current = nums [i];
        expected = previous + 1;
        if (current != expected || i == (nums.length - 1)) {
            if (current == rangeStart) {
                sb.append (previous + ",");
            } else {
                if (rangeStart != previous) {
                    if (i == nums.length - 1) sb.append (rangeStart + "-" + current);
                    else sb.append (rangeStart + "-" + previous + ",");
                } else {
                    if (i == nums.length - 1) sb.append (rangeStart + "," + current);
                    else sb.append (rangeStart + ",");
                }
            }
            rangeStart = current;
        }
        previous = current;
    }
    if (sb.charAt (sb.length () - 1) == ',') {
        sb.deleteCharAt (sb.length () - 1);
    }
    return sb.toString ();
}

}
