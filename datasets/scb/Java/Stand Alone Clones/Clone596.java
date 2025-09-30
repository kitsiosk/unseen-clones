public class Clone596 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9175976
*  Stack Overflow answer #:9176913
*  And Stack Overflow answer#:9176103
*/
public static void main (String...args) {
    long start = System.nanoTime ();
    int letters = 26;
    int count = 6;
    final int combinations = (int) Math.pow (letters, count);
    char [] chars = new char [count];
    Arrays.fill (chars, 'a');
    final int last = count - 1;
    OUTER : while (true) {
        for (chars [last] = 'a'; chars [last] <= 'z'; chars [last] += 2) {
            newComination (chars);
            chars [last] ++;
            newComination (chars);
        }
        UPDATED : {
            for (int i = last - 1;
            i >= 0; i --) {
                if (chars [i] ++ >= 'z') chars [i] = 'a';
                else break UPDATED;
            }
            break OUTER;
        }}
    long time = System.nanoTime () - start;
    System.out.printf ("Took %.3f seconds to generate %,d combinations%n", time / 1e9, combinations);
}

public static void main (String [] args) {
    List < Character > characters = new ArrayList < Character > ();
    for (char c = 'a';
    c <= 'z'; c ++) {
        characters.add (c);
    }
    List < String > allStrings = new ArrayList < String > ();
    for (Character c : characters) {
        for (Character d : characters) {
            for (Character e : characters) {
                for (Character f : characters) {
                    String s = "" + c + d + e + f;
                    allStrings.add (s);
                }
            }
        }
    }
    System.out.println (allStrings.size ());
}

}
