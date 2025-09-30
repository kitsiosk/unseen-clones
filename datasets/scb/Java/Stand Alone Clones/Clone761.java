public class Clone761 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14121918
*  Stack Overflow answer #:14122435
*  And Stack Overflow answer#:14122455
*/
public static void main (final String [] args) {
    final JFrame f = new JFrame ();
    f.setBounds (200, 200, 400, 400);
    f.setVisible (true);
    {
        try {
            Thread.sleep (2345);
        } catch (final InterruptedException ignore) {
        }
    } {
        final JTextField t = new JTextField ("Hello World!");
        t.addFocusListener (new FocusListener () {
            @Override
            public void focusLost (final FocusEvent pE) {
            }@Override
            public void focusGained (final FocusEvent pE) {
                t.selectAll ();
            }}
        );
        f.add (t);
        f.validate ();
        t.requestFocus ();
    }}

public static void main (String...args) {
    EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            new SelectAll ().displayGUI ();
        }}
    );
}

}
