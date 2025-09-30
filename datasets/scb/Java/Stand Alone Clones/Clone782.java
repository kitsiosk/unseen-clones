public class Clone782 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51159957
*  Stack Overflow answer #:51160480
*  And Stack Overflow answer#:51160336
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

}
