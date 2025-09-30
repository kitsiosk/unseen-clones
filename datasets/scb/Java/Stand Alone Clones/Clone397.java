public class Clone397 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2148103
*  Stack Overflow answer #:2148293
*  And Stack Overflow answer#:2153614
*/
public static void main (String [] args) {
    JFrame main = new JFrame ();
    JPanel p = new JPanel ();
    p.setLayout (new BorderLayout ());
    p.add (new JLabel ("test"), BorderLayout.WEST);
    p.add (new JTextField ("growable"), BorderLayout.CENTER);
    p.add (new JComboBox (), BorderLayout.EAST);
    main.add (p);
    main.pack ();
    main.setVisible (true);
}

public static void main (String [] args) {
    JFrame frame = new JFrame ("GridBagLayout Demo");
    frame.setLayout (new GridBagLayout ());
    JLabel label = new JLabel ("Demo Label");
    JTextField textField = new JTextField ("Demo Text");
    JComboBox comboBox = new JComboBox (new String [] {"hello", "goodbye", "foo"});
    GridBagConstraints cons = new GridBagConstraints ();
    cons.insets = new Insets (10, 10, 10, 10);
    frame.add (label, cons);
    cons.gridx = 1;
    cons.weightx = 1;
    cons.weighty = 1;
    cons.insets = new Insets (10, 0, 10, 10);
    cons.fill = GridBagConstraints.HORIZONTAL;
    frame.add (textField, cons);
    cons.gridx = 2;
    cons.weightx = 0;
    cons.weighty = 0;
    cons.insets = new Insets (10, 0, 10, 10);
    cons.fill = GridBagConstraints.NONE;
    frame.add (comboBox, cons);
    frame.pack ();
    frame.setVisible (true);
}

}
