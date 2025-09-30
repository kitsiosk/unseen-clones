public class Clone377 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:38945879
*  Stack Overflow answer #:38946823
*  And Stack Overflow answer#:38946381
*/
protected void paintComponent (Graphics g) {
    super.paintComponent (g);
    Graphics2D g2d = (Graphics2D) g.create ();
    Shape outer = new Rectangle (0, 0, getWidth (), getHeight ());
    Shape inner = new Rectangle (0, 0, 50, 50);
    Area area = new Area (outer);
    area.subtract (new Area (inner));
    g2d.setColor (getBackground ());
    g2d.fill (area);
    g2d.dispose ();
}

protected void paintComponent (Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    Graphics2D imgG2 = img.createGraphics ();
    imgG2.setBackground (new Color (0, 0, 0, 0));
    imgG2.setColor (Color.red);
    imgG2.fillRect (0, 0, 100, 100);
    imgG2.clearRect (0, 0, 50, 50);
    imgG2.dispose ();
    g2.drawImage (img, 0, 0, null);
    g2.dispose ();
    super.paintComponent (g);
}

}
