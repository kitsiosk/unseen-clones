public class Clone959 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31432614
*  Stack Overflow answer #:31433347
*  And Stack Overflow answer#:31432814
*/
public static void main (String [] args) {
    double rate = 0;
    CurrencyConverter w = new CurrencyConverter ();
    w.print ();
    System.out.print ("Choose the input currency: ");
    Scanner sc = new Scanner (System.in);
    int choice = sc.nextInt ();
    Currency from = Currency.values () [choice];
    System.out.print ("Choose the output currency: ");
    int output = sc.nextInt ();
    Currency to = Currency.values () [output];
    System.out.printf ("Now enter the input in " + from.description + ": ");
    double input = sc.nextDouble ();
    if (from == to) {
        System.out.println ("Troller ._. pabobo");
    }
    rate = to.conversion / from.conversion;
    System.out.print ("The Conversion of " + from.description + " to " + to.description + " = " + rate);
}

public static void main (String [] args) {
    double rate = 0;
    CurrencyConverter w = new CurrencyConverter ();
    w.print ();
    System.out.print ("Choose the input currency: ");
    Scanner sc = new Scanner (System.in);
    int choice = sc.nextInt ();
    if (choice < 1 || choice > 12) {
        System.out.println ("404 not found XD");
        sc.close ();
        return;
    }
    System.out.print ("Choose the output currency: ");
    int output = sc.nextInt ();
    Currency first = Currency.values () [choice - 1];
    Currency second = Currency.values () [output - 1];
    System.out.printf ("Now enter the input in " + first.getFullName () + ": ");
    double input = sc.nextDouble ();
    if (choice == output) System.out.println ("Troller ._. pabobo");
    rate = (input * first.getRate ()) / second.getRate ();
    System.out.print ("The conversion of " + first.toString () + " to " + second.toString () + " = " + rate);
    sc.close ();
}

}
