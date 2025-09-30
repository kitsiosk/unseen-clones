public class Clone595 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18526099
*  Stack Overflow answer #:18526243
*  And Stack Overflow answer#:18526122
*/
public static void main (String [] args) {
    final class Constants {
        public static final String name = "globe";
    }
    Thread thread = new Thread (new Runnable () {
        @Override
        public void run () {
            System.out.println (Constants.name);
        }}
    );
    thread.start ();
}

public static void main (String [] args) {
    Thread thread = new Thread (new Runnable () {
        @Override
        public void run () {
            System.out.println (Constants.name);
        }}
    );
    thread.start ();
}

}
