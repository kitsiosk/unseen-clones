public class Clone174 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6318293
*  And Stack Overflow answer#:6310273
*/
public void actionPerformed (ActionEvent e) {
    timer.stop ();
    timer.stop ();
    if (SwingUtilities.isEventDispatchThread ()) {
        Runnable doRun = new Runnable () {
            @Override
            public void run () {
                pastRemWins ();
            }}
        ;
        SwingUtilities.invokeLater (doRun);
    } else {
        Runnable doRun = new Runnable () {
            @Override
            public void run () {
                pastRemWins ();
            }}
        ;
        SwingUtilities.invokeLater (doRun);
    }
}

public void actionPerformed (ActionEvent e) {
    System.out.println ();
    System.out.println ("Close Dialogs");
    for (Window window : Window.getWindows ()) {
        if (window instanceof JDialog) {
            JDialog dialog = (JDialog) window;
            System.out.println ("\tClosing " + dialog.getTitle ());
            dialog.dispose ();
        }
    }
    Runtime.getRuntime ().gc ();
}

}
