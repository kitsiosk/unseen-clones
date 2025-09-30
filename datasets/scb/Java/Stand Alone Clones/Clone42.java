public class Clone42 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12967896
*  Stack Overflow answer #:30406772
*  And Stack Overflow answer#:28972634
*/
public static void main (String args []) {
    Scanner in = new Scanner (System.in);
    System.out.print ("give us an integer < 4000: ");
    System.out.println ("the roman numeral version is: " + toRoman (in.nextInt ()));
    for (int i = 1;
    i <= 3999; i ++) {
        System.out.println (i + " === " + toRoman (i));
    }
}

public static void main (String [] args) {
    int number = 2345;
    number = Math.min (3999, Math.max (1, number));
    String asRomanNumerals = "";
    String [] RN = {"I", "V", "X", "L", "C", "D", "M"};
    int i = 0;
    while (number > 0) {
        switch (number % 10) {
            case 1 :
                asRomanNumerals = RN [i] + asRomanNumerals;
                break;
            case 2 :
                asRomanNumerals = RN [i] + RN [i] + asRomanNumerals;
                break;
            case 3 :
                asRomanNumerals = RN [i] + RN [i] + RN [i] + asRomanNumerals;
                break;
            case 4 :
                asRomanNumerals = RN [i] + RN [i + 1] + asRomanNumerals;
                break;
            case 5 :
                asRomanNumerals = RN [i + 1] + asRomanNumerals;
                break;
            case 6 :
                asRomanNumerals = RN [i + 1] + RN [i] + asRomanNumerals;
                break;
            case 7 :
                asRomanNumerals = RN [i + 1] + RN [i] + RN [i] + asRomanNumerals;
                break;
            case 8 :
                asRomanNumerals = RN [i + 1] + RN [i] + RN [i] + RN [i] + asRomanNumerals;
                break;
            case 9 :
                asRomanNumerals = RN [i] + RN [i + 2] + asRomanNumerals;
                break;
        }
        number = (int) number / 10;
        i += 2;
    }
    System.out.println (asRomanNumerals);
}

}
