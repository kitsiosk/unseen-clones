public class Clone885 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35382694
*  Stack Overflow answer #:35383133
*  And Stack Overflow answer#:35382765
*/
public void paintComponent (Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    RenderingHints rh = new RenderingHints (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    rh.put (RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHints (rh);
    double w = getWidth ();
    double m = w / 12;
    double dx = w / 7;
    double dy = w / 8;
    double x = m;
    double y = .7 * m;
    double r = w / 4;
    int fwdStart = - 30;
    int topStart = 90 - 30;
    float rw = (float) w / 40;
    BasicStroke bs = new BasicStroke (rw * 1.5f);
    BasicStroke fs = new BasicStroke (rw);
    Color blue = new Color (0, 133, 199);
    Color gold = new Color (244, 195, 0);
    Color black = Color.black;
    Color green = new Color (0, 159, 61);
    Color red = new Color (223, 0, 36);
    paintRing (g2d, fs, bs, x, y, r, rw, blue, 0, 360);
    paintRing (g2d, fs, bs, x + dx, y + dy, r, rw, gold, 0, 360);
    paintRing (g2d, fs, bs, x + 2 * dx, y, r, rw, black, 0, 360);
    paintRing (g2d, fs, bs, x + dx, y + dy, r, rw, gold, topStart, 60);
    paintRing (g2d, fs, bs, x, y, r, rw, blue, fwdStart, 60);
    paintRing (g2d, fs, bs, x + 3 * dx, y + dy, r, rw, green, 0, 360);
    paintRing (g2d, fs, bs, x + 4 * dx, y, r, rw, red, 0, 360);
    paintRing (g2d, fs, bs, x + 3 * dx, y + dy, r, rw, green, topStart, 60);
    paintRing (g2d, fs, bs, x + 2 * dx, y, r, rw, black, fwdStart, 60);
}

protected void paintComponent (Graphics g) {
    super.paintComponent (g);
    Graphics2D g2 = (Graphics2D) g.create ();
    g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    int x = X_START;
    int y = Y_START;
    myDrawOval (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, Color.BLUE, OVAL_WIDTH);
    x += DELTA_X;
    y += DELTA_Y;
    myDrawOval (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, COLOR_GOLD, OVAL_WIDTH);
    x += DELTA_X;
    y -= DELTA_Y;
    myDrawOval (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, Color.BLACK, OVAL_WIDTH);
    x += DELTA_X;
    y += DELTA_Y;
    myDrawOval (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, Color.GREEN.darker (), OVAL_WIDTH);
    x += DELTA_X;
    y -= DELTA_Y;
    myDrawOval (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, Color.RED, OVAL_WIDTH);
    x = X_START;
    y = Y_START;
    int angle = CIRCLE_DEGREES - ARC_LENGTH;
    myDrawArc (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, Color.BLUE, OVAL_WIDTH, angle, ARC_LENGTH);
    x += DELTA_X;
    y += DELTA_Y;
    myDrawArc (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, COLOR_GOLD, OVAL_WIDTH, 0, ARC_LENGTH);
    x += DELTA_X;
    y -= DELTA_Y;
    myDrawArc (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, Color.BLACK, OVAL_WIDTH, angle, ARC_LENGTH);
    x += DELTA_X;
    y += DELTA_Y;
    myDrawArc (g2, INNER_STROKE, OUTER_STROKE, x, y, BG, Color.GREEN.darker (), OVAL_WIDTH, 0, ARC_LENGTH);
    g2.dispose ();
}

}
