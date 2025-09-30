public class Clone897 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:26752720
*  Stack Overflow answer #:26753711
*  And Stack Overflow answer#:26752786
*/
public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    int x = 0;
    int [] list1Array = new int [1];
    System.out.println ("Enter list1: ");
    while (input.hasNext ()) {
        list1Array [x] = input.nextInt ();
        x ++;
        int [] temp = new int [list1Array.length + 1];
        for (int i = 0;
        i < list1Array.length; i ++) {
            temp [i] = list1Array [i];
        }
        list1Array = temp;
    }
}

public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    System.out.println ("Enter elemnt size ");
    int size = input.nextInt ();
    int x = 0;
    int [] list1Array = new int [size];
    for (int y = 0;
    y < size; y ++) {
        System.out.println ("Enter number");
        list1Array [x] = input.nextInt ();
        x ++;
    }
    System.out.println (Arrays.toString (list1Array));
}

}
