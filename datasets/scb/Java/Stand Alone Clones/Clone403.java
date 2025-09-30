public class Clone403 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20445186
*  Stack Overflow answer #:20445338
*  And Stack Overflow answer#:20445389
*/
private void init () {
    textField = new JTextField ();
    okButton = new JButton ("OK");
    okButton.addActionListener (this);
    setLayout (new GridLayout (2, 1, 5, 5));
    add (textField);
    add (okButton);
    pack ();
}

private void init () {
    textField = new JTextField ();
    JButton okButton = new JButton ("OK");
    okButton.addActionListener (new ActionListener () {
        @Override
        public void actionPerformed (ActionEvent e) {
            dialog.dispose ();
        }}
    );
    dialog.setLayout (new GridLayout (2, 1, 5, 5));
    dialog.add (textField);
    dialog.add (okButton);
    dialog.pack ();
}

}
