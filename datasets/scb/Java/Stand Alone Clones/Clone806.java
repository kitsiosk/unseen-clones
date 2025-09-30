public class Clone806 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16016064
*  Stack Overflow answer #:16017118
*  And Stack Overflow answer#:16016324
*/
public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            new Mail ().initUI ();
        }}
    );
}

public static void main (String [] args) {
    JFrame frame = new JFrame ("New Message");
    frame.setSize (100, 100);
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    JTextArea textArea = new JTextArea ();
    frame.add (textArea, BorderLayout.CENTER);
    JPanel list = new JPanel ();
    list.setLayout (new BoxLayout (list, BoxLayout.Y_AXIS));
    frame.add (list, BorderLayout.NORTH);
    String [] labels = {"To: ", "Cc: ", "Bcc: ", "Subject: "};
    for (int i = 0;
    i < labels.length; i ++) {
        JLabel l = new JLabel (labels [i]);
        JTextField f = new JTextField ();
        JPanel p = new JPanel (new BorderLayout ());
        p.add (l, BorderLayout.WEST);
        p.add (f, BorderLayout.CENTER);
        list.add (p);
    }
    frame.pack ();
    frame.setVisible (true);
}

}
