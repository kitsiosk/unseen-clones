public class Clone650 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2044033
*  Stack Overflow answer #:2044236
*  And Stack Overflow answer#:2044423
*/
public static void main (String [] args) {
    String set = new java.util.BitSet () {
        {
            set (1, 100 + 1);
        }
    }
    .toString ();
    System.out.append (set, 1, set.length () - 1);
}

public static void main (String...args) {
    Runnable r1 = new Runnable () {
        int n;
        public void run () {
            System.out.println (++ n);
        }}
    ;
    fourTimes (fiveTimes (fiveTimes (r1))).run ();
}

}
