public class Clone436 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3911966
*  Stack Overflow answer #:3911982
*  And Stack Overflow answer#:3911987
*/
public static void main (String...args) {
    processor = new DefaultProcessor ();
    long [] values = new long [] {0, 4, 10, 12, 100, 108, 299, 1000, 1003, 2040, 45213, 100000, 100005, 100010, 202020, 202022, 999999, 1000000, 1000001, 10000000, 10000007, 99999999, Long.MAX_VALUE, Long.MIN_VALUE};
    String [] strValues = new String [] {"0001.2", "3.141592"};
    for (long val : values) {
        System.out.println (val + " = " + processor.getName (val));
    }
    for (String strVal : strValues) {
        System.out.println (strVal + " = " + processor.getName (strVal));
    }
    StringBuilder bigNumber = new StringBuilder ();
    for (int d = 0;
    d < 66; d ++) {
        bigNumber.append ((char) ((Math.random () * 10) + '0'));
    }
    bigNumber.append (".");
    for (int d = 0;
    d < 26; d ++) {
        bigNumber.append ((char) ((Math.random () * 10) + '0'));
    }
    System.out.println (bigNumber.toString () + " = " + processor.getName (bigNumber.toString ()));
}

public static void main (String [] args) {
    System.out.println ("*** " + FrenchNumberToWords.convert (0));
    System.out.println ("*** " + FrenchNumberToWords.convert (9));
    System.out.println ("*** " + FrenchNumberToWords.convert (19));
    System.out.println ("*** " + FrenchNumberToWords.convert (21));
    System.out.println ("*** " + FrenchNumberToWords.convert (28));
    System.out.println ("*** " + FrenchNumberToWords.convert (71));
    System.out.println ("*** " + FrenchNumberToWords.convert (72));
    System.out.println ("*** " + FrenchNumberToWords.convert (80));
    System.out.println ("*** " + FrenchNumberToWords.convert (81));
    System.out.println ("*** " + FrenchNumberToWords.convert (89));
    System.out.println ("*** " + FrenchNumberToWords.convert (90));
    System.out.println ("*** " + FrenchNumberToWords.convert (91));
    System.out.println ("*** " + FrenchNumberToWords.convert (97));
    System.out.println ("*** " + FrenchNumberToWords.convert (100));
    System.out.println ("*** " + FrenchNumberToWords.convert (101));
    System.out.println ("*** " + FrenchNumberToWords.convert (110));
    System.out.println ("*** " + FrenchNumberToWords.convert (120));
    System.out.println ("*** " + FrenchNumberToWords.convert (200));
    System.out.println ("*** " + FrenchNumberToWords.convert (201));
    System.out.println ("*** " + FrenchNumberToWords.convert (232));
    System.out.println ("*** " + FrenchNumberToWords.convert (999));
    System.out.println ("*** " + FrenchNumberToWords.convert (1000));
    System.out.println ("*** " + FrenchNumberToWords.convert (1001));
    System.out.println ("*** " + FrenchNumberToWords.convert (10000));
    System.out.println ("*** " + FrenchNumberToWords.convert (10001));
    System.out.println ("*** " + FrenchNumberToWords.convert (100000));
    System.out.println ("*** " + FrenchNumberToWords.convert (2000000));
    System.out.println ("*** " + FrenchNumberToWords.convert (3000000000L));
    System.out.println ("*** " + FrenchNumberToWords.convert (2147483647));
}

}
