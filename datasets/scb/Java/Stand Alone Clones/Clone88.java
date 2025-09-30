public class Clone88 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1248510
*  Stack Overflow answer #:19393755
*  And Stack Overflow answer#:37179377
*/
public void type (char c) {
    keyPress (VK_ALT);
    keyPress (VK_NUMPAD0);
    keyRelease (VK_NUMPAD0);
    String altCode = Integer.toString (c);
    for (int i = 0;
    i < altCode.length (); i ++) {
        c = (char) (altCode.charAt (i) + '0');
        keyPress (c);
        keyRelease (c);
    }
    keyRelease (VK_ALT);
}

public void type (CharSequence chars, int ms) {
    ms = ms > 0 ? ms : 0;
    for (int i = 0, len = chars.length ();
    i < len; i ++) {
        char c = chars.charAt (i);
        AWTKeyStroke keyStroke = getKeyStroke (c);
        int keyCode = keyStroke.getKeyCode ();
        boolean shift = Character.isUpperCase (c) || keyStroke.getModifiers () == (SHIFT_DOWN_MASK + 1);
        if (shift) {
            robot.keyPress (KeyEvent.VK_SHIFT);
        }
        robot.keyPress (keyCode);
        robot.keyRelease (keyCode);
        if (shift) {
            robot.keyRelease (KeyEvent.VK_SHIFT);
        }
        if (ms > 0) {
            robot.delay (ms);
        }
    }
}

}
