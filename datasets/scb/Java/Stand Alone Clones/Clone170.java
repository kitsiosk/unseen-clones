public class Clone170 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6318293
*  And Stack Overflow answer#:6375412
*/
public void actionPerformed (ActionEvent e) {
    timer.stop ();
    if (SwingUtilities.isEventDispatchThread ()) {
        Runnable doRun = new Runnable () {
            @Override
            public void run () {
                remWins ();
            }}
        ;
        SwingUtilities.invokeLater (doRun);
    } else {
        Runnable doRun = new Runnable () {
            @Override
            public void run () {
                remWins ();
            }}
        ;
        SwingUtilities.invokeLater (doRun);
    }
}

public void actionPerformed (ActionEvent e) {
    if (runProcess) {
        for (Window win : Window.getWindows ()) {
            if (win instanceof JDialog) {
                System.out.println ("    Trying to Remove JDialog");
                win.dispose ();
            }
        }
        System.out.println ("    Remove Cycle Done :-)");
        runProcess = false;
        new Thread () {
            @Override
            public void run () {
                try {
                    Thread.sleep (100);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                Runtime.getRuntime ().gc ();
            }}
        .start ();
    } else {
        pastRemWins ();
        runProcess = true;
    }
}

}
