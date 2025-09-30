public class Clone168 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6318293
*  And Stack Overflow answer#:6310273
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

}
