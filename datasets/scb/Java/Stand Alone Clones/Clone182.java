public class Clone182 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2622725
*  Stack Overflow answer #:28647721
*  And Stack Overflow answer#:52479127
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
