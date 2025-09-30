public class Clone955 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14602844
*  Stack Overflow answer #:14602975
*  And Stack Overflow answer#:14602936
*/
public TerminalGui [] getTerminalGuis () {
    Component [] comps = this.getComponents ();
    int j = 0;
    for (int i = 0;
    i < comps.length; i ++) {
        if (comps [i] instanceof TerminalGui) {
            j ++;
        }
    }
    TerminalGui [] terminalGuis = new TerminalGui [j];
    int k = 0;
    for (Component c : comps) {
        if (c instanceof TerminalGui) {
            terminalGuis [k] = c;
            k ++;
        }
    }
    return terminalGuis;
}

public TerminalGui [] getTerminalGuis () {
    Components comps [] = getComponents ();
    List < TerminalGui > list = new ArrayList < TerminalGui > ();
    if (comps == null) return null;
    for (Component c : comps) {
        if (c instanceof TerminalGui) {
            list.add (c);
        }
    }
    return list.toArray (new TerminalGui [list.size ()]);
}

}
