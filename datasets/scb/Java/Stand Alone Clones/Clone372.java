public class Clone372 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13318574
*  Stack Overflow answer #:13319161
*  And Stack Overflow answer#:13319161
*/
public void run () {
    try {
        UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
    } catch (ClassNotFoundException ex) {
    } catch (InstantiationException ex) {
    } catch (IllegalAccessException ex) {
    } catch (UnsupportedLookAndFeelException ex) {
    }
    Game game = new Game ();
    JFrame frame = new JFrame ("Test");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setLayout (new BorderLayout ());
    frame.add (game);
    frame.pack ();
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

public void run () {
    while (true) {
        game.move ();
        try {
            long startedAt = System.currentTimeMillis ();
            SwingUtilities.invokeAndWait (new Runnable () {
                @Override
                public void run () {
                    game.repaint ();
                }}
            );
            long completedAt = System.currentTimeMillis ();
            long sleepFor = 30 - (completedAt - startedAt);
            if (sleepFor < 0) {
                sleepFor = 30;
            }
            Thread.sleep (sleepFor);
        } catch (Exception exp) {
            exp.printStackTrace ();
        }
    }
}

}
