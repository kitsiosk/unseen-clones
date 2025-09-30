public class Clone892 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17571593
*  Stack Overflow answer #:31687182
*  And Stack Overflow answer#:17579619
*/
@Override
public void start (Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader (getClass ().getResource ("/sample/screen.fxml"));
    AnchorPane shadowPane = loader.load ();
    AnchorPane rootPane = (AnchorPane) shadowPane.lookup ("#rootPane");
    rootPane.setStyle ("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);" + "-fx-background-color: white;");
    Scene scene = new Scene (shadowPane);
    stage.setScene (scene);
    shadowPane.setBorder (new Border (new BorderStroke (Color.RED, BorderStrokeStyle.SOLID, null, null)));
    shadowPane.setStyle ("-fx-background-color: transparent;");
    scene.setFill (Color.TRANSPARENT);
    stage.initStyle (StageStyle.TRANSPARENT);
    stage.show ();
}

public void start (final Stage primaryStage) {
    final WebView webView = new WebView ();
    final ModalDialog dialog = createWebViewPreferenceDialog (primaryStage, webView);
    webView.getEngine ().getLoadWorker ().stateProperty ().addListener (new ChangeListener < Worker.State > () {
        @Override
        public void changed (ObservableValue < ? extends Worker.State > observableValue, Worker.State state, Worker.State newState) {
            if (newState.equals (Worker.State.SUCCEEDED)) {
                dialog.show ();
                dialog.toFront ();
            }
        }}
    );
    webView.getEngine ().load ("http://docs.oracle.com/javafx/");
    primaryStage.setTitle ("Modal Confirm Example");
    primaryStage.setScene (new Scene (webView));
    primaryStage.show ();
}

}
