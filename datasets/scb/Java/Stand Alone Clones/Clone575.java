public class Clone575 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6963021
*  Stack Overflow answer #:6964178
*  And Stack Overflow answer#:6967559
*/
private static void createAndShowGUI () {
    final JFrame frame = new JFrame ();
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setLayout (new FlowLayout ());
    JButton readerStopButton_ = new JButton ();
    readerStopButton_.setFocusPainted (false);
    readerStopButton_.setBackground (UIManager.getDefaults ().getColor ("Button.light"));
    readerStopButton_.setFont (new Font ("Geneva", 0, 12));
    readerStopButton_.setText ("<html><center>READER<br>STOP</center></html>\n");
    readerStopButton_.setHorizontalTextPosition (SwingConstants.CENTER);
    frame.add (readerStopButton_);
    frame.pack ();
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

private static void createAndShowGUI () {
    final JFrame frame = new JFrame ();
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setLayout (new FlowLayout ());
    JPanel operationButtons_ = new JPanel ();
    JButton readerStopButton_ = new JButton ();
    readerStopButton_.setBackground (javax.swing.UIManager.getDefaults ().getColor ("Button.light"));
    readerStopButton_.setFont (new java.awt.Font ("Geneva", 0, 12));
    readerStopButton_.setText ("<html><center>READER<br>STOP</center></html>\n");
    readerStopButton_.setToolTipText ("<html><b>Stop</b> button is currently inactive.  ");
    readerStopButton_.setMargin (new Insets (0, - 30, 0, - 30));
    readerStopButton_.setPreferredSize (new Dimension (66, 40));
    operationButtons_.add (readerStopButton_);
    readerStopButton_ = new JButton ();
    readerStopButton_.setBackground (javax.swing.UIManager.getDefaults ().getColor ("Button.light"));
    readerStopButton_.setFont (new java.awt.Font ("Geneva", 0, 12));
    readerStopButton_.setText ("<html><center>READER<br>STOP</center></html>\n");
    readerStopButton_.setToolTipText ("<html><b>Stop</b> button is currently inactive.  ");
    System.out.println (readerStopButton_.getPreferredSize ());
    readerStopButton_.setPreferredSize (new Dimension (66, 40));
    operationButtons_.add (readerStopButton_);
    operationButtons_.add (new JButton ("yCoder.com"));
    frame.add (operationButtons_);
    frame.pack ();
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

}
