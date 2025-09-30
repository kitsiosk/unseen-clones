public class Clone731 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:41403166
*  Stack Overflow answer #:41403256
*  And Stack Overflow answer#:41403735
*/
public static void main (String [] args) {
    JFrame start_frame = new JFrame ("P.D");
    int width = 1200;
    int height = 800;
    start_frame.setSize (width, height);
    start_frame.setVisible (true);
    start_frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    JPanel start_panel = new JPanel ();
    start_panel.setLayout (null);
    start_frame.add (start_panel);
    JButton start_button = new JButton ("Start");
    buttonWidth = 80;
    buttonHeight = 20;
    start_button.setBounds (new Rectangle ((width - buttonWidth) / 2, (height - buttonHeight) / 2, buttonWidth, buttonHeight));
    start_button.setSize (new Dimension (buttonWidth, buttonHeight));
    start_button.setFocusable (false);
    start_panel.add (start_button);
}

public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            new MainGUIJFrame ().setVisible (true);
        }}
    );
}

}
