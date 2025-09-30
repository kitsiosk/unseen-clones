public class Clone371 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13318574
*  Stack Overflow answer #:13318864
*  And Stack Overflow answer#:13319161
*/
public void move () {
    if (x + xa > 0 && x + xa < game.getWidth () - 30) x = x + xa;
    if (y + ya > 0 && y + ya < game.getHeight () - 60) {
        for (int i = 12;
        i < 0; i --);
        ya += 10;
        y = y + ya;
    }
    if (collision ()) {
        y -= 10;
        onGround = true;
    }
    Square.y += 10;
}

public void move () {
    y += ya;
    x += xa;
    if (x < 0) {
        x = 0;
    } else if (x + 30 > game.getWidth ()) {
        x = game.getWidth () - 30;
    }
    if (y < 0) {
        y = 0;
    } else if (collision ()) {
        onGround = true;
        y = game.ground.getBounds ().y - d;
    }
}

}
