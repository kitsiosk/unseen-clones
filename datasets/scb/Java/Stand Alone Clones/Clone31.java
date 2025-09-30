public class Clone31 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5525176
*  Stack Overflow answer #:5525213
*  And Stack Overflow answer#:5525891
*/
public static void main (String [] args) throws InterruptedException {
    String [] arrayElements = {"value1", "value2", "value3", "value4"};
    long start = System.currentTimeMillis ();
    for (int i = 0;
    i < arrayElements.length; i ++) {
        final String value = arrayElements [i];
        new java.util.Timer ().schedule (new java.util.TimerTask () {
            public void run () {
                System.out.println (value);
            }}
        , new Date (start));
        start += 5000;
    }
}

public static void main (String [] args) {
    final Timer utilTimer = new Timer ();
    utilTimer.scheduleAtFixedRate (new TimerTask () {
        private int index = 0;
        public void run () {
            System.out.println (ARRAY_ELEMENTS [index]);
            index ++;
            if (index >= ARRAY_ELEMENTS.length) {
                utilTimer.cancel ();
            }
        }}
    , 5000L, 5000L);
}

}
