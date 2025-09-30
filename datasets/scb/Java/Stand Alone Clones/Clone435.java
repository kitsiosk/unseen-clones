public class Clone435 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3911966
*  Stack Overflow answer #:3911982
*  And Stack Overflow answer#:24735013
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

}
