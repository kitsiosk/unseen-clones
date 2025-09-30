public class Clone615 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3391794
*  Stack Overflow answer #:3444682
*  And Stack Overflow answer#:3444682
*/
public void run () {
    if (bar.isDisposed () || bar.getShell ().isDisposed ()) {
        return;
    }
    synchronized (lock) {
        bar.getShell ().pack (true);
        orgSize [0] = bar.getShell ().getSize ().y;
        currentSize [0] = orgSize [0];
    }
}

public void run () {
    synchronized (lock) {
        if (bar.isDisposed () || bar.getShell ().isDisposed ()) {
            return;
        }
        currentSize [0] = bar.getShell ().getSize ().y;
        if (currentSize [0] != orgSize [0]) {
            return;
        } else {
            bar.getShell ().layout (true);
            bar.getShell ().pack (true);
        }
    }
}

}
