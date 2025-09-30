public class Clone698 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2666758
*  Stack Overflow answer #:8082598
*  And Stack Overflow answer#:26093254
*/
public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            FixedRow2Tables frame = new FixedRow2Tables ();
            frame.addWindowListener (new WindowAdapter () {
                @Override
                public void windowClosing (WindowEvent e) {
                    System.exit (0);
                }}
            );
            frame.pack ();
            frame.setVisible (true);
        }}
    );
}

public static void main (String args []) {
    SwingUtilities.invokeLater (new Runnable () {
        public void run () {
            Application application = new Application ();
            application.setVisible (true);
        }}
    );
}

}
