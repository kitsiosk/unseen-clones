public class Clone463 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18142745
*  Stack Overflow answer #:18143616
*  And Stack Overflow answer#:30896438
*/
public static String generateRandomPassword (int length) {
    StringBuilder sb = new StringBuilder (length);
    for (int i = 0;
    i < length; i ++) {
        int c = RANDOM.nextInt (62);
        if (c <= 9) {
            sb.append (String.valueOf (c));
        } else if (c < 36) {
            sb.append ((char) ('a' + c - 10));
        } else {
            sb.append ((char) ('A' + c - 36));
        }
    }
    return sb.toString ();
}

public String generateRandomPassword (final int length) {
    if (length < 1) {
        throw new IllegalArgumentException ("length must be greater than 0");
    }
    final char [] buf = new char [length];
    for (int idx = 0;
    idx < buf.length; ++ idx) {
        buf [idx] = symbols [RANDOM.nextInt (symbols.length)];
    }
    return shuffle (new String (buf));
}

}
