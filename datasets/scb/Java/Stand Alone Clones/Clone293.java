public class Clone293 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35531747
*  Stack Overflow answer #:50056609
*  And Stack Overflow answer#:46290176
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
    String binary = Integer.toString (N, 2);
    int largestGap = 0;
    for (int i = 1, gap = 0;
    i < binary.length (); i ++) {
        while (i < binary.length () && binary.charAt (i) == '0') {
            i ++;
            gap ++;
        }
        if (gap > largestGap && i < binary.length ()) {
            largestGap = gap;
        }
        gap = 0;
    }
    return largestGap;
}

}
