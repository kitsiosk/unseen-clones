public class Clone55 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23187539
*  Stack Overflow answer #:41833518
*  And Stack Overflow answer#:42175007
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

public static boolean isBalanced (String str) {
    boolean result = false;
    if (str.length () < 2) return false;
    Stack < Character > stack = new Stack < > ();
    for (int i = 0;
    i < str.length (); i ++) {
        char ch = str.charAt (i);
        if (! parenthesesMapRight.containsKey (ch) && ! parenthesesMapLeft.containsKey (ch)) {
            continue;
        }
        if (parenthesesMapLeft.containsKey (ch)) {
            stack.push (ch);
        } else {
            if (! stack.isEmpty () && stack.pop () == parenthesesMapRight.get (ch).charValue ()) {
                result = true;
            } else {
                return false;
            }
        }
    }
    if (! stack.isEmpty ()) return result = false;
    return result;
}

}
