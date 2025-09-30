public class Clone324 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:47193361
*  Stack Overflow answer #:47193643
*  And Stack Overflow answer#:47193530
*/
public static void main (String [] args) {
    Scanner keyboard = new Scanner (System.in);
    System.out.print ("Number of days in the period: ");
    numberofDays = keyboard.nextInt ();
    System.out.print ("Share points on the first day: ");
    sharePoints = keyboard.nextInt ();
    while (numberofDays < 10 || numberofDays > 20) {
        System.out.println ("The number of days doesn’t meet the required criteria, enter it again");
        System.out.print ("Number of days in the period: ");
        numberofDays = keyboard.nextInt ();
    }
    DisplayStock ();
}

public static void main (String [] args) {
    int numberofDays;
    int sharePoints;
    Scanner keyboard = new Scanner (System.in);
    System.out.print ("Number of days in the period: ");
    numberofDays = keyboard.nextInt ();
    System.out.print ("Share points on the first day: ");
    sharePoints = keyboard.nextInt ();
    numberofDays = validator (numberofDays, keyboard);
    outPutTablePrinter (numberofDays, sharePoints);
}

}
