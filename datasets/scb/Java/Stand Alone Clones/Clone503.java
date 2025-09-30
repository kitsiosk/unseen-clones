public class Clone503 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:154577
*  Stack Overflow answer #:50202481
*  And Stack Overflow answer#:39532917
*/
public static void main (String [] args) {
    VolumeControllerV4 volumeControllerV4 = new VolumeControllerV4 ();
    BrightnessControllerV4 brightnessControllerV4 = new BrightnessControllerV4 ();
    ColourControllerV4 colourControllerV4 = new ColourControllerV4 ();
    List < ControllerV4 > controllerV4s = new ArrayList < > ();
    controllerV4s.add (brightnessControllerV4);
    controllerV4s.add (volumeControllerV4);
    controllerV4s.add (colourControllerV4);
    List < OnStart > controllersToInitialize = new ArrayList < > ();
    controllersToInitialize.addAll (controllerV4s);
    InitializeDeviceV4 initializeDeviceV4 = new InitializeDeviceV4 (controllersToInitialize);
    initializeDeviceV4.initialize ();
    List < OnReset > controllersToReset = new ArrayList < > ();
    controllersToReset.addAll (controllerV4s);
    ResetFunctionV4 resetFunctionV4 = new ResetFunctionV4 (controllersToReset);
    OUTER : while (true) {
        Scanner sc = new Scanner (System.in);
        System.out.println (" Enter your option \n Press 1 to increase volume \n Press 2 to decrease volume");
        System.out.println (" Press 3 to increase brightness \n Press 4 to decrease brightness");
        System.out.println (" Press 5 to increase color \n Press 6 to decrease color");
        System.out.println (" Press 7 to reset TV \n Press any other Button to shutdown");
        int button = sc.nextInt ();
        switch (button) {
            case 1 :
                {
                    volumeControllerV4.adjust (5);
                    break;
                } case 2 :
                {
                    volumeControllerV4.adjust (- 5);
                    break;
                } case 3 :
                {
                    brightnessControllerV4.adjust (5);
                    break;
                } case 4 :
                {
                    brightnessControllerV4.adjust (- 5);
                    break;
                } case 5 :
                {
                    colourControllerV4.adjust (5);
                    break;
                } case 6 :
                {
                    colourControllerV4.adjust (- 5);
                    break;
                } case 7 :
                {
                    resetFunctionV4.onReset ();
                    break;
                } default :
                System.out.println ("Shutting down...........");
                break OUTER;
        }
    }
}

public static void main (String args []) {
    try {
        Game game = new Chess ();
        Thread t1 = new Thread (game);
        t1.start ();
        Thread.sleep (1000);
        game.setRunGame (false);
        Thread.sleep (1000);
        game = new TicTacToe ();
        Thread t2 = new Thread (game);
        t2.start ();
        Thread.sleep (1000);
        game.setRunGame (false);
    } catch (Exception err) {
        err.printStackTrace ();
    }
}

}
