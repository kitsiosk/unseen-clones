public class Clone396 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2148103
*  Stack Overflow answer #:2148293
*  And Stack Overflow answer#:2148426
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
    EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            create ();
        }}
    );
}

}
