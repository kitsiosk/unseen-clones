public class Clone142 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12115275
*  Stack Overflow answer #:12115436
*  And Stack Overflow answer#:12115436
*/
public void actionPerformed (ActionEvent e) {
    JFrame owner = (JFrame) SwingUtilities.getWindowAncestor ((Component) e.getSource ());
    final JDialog dialog = new JDialog (owner, "Dialog", ModalityType.APPLICATION_MODAL);
    dialog.getContentPane ().add (panel);
    dialog.pack ();
    dialog.setLocation (0, 0);
    int delay = 20;
    new Timer (delay, new ActionListener () {
        int x = 0;
        int y = 0;
        Dimension scrn = Toolkit.getDefaultToolkit ().getScreenSize ();
        @Override
        public void actionPerformed (ActionEvent e) {
            int maxX = scrn.width - dialog.getWidth ();
            int maxY = scrn.height - dialog.getHeight ();
            if (x < maxX && y < maxY) {
                x ++;
                y ++;
                dialog.setLocation (x, y);
            } else {
                ((Timer) e.getSource ()).stop ();
            }
        }}
    ).start ();
    dialog.setVisible (true);
}

public void actionPerformed (ActionEvent e) {
    int maxX = scrn.width - dialog.getWidth ();
    int maxY = scrn.height - dialog.getHeight ();
    if (x < maxX && y < maxY) {
        x ++;
        y ++;
        dialog.setLocation (x, y);
    } else {
        ((Timer) e.getSource ()).stop ();
    }
}

}
