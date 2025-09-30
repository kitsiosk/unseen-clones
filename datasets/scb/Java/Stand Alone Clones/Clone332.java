public class Clone332 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13119926
*  Stack Overflow answer #:48723167
*  And Stack Overflow answer#:44093828
*/
public static void main (String [] args) {
    String string = "check duplicate charcters in string";
    string = string.toLowerCase ();
    char [] charAr = string.toCharArray ();
    Arrays.sort (charAr);
    for (int i = 1;
    i < charAr.length;) {
        int count = recursiveMethod (charAr, i, 1);
        if (count > 1) {
            System.out.println ("'" + charAr [i] + "' comes " + count + " times");
            i = i + count;
        } else i ++;
    }
}

public static void main (String [] args) {
    String test = "The quick brown fox jumped over the lazy dog.";
    int countA = 0, countO = 0, countSpace = 0, countDot = 0;
    for (int i = 0;
    i < test.length (); i ++) {
        switch (test.charAt (i)) {
            case 'a' :
            case 'A' :
                countA ++;
                break;
            case 'o' :
            case 'O' :
                countO ++;
                break;
            case ' ' :
                countSpace ++;
                break;
            case '.' :
                countDot ++;
                break;
        }
    }
    System.out.printf ("%s%d%n%s%d%n%s%d%n%s%d", "A: ", countA, "O: ", countO, "Space: ", countSpace, "Dot: ", countDot);
}

}
