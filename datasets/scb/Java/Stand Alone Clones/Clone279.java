public class Clone279 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23729944
*  Stack Overflow answer #:23730104
*  And Stack Overflow answer#:23730189
*/
protected void paintComponent (Graphics g) {
    super.paintComponent (g);
    Graphics2D g2d = (Graphics2D) g.create ();
    g2d.setColor (Color.RED);
    g2d.drawLine (getWidth () / 2, 0, getWidth () / 2, getHeight ());
    g2d.drawLine (0, getHeight () / 2, getWidth (), getHeight () / 2);
    FontRenderContext context = g2d.getFontRenderContext ();
    Font font = new Font ("Arial", Font.BOLD, 48);
    TextLayout txt = new TextLayout (text, font, context);
    Rectangle2D bounds = txt.getBounds ();
    int x = (int) ((getWidth () - (int) bounds.getWidth ()) / 2);
    int y = (int) ((getHeight () - (bounds.getHeight () - txt.getDescent ())) / 2);
    y += txt.getAscent () - txt.getDescent ();
    g2d.setFont (font);
    g2d.setColor (Color.BLACK);
    g2d.drawString (text, x, y);
    g2d.setColor (Color.BLUE);
    g2d.translate (x, y);
    g2d.draw (bounds);
    g2d.dispose ();
}

@Override
protected void paintComponent (Graphics g) {
    super.paintComponent (g);
    Font font = new Font ("Arial", Font.BOLD, 48);
    String text = "Along time ago, in a galaxy, far, far away";
    Shape outline = font.createGlyphVector (g.getFontMetrics ().getFontRenderContext (), text).getOutline ();
    AffineTransform transform = AffineTransform.getTranslateInstance (- outline.getBounds ().getX () + getWidth () / 2 - outline.getBounds ().width / 2, - outline.getBounds ().getY () + getHeight () / 2 - outline.getBounds ().height / 2);
    outline = transform.createTransformedShape (outline);
    g2d.fill (outline);
}

}
