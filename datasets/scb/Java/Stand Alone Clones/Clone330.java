public class Clone330 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13119926
*  Stack Overflow answer #:48723167
*  And Stack Overflow answer#:13119986
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

public static void main (String [] args) throws IOException {
    String ch;
    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    System.out.print ("Enter the Statement:");
    ch = br.readLine ();
    int count = 0, len = 0;
    do {
        try {
            char name [] = ch.toCharArray ();
            len = name.length;
            count = 0;
            for (int j = 0;
            j < len; j ++) {
                if ((name [0] == name [j]) && ((name [0] >= 65 && name [0] <= 91) || (name [0] >= 97 && name [0] <= 123))) count ++;
            }
            if (count != 0) System.out.println (name [0] + " " + count + " Times");
            ch = ch.replace ("" + name [0], "");
        } catch (Exception ex) {
        }
    } while (len != 1);
}

}
