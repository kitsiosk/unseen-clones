public class Clone843 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31258430
*  Stack Overflow answer #:31258702
*  And Stack Overflow answer#:31258715
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
