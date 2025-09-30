public class Clone525 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:39804782
*  Stack Overflow answer #:39805008
*  And Stack Overflow answer#:39805127
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

private static String decrypt (final String s) {
    final List < Integer > crypt = new ArrayList < > ();
    final String [] groups = s.split ("#");
    for (int i = 0;
    i < groups.length; i ++) {
        final String group = groups [i];
        int j = 0;
        if ((i == (groups.length - 1)) && ! s.endsWith ("#")) {
            j = group.length ();
        }
        if (group.length () > 2) {
            j = group.length () - 2;
        }
        for (int k = 0;
        k < j; k ++) {
            crypt.add (Integer.valueOf (group.substring (k, k + 1)));
        }
        if (j < group.length ()) {
            crypt.add (Integer.valueOf (group.substring (j, group.length ())));
        }
    }
    final StringBuilder n = new StringBuilder (crypt.size ());
    for (final Integer c : crypt) {
        final char d = (char) (('a' + c) - 1);
        n.append (d);
    }
    return n.toString ();
}

}
