public class Clone32 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5585779
*  Stack Overflow answer #:53921506
*  And Stack Overflow answer#:45994764
*/
public static void main (String [] args) {
    String str = "123";
    byte barr [] = str.getBytes ();
    System.out.println (Arrays.toString (barr));
    int result = 0;
    for (int i = 0;
    i < barr.length; i ++) {
        int ii = barr [i];
        char a = (char) ii;
        int no = Character.getNumericValue (a);
        result = result * 10 + no;
        System.out.println (result);
    }
    System.out.println ("result:" + result);
}

public static void main (String args []) {
    String inputString;
    Scanner s = new Scanner (System.in);
    inputString = s.nextLine ();
    if (! inputString.matches ("([+-]?([0-9]*[.])?[0-9]+)")) {
        System.out.println ("Not a Number");
    } else {
        Double result2 = getNumber (inputString);
        System.out.println ("result = " + result2);
    }
}

}
