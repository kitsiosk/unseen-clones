public class Clone711 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28302578
*  Stack Overflow answer #:28302714
*  And Stack Overflow answer#:28302706
*/
public int readNumber () {
    int x = - 1;
    do {
        try {
            System.out.println ("Please enter a positive number.");
            x = keyboard.nextInt ();
        } catch (InputMismatchException e) {
        }
    } while (x < 0);
    return x;
}

public int readNumber () {
    int x = - 1;
    while (x < 0) {
        System.out.println ("Please enter a positive number.");
        try {
            x = keyboard.nextInt ();
        } catch (java.util.InputMismatchException e) {
        }
    }
    return x;
}

}
