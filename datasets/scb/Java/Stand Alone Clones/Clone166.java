public class Clone166 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6318293
*  And Stack Overflow answer#:6375412
*/
public RemoveDialogOnRuntime () {
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setPreferredSize (new Dimension (300, 300));
    setTitle ("Remove Dialog On Runtime");
    setLocation (150, 150);
    pack ();
    setVisible (true);
    Point loc = this.getLocation ();
    top += loc.x;
    left += loc.y;
    AddNewDialog ();
}

public RemoveDialogOnRuntime () {
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setPreferredSize (new Dimension (300, 300));
    setTitle ("Remove Dialog On Runtime");
    setLocation (150, 150);
    pack ();
    setVisible (true);
    addNewDialog ();
}

}
