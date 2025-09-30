public class Clone621 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18529240
*  Stack Overflow answer #:18529950
*  And Stack Overflow answer#:18530099
*/
public static void main (String args []) {
    java.awt.EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            new RowSorterDefaults ();
        }}
    );
}

public static void main (String args []) {
    UIManager.getLookAndFeelDefaults ().put ("Table.ascendingSortIcon", new BevelArrowIcon (BevelArrowIcon.UP, false, false));
    UIManager.getLookAndFeelDefaults ().put ("Table.descendingSortIcon", new BevelArrowIcon (BevelArrowIcon.DOWN, false, false));
    java.awt.EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            new RowSorterCustom ();
        }}
    );
}

}
