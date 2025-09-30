public class Clone148 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:22649348
*  Stack Overflow answer #:22649530
*  And Stack Overflow answer#:22649632
*/
public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    String inString;
    int decimal;
    System.out.println ("Enter a binary number: ");
    inString = input.nextLine ();
    while (inString != "-1") {
        int i;
        int binaryLength;
        binaryLength = inString.length ();
        for (i = 0, decimal = 0; i < binaryLength; i ++) {
            decimal = decimal * 2 + (Character.getNumericValue (inString.charAt (i)) - 0);
            System.out.print (decimal);
        }
        System.out.println ("Enter a binary number: ");
        inString = input.nextLine ();
    }
    System.out.println ("All set !");
}

public static void main (String [] args) {
    final Scanner input = new Scanner (System.in);
    String inString;
    while (true) {
        System.out.println ("Enter a binary number: ");
        inString = input.nextLine ();
        if (inString.equals ("-1")) break;
        System.out.println (Integer.parseInt (inString, 2));
    }
    System.out.println ("All set !");
}

}
