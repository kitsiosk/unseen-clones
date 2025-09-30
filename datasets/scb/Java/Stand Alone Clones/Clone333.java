public class Clone333 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13119926
*  Stack Overflow answer #:48723167
*  And Stack Overflow answer#:45513947
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

public static void main (String...a) {
    System.out.print ("Enter the String");
    Scanner sc = new Scanner (System.in);
    String st = sc.nextLine ();
    int [] ar = new int [256];
    for (int i = 0;
    i < st.length (); i ++) {
        ar [st.charAt (i)] = ar [st.charAt (i)] + 1;
    }
    for (int i = 0;
    i < 256; i ++) {
        char ch = (char) i;
        if (ar [i] > 0) {
            if (ar [i] == 1) {
                System.out.print (ch);
            } else {
                System.out.print (ch + "" + ar [i]);
            }
        }
    }
}

}
