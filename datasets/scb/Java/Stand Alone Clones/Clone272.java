public class Clone272 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6390240
*  Stack Overflow answer #:6390444
*  And Stack Overflow answer#:6395105
*/
public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            JFrame frame = new JFrame ();
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            frame.setSize (new Dimension (300, 300));
            frame.add (new Panel ());
            frame.setVisible (true);
        }}
    );
}

public static void main (String [] args) {
    javax.swing.SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            ValidateRevalidateRepaint rVR = new ValidateRevalidateRepaint ();
        }}
    );
}

}
