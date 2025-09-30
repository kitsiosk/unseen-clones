public class Clone137 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11133301
*  Stack Overflow answer #:11133329
*  And Stack Overflow answer#:11133425
*/
public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            initUI ();
        }}
    );
}

public static void main (final String args []) {
    EventQueue.invokeLater (new Runnable () {
        public void run () {
            try {
                UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
            } catch (Exception e) {
                e.printStackTrace ();
            }
            JFrame f = new JFrame ("JScrollableToolTip");
            f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            f.setSize (300, 200);
            f.setLocationRelativeTo (null);
            ToolTipManager.sharedInstance ().setInitialDelay (500);
            ToolTipManager.sharedInstance ().setDismissDelay (10000);
            ToolTipManager.sharedInstance ().mousePressed (null);
            JTable table = new JTable (50, 4) {
                private static final long serialVersionUID = 1L;
                @Override
                public JToolTip createToolTip () {
                    JScrollableToolTip tip = new JScrollableToolTip (3, 20);
                    tip.setComponent (this);
                    return tip;
                }}
            ;
            table.setDefaultRenderer (Object.class, new DefaultTableCellRenderer () {
                private static final long serialVersionUID = 1L;
                @Override
                public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
                    setToolTipText ("Row " + row + " Column " + column + "\nUsed to display a 'Tip' for a Component. " + "Typically components provide api to automate the process of " + "using ToolTips. For example, any Swing component can use the " + "JComponent  setToolTipText method to specify the text for a standard tooltip.");
                    return this;
                }}
            );
            f.add (new JScrollPane (table));
            f.setVisible (true);
        }}
    );
}

}
