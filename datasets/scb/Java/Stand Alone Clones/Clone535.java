public class Clone535 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7269294
*  Stack Overflow answer #:7376085
*  And Stack Overflow answer#:7300784
*/
public void run () {
    if (! isFinished ()) {
        realRunnable.run ();
        if (! isInfinite ()) {
            repetitions --;
            if (isFinished ()) {
                synchronized (this) {
                    if (self == null) {
                        try {
                            wait ();
                        } catch (Exception e) {
                        }
                    }
                    self.cancel (false);
                }
            }
        }
    }
}

public synchronized void run () {
    if (! this.infinite) {
        if (this.repeatCounter > 0) {
            this.command.run ();
            this.repeatCounter --;
        } else {
            this.control.cancel (false);
        }
    } else {
        this.command.run ();
    }
}

}
