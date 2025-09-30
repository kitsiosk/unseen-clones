public class Clone838 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:48265517
*  Stack Overflow answer #:48265734
*  And Stack Overflow answer#:48265638
*/
@Override
public void tick (float delta) {
    for (Entity e : entities) {
        if (color == Color.WHITE) {
            if (getSurrounding (- 32, - 32) != null && getSurrounding (- 32, - 32).getColor () == Color.BLACK) {
                if (getSurrounding (- 32, - 32).getStrength () < strength) {
                    getSurrounding (- 32, - 32).setStrength (- 50);
                }
            }
        }
        if (! inGame.entities.isEmpty () && strength <= 0) {
            inGame.entities.remove (this);
        }
    }
}

@Override
public void tick (float delta) {
    Entity removeEntity = null;
    for (Entity e : entities) {
        e.tick (delta);
        if (e.checkStrength ()) {
            removeEntity = e;
            break;
        }
    }
    if (removeEntity != null) {
        entities.remove (removeEntity);
    }
    player.tick (delta);
}

}
