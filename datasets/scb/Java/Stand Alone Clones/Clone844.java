public class Clone844 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31258430
*  Stack Overflow answer #:31259151
*  And Stack Overflow answer#:31258715
*/
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

public static String sequenceNums (int [] nums) {
    StringBuilder sb = new StringBuilder ();
    if (nums.length == 0) return sb.toString ();
    int begin = nums [0], end = nums [0];
    for (int cur : nums) if (cur - end <= 1) end = cur;
    else {
        appendRange (sb, begin, end);
        begin = end = cur;
    }
    appendRange (sb, begin, end);
    return sb.substring (1);
}

}
