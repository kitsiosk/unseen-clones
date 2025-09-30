public class Clone107 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13750659
*  Stack Overflow answer #:13750859
*  And Stack Overflow answer#:13750859
*/
public void run () {
    try {
        UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
    }
    JFrame frame = new JFrame ();
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setLayout (new BorderLayout ());
    frame.add (new BlinkPane ());
    frame.pack ();
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

public void run () {
    Blink blinkOn = new Blink (blinkPane, true);
    Blink blinkOff = new Blink (blinkPane, false);
    for (int index = 0;
    index < 10; index ++) {
        if (index % 2 == 0) {
            SwingUtilities.invokeLater (blinkOn);
        } else {
            SwingUtilities.invokeLater (blinkOff);
        }
        try {
            Thread.sleep (125);
        } catch (InterruptedException ex) {
        }
    }
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            blinkPane.reset ();
        }}
    );
}

}
