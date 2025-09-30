public class Clone66 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6887296
*  Stack Overflow answer #:6887354
*  And Stack Overflow answer#:6887354
*/
public void actionPerformed (ActionEvent e) {
    tick ();
    int delta = 20;
    int width = SPRITE_WIDTH + 2 * delta;
    int height = width;
    if (moved) {
        int x = oldMX - delta;
        int y = oldMY - delta;
        repaint (x, y, width, height);
    }
    int x = mX - delta;
    int y = mY - delta;
    repaint (x, y, width, height);
    moved = false;
}

public void actionPerformed (ActionEvent e) {
    switch (direction) {
        case UP :
            draw.incrementY (false);
            break;
        case DOWN :
            draw.incrementY (true);
            break;
        case LEFT :
            draw.incrementX (false);
            break;
        case RIGHT :
            draw.incrementX (true);
            break;
        default :
            break;
    }
}

}
