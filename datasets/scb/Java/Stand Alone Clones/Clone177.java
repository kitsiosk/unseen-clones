public class Clone177 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6310273
*  And Stack Overflow answer#:6375412
*/
public void actionPerformed (ActionEvent e) {
    System.out.println ();
    System.out.println ("Display Dialogs");
    for (Window window : Window.getWindows ()) {
        if (window instanceof JDialog) {
            JDialog dialog = (JDialog) window;
            System.out.println ("\t" + dialog.getTitle () + " " + dialog.isDisplayable ());
        }
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
