public class Clone540 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10421764
*  Stack Overflow answer #:10421884
*  And Stack Overflow answer#:10422340
*/
public static void main (String [] args) {
    new Thread (new Runnable () {
        public void run () {
            for (int i = 0;
            i < 30; i ++) {
                System.out.println ("i := " + i);
                try {
                    Thread.sleep (1000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }}
    ).start ();
    try {
        frameTest ();
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }
}

public static void main (String [] args) {
    SwingUtilities.invokeLater (new Runnable () {
        @Override
        public void run () {
            ClosingFrame cf = new ClosingFrame ();
        }}
    );
}

}
