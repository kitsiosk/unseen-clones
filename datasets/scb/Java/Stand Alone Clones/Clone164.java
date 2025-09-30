public class Clone164 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17138614
*  Stack Overflow answer #:23601527
*  And Stack Overflow answer#:17138782
*/
public static void main (String [] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
    File in = new File ("C:\\Users\\Sandra\\Desktop\\music\\rags.wav");
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (in);
    Clip play = AudioSystem.getClip ();
    play.open (audioInputStream);
    FloatControl volume = (FloatControl) play.getControl (FloatControl.Type.MASTER_GAIN);
    volume.setValue (1.0f);
    play.start ();
    play.drain ();
    play.close ();
}

public static void main (String [] args) throws Exception {
    File in = new File ("C:\\Users\\Sandra\\Desktop\\music\\rags.wav");
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream (in);
    Clip play = AudioSystem.getClip ();
    play.open (audioInputStream);
    FloatControl volume = (FloatControl) play.getControl (FloatControl.Type.MASTER_GAIN);
    volume.setValue (1.0f);
    play.start ();
    SwingUtilities.invokeLater (new Runnable () {
        public void run () {
            JOptionPane.showMessageDialog (null, "Close to exit!");
        }}
    );
}

}
