public class Clone494 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18918616
*  Stack Overflow answer #:18919039
*  And Stack Overflow answer#:18919051
*/
public void move (Container container) {
    if (leftRight) {
        x += deltaX;
        if (x >= canvasWidth) {
            leftRight = false;
            updateDelta ();
        }
    } else {
        x += - deltaX;
        if (x <= 0) {
            leftRight = true;
            updateDelta ();
        }
    }
    if (upDown) {
        y += deltaY;
        upDown = ! (y >= (canvasHeight));
        if (y >= (canvasHeight)) {
            upDown = false;
            updateDelta ();
        }
    } else {
        y += - deltaY;
        if (y <= 0) {
            upDown = true;
            updateDelta ();
        }
    }
}

public void move (Container container) {
    if (x >= canvasWidth || x <= 0) {
        deltaX = - 1 * deltaX;
    }
    if (y >= canvasHeight || y <= 0) {
        deltaY = - 1 * deltaY;
    }
    x += deltaX;
    y += deltaY;
}

}
