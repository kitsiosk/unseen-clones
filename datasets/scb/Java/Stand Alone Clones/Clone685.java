public class Clone685 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13341857
*  Stack Overflow answer #:13344896
*  And Stack Overflow answer#:13344337
*/
public static void main (String [] args) {
    javax.swing.SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels ()) {
                    if ("Nimbus".equals (info.getName ())) {
                        UIManager.setLookAndFeel (info.getClassName ());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace ();
            }
            Test test = new Test ();
        }}
    );
}

public static void main (String [] args) {
    EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            createAndShowGUI ();
        }}
    );
}

}
