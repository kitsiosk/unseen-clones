public class Clone740 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15644319
*  Stack Overflow answer #:15644939
*  And Stack Overflow answer#:19030725
*/
public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int row, int column) {
    SwingUtilities.invokeLater (new Runnable () {
        public void run () {
            System.out.println ("run");
            popup.setText (currentText);
            Point p = editorComponent.getLocationOnScreen ();
            popup.setLocation (p.x, p.y + editorComponent.getSize ().height);
            popup.show ();
            fireEditingStopped ();
        }}
    );
    currentText = value.toString ();
    editorComponent.setText (currentText);
    return editorComponent;
}

public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int row, int column) {
    file = value.toString ();
    SwingUtilities.invokeLater (new Runnable () {
        public void run () {
            fileChooser.setSelectedFile (new File (file));
            if (fileChooser.showOpenDialog (button) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile ().getAbsolutePath ();
            }
            fireEditingStopped ();
        }}
    );
    button.setText (file);
    return button;
}

}
