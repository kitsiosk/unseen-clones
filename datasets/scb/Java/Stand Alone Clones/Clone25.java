public class Clone25 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:42556279
*  Stack Overflow answer #:42575276
*  And Stack Overflow answer#:42560392
*/
protected void cleanup (JComponent c, boolean remove) {
    if (remove && indices != null) {
        c.setCursor (Cursor.getPredefinedCursor (Cursor.DEFAULT_CURSOR));
        DefaultTableModel model = (DefaultTableModel) ((JTable) c).getModel ();
        if (addCount > 0) {
            for (int i = 0;
            i < indices.length; i ++) {
                if (indices [i] >= addIndex) {
                    indices [i] += addCount;
                }
            }
        }
        for (int i = indices.length - 1;
        i >= 0; i --) {
            model.removeRow (indices [i]);
        }
    }
    indices = null;
    addCount = 0;
    addIndex = - 1;
}

protected void cleanup (JComponent c, boolean remove) {
    JTable source = (JTable) c;
    if (remove && rows != null) {
        DefaultTableModel model = (DefaultTableModel) source.getModel ();
        for (int i = rows.length - 1;
        i >= 0; i --) {
            model.removeRow (rows [i]);
        }
    }
    rows = null;
    addCount = 0;
    addIndex = - 1;
}

}
