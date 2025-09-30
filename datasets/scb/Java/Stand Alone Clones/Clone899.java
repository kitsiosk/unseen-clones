public class Clone899 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5516843
*  Stack Overflow answer #:5517044
*  And Stack Overflow answer#:5516982
*/
private int count8 (int n) {
    String nString = Integer.toString (n);
    boolean isPrevChar8 = false;
    int total = 0;
    for (int i = 0;
    i < nString.length (); i ++) {
        char nextChar = nString.charAt (i);
        if (nextChar == '8') {
            total += (isPrevChar8 ? 2 : 1);
            isPrevChar8 = true;
        } else {
            isPrevChar8 = false;
        }
    }
    return total;
}

public static int count8 (int num) {
    int count = 0;
    boolean doubl = false;
    while (true) {
        int n = num % 10;
        num = num / 10;
        if (n == 8) {
            if (doubl) {
                count = count + 2;
            } else {
                count ++;
            }
            doubl = true;
        } else {
            doubl = false;
        }
        if (num == 0) break;
    }
    return count;
}

}
