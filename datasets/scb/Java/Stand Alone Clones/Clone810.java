public class Clone810 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14492848
*  Stack Overflow answer #:14493395
*  And Stack Overflow answer#:14492968
*/
public void run () {
    final CardLayout cards = new CardLayout ();
    final JPanel gui = new JPanel (cards);
    gui.setBorder (new EmptyBorder (100, 300, 100, 300));
    gui.setBackground (Color.WHITE);
    gui.add (new JLabel (icon1), "label " + 1);
    gui.add (new JLabel (icon2), "label " + 2);
    gui.add (new JLabel (icon3), "label " + 3);
    gui.add (new JLabel (icon4), "label " + 4);
    gui.add (new JLabel (icon3), "label " + 5);
    gui.add (new JLabel (icon2), "label " + 6);
    ActionListener animate = new ActionListener () {
        long lastTime = - 1;
        int frameCount = 0;
        String timeString;
        DecimalFormat format = new DecimalFormat ("0.00");
        @Override
        public void actionPerformed (ActionEvent e) {
            long time = System.nanoTime ();
            if (lastTime < 0) {
                lastTime = time;
                timeString = "00.00";
            } else if (time - lastTime > 1000) {
                long duration = time - lastTime;
                double fps = 1000000000d * (double) frameCount / (double) duration;
                timeString = format.format (fps);
                frameCount = 0;
                lastTime = time;
                System.out.println (timeString);
            }
            frameCount ++;
            cards.next (gui);
        }}
    ;
    Timer timer = new Timer (5, animate);
    timer.start ();
    JOptionPane.showMessageDialog (null, gui);
    timer.stop ();
}

public void run () {
    try {
        UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
    } catch (Exception ex) {
    }
    final JPanel panel = new JPanel ();
    panel.setBackground (Color.RED);
    final JFrame frame = new JFrame ("Test");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.add (panel);
    JButton change = new JButton ("Switch");
    change.addActionListener (new ActionListener () {
        @Override
        public void actionPerformed (ActionEvent e) {
            long start = System.currentTimeMillis ();
            frame.remove (panel);
            long end = System.currentTimeMillis ();
            JPanel newPanel = new JPanel ();
            newPanel.setBackground (Color.BLUE);
            frame.add (newPanel);
            frame.validate ();
        }}
    );
    frame.add (change, BorderLayout.SOUTH);
    frame.setSize (100, 100);
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

}
