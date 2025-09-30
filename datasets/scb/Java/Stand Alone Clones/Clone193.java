public class Clone193 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:54578942
*  Stack Overflow answer #:54579435
*  And Stack Overflow answer#:54579355
*/
public static String compressBad (String str) {
    if (str.length () == 1) return str + "1";
    int countConsecutive = 0;
    String compressedString = "";
    for (int i = 0;
    i < str.length (); i ++) {
        if (i > 0) {
            countConsecutive ++;
            if (str.charAt (i) != str.charAt (i - 1)) {
                compressedString += "" + str.charAt (i - 1) + countConsecutive;
                countConsecutive = 0;
            }
            if (i == str.length () - 1) {
                countConsecutive ++;
                compressedString += "" + str.charAt (i) + countConsecutive;
            }
        }
    }
    return compressedString;
}

public static String compressBad (String str) {
    String compressedString = "";
    if (str != null && str.length () > 0) {
        int countConsecutive = 1;
        char prevChar = str.charAt (0);
        for (int i = 1;
        i < str.length (); i ++) {
            if (str.charAt (i) != prevChar) {
                compressedString += String.valueOf (prevChar) + countConsecutive;
                prevChar = str.charAt (i);
                countConsecutive = 1;
                continue;
            }
            countConsecutive ++;
        }
        compressedString += String.valueOf (prevChar) + countConsecutive;
    }
    return compressedString;
}

}
