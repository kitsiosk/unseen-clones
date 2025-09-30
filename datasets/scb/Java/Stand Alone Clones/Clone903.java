public class Clone903 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14292543
*  Stack Overflow answer #:14294467
*  And Stack Overflow answer#:14296247
*/
public void actionPerformed (ActionEvent actionEvent) {
    doc.setCharacterAttributes (stringIndex, 1, textpane.getStyle ("Red"), true);
    stringIndex ++;
    try {
        if (stringIndex >= doc.getLength () || doc.getText (stringIndex, 1).equals (" ")) {
            index ++;
        }
        if (index < times.size ()) {
            double delay = times.get (index).doubleValue ();
            timer.setDelay ((int) (delay / WORDS [index].length ()));
        } else {
            timer.stop ();
            System.err.println ("Timer stopped");
        }
    } catch (BadLocationException e) {
        e.printStackTrace ();
    }
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
