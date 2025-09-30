public class Clone932 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18001177
*  Stack Overflow answer #:18001393
*  And Stack Overflow answer#:18001496
*/
public void addString (String...myString) {
    StringBuilder sb = new StringBuilder ("(");
    for (int i = 0;
    i < myString.length - 1; i ++) {
        sb.append (myString [i] + " AND ");
    }
    if (myString.length == 0) sb.append (")");
    else sb.append (myString [myString.length - 1]);
    System.out.println (sb);
}

public void addString (String...myString) {
    String separator = " AND ";
    StringBuilder sb = new StringBuilder ();
    sb.append ('(');
    boolean needSeparator = false;
    for (String string : myString) {
        if (needSeparator) {
            sb.append (separator);
        } else {
            needSeparator = true;
        }
        sb.append (string);
    }
    sb.append (')');
    System.out.println (sb);
}

}
