public class Clone506 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:47277358
*  Stack Overflow answer #:47280570
*  And Stack Overflow answer#:47282216
*/
public void displayImage (String strfilename, JLabel label) {
    try {
        BufferedImage image = ImageIO.read (new File (strfilename + ".jpg"));
        ImageIcon icon = new ImageIcon (image);
        label.setIcon (icon);
    } catch (IOException | NullPointerException ex) {
        ImageIcon icon = new ImageIcon ("NOIMAGE.jpg");
        label.setIcon (icon);
    }
}

public void displayImage (String strfilename, JLabel JLlabel) {
    BufferedImage image = null;
    if (! isImageExist (strfilename)) {
        image = ImageIO.read (new File ("NOIMAGE.jpg"));
    } else {
        try {
            image = ImageIO.read (new File (strfilename + ".jpg"));
        } catch (IOException ioe) {
            ioe.printStackTrace ();
        }
    }
    ImageIcon icon = new ImageIcon (image);
    JLlabel.setIcon (icon);
}

}
