public class Clone24 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:42556279
*  Stack Overflow answer #:42575276
*  And Stack Overflow answer#:42560392
*/
public boolean importData (TransferHandler.TransferSupport info) {
    if (! canImport (info)) {
        return false;
    }
    TransferHandler.DropLocation tdl = info.getDropLocation ();
    if (! (tdl instanceof JTable.DropLocation)) {
        return false;
    }
    JTable.DropLocation dl = (JTable.DropLocation) tdl;
    JTable target = (JTable) info.getComponent ();
    DefaultTableModel model = (DefaultTableModel) target.getModel ();
    int index = dl.getRow ();
    int max = model.getRowCount ();
    if (index < 0 || index > max) {
        index = max;
    }
    addIndex = index;
    target.setCursor (Cursor.getPredefinedCursor (Cursor.DEFAULT_CURSOR));
    try {
        Object [] values = (Object []) info.getTransferable ().getTransferData (localObjectFlavor);
        addCount = values.length;
        for (int i = 0;
        i < values.length; i ++) {
            int idx = index ++;
            model.insertRow (idx, (Vector) values [i]);
            target.getSelectionModel ().addSelectionInterval (idx, idx);
        }
        return true;
    } catch (UnsupportedFlavorException | IOException ex) {
        ex.printStackTrace ();
    }
    return false;
}

public boolean importData (JComponent c, Transferable t) {
    if (canImport (c, t.getTransferDataFlavors ())) {
        try {
            String str = (String) t.getTransferData (DataFlavor.stringFlavor);
            importString (c, str);
            return true;
        } catch (UnsupportedFlavorException ufe) {
        } catch (IOException ioe) {
        }
    }
    return false;
}

}
