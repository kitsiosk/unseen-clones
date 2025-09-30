public class Clone728 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:47921264
*  Stack Overflow answer #:47921566
*  And Stack Overflow answer#:47921432
*/
public static void main (String [] args) {
    Scanner scn = new Scanner (System.in);
    int number;
    int nearNumberZero = 0;
    for (int i = 1;
    i <= 5; i ++) {
        System.out.println ("Enter number " + i);
        number = scn.nextInt ();
        if (i == 1 || Math.abs (number) < Math.abs (nearNumberZero)) nearNumberZero = number;
    }
    System.out.println ("The number near zero 0 is - " + nearNumberZero);
    scn.close ();
}

public static void main (String [] args) {
    Scanner scn = new Scanner (System.in);
    ArrayList < Integer > integers = new ArrayList < > ();
    System.out.println ("Enter number 1");
    integers.add (scn.nextInt ());
    System.out.println ("Enter number 2");
    integers.add (scn.nextInt ());
    System.out.println ("Enter number 3");
    integers.add (scn.nextInt ());
    System.out.println ("Enter number 4");
    integers.add (scn.nextInt ());
    System.out.println ("Enter number 5");
    integers.add (scn.nextInt ());
    Collections.sort (integers, Comparator.comparingInt (Math :: abs));
    System.out.println ("The number near zero 0 is" + integers.get (0));
}

}
