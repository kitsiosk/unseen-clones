public class Clone327 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20129281
*  Stack Overflow answer #:20131064
*  And Stack Overflow answer#:20129607
*/
public void mouseMoved (MouseEvent e) {
    int x = width / 2;
    int y = height / 2;
    Point mousePoint = e.getPoint ();
    int deltaX = mousePoint.x - x;
    int deltaY = mousePoint.y - y;
    polyrot = - Math.atan2 (deltaX, deltaY);
    polyrot = Math.toDegrees (polyrot) + 180;
    repaint ();
}

public void mouseMoved (MouseEvent e) {
    xpos = getX ();
    if (xpos < 0) {
        polyrot --;
    } else if (xpos > 0) {
        polyrot ++;
    }
    repaint ();
    break;
}

}
