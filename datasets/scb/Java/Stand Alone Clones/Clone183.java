public class Clone183 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2622725
*  Stack Overflow answer #:2623292
*  And Stack Overflow answer#:52479127
*/
public static void main (String [] args) {
    List < String > list = new ArrayList < String > ();
    Scanner stdin = new Scanner (System.in);
    do {
        System.out.println ("Current list is " + list);
        System.out.println ("Add more? (y/n)");
        if (stdin.next ().startsWith ("y")) {
            System.out.println ("Enter : ");
            list.add (stdin.next ());
        } else {
            break;
        }
    } while (true);
    stdin.close ();
    System.out.println ("List is " + list);
    String [] arr = list.toArray (new String [0]);
    System.out.println ("Array is " + Arrays.toString (arr));
}

public static void main (String [] args) {
    int arr [];
    Scanner scan = new Scanner (System.in);
    for (int i = 0;
    i < 5; i ++) {
        System.out.print ("Enter number " + (i + 1) + ": ");
        arr [i] = scan.nextInt ();
    }
    for (int i = 0;
    i < 5; i ++) System.out.println ("Number " + (i + 1) + ": " + arr [i]);
}

}
