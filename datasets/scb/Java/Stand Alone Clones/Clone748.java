public class Clone748 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11569076
*  Stack Overflow answer #:11569223
*  And Stack Overflow answer#:11569223
*/
public void actionPerformed (ActionEvent e) {
    int index = list.getSelectedIndex ();
    listModel.remove (index);
    int size = listModel.getSize ();
    if (size == 0) {
        fireButton.setEnabled (false);
    } else {
        if (index == listModel.getSize ()) {
            index --;
        }
        list.setSelectedIndex (index);
        list.ensureIndexIsVisible (index);
    }
}

public void actionPerformed (ActionEvent e) {
    String name = employeeName.getText ();
    if (name.equals ("") || alreadyInList (name)) {
        Toolkit.getDefaultToolkit ().beep ();
        employeeName.requestFocusInWindow ();
        employeeName.selectAll ();
        return;
    }
    int index = list.getSelectedIndex ();
    if (index == - 1) {
        index = 0;
    } else {
        index ++;
    }
    listModel.insertElementAt (employeeName.getText (), index);
    employeeName.requestFocusInWindow ();
    employeeName.setText ("");
    list.setSelectedIndex (index);
    list.ensureIndexIsVisible (index);
}

}
