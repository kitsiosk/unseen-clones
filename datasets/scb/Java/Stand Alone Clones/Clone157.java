public class Clone157 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10413007
*  Stack Overflow answer #:10413462
*  And Stack Overflow answer#:10413419
*/
public static void main (String [] args) {
    JFrame frame = new JFrame ();
    frame.setLayout (new GridLayout (9, 9));
    frame.getContentPane ().setPreferredSize (new Dimension (300, 300));
    final Random random = new Random ();
    for (int i = 0;
    i < 9; i ++) {
        for (int j = 0;
        j < 9; j ++) {
            final JLabel label = new JLabel ("", JLabel.CENTER);
            label.setBorder (BorderFactory.createLineBorder (Color.LIGHT_GRAY));
            label.addMouseListener (new MouseAdapter () {
                public void mousePressed (MouseEvent e) {
                    label.setText ("" + random.nextInt (100));
                }}
            );
            frame.add (label);
        }
    }
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.pack ();
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        public void run () {
            Image selected = getImage (true);
            Image unselected = getImage (false);
            int row = 2;
            int col = 5;
            JPanel p = new JPanel (new GridLayout (row, col));
            for (int ii = 0;
            ii < row * col; ii ++) {
                p.add (getButton (selected, unselected));
            }
            JOptionPane.showMessageDialog (null, p);
        }}
    );
}

}
