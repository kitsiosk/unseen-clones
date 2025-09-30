public class Clone513 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23894811
*  Stack Overflow answer #:23895135
*  And Stack Overflow answer#:23895074
*/
@Override
public void itemStateChanged (ItemEvent e) {
    if (e.getStateChange () == ItemEvent.SELECTED) {
        size = Integer.parseInt ((String) box.getSelectedItem ());
        for (i = 1; i <= size; i ++) {
            System.out.print (" " + i);
        }
        System.out.println ();
    }
}

public void itemStateChanged (ItemEvent e) {
    size = Integer.parseInt ((String) box.getSelectedItem ());
    if (e.getStateChange () == ItemEvent.SELECTED) {
        for (i = 1; i <= size; i ++) {
            System.out.print (" " + i);
        }
        System.out.println ();
    }
}

}
