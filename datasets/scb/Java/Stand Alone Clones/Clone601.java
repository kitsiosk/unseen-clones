public class Clone601 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10647520
*  Stack Overflow answer #:39195881
*  And Stack Overflow answer#:35861549
*/
public static void main (String [] args) {
    String s = "aaaabbccccdddeee";
    String s1 = "";
    String s2 = "";
    int count = 0;
    for (int i = 0;
    i < s.length (); i ++) {
        if (s1.indexOf (s.charAt (i)) < 0) {
            s1 = s1 + s.charAt (i);
        }
    }
    for (int i = 0;
    i < s1.length (); i ++) {
        for (int j = 0;
        j < s.length (); j ++) {
            if (s1.charAt (i) == s.charAt (j)) {
                count ++;
            }
        }
        s2 = s2 + s1.charAt (i) + count;
        count = 0;
    }
    System.out.println (s2);
}

public static void main (String args []) {
    inp = new Scanner (System.in);
    String str = inp.nextLine ();
    List < Character > arrlist = new ArrayList < Character > ();
    for (int i = 0;
    i < str.length (); i ++) {
        arrlist.add (str.charAt (i));
    }
    for (int i = 0;
    i < str.length (); i ++) {
        int freq = Collections.frequency (arrlist, str.charAt (i));
        System.out.println ("Frequency of " + str.charAt (i) + "  is:   " + freq);
    }
}

}
