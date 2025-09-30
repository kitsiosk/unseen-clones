public class Clone286 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:22440733
*  Stack Overflow answer #:35661712
*  And Stack Overflow answer#:22441642
*/
public static void main (String [] args) {
    EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            JFrame main_frame = new JFrame ();
            main_frame.setPreferredSize (new Dimension (1200, 300));
            main_frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            ArrayList < String > nonsense = new ArrayList < String > (Arrays.asList ("Lorem ipsum dolor sit amet, sed dolore vivendum ut", "pri an soleat causae doctus.", "Alienum abhorreant mea ea", "cum malorum diceret ei. Pri oratio invidunt consequat ne.", "Ius tritani detraxit scribentur et", "has detraxit legendos intellegat at", "quo oporteat constituam ex"));
            JTable example_table = new JTable (10, 4);
            example_table.setRowHeight (example_table.getRowHeight () * 2);
            DefaultCellEditor cell_editor = new SelectableNonEditableCellEditor (new JTextField ());
            cell_editor.setClickCountToStart (1);
            example_table.setDefaultEditor (Object.class, cell_editor);
            TableCellRenderer renderer = new SelectableNonEditableTableRenderer ();
            example_table.setDefaultRenderer (Object.class, renderer);
            for (int i = 0;
            i < 10; i ++) {
                example_table.setValueAt (nonsense.get (i % nonsense.size ()), i, i % 4);
            }
            main_frame.getContentPane ().add (new JScrollPane (example_table));
            main_frame.pack ();
            main_frame.setVisible (true);
        }}
    );
}

public static void main (String args []) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            createAndShowGUI (new JTableTest ().panel, "Test");
        }}
    );
}

}
