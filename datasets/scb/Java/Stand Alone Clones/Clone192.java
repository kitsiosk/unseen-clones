public class Clone192 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6992154
*  Stack Overflow answer #:6992259
*  And Stack Overflow answer#:6992259
*/
public void actionPerformed (ActionEvent e) {
    float newAlpha = softButton1.getAlpha () + incrementer;
    if (newAlpha < 0) {
        newAlpha = 0;
        incrementer = - incrementer;
    } else if (newAlpha > 1f) {
        newAlpha = 1f;
        incrementer = - incrementer;
    }
    softButton1.setAlpha (newAlpha);
    softButton2.setAlpha (newAlpha);
}

public void actionPerformed (ActionEvent e) {
    try {
        UIManager.setLookAndFeel (laf [index].getClassName ());
        SwingUtilities.updateComponentTreeUI (frame);
    } catch (Exception exc) {
        exc.printStackTrace ();
    }
    index = (index + 1) % laf.length;
}

}
