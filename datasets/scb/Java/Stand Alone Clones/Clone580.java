public class Clone580 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:363681
*  Stack Overflow answer #:10930164
*  And Stack Overflow answer#:51961141
*/
public static final void main (String...aArgs) {
    log ("Generating random integers in the range 1..10.");
    int START = 1;
    int END = 10;
    Random random = new Random ();
    for (int idx = 1;
    idx <= 10; ++ idx) {
        showRandomInteger (START, END, random);
    }
    log ("Done.");
}

public static void main (String [] args) {
    Random ran = new Random ();
    int min, max;
    Scanner sc = new Scanner (System.in);
    System.out.println ("Enter min range:");
    min = sc.nextInt ();
    System.out.println ("Enter max range:");
    max = sc.nextInt ();
    int num = ran.nextInt (min);
    int num1 = ran.nextInt (max);
    System.out.println ("Random Number between given range is " + num1);
}

}
