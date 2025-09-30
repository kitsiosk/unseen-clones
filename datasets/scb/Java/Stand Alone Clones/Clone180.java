public class Clone180 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2622725
*  Stack Overflow answer #:7702240
*  And Stack Overflow answer#:2623292
*/
public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    System.out.println ("How many numbers do you want to enter?");
    int num = input.nextInt ();
    int array [] = new int [num];
    System.out.println ("Enter the " + num + " numbers now.");
    for (int i = 0;
    i < array.length; i ++) {
        array [i] = input.nextInt ();
    }
    System.out.println ("These are the numbers you have entered.");
    printArray (array);
    input.close ();
}

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

}
