public class Clone602 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10647520
*  Stack Overflow answer #:39195881
*  And Stack Overflow answer#:45202269
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
    String string = "aaabbbbbaccc";
    int counter;
    String result = "";
    int i = 0;
    while (i < string.length ()) {
        counter = 1;
        for (int j = i + 1;
        j < string.length (); j ++) {
            System.out.println ("string length =" + string.length ());
            if (string.charAt (i) == string.charAt (j)) {
                counter ++;
            }
        }
        result = result + string.charAt (i) + counter;
        string = string.replaceAll (String.valueOf (string.charAt (i)), "");
    }
    System.out.println ("result is = " + result);
}

}
