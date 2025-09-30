public class Clone285 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:22440733
*  Stack Overflow answer #:22441678
*  And Stack Overflow answer#:35661712
*/
public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int row, int column) {
    _value = value;
    JTextField textField = new JTextField (_value.toString ());
    textField.addKeyListener (new KeyAdapter () {
        public void keyTyped (KeyEvent e) {
            e.consume ();
        }@Override
        public void keyPressed (KeyEvent e) {
            e.consume ();
        }}
    );
    textField.setEditable (false);
    return textField;
}

public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int row, int col) {
    Component comp = super.getTableCellEditorComponent (table, value, isSelected, row, col);
    if (value instanceof java.lang.String) {
        DefaultStyledDocument sty_doc = new DefaultStyledDocument ();
        try {
            sty_doc.insertString (0, (String) value, null);
        } catch (BadLocationException e) {
            e.printStackTrace ();
        }
        JTextPane jtp_comp = new JTextPane (sty_doc);
        jtp_comp.setEditable (false);
        return jtp_comp;
    }
    return comp;
}

}
