public class Clone558 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12683533
*  Stack Overflow answer #:12683632
*  And Stack Overflow answer#:12683632
*/
public void actionPerformed (ActionEvent arg0) {
    int result = JOptionPane.OK_OPTION;
    if (dirty) {
        result = JOptionPane.showConfirmDialog (gui, "Erase the current painting?");
    }
    if (result == JOptionPane.OK_OPTION) {
        clear (canvasImage);
    }
}

public void actionPerformed (ActionEvent e) {
    JFileChooser ch = getFileChooser ();
    int result = ch.showSaveDialog (gui);
    if (result == JFileChooser.APPROVE_OPTION) {
        try {
            File f = ch.getSelectedFile ();
            ImageIO.write (BasicPaint.this.canvasImage, "png", f);
            BasicPaint.this.originalImage = BasicPaint.this.canvasImage;
            dirty = false;
        } catch (IOException ioe) {
            showError (ioe);
            ioe.printStackTrace ();
        }
    }
}

}
