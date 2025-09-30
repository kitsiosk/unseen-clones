public class Clone93 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1248510
*  Stack Overflow answer #:11779211
*  And Stack Overflow answer#:37179377
*/
public static void type (String characters) {
    Clipboard clipboard = Toolkit.getDefaultToolkit ().getSystemClipboard ();
    StringSelection stringSelection = new StringSelection (characters);
    clipboard.setContents (stringSelection, clipboardOwner);
    robot.keyPress (KeyEvent.VK_CONTROL);
    robot.keyPress (KeyEvent.VK_V);
    robot.keyRelease (KeyEvent.VK_V);
    robot.keyRelease (KeyEvent.VK_CONTROL);
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
