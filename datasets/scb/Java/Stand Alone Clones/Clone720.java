public class Clone720 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8122782
*  Stack Overflow answer #:8123060
*  And Stack Overflow answer#:8124272
*/
public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            new CaretPositionTest ();
        }}
    );
}

public static void main (final String [] args) {
    final JFrame frame = new JFrame ("Display Keyword Panel");
    final JPanel panel = new JPanel ();
    panel.setLayout (new BoxLayout (panel, BoxLayout.Y_AXIS));
    text1.setBorder (null);
    text1.setOpaque (false);
    text1.setEditable (false);
    text2.setBorder (null);
    text2.setOpaque (false);
    text2.setEditable (false);
    text1.getInputMap ().put (KeyStroke.getKeyStroke ('G', KeyEvent.CTRL_DOWN_MASK), "copyAll");
    text1.getActionMap ().put ("copyAll", new AbstractAction () {
        @Override
        public void actionPerformed (ActionEvent e) {
            StringBuilder s = new StringBuilder ();
            s.append (text1.getText ()).append ("\n").append (text2.getText ());
            System.out.println (s.toString ());
        }}
    );
    panel.add (text1);
    panel.add (text2);
    frame.setLayout (new BorderLayout ());
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane ().add (panel, BorderLayout.CENTER);
    frame.setLocation (450, 400);
    frame.pack ();
    frame.setVisible (true);
}

}
