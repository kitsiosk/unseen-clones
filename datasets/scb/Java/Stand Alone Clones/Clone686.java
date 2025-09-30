public class Clone686 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13341857
*  Stack Overflow answer #:13344896
*  And Stack Overflow answer#:13344337
*/
public void mouseDragged (MouseEvent me) {
    super.mouseDragged (me);
    if (me.getX () < startX) {
        x -= 2;
    } else if (me.getX () > startX) {
        x += 2;
    }
    if (me.getY () < startY) {
        y -= 2;
    } else if (me.getY () > startY) {
        y += 2;
    }
    repaint ();
}

public void mouseDragged (MouseEvent e) {
    JViewport vport = (JViewport) e.getSource ();
    JComponent label = (JComponent) vport.getView ();
    Point cp = e.getPoint ();
    Point vp = vport.getViewPosition ();
    vp.translate (pp.x - cp.x, pp.y - cp.y);
    label.scrollRectToVisible (new Rectangle (vp, vport.getSize ()));
    pp.setLocation (cp);
}

}
