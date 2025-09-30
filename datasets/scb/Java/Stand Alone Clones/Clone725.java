public class Clone725 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2027613
*  Stack Overflow answer #:2027641
*  And Stack Overflow answer#:2027641
*/
void draw (Graphics2D g, int width, int height) {
    g.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor (Color.WHITE);
    g.fillRect (0, 0, width, height);
    for (Arrow arrow : arrows) {
        g.setColor (Color.ORANGE);
        g.fillRect (350, 20, 20, 280);
        g.setStroke (new BasicStroke (20.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g.translate (0, 60);
        arrow.draw (g);
        g.setStroke (new BasicStroke (20.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        g.translate (0, 100);
        arrow.draw (g);
        g.setStroke (new BasicStroke (20.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));
        g.translate (0, 100);
        arrow.draw (g);
        g.translate (400, - 260);
    }
}

public void draw (Graphics2D g) {
    float arrowRatio = 0.5f;
    float arrowLength = 80.0f;
    BasicStroke stroke = (BasicStroke) g.getStroke ();
    float endX = 350.0f;
    float veeX;
    switch (stroke.getLineJoin ()) {
        case BasicStroke.JOIN_BEVEL :
            veeX = endX - stroke.getLineWidth () * 0.25f;
            break;
        default :
        case BasicStroke.JOIN_MITER :
            veeX = endX - stroke.getLineWidth () * 0.5f / arrowRatio;
            break;
        case BasicStroke.JOIN_ROUND :
            veeX = endX - stroke.getLineWidth () * 0.5f;
            break;
    }
    Path2D.Float path = new Path2D.Float ();
    path.moveTo (veeX - arrowLength, - arrowRatio * arrowLength);
    path.lineTo (veeX, 0.0f);
    path.lineTo (veeX - arrowLength, arrowRatio * arrowLength);
    g.setColor (Color.BLUE);
    g.draw (path);
    g.setColor (Color.YELLOW);
    g.draw (new Line2D.Float (50.0f, 0.0f, veeX, 0.0f));
    g.setColor (Color.RED);
    g.draw (new Line2D.Float (50.0f, 0.0f, veeX - stroke.getLineWidth () * 0.25f, 0.0f));
}

}
