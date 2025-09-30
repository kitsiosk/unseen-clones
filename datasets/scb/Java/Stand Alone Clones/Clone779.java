public class Clone779 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4820716
*  Stack Overflow answer #:29217025
*  And Stack Overflow answer#:4824465
*/
public static void main (String args []) {
    String value = "This is testing Program testing Program";
    String item [] = value.split (" ");
    HashMap < String, Integer > map = new HashMap < > ();
    for (String t : item) {
        if (map.containsKey (t)) {
            map.put (t, map.get (t) + 1);
        } else {
            map.put (t, 1);
        }
    }
    Set < String > keys = map.keySet ();
    for (String key : keys) {
        System.out.println (key);
        System.out.println (map.get (key));
    }
}

public static void main (String [] args) {
    Map < String, Integer > unique = new LinkedHashMap < String, Integer > ();
    for (String string : "House, House, House, Dog, Dog, Dog, Dog".split (", ")) {
        if (unique.get (string) == null) unique.put (string, 1);
        else unique.put (string, unique.get (string) + 1);
    }
    String uniqueString = join (unique.keySet (), ", ");
    List < Integer > value = new ArrayList < Integer > (unique.values ());
    System.out.println ("Output = " + uniqueString);
    System.out.println ("Values = " + value);
}

}
