public class Clone522 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7913938
*  Stack Overflow answer #:7914121
*  And Stack Overflow answer#:7914356
*/
public void run () {
    JFrame frame = new JFrame ("Menu test");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setSize (new Dimension (600, 400));
    JMenuBar menuBar = new JMenuBar ();
    JMenu menu = new JMenu ("Test");
    JPopupMenu popupMenu = menu.getPopupMenu ();
    popupMenu.setLayout (new GridLayout (5, 5));
    for (int r = 0;
    r < 5; r ++) {
        for (int c = 0;
        c < 5; c ++) {
            popupMenu.add (new JMenuItem ("(" + (r + 1) + ", " + (c + 1) + ")"));
        }
    }
    menuBar.add (menu);
    frame.setJMenuBar (menuBar);
    frame.setVisible (true);
}

public void run () {
    JMenuBar menuBar = new JMenuBar ();
    JMenu menu = new JMenu ("A regular menu");
    menu.add (new JMenuItem ("Menu item"));
    JMenu gridMenu = new JMenu ("Menu with grid");
    gridMenu.getPopupMenu ().setLayout (new GridLayout (2, 2));
    gridMenu.add ("Top left");
    gridMenu.add ("Top right");
    gridMenu.add ("Bottom left");
    gridMenu.add ("Bottom right");
    menu.add (gridMenu);
    menuBar.add (menu);
    JFrame frame = new JFrame ("Menus");
    frame.setJMenuBar (menuBar);
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.pack ();
    frame.setVisible (true);
}

}
