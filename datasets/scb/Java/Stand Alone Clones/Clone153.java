public class Clone153 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14615888
*  Stack Overflow answer #:14616065
*  And Stack Overflow answer#:14616064
*/
public void actionPerformed (ActionEvent e) {
    JPanel panel = new JPanel ();
    panel.add (new JLabel ("Hello"));
    panel.setBorder (new MatteBorder (0, 0, 1, 0, Color.GRAY));
    GridBagConstraints gbc = new GridBagConstraints ();
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    mainList.add (panel, gbc, 0);
    validate ();
    repaint ();
}

public void actionPerformed (ActionEvent e) {
    final JPanel newPanel = new JPanel ();
    newPanel.add (new JLabel ("Label " + i ++));
    listContainer.add (newPanel);
    listContainer.revalidate ();
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            newPanel.scrollRectToVisible (newPanel.getBounds ());
        }}
    );
}

}
