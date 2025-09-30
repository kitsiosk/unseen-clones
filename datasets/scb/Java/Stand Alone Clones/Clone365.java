public class Clone365 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:42091542
*  Stack Overflow answer #:42092086
*  And Stack Overflow answer#:42091646
*/
public static boolean isPermutation (String s1, String s2) {
    if (s1.length () != s2.length ()) {
        return false;
    }
    int [] charCount = new int [256];
    for (int i = 0;
    i < s1.length (); i ++) {
        charCount [s1.charAt (i)] ++;
        charCount [s2.charAt (i)] --;
    }
    for (int i = 0;
    i < charCount.length; i ++) {
        if (charCount [i] != 0) {
            return false;
        }
    }
    return true;
}

private static boolean isPermutation (String a, String b) {
    char [] aArray = a.toCharArray ();
    char [] bArray = b.toCharArray ();
    if (a.length () != b.length ()) {
        return false;
    }
    int found = 0;
    for (int i = 0;
    i < aArray.length; i ++) {
        char eachA = aArray [i];
        for (int k = 0;
        k < bArray.length; k ++) {
            if (eachA == bArray [k]) {
                found ++;
                bArray [k] = '\uFFFF';
                break;
            }
        }
    }
    return found == a.length ();
}

}
