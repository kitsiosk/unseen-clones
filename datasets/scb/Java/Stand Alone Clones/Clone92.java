public class Clone92 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1248510
*  Stack Overflow answer #:19393755
*  And Stack Overflow answer#:28973188
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
