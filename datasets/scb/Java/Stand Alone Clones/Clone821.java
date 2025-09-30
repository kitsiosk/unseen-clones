public class Clone821 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:42911986
*  Stack Overflow answer #:42912823
*  And Stack Overflow answer#:42912896
*/
public void primeFactor () {
    if (input > 1) {
        for (int i = input;
        i >= 1; i --) {
            if (isPrime (i)) {
                if (divide (i)) {
                    System.out.println ("Adding a new int...");
                    factors.add (i);
                    input = input / i;
                    primeFactor ();
                }
            }
        }
    }
}

public void primeFactor () {
    input = sc.nextInt ();
    for (num = 1; num <= input; num ++) {
        if (isPrime (num)) {
            if (divide (num)) {
                System.out.println ("Adding a new int...");
                factors.add (num);
            }
        }
    }
    for (int element : factors) {
        System.out.println (element);
    }
}

}
