public class Clone406 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:43711833
*  Stack Overflow answer #:43712052
*  And Stack Overflow answer#:43711980
*/
public static void main (String [] args) {
    Scanner scan = new Scanner (System.in);
    System.out.print ("Enter a String : ");
    String str = scan.nextLine ();
    ArrayList < String > repetition = new ArrayList < String > ();
    ArrayList < String > digrams = new ArrayList < String > ();
    String digram;
    for (int i = 0;
    i < str.length () - 1; i ++) {
        digram = str.substring (i, i + 2);
        if (repetition.contains (digram) || digram.contains (" ") || digram.length () < 2) continue;
        int occurances = (str.length () - str.replace (digram, "").length ()) / 2;
        occurances += (str.replaceFirst (".*?(" + digram.charAt (0) + "+).*", "$1").length () - 1) / 2;
        digrams.add (digram + ":" + occurances);
        repetition.add (digram);
    }
    Collections.sort (digrams, (s1, s2) -> s1.substring (3, 4).compareTo (s2.substring (3, 4)));
    System.out.println (digrams);
}

public static void main (String args []) {
    int ci, i, j, k, l = 0;
    String str, str1, result, subString;
    char c1, c2, ch;
    Scanner scan = new Scanner (System.in);
    System.out.print ("Enter a String : ");
    str = scan.nextLine ();
    i = str.length ();
    for (c1 = 'A'; c1 <= 'z'; c1 ++) {
        for (c2 = 'A'; c2 <= 'z'; c2 ++) {
            result = new String (new char [] {c1, c2});
            k = 0;
            for (j = 0; j < i - 1; j ++) {
                subString = str.substring (j, j + 2);
                if (result.equals (subString)) {
                    k ++;
                }
            }
            if (k > 0) {
                System.out.println ("" + result + ": " + k);
            }
        }
    }
}

}
