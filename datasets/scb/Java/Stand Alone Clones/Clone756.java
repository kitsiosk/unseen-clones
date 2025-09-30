public class Clone756 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18588765
*  Stack Overflow answer #:19089152
*  And Stack Overflow answer#:19190175
*/
public void start (Stage primaryStage) throws Exception {
    AnchorPane root = new AnchorPane ();
    root.setStyle ("-fx-padding:20;-fx-background-color:dodgerblue;");
    final TextArea textArea = new TextArea ();
    AnchorPane.setTopAnchor (textArea, 10.0);
    AnchorPane.setLeftAnchor (textArea, 10.0);
    AnchorPane.setRightAnchor (textArea, 10.0);
    root.getChildren ().add (textArea);
    primaryStage.setScene (new Scene (root, 400, 300));
    primaryStage.show ();
    ScrollBar scrollBar = lookupVerticalScrollBar (textArea);
    scrollBar.setOpacity (0.0);
    scrollBar.visibleProperty ().addListener (new ChangeListener < Boolean > () {
        @Override
        public void changed (ObservableValue < ? extends Boolean > source, Boolean wasVisible, Boolean isVisible) {
            if (isVisible) {
                textArea.setPrefRowCount (textArea.getPrefRowCount () + 1);
                textArea.requestLayout ();
            }
        }}
    );
}

public void start (Stage primaryStage) {
    final TextArea textArea = new TextArea ();
    textArea.setPrefSize (200, 40);
    textArea.setWrapText (true);
    textHolder.textProperty ().bind (textArea.textProperty ());
    textHolder.layoutBoundsProperty ().addListener (new ChangeListener < Bounds > () {
        @Override
        public void changed (ObservableValue < ? extends Bounds > observable, Bounds oldValue, Bounds newValue) {
            if (oldHeight != newValue.getHeight ()) {
                System.out.println ("newValue = " + newValue.getHeight ());
                oldHeight = newValue.getHeight ();
                textArea.setPrefHeight (textHolder.getLayoutBounds ().getHeight () + 20);
            }
        }}
    );
    Group root = new Group (textArea);
    Scene scene = new Scene (root, 300, 250);
    primaryStage.setScene (scene);
    primaryStage.show ();
}

}
