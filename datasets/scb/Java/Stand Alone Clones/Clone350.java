public class Clone350 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25227777
*  Stack Overflow answer #:25227906
*  And Stack Overflow answer#:25227916
*/
public void run () {
    try {
        UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        ex.printStackTrace ();
    }
    JFrame frame = new JFrame ("Testing");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.add (new TestPane ());
    frame.pack ();
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

public void run () {
    JLabel l = new JLabel (new ImageIcon (bi));
    Border twoPartBorder = new CompoundBorder (new EmptyBorder (15, 15, 15, 15), new EtchedBorder ());
    Border threePartBorder = new CompoundBorder (twoPartBorder, new EmptyBorder (15, 15, 15, 15));
    l.setBorder (threePartBorder);
    JFrame f = new JFrame ("Three Part Border");
    f.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
    f.setContentPane (l);
    f.pack ();
    f.setLocationByPlatform (true);
    f.setVisible (true);
}

}
