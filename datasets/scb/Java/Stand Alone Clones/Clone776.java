public class Clone776 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18581197
*  Stack Overflow answer #:29579141
*  And Stack Overflow answer#:30950077
*/
public static void main (String args []) {
    String s = "1234";
    int len = s.length ();
    int num = Integer.parseInt (s);
    int mod;
    int od = 0, even = 0;
    for (int i = 0;
    i < len; i ++) {
        mod = num % 10;
        num = num / 10;
        if (mod % 2 == 0) {
            even = even + mod;
        } else {
            od = od + mod;
        }
    }
    System.out.println ("Sum of even numbers is " + even);
    System.out.println ("Sum of odd numbers is " + od);
}

public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    String number = "";
    int a = 0, total = 0;
    boolean even = false;
    System.out.println ("Enter a number");
    number = input.nextLine ();
    for (int counter = 0;
    counter < number.length (); counter ++) {
        a = Integer.parseInt (number.substring (counter, counter + 1));
        if (a % 2 != 0 || a == 1) {
            even = false;
            total += a;
        }
    }
    System.out.println ("The sum is " + total);
}

}
