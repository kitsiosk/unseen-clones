public class Clone210 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51070885
*  Stack Overflow answer #:51071114
*  And Stack Overflow answer#:51071665
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
    int answer = 0;
    ArrayList al = new ArrayList ();
    for (int i = 0;
    i < nums.length; i ++) {
        al.add (nums [i]);
    }
    for (int i = 0;
    i < nums.length; i ++) {
        int test = nums [i];
        if (al.indexOf (test) == al.lastIndexOf (test)) {
            answer = nums [i];
        }
    }
    return answer;
}

}
