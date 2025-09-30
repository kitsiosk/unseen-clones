public class Clone723 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:26757243
*  Stack Overflow answer #:26758033
*  And Stack Overflow answer#:26759356
*/
public void actionPerformed (ActionEvent e) {
    if (! connected) {
        JOptionPane.showMessageDialog (null, "Connected");
        putValue (NAME, "Disonnect");
        connected = true;
    } else {
        JOptionPane.showMessageDialog (null, "Disconnected");
        putValue (NAME, "Connect");
        connected = false;
    }
}

public void actionPerformed (ActionEvent e) {
    SwingUtilities.invokeLater (new Runnable () {
        public void run () {
            if (! isConnected) {
                System.out.println ("connect action");
                connect ();
                isConnected = true;
            } else {
                System.out.println ("disconnect action");
                disconnect ();
                isConnected = false;
            }
        }}
    );
}

}
