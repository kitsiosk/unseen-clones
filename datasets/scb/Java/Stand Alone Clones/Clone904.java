public class Clone904 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14292543
*  Stack Overflow answer #:14296247
*  And Stack Overflow answer#:14296247
*/
public void actionPerformed (ActionEvent ae) {
    startButton.setEnabled (false);
    count = 0;
    final ArrayList < String > chars = new ArrayList < > ();
    final ArrayList < Integer > charsTiming = new ArrayList < > ();
    for (String s : individualWordsToHighlight) {
        for (int i = 0;
        i < s.length (); i ++) {
            chars.add (String.valueOf (s.charAt (i)));
            System.out.println (String.valueOf (s.charAt (i)));
        }
    }
    for (int x = 0;
    x < timingsArray.length; x ++) {
        for (int i = 0;
        i < individualWordsToHighlight [x].length (); i ++) {
            charsTiming.add (timingsArray [x] / individualWordsToHighlight [x].length ());
            System.out.println (timingsArray [x] / individualWordsToHighlight [x].length ());
        }
    }
    new Timer (1, new AbstractAction () {
        @Override
        public void actionPerformed (ActionEvent ae) {
            if (count < charsTiming.size ()) {
                highlightNextWord ();
                ((Timer) ae.getSource ()).setInitialDelay (charsTiming.get (count));
                ((Timer) ae.getSource ()).restart ();
            } else {
                reset ();
                ((Timer) ae.getSource ()).stop ();
            }
            count ++;
        }}
    ).start ();
}

public void actionPerformed (ActionEvent ae) {
    if (count < charsTiming.size ()) {
        highlightNextWord ();
        ((Timer) ae.getSource ()).setInitialDelay (charsTiming.get (count));
        ((Timer) ae.getSource ()).restart ();
    } else {
        reset ();
        ((Timer) ae.getSource ()).stop ();
    }
    count ++;
}

}
