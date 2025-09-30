public class Clone273 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6390240
*  Stack Overflow answer #:6395105
*  And Stack Overflow answer#:6390974
*/
public ValidateRevalidateRepaint () {
    validate = revalidate = repaint = false;
    panel = new JPanel (new GridBagLayout ());
    gbc = new GridBagConstraints ();
    gbc.insets = new Insets (0, 20, 0, 20);
    panel.add (getFiller (), gbc);
    JFrame f = new JFrame ();
    f.setJMenuBar (getMenuBar ());
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.getContentPane ().add (panel);
    f.getContentPane ().add (getRadioPanel (), "East");
    f.getContentPane ().add (getCheckBoxPanel (), "South");
    f.setSize (400, 200);
    f.setLocation (200, 200);
    f.setVisible (true);
}

public ValidateRevalidateRepaint () {
    center = new JPanel (new GridLayout (1, 0, 10, 10));
    JFrame f = new JFrame ();
    f.setTitle ("VRR");
    f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    f.add (center, BorderLayout.CENTER);
    f.add (getRadioPanel (), BorderLayout.EAST);
    f.add (getCheckBoxPanel (), BorderLayout.SOUTH);
    makeChange (4);
    f.pack ();
    f.setLocationRelativeTo (null);
    f.setVisible (true);
}

}
