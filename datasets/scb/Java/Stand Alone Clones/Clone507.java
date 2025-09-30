public class Clone507 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17874717
*  Stack Overflow answer #:24637165
*  And Stack Overflow answer#:17874718
*/
public static void main (String [] args) {
    EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            MigLayoutGaps2 ex = new MigLayoutGaps2 ();
            ex.setVisible (true);
        }}
    );
}

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

}
