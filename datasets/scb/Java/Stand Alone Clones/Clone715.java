public class Clone715 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:26737852
*  Stack Overflow answer #:26738642
*  And Stack Overflow answer#:26738104
*/
private static void decimalToHex (int decimal) {
    int maxDigit = 1;
    while (maxDigit * 16 <= decimal && maxDigit > 0) {
        maxDigit *= 16;
    }
    if (maxDigit <= 0) {
        throw new IllegalArgumentException ("Can not convert " + decimal);
    }
    for (int digit = maxDigit;
    digit > 0; digit /= 16) {
        printHex ((decimal / digit) % 16);
    }
}

private static void decimalToHex (int decimal) {
    if (decimal >= 256) {
        returnHex (decimal / 256);
        decimal %= 256;
    } else {
        System.out.print ("0");
    }
    if (decimal >= 16) {
        returnHex (decimal / 16);
        decimal %= 16;
    } else {
        System.out.print ("0");
    }
    returnHex (decimal);
    decimal /= 16;
}

}
