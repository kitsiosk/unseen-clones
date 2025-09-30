public class Clone622 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16855677
*  Stack Overflow answer #:25832863
*  And Stack Overflow answer#:16866962
*/
public void start (final Stage primaryStage) {
    Group rootGroup = new Group ();
    Label label = new Label ("Demo Text");
    try {
        final Font f = Font.loadFont (new FileInputStream (new File ("./myFonts/TRON.TTF")), 12);
        label.setFont (f);
    } catch (FileNotFoundException e) {
        e.printStackTrace ();
    }
    rootGroup.getChildren ().add (label);
    Scene scene = new Scene (rootGroup, 640, 480, Color.WHITE);
    primaryStage.setScene (scene);
    primaryStage.show ();
}

public void start (Stage stage) {
    stage.setTitle ("TRON Synopsis");
    Font.loadFont (CustomFontApp.class.getResource ("TRON.TTF").toExternalForm (), 10);
    Label title = new Label ("TRON");
    title.getStyleClass ().add ("title");
    Label caption = new Label ("A sci-fi flick set in an alternate reality.");
    caption.getStyleClass ().add ("caption");
    caption.setMaxWidth (220);
    caption.setWrapText (true);
    caption.setTextAlignment (TextAlignment.CENTER);
    VBox layout = new VBox (10);
    layout.setStyle ("-fx-padding: 20px; -fx-background-color: silver");
    layout.setAlignment (Pos.CENTER);
    layout.getChildren ().setAll (title, new ImageView (new Image ("http://ia.media-imdb.com/images/M/MV5BMTY5NjM2MjAwOV5BMl5BanBnXkFtZTYwMTgyMzA5.V1.SY317.jpg")), caption);
    final Scene scene = new Scene (layout);
    scene.getStylesheets ().add (getClass ().getResource ("custom-font-styles.css").toExternalForm ());
    stage.setScene (scene);
    stage.show ();
}

}
