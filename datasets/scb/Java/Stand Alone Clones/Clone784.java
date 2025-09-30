public class Clone784 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51159957
*  Stack Overflow answer #:51160336
*  And Stack Overflow answer#:51160642
*/
public static void main (String [] args) {
    Scanner scan = new Scanner (System.in);
    int numOfItems = 20, maxItems = 0;
    String arrayOfNames [] = new String [numOfItems];
    String Temp = "";
    for (int i = 0;
    i < arrayOfNames.length; i ++) {
        System.out.print ("Enter Item " + (i + 1) + " : ");
        Temp = scan.nextLine ();
        if (Temp.equals (arrayOfNames [0])) {
            maxItems = i;
            break;
        } else {
            arrayOfNames [i] = Temp;
        }
    }
    for (int i = 0;
    i < maxItems; i ++) {
        System.out.print ("Item # " + (i + 1) + " : ");
        System.out.print (arrayOfNames [i] + "\n");
    }
}

public static void main (String [] args) {
    Scanner scan = new Scanner (System.in);
    int numOfItems = 0;
    System.out.print ("Enter How Many Items: ");
    try {
        numOfItems = Integer.parseInt (scan.nextLine ().trim ());
    } catch (NumberFormatException e) {
        System.out.print ("Number of items you entered is invalid!");
        System.exit (0);
    }
    Grocery grocery = new Grocery (numOfItems);
    for (int i = 0;
    i < numOfItems; i ++) {
        System.out.print ("Enter Item " + (i + 1) + " : ");
        if (! grocery.addItem (scan.nextLine ())) {
            System.out.println ("First Item Duplicate Detected!");
            System.exit (0);
        }
    }
    scan.close ();
    System.out.println (grocery.toString ());
}

}
