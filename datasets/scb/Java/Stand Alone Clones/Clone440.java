public class Clone440 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3911966
*  Stack Overflow answer #:24735013
*  And Stack Overflow answer#:3911987
*/
public static void main (String [] args) {
    int n = 0;
    Scanner s = new Scanner (System.in);
    System.out.print ("Enter an integer number: ");
    n = s.nextInt ();
    if (n <= 0) System.out.print ("Enter numbers greater than 0");
    else {
        NumberToWord a = new NumberToWord ();
        System.out.print ("After conversion number in words is :");
        a.pw ((n / 1000000000), " Hundred");
        a.pw ((n / 10000000) % 100, " crore");
        a.pw (((n / 100000) % 100), " lakh");
        a.pw (((n / 1000) % 100), " thousand");
        a.pw (((n / 100) % 10), " hundred");
        a.pw ((n % 100), " ");
    }
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
