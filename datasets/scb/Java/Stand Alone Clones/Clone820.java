public class Clone820 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:42101052
*  Stack Overflow answer #:42101380
*  And Stack Overflow answer#:42101146
*/
public static String numLetters (String str) {
    StringBuilder s = new StringBuilder (s);
    String end = new String ();
    int counter = 0;
    char c, d;
    for (int i = 0;
    i < s.length (); i ++) {
        c = s.charAt (i);
        for (int j = 0;
        j < s.length (); j ++) {
            d = s.charAt (j);
            if (c == d) {
                s.deleteCharAt (j);
                if (i >= j) i --;
                j --;
                counter ++;
            }
        }
        end = end + counter + c;
        counter = 0;
    }
    return end;
}

public static String numLetters (String s) {
    int [] count = new int [26];
    for (int i = 0;
    i < s.length (); i ++) {
        char c = s.charAt (i);
        count [(int) (c - 'a')] ++;
    }
    String ans = "";
    for (int i = 0;
    i < 26; i ++) {
        if (count [i] != 0) {
            ans += String.valueOf (count [i]) + (char) (i + 'a');
        }
    }
    return ans;
}

}
