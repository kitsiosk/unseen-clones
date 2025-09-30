public class Clone269 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29496199
*  Stack Overflow answer #:29496279
*  And Stack Overflow answer#:29496279
*/
public void actionPerformed (ActionEvent evt) {
    if (! onKeyRelease) {
        if (upTimer != null && upTimer.isRunning ()) {
            return;
        }
        System.out.println ("key pressed");
        label.setText (UP_KEY_PRESSED);
        upTimer = new Timer (UP_TIMER_DELAY, new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                Color c = label.getBackground ();
                if (FLASH_COLOR.equals (c)) {
                    label.setBackground (null);
                    label.setForeground (Color.black);
                } else {
                    label.setBackground (FLASH_COLOR);
                    label.setForeground (Color.white);
                }
            }}
        );
        upTimer.start ();
    } else {
        System.out.println ("Key released");
        if (upTimer != null && upTimer.isRunning ()) {
            upTimer.stop ();
            upTimer = null;
        }
        label.setText ("");
    }
}

public void actionPerformed (ActionEvent e) {
    Color c = label.getBackground ();
    if (FLASH_COLOR.equals (c)) {
        label.setBackground (null);
        label.setForeground (Color.black);
    } else {
        label.setBackground (FLASH_COLOR);
        label.setForeground (Color.white);
    }
}

}
