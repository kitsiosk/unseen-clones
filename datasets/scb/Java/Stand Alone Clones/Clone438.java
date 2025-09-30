public class Clone438 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3911966
*  Stack Overflow answer #:10931342
*  And Stack Overflow answer#:3911987
*/
public static void main (String [] args) {
    System.out.println ("Enter Number to convert into words");
    Scanner sc = new Scanner (System.in);
    long num = sc.nextInt ();
    int rem = 0;
    int i = 0;
    while (num > 0) {
        if (i == 0) {
            rem = (int) (num % 1000);
            printText (rem);
            num = num / 1000;
            i ++;
        } else if (num > 0) {
            rem = (int) (num % 100);
            if (rem > 0) text = denom.values () [i - 1] + " " + text;
            printText (rem);
            num = num / 100;
            i ++;
        }
    }
    if (i > 0) System.out.println (text);
    else System.out.println ("Zero");
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
