public class Clone294 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35531747
*  Stack Overflow answer #:50056609
*  And Stack Overflow answer#:49321523
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

public static int solution (Integer number) {
    String binary = Integer.toBinaryString (number);
    String [] gaps = binary.split ("1");
    String biggestGap = "";
    for (int i = 0;
    i < (binary.endsWith ("1") ? gaps.length : gaps.length - 1); i ++) {
        if (gaps [i].contains ("0") && gaps [i].length () > biggestGap.length ()) biggestGap = gaps [i];
    }
    return biggestGap.length ();
}

}
