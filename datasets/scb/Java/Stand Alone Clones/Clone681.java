public class Clone681 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:40777551
*  Stack Overflow answer #:40777765
*  And Stack Overflow answer#:40778001
*/
public static void main (String [] args) {
    JFrame frame = new JFrame ();
    frame.setTitle ("Stackoverflow");
    JButton button = new JButton ("Change Size");
    button.setVisible (true);
    frame.getContentPane ().add (button, BorderLayout.SOUTH);
    frame.setSize (200, 200);
    frame.setVisible (true);
    button.addActionListener (new ActionListener () {
        @Override
        public void actionPerformed (ActionEvent e) {
            frame.setSize (frame.getWidth (), frame.getHeight () + 50);
        }}
    );
}

public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            new Main ();
        }}
    );
}

}
