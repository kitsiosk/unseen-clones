public class Clone69 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:38872133
*  Stack Overflow answer #:38874576
*  And Stack Overflow answer#:38872616
*/
public static void main (String [] args) {
    String stmt = " INSERT INTO `TABLENAME` VALUES(xxx,yyy,zzz),(aaa,'bb),(b',ccc),(aaa,bbb,ccc); ";
    System.out.printf ("%s\n", stmt);
    stmt = stmt.split ("(?i)\\s+values\\s*\\(|\\);") [1];
    System.out.printf ("values list: %s\n", stmt);
    Matcher m = Pattern.compile ("('\\w*)(\\)\\,\\()+(\\w*')").matcher (stmt);
    while (m.find ()) {
        stmt = stmt.substring (0, m.start (2)) + "###" + stmt.substring (m.end (2), stmt.length ());
        System.out.printf ("values list with pattern subst inside char literal: %s\n", stmt);
    }
    String [] multiValues = stmt.split ("\\)\\,\\(");
    for (int i = 0;
    i < multiValues.length; i ++) {
        multiValues [i] = multiValues [i].replaceAll ("###", "),(");
    }
    System.out.println (Arrays.toString (multiValues));
}

public static void main (String [] args) {
    Test t = new Test ();
    String [] allQueryStrings = new String [] {"INSERT INTO `TABLENAME` VALUES(xxx,yyy,zzz);", "INSERT INTO `TABLENAME` VALUES(xxx,yyy,zzz),(aaa,bbb,ccc);", "INSERT INTO `TABLENAME` VALUES(xxx,yyy,zzz),(aaa,'bb(,)b',ccc);", "INSERT INTO `TABLENAME` VALUES(xxx,yyy,zzz),(aaa,'bb),(b',ccc);"};
    for (String queryString : allQueryStrings) {
        System.out.println (queryString);
        for (String values : t.extractValues (queryString)) {
            System.out.println (values);
        }
    }
}

}
