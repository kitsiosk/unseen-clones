public class Clone600 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10647520
*  Stack Overflow answer #:39195881
*  And Stack Overflow answer#:44578831
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

public static void main (String [] args) {
    String str = "AAABBBBCC";
    int length = str.length ();
    StringBuilder sb = new StringBuilder ();
    int count = 1;
    for (int i = 0;
    i < length; i ++) {
        if (i == length - 1) {
            sb.append (str.charAt (i) + "" + count);
            break;
        }
        if (str.charAt (i) == str.charAt (i + 1)) {
            count ++;
        } else {
            sb.append (str.charAt (i) + "" + count);
            count = 1;
        }
    }
    System.out.println (sb.toString ());
}

}
