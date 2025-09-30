public class Clone509 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17874717
*  Stack Overflow answer #:17874718
*  And Stack Overflow answer#:22525005
*/
public static void main (String [] args) {
    Runnable r = new Runnable () {
        @Override
        public void run () {
            WhiteSpace ws = new WhiteSpace ();
            Container gui = ws.getGui ();
            JFrame f = new JFrame ("White (OK Red) Space");
            f.add (gui);
            f.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform (true);
            f.setResizable (false);
            f.pack ();
            f.setVisible (true);
        }}
    ;
    SwingUtilities.invokeLater (r);
}

public static void main (String [] args) {
    Runnable runnable = new Runnable () {
        @Override
        public void run () {
            whiteSpace = new WhiteSpace ();
        }}
    ;
    SwingUtilities.invokeLater (runnable);
}

}
