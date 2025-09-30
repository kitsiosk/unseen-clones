public class Clone783 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51159957
*  Stack Overflow answer #:51160480
*  And Stack Overflow answer#:51160642
*/
public static void main (String [] args) {
    ArrayList < String > al = new ArrayList < String > ();
    Scanner sc = new Scanner (System.in);
    while (true) {
        System.out.print ("Enter name:");
        String temp = sc.next ();
        if (al.isEmpty () != true) {
            if (temp.equals (al.get (0))) break;
        }
        al.add (temp);
    }
    for (int i = 0;
    i < al.size (); i ++) {
        System.out.println (al.get (i));
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
