public class Clone470 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11129608
*  Stack Overflow answer #:11131267
*  And Stack Overflow answer#:11130706
*/
public ControlsB (Box b, Graph g) {
    graph = g;
    b = Box.createVerticalBox ();
    Box boxUpper = new Box (BoxLayout.X_AXIS);
    boxUpper.add (new JLabel ("Please enter range:  "));
    b.add (boxUpper);
    Box boxX = new Box (BoxLayout.X_AXIS);
    boxX.add (new JLabel (" x-axis "));
    boxX.add (new JLabel ("from"));
    final JTextField f1 = new JTextField ("-5");
    f1.setMaximumSize (new Dimension (100, 30));
    boxX.add (f1);
    boxX.add (new JLabel (" to "));
    JTextField f2 = new JTextField ("5");
    f2.setMaximumSize (new Dimension (100, 30));
    boxX.add (f2);
    b.add (boxX);
    Box boxY = new Box (BoxLayout.X_AXIS);
    boxY.add (new JLabel ("y-axis "));
    boxY.add (new JLabel ("from"));
    final JTextField f3 = new JTextField ("5");
    f3.setMaximumSize (new Dimension (100, 30));
    boxY.add (f3);
    boxY.add (new JLabel ("to"));
    JTextField f4 = new JTextField ("-5");
    f4.setMaximumSize (new Dimension (100, 30));
    boxY.add (f4);
    b.add (boxY);
    Box buttonBox = new Box (BoxLayout.X_AXIS);
    buttonBox.add (new JButton ("Plot"));
    refineButton = new JButton ("Refine");
    buttonBox.add (refineButton);
    refineButton.addActionListener (new ActionListener () {
        public void actionPerformed (ActionEvent ae) {
            int x = Integer.parseInt (f1.getText ());
            int y = Integer.parseInt (f3.getText ());
            graph.setValues (x, y);
        }}
    );
    b.add (buttonBox);
    add (b);
}

public ControlsB (Box box2, final Graph graph) {
    btn1.addActionListener (new ActionListener () {
        public void actionPerformed (ActionEvent event) {
            f = Integer.parseInt (f1.getText ());
            g = Integer.parseInt (f2.getText ());
            System.out.println (f + "  " + g);
            graph.repaint ();
        }}
    );
}

}
