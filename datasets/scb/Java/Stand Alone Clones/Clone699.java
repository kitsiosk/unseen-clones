public class Clone699 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31655284
*  Stack Overflow answer #:31655785
*  And Stack Overflow answer#:31655990
*/
public static void main (String [] args) throws IOException {
    JFrame myFrame = new JFrame ("myJfTitle");
    myFrame.setSize (300, 100);
    myFrame.setLayout (new BorderLayout ());
    JPanel myPanel = new JPanel ();
    JButton myButton = new JButton ("Click me");
    JProgressBar myBar = new JProgressBar ();
    myBar.setPreferredSize (new Dimension (myFrame.getWidth (), myFrame.getHeight ()));
    myFrame.addComponentListener (new ComponentAdapter () {
        public void componentResized (ComponentEvent evt) {
            Component c = (Component) evt.getSource ();
            myBar.setPreferredSize (new Dimension (myFrame.getWidth (), myFrame.getHeight ()));
        }}
    );
    JPanel glass = (JPanel) myFrame.getGlassPane ();
    glass.setVisible (true);
    myBar.setValue (50);
    glass.add (myButton, BorderLayout.CENTER);
    myPanel.add (myBar);
    myFrame.add (myPanel);
    myFrame.revalidate ();
    myFrame.repaint ();
    myFrame.setVisible (true);
}

public static void main (String [] args) throws IOException {
    JFrame myFrame = new JFrame ("myJfTitle");
    myFrame.setLayout (new BorderLayout ());
    JButton myButton = new JButton ("Click me");
    myButton.setAlignmentX (Component.CENTER_ALIGNMENT);
    JProgressBar myBar = new JProgressBar ();
    LayoutManager overlay = new OverlayLayout (myBar);
    myBar.setLayout (overlay);
    myBar.setValue (50);
    myBar.add (myButton);
    myFrame.add (myBar, BorderLayout.CENTER);
    myFrame.pack ();
    myFrame.setSize (new Dimension (300, 100));
    myFrame.setVisible (true);
}

}
