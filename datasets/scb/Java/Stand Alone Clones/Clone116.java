public class Clone116 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:36727833
*  Stack Overflow answer #:36728149
*  And Stack Overflow answer#:36728319
*/
public static String camelCaser (String str) {
    char [] strChr = str.toCharArray ();
    strChr [0] = Character.toUpperCase (strChr [0]);
    for (int i = 0;
    i < strChr.length; i ++) if (strChr [i] == '_') strChr [i + 1] = Character.toUpperCase (strChr [i + 1]);
    String reply = new String (strChr);
    reply = reply.replace ("_", "");
    return reply;
}

public static String camelCaser (String str) {
    String [] words = str.split ("_");
    String res = "";
    for (String word : words) {
        if (! word.isEmpty ()) {
            res += Character.toUpperCase (word.charAt (0));
            if (word.length () > 1) {
                res += word.substring (1);
            }
        }
    }
    return res;
}

}
