public class Clone749 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7781148
*  Stack Overflow answer #:7782392
*  And Stack Overflow answer#:7782392
*/
public void actionPerformed (ActionEvent e) {
    ImageIcon saveIcon = new ImageIcon ("save-icon.png");
    int askSave = JOptionPane.showConfirmDialog (null, "Save current image?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, saveIcon);
    if (askSave == JOptionPane.YES_OPTION) {
        saveImage ();
        System.exit (0);
    } else {
        System.exit (0);
    }
}

public void actionPerformed (ActionEvent e) {
    ImageIcon widthIcon = new ImageIcon ("LR-arrows.png");
    String scaleWidth = (String) JOptionPane.showInputDialog (null, "What should the new width be?", "", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
    ImageIcon heightIcon = new ImageIcon ("UD-arrows.png");
    String scaleHeight = (String) JOptionPane.showInputDialog (null, "What should the new height be?", "", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
    double x = Double.parseDouble (scaleWidth);
    double y = Double.parseDouble (scaleHeight);
    int newWidth = (int) x;
    int newHeight = (int) y;
    frame.setSize (newWidth, newHeight);
    scale (newWidth, newHeight);
}

}
