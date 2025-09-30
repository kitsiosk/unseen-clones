public class Clone54 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23187539
*  Stack Overflow answer #:41833518
*  And Stack Overflow answer#:39257039
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

public static boolean isBalanced (String brackets) {
    Map < Character, Character > braces = new HashMap < > ();
    braces.put ('(', ')');
    braces.put ('[', ']');
    braces.put ('{', '}');
    if (brackets.length () % 2 != 0) {
        return false;
    }
    Stack < Character > halfBraces = new Stack ();
    for (char ch : brackets.toCharArray ()) {
        if (braces.containsKey (ch)) {
            halfBraces.push (braces.get (ch));
        } else if (halfBraces.isEmpty () || ch != halfBraces.pop ()) {
            return false;
        }
    }
    return halfBraces.isEmpty ();
}

}
