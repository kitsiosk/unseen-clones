public class Clone524 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:39804782
*  Stack Overflow answer #:39805008
*  And Stack Overflow answer#:39809663
*/
static String decrypt (String cipher) {
    String [] cipher_char_codes = cipher.split ("#");
    StringBuilder message = new StringBuilder ();
    for (String code : cipher_char_codes) {
        int index = Integer.parseInt (code);
        if (index > 26) {
            char [] pair = code.toCharArray ();
            for (int i = 0;
            i < pair.length; i ++) {
                int x = Integer.parseInt ("" + code.charAt (i));
                message.append ((char) ('a' + ((x - 1) % 26)));
            }
        } else {
            message.append ((char) ('a' + ((index - 1) % 26)));
        }
    }
    return message.toString ();
}

public static String decrypt (final String msg) {
    final Pattern regex = Pattern.compile ("((\\d\\d)(#)|(\\d))");
    final Matcher regexMatcher = regex.matcher (msg);
    final StringBuffer result = new StringBuffer ();
    String c;
    while (regexMatcher.find ()) {
        if (regexMatcher.group (2) == null) {
            c = regexMatcher.group (1);
        } else {
            c = regexMatcher.group (2);
        }
        result.append ((char) ((Integer.parseInt (c) + 'a') - 1));
    }
    return result.toString ();
}

}
