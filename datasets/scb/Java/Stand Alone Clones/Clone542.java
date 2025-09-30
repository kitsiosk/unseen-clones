public class Clone542 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9762747
*  Stack Overflow answer #:9763337
*  And Stack Overflow answer#:9763090
*/
public void propertyChange (PropertyChangeEvent evt) {
    if (evt.getPropertyName ().equals (ListenToModel.ADD)) {
        JLabel label = createLabel (evt);
        for (Component comp : mainPanel.getComponents ()) {
            comp.setBackground (null);
        }
        int index = ((IndexedPropertyChangeEvent) evt).getIndex ();
        mainPanel.add (label, index);
        label.setBackground (SELECTED_COLOR);
        selectedIndex = index;
    } else if (evt.getPropertyName ().equals (ListenToModel.REMOVE)) {
        int index = ((IndexedPropertyChangeEvent) evt).getIndex ();
        mainPanel.remove (index);
        for (Component comp : mainPanel.getComponents ()) {
            comp.setBackground (null);
        }
        selectedIndex = - 1;
    } else if (evt.getPropertyName ().equals (ListenToModel.REMOVE_ALL)) {
        mainPanel.removeAll ();
        selectedIndex = - 1;
    }
    mainPanel.revalidate ();
    mainPanel.repaint ();
}

public void propertyChange (PropertyChangeEvent pce) {
    if (MVC_Model.PROGRESS.equals (pce.getPropertyName ())) {
        view.setProgress ((Integer) pce.getNewValue ());
    }
    if (MVC_Model.PROGRESS1.equals (pce.getPropertyName ())) {
        view.setProgressLabel ((String) pce.getNewValue ());
    }
    if (MVC_Model.PROGRESS2.equals (pce.getPropertyName ())) {
        view.setIconLabel ((Icon) pce.getNewValue ());
    }
}

}
