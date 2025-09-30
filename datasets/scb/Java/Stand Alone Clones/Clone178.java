public class Clone178 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6310273
*  And Stack Overflow answer#:6375412
*/
public void actionPerformed (ActionEvent e) {
    System.out.println ();
    System.out.println ("Create Dialog");
    JDialog dialog = new JDialog ();
    dialog.getContentPane ().setLayout (null);
    for (int i = 0;
    i < 200; i ++) {
        dialog.add (new JTextField ("some text"));
    }
    dialog.setTitle ("Dialog " + count ++);
    dialog.setLocation (count * 25, count * 25);
    dialog.setVisible (true);
    System.out.println ("\tCreated " + dialog.getTitle ());
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
