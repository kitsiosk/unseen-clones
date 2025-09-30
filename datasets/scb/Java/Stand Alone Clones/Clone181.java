public class Clone181 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2622725
*  Stack Overflow answer #:28647721
*  And Stack Overflow answer#:2623292
*/
public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    System.out.println ("how many number you want to put in the pot?");
    int num = input.nextInt ();
    int numbers [] = new int [num];
    for (int i = 0;
    i < num; i ++) {
        System.out.println ("number" + i + ":");
        numbers [i] = input.nextInt ();
    }
    for (int temp : numbers) {
        System.out.print (temp + "\t");
    }
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
