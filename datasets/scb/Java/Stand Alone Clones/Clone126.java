public class Clone126 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13003323
*  Stack Overflow answer #:13003602
*  And Stack Overflow answer#:18202579
*/
public void start (Stage primaryStage) {
    try {
        stage = primaryStage;
        gotoLogin ();
        primaryStage.show ();
    } catch (Exception ex) {
        Logger.getLogger (App.class.getName ()).log (Level.SEVERE, null, ex);
    }
}

@Override
public void start (Stage stage) throws Exception {
    URL location = getClass ().getResource ("Main.fxml");
    FXMLLoader fxmlLoader = new FXMLLoader ();
    fxmlLoader.setLocation (location);
    fxmlLoader.setBuilderFactory (new JavaFXBuilderFactory ());
    Parent root = (Parent) fxmlLoader.load (location.openStream ());
    Scene scene = new Scene (root);
    stage.setScene (scene);
    MainController mainController = fxmlLoader.getController ();
    mainController.setStage (stage);
    mainController.showStage ();
}

}
