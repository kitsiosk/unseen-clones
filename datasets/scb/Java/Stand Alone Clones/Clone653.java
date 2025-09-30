public class Clone653 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2044033
*  Stack Overflow answer #:2044423
*  And Stack Overflow answer#:2044675
*/
public static void main (String...args) {
    Runnable r1 = new Runnable () {
        int n;
        public void run () {
            System.out.println (++ n);
        }}
    ;
    fourTimes (fiveTimes (fiveTimes (r1))).run ();
}

public static void main (String [] args) {
    Object [] numbers = new Object [100];
    Arrays.fill (numbers, new Object () {
        private int count = 0;
        @Override
        public String toString () {
            return Integer.toString (++ count);
        }}
    );
    System.out.println (Arrays.toString (numbers));
}

}
