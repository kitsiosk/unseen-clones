public class Clone746 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:522244
*  Stack Overflow answer #:19003495
*  And Stack Overflow answer#:525363
*/
public final void mouseReleased (MouseEvent e) {
    target.mouseReleased (e);
    if (pressed != null) {
        if (getDragDistance (e) < MAX_CLICK_DISTANCE) {
            MouseEvent clickEvent = new MouseEvent ((Component) pressed.getSource (), MouseEvent.MOUSE_CLICKED, e.getWhen (), pressed.getModifiers (), pressed.getX (), pressed.getY (), pressed.getXOnScreen (), pressed.getYOnScreen (), pressed.getClickCount (), pressed.isPopupTrigger (), pressed.getButton ());
            target.mouseClicked (clickEvent);
        }
        pressed = null;
    }
}

public void mouseReleased (int mod, Point loc) {
    if (pressLocation != null && dragLocation != null) {
        pressLocation = null;
    } else if (dragLocation != null) {
    } else {
    }
    pressLocation = null;
    dragLocation = null;
}

}
