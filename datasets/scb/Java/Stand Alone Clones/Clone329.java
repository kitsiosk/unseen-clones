public class Clone329 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13119926
*  Stack Overflow answer #:48723167
*  And Stack Overflow answer#:48888657
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
    String str = "abcdabghplhhnfl".toLowerCase ();
    Integer [] ar = new Integer [26];
    for (int i = 0;
    i < str.length (); i ++) {
        int j = str.charAt (i) - 'a';
        if (ar [j] == null) {
            ar [j] = 1;
        } else {
            ar [j] += 1;
        }
    }
    for (int i = 0;
    i < ar.length; i ++) {
        if (ar [i] != null && ar [i] > 1) {
            char c = (char) (97 + i);
            System.out.println ("'" + c + "' comes " + ar [i] + " times.");
        }
    }
}

}
