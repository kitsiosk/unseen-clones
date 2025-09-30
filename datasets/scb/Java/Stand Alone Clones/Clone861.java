public class Clone861 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21898116
*  Stack Overflow answer #:21898215
*  And Stack Overflow answer#:21898536
*/
public static void main (String [] arguments) {
    System.out.println ("Type in any integer");
    Scanner inputChar = new Scanner (System.in);
    int i;
    if (! inputChar.hasNextInt ()) System.out.println ("Not a number");
    else {
        i = inputChar.nextInt ();
        if (i != 0) {
            if (i % 2 == 0) System.out.println (i + " is even");
            else {
                System.out.println (i + " is odd");
            }
        } else {
            System.out.println ("Zeros are not allowed, bye!");
        }
    }
}

public static void main (String [] arguments) {
    Scanner inputChar = new Scanner (System.in);
    int i;
    while (true) {
        System.out.println ("Type in any integer:");
        if (! inputChar.hasNextInt ()) {
            System.out.println ("Not a number");
            inputChar.next ();
        } else {
            i = inputChar.nextInt ();
            if (i != 0) {
                if (i % 2 == 0) System.out.println (i + " is even");
                else {
                    System.out.println (i + " is odd");
                }
            } else {
                System.out.println ("Zeros are not allowed, bye!");
                break;
            }
        }
    }
}

}
