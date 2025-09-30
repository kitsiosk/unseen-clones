public class Clone913 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:332079
*  Stack Overflow answer #:1059731
*  And Stack Overflow answer#:334295
*/
public static String toHexString (byte [] bytes) {
    char [] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    char [] hexChars = new char [10000000];
    int c = 0;
    int v;
    for (j = 0; j < bytes.length; j ++) {
        v = bytes [j] & 0xFF;
        hexChars [c] = hexArray [v / 16];
        c ++;
        hexChars [c] = hexArray [v % 16];
        c ++;
    }
    return new String (hexChars, 0, c);
}

public static String toHexString (byte bytes []) {
    if (bytes == null) {
        return null;
    }
    StringBuffer sb = new StringBuffer ();
    for (int iter = 0;
    iter < bytes.length; iter ++) {
        byte high = (byte) ((bytes [iter] & 0xf0)>> 4);
        byte low = (byte) (bytes [iter] & 0x0f);
        sb.append (nibble2char (high));
        sb.append (nibble2char (low));
    }
    return sb.toString ();
}

}
