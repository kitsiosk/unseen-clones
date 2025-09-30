public class Clone916 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:332079
*  Stack Overflow answer #:2197650
*  And Stack Overflow answer#:332101
*/
public static String toHexString (byte [] bytes) {
    char [] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    char [] hexChars = new char [bytes.length * 2];
    int v;
    for (int j = 0;
    j < bytes.length; j ++) {
        v = bytes [j] & 0xFF;
        hexChars [j * 2] = hexArray [v / 16];
        hexChars [j * 2 + 1] = hexArray [v % 16];
    }
    return new String (hexChars);
}

public static String toHexString (byte [] bytes) {
    StringBuilder hexString = new StringBuilder ();
    for (int i = 0;
    i < bytes.length; i ++) {
        String hex = Integer.toHexString (0xFF & bytes [i]);
        if (hex.length () == 1) {
            hexString.append ('0');
        }
        hexString.append (hex);
    }
    return hexString.toString ();
}

}
