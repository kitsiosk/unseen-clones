public class Clone657 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6793257
*  Stack Overflow answer #:6798013
*  And Stack Overflow answer#:6796673
*/
public void show (String columnName) {
    IndexedColumn ic = hidden.remove (columnName);
    if (ic != null) {
        tcm.addColumn (ic.column);
        int lastColumn = tcm.getColumnCount () - 1;
        if (ic.index < lastColumn) {
            tcm.moveColumn (lastColumn, ic.index);
        }
    }
}

public void show (String columnName) {
    Object o = hiddenColumns.remove (columnName);
    if (o == null) {
        return;
    }
    tcm.addColumn ((TableColumn) o);
    o = hiddenColumns.remove (":" + columnName);
    if (o == null) {
        return;
    }
    int column = ((Integer) o).intValue ();
    int lastColumn = tcm.getColumnCount () - 1;
    if (column < lastColumn) {
        tcm.moveColumn (lastColumn, column);
    }
}

}
