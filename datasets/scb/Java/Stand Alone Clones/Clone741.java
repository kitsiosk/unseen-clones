public class Clone741 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15644319
*  Stack Overflow answer #:15644939
*  And Stack Overflow answer#:15644537
*/
public static void main (String [] args) {
    String [] columnNames = {"Item", "Description"};
    Object [] [] data = {{"Item 1", "Description of Item 1"}, {"Item 2", "Description of Item 2"}, {"Item 3", "Description of Item 3"}};
    JTable table = new JTable (data, columnNames);
    table.getColumnModel ().getColumn (1).setPreferredWidth (300);
    table.setPreferredScrollableViewportSize (table.getPreferredSize ());
    JScrollPane scrollPane = new JScrollPane (table);
    TablePopupEditor popupEditor = new TablePopupEditor ();
    table.getColumnModel ().getColumn (1).setCellEditor (popupEditor);
    JFrame frame = new JFrame ("Popup Editor Test");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.add (new JTextField (), BorderLayout.NORTH);
    frame.add (scrollPane);
    frame.pack ();
    frame.setLocationRelativeTo (null);
    frame.setVisible (true);
}

public static void main (String st []) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            TableFileChooser td = new TableFileChooser ();
            td.prepareAndShowGUI ();
        }}
    );
}

}
