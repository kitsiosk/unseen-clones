public class Clone85 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10075841
*  Stack Overflow answer #:16770713
*  And Stack Overflow answer#:10516705
*/
public void start (Stage stage) {
    final HTMLEditor htmlEditor = new HTMLEditor ();
    stage.setScene (new Scene (htmlEditor));
    stage.setWidth (300);
    stage.setHeight (200);
    stage.show ();
    addCustomToolBarTo (htmlEditor);
    printChildren (htmlEditor, 20);
    moveFromTo (htmlEditor, "PopupButton", 0, "ToolBar", 2);
    moveFromTo (htmlEditor, "PopupButton", 1, "ToolBar", 2);
    moveFromTo (htmlEditor, "Separator", 4, "ToolBar", 2);
    moveFromTo (htmlEditor, "ComboBox", 2, "ToolBar", 2);
    moveFromTo (htmlEditor, "Separator", 5, "ToolBar", 2);
    moveFromTo (htmlEditor, "ToggleButton", 6, "ToolBar", 2);
    moveFromTo (htmlEditor, "ToggleButton", 7, "ToolBar", 2);
    moveFromTo (htmlEditor, "ToggleButton", 8, "ToolBar", 2);
    removeFrom (htmlEditor, "ToolBar", 1);
    removeFrom (htmlEditor, "ToolBar", 0);
}

public void start (Stage primaryStage) {
    final HTMLEditor htmlEditor = new HTMLEditor ();
    primaryStage.setScene (new Scene (htmlEditor));
    primaryStage.show ();
    for (Node toolBar = htmlEditor.lookup (".tool-bar");
    toolBar != null; toolBar = htmlEditor.lookup (".tool-bar")) {
        ((Pane) toolBar.getParent ()).getChildren ().remove (toolBar);
    }
}

}
