public class Clone143 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29581774
*  Stack Overflow answer #:29582614
*  And Stack Overflow answer#:29582913
*/
public static void main (String [] args) {
    Map < Example, Number > m = new HashMap < > ();
    Example e1 = new Example (100);
    Example e2 = new Example (200);
    Example e3 = new Example (300);
    m.put (e1, 10);
    m.put (e2, 20);
    m.put (e3, 30);
    System.out.println (m);
}

public static void main (String [] args) {
    HashMap < A, String > map = new HashMap < A, String > (4);
    map.put (new A (), "abc");
    map.put (new A (), "def");
    Class clazz = map.getClass ();
    Field table = clazz.getDeclaredField ("table");
    table.setAccessible (true);
    Map.Entry < Integer, String > [] realTable = (Map.Entry < Integer, String > []) table.get (map);
    for (int i = 0;
    i < realTable.length; i ++) {
        System.out.println (String.format ("Bucket : %d, Entry: %s", i, bucketToString (realTable [i])));
    }
}

}
