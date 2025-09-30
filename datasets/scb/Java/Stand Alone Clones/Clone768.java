public class Clone768 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8444710
*  Stack Overflow answer #:26229188
*  And Stack Overflow answer#:8444800
*/
public boolean isPalindrome (String original) {
    int i = original.length () - 1;
    int j = 0;
    while (i > j) {
        if (original.charAt (i) != original.charAt (j)) {
            return false;
        }
        i --;
        j ++;
    }
    return true;
}

boolean isPalindrome (String s) {
    int n = s.length ();
    for (int i = 0;
    i < (n / 2); ++ i) {
        if (s.charAt (i) != s.charAt (n - i - 1)) {
            return false;
        }
    }
    return true;
}

}
