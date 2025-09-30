public class Clone931 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15210979
*  Stack Overflow answer #:19935987
*  And Stack Overflow answer#:20251728
*/
private void expandAllNodes (JTree tree, int startingIndex, int rowCount) {
    for (int i = startingIndex;
    i < rowCount; ++ i) {
        tree.expandRow (i);
    }
    if (tree.getRowCount () != rowCount) {
        expandAllNodes (tree, rowCount, tree.getRowCount ());
    }
}

private void expandAllNodes (JTree tree) {
    int j = tree.getRowCount ();
    int i = 0;
    while (i < j) {
        tree.expandRow (i);
        i += 1;
        j = tree.getRowCount ();
    }
}

}
