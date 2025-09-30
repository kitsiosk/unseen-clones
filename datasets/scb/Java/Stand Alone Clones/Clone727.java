public class Clone727 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2027613
*  Stack Overflow answer #:2027641
*  And Stack Overflow answer#:2027641
*/
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
