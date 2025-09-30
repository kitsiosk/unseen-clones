public class Clone651 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2044033
*  Stack Overflow answer #:2044236
*  And Stack Overflow answer#:2044675
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
