public class Clone101 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1248510
*  Stack Overflow answer #:37179377
*  And Stack Overflow answer#:28973188
*/
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

public void type (String text) {
    char c;
    for (int ii = 0;
    ii < text.length (); ii ++) {
        c = text.charAt (ii);
        if (c <= 31 || c == 129) {
            pressControlKey (c);
        } else {
            typeAsciiCode (c);
        }
    }
}

}
