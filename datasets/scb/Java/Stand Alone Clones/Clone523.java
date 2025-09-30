public class Clone523 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:45068150
*  Stack Overflow answer #:45068692
*  And Stack Overflow answer#:45068812
*/
public Ships () {
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setBounds (0, 0, 1363, 730);
    contentPane = new JPanel ();
    setContentPane (contentPane);
    contentPane.setLayout (null);
    setVisible (true);
    l5.setIcon (new ImageIcon ("C:\\Users\\The Wimpster\\Desktop\\images22.png"));
    contentPane.add (l5);
    l5.setBounds (0, 10, 75, 50);
    contentPane.addMouseMotionListener (new MouseAdapter () {
        public void mouseMoved (MouseEvent e) {
            p = e.getX ();
            l = e.getY ();
            l5.setBounds (p, l, 150, 50);
        }}
    );
}

public Ships () {
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setSize (500, 500);
    l5.setIcon (new ImageIcon ("C:\\Users\\The Wimpster\\Desktop\\images22.png"));
    add (l5);
    l5.setBounds (0, 10, 75, 50);
    addMouseMotionListener (new MouseAdapter () {
        public void mouseMoved (MouseEvent e) {
            int x = e.getX ();
            int y = e.getY ();
            int imgWidth = 50;
            int imgHeight = 50;
            l5.setBounds (x - (imgWidth / 2), y - (imgHeight / 2), imgWidth, imgHeight);
            l5.repaint ();
        }}
    );
    setVisible (true);
}

}
