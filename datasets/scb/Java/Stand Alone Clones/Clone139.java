public class Clone139 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17038371
*  Stack Overflow answer #:17038806
*  And Stack Overflow answer#:17038501
*/
public static void main (String [] args) {
    java.awt.EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            Evaluator evaluator = new Evaluator ();
        }}
    );
}

public static void main (String [] args) {
    Runnable r = new Runnable () {
        public void run () {
            final JCheckBox show = new JCheckBox ("Have Text", false);
            JPanel ui = new JPanel (new FlowLayout (FlowLayout.CENTER, 5, 5));
            ui.add (show);
            final CardLayout cl = new CardLayout ();
            final JPanel cards = new JPanel (cl);
            ui.add (cards);
            cards.add (new JPanel (), "notext");
            cards.add (new JTextField (8), "text");
            ItemListener al = new ItemListener () {
                public void itemStateChanged (ItemEvent ie) {
                    if (show.isSelected ()) {
                        cl.show (cards, "text");
                    } else {
                        cl.show (cards, "notext");
                    }
                }}
            ;
            show.addItemListener (al);
            JOptionPane.showMessageDialog (null, ui);
        }}
    ;
    SwingUtilities.invokeLater (r);
}

}
