public class Clone53 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23187539
*  Stack Overflow answer #:41833518
*  And Stack Overflow answer#:47709379
*/
public static boolean isBalanced (String expression) {
    if ((expression.length () % 2) == 1) return false;
    else {
        Stack < Character > s = new Stack < > ();
        for (char bracket : expression.toCharArray ()) switch (bracket) {
            case '{' :
                s.push ('}');
                break;
            case '(' :
                s.push (')');
                break;
            case '[' :
                s.push (']');
                break;
            default :
                if (s.isEmpty () || bracket != s.peek ()) {
                    return false;
                }
                s.pop ();
        }
        return s.isEmpty ();
    }
}

public boolean isBalanced (String strExpression) {
    Map < Character, Character > bracketPair = new HashMap < Character, Character > ();
    bracketPair.put ('(', ')');
    bracketPair.put ('[', ']');
    bracketPair.put ('{', '}');
    Stack < Character > stk = new Stack < Character > ();
    for (int i = 0;
    i < strExpression.length (); i ++) {
        if (bracketPair.containsKey (strExpression.charAt (i))) stk.push (strExpression.charAt (i));
        else if (bracketPair.containsValue (strExpression.charAt (i))) if (stk.isEmpty () || bracketPair.get (stk.pop ()) != strExpression.charAt (i)) return false;
    }
    if (stk.isEmpty ()) return true;
    else return false;
}

}
