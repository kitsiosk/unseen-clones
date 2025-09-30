public class Clone893 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:37541279
*  Stack Overflow answer #:37541701
*  And Stack Overflow answer#:37541777
*/
public void start (Stage primaryStage) {
    try {
        StackPane root = new StackPane ();
        Text text2 = new Text ("I will be aligned TOPLEFT");
        Text text = new Text (" Level 2 \n\n" + "Press ENTER to start a new game");
        text.setTextAlignment (TextAlignment.CENTER);
        root.getChildren ().addAll (text2, text);
        StackPane.setAlignment (text2, Pos.TOP_LEFT);
        StackPane.setAlignment (text, Pos.CENTER);
        Scene scene = new Scene (root, 400, 400);
        primaryStage.setScene (scene);
        primaryStage.show ();
    } catch (Exception e) {
        e.printStackTrace ();
    }
}

public void start (Stage primaryStage) {
    Text waitingForKey = new Text ("Level 2 \n\n" + "Press ENTER to start a new game");
    waitingForKey.setTextAlignment (TextAlignment.CENTER);
    waitingForKey.setFont (new Font (18));
    waitingForKey.setFill (Color.ALICEBLUE);
    StackPane root = new StackPane ();
    root.getChildren ().add (waitingForKey);
    Scene scene = new Scene (root, 320, 240, Color.BLACK);
    primaryStage.setTitle ("Test");
    primaryStage.setScene (scene);
    primaryStage.show ();
}

}
