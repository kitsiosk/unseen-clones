public class Clone295 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35531747
*  Stack Overflow answer #:50056609
*  And Stack Overflow answer#:41500484
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

private static int solution (int N) {
    int gap = 0;
    String binaryStr = Integer.toBinaryString (N);
    String [] zeroArrays = binaryStr.split ("1");
    System.out.println (Arrays.toString (zeroArrays));
    for (String zeroArray : zeroArrays) {
        gap = zeroArray.length () > gap ? zeroArray.length () : gap;
    }
    return gap;
}

}
