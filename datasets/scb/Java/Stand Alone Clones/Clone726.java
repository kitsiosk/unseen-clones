public class Clone726 {
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
    float veeX = endX - stroke.getLineWidth () * 0.5f / arrowRatio;
    Path2D.Float path = new Path2D.Float ();
    float waisting = 0.5f;
    float waistX = endX - arrowLength * 0.5f;
    float waistY = arrowRatio * arrowLength * 0.5f * waisting;
    float arrowWidth = arrowRatio * arrowLength;
    path.moveTo (veeX - arrowLength, - arrowWidth);
    path.quadTo (waistX, - waistY, endX, 0.0f);
    path.quadTo (waistX, waistY, veeX - arrowLength, arrowWidth);
    path.lineTo (veeX - arrowLength * 0.75f, 0.0f);
    path.lineTo (veeX - arrowLength, - arrowWidth);
    g.setColor (Color.BLUE);
    g.fill (path);
    g.setColor (Color.RED);
    g.draw (new Line2D.Float (50.0f, 0.0f, veeX - arrowLength * 0.5f, 0.0f));
}

}
