public class Clone928 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6067673
*  Stack Overflow answer #:6223859
*  And Stack Overflow answer#:18368345
*/
public static String replacer (StringBuffer outBuffer) {
    String data = outBuffer.toString ();
    try {
        StringBuffer tempBuffer = new StringBuffer ();
        int incrementor = 0;
        int dataLength = data.length ();
        while (incrementor < dataLength) {
            char charecterAt = data.charAt (incrementor);
            if (charecterAt == '%') {
                tempBuffer.append ("<percentage>");
            } else if (charecterAt == '+') {
                tempBuffer.append ("<plus>");
            } else {
                tempBuffer.append (charecterAt);
            }
            incrementor ++;
        }
        data = tempBuffer.toString ();
        data = URLDecoder.decode (data, "utf-8");
        data = data.replaceAll ("<percentage>", "%");
        data = data.replaceAll ("<plus>", "+");
    } catch (Exception e) {
        e.printStackTrace ();
    }
    return data;
}

public static String replacer (StringBuffer outBuffer) {
    String data = outBuffer.toString ();
    try {
        data = data.replaceAll ("%(?![0-9a-fA-F]{2})", "%25");
        data = data.replaceAll ("\\+", "%2B");
        data = URLDecoder.decode (data, "utf-8");
    } catch (Exception e) {
        e.printStackTrace ();
    }
    return data;
}

}
