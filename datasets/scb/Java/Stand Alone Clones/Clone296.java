public class Clone296 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35531747
*  Stack Overflow answer #:50056609
*  And Stack Overflow answer#:53008866
*/
int solution (int N) {
    int tempGap = 0, gap = 0;
    String binaryString = Integer.toBinaryString (N);
    int i = 0;
    while (i < binaryString.length ()) {
        if (binaryString.charAt (i) == '1') {
            ++ i;
            tempGap = 0;
            while (i < binaryString.length () && binaryString.charAt (i) != '1') {
                ++ i;
                tempGap ++;
            }
            if (i >= binaryString.length ()) {
                tempGap = 0;
            }
        } else {
            ++ i;
        }
        if (tempGap > gap) {
            gap = tempGap;
        }
    }
    return gap;
}

public int solution (int N) {
    int result = 0;
    while (N > 0) {
        if ((N & 1) == 1) {
            int temp = 0;
            while ((N>>= 1) > 0 && ((N & 1) != 1)) {
                temp ++;
            }
            result = Math.max (result, temp);
        } else {
            N>>= 1;
        }
    }
    return result;
}

}
