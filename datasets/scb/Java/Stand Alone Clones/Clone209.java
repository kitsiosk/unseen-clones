public class Clone209 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51070885
*  Stack Overflow answer #:51071114
*  And Stack Overflow answer#:51070993
*/
public static int singleNumber (int [] nums) {
    int temp = 0;
    int answer = 0;
    for (int i = 0;
    i < nums.length; i ++) {
        boolean flag = true;
        temp = nums [i];
        for (int j = 0;
        j < nums.length; j ++) {
            if (temp == nums [j]) {
                if (i != j) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true) {
            answer = temp;
        }
    }
    return answer;
}

public static int singleNumber (int [] nums) {
    Set < Integer > unique = new HashSet < > ();
    for (int num : nums) {
        if (! unique.add (num)) {
            unique.remove (num);
        }
    }
    return unique.iterator ().next ();
}

}
