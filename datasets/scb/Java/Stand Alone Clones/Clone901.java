public class Clone901 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:24361899
*  Stack Overflow answer #:24388952
*  And Stack Overflow answer#:24362101
*/
public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            mainFrame = new JFrame ("test");
            mainFrame.setSize (800, 600);
            mainFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
            mainFrame.setVisible (true);
            A a = new A ();
        }}
    );
}

public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            mainFrame = new JFrame ("test");
            mainFrame.setSize (800, 600);
            mainFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
            mainFrame.setVisible (true);
            final A a = new A ();
            mainFrame.addWindowListener (new WindowAdapter () {
                @Override
                public void windowDeactivated (WindowEvent e) {
                    a.setAlwaysOnTop (false);
                }@Override
                public void windowActivated (WindowEvent e) {
                    a.setAlwaysOnTop (true);
                }}
            );
        }}
    );
}

}
