public class Clone472 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10769895
*  Stack Overflow answer #:10770381
*  And Stack Overflow answer#:10770381
*/
public void run () {
    countCalled ++;
    if (countCalled < maxCalled) {
        if (countCalled % 3 == 0) {
            SwingUtilities.invokeLater (new Runnable () {
                @Override
                public void run () {
                    System.out.println ("Push a new event to EDT");
                    frame1.getContentPane ().setBackground (Color.red);
                    isThereReallyEDT ();
                }}
            );
        } else {
            if (this.getExecutionTime () < ALLOWED_TARDINESS) {
                countRun ++;
                isThereReallyEDT ();
            }
        }
    } else {
        System.out.println ("Terminating this madness");
        System.exit (0);
    }
}

public void run () {
    JFrame frame2 = new JFrame ("Frame 2");
    frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame2.getContentPane ().add (new JLabel ("Hello in frame 2"));
    frame2.pack ();
    frame2.setLocation (200, 200);
    frame2.setVisible (true);
    isThereReallyEDT ();
}

}
