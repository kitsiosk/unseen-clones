public class Clone374 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10862760
*  Stack Overflow answer #:10862971
*  And Stack Overflow answer#:10862931
*/
public void actionPerformed (ActionEvent evt) {
    NewComboBox combo = (NewComboBox) evt.getSource ();
    String selection = combo.getSelectedItem ().toString ();
    for (int i = 0;
    i < comboBoxes.length; i ++) {
        NewComboBox comboI = comboBoxes [i];
        if (comboI != combo && comboI.getSelectedItem ().equals (selection)) {
            comboI.setSelectedItem (combo.getPreviousSelectedItem ());
        }
    }
}

public void actionPerformed (ActionEvent e) {
    String item = (String) mainComboBox.getSelectedItem ();
    Object o = subItems.get (item);
    if (o == null) {
        subComboBox.setModel (new DefaultComboBoxModel ());
    } else {
        subComboBox.setModel (new DefaultComboBoxModel ((String []) o));
    }
}

}
