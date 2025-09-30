public class Clone905 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:37962971
*  Stack Overflow answer #:37963373
*  And Stack Overflow answer#:37963350
*/
public static void main (String args []) {
    ArrayList < String > keys = new ArrayList < > ();
    ArrayList < String > values = new ArrayList < > ();
    keys.add ("1");
    keys.add ("1");
    keys.add ("1");
    keys.add ("2");
    keys.add ("2");
    keys.add ("3");
    values.add ("2016-06-22 07:18:45");
    values.add ("2016-06-22 08:18:45");
    values.add ("2016-06-22 09:18:45");
    values.add ("2016-06-22 03:18:45");
    values.add ("2016-06-22 04:18:45");
    values.add ("2016-06-22 01:18:45");
    LinkedHashMap < String, String > map = new LinkedHashMap < String, String > ();
    for (int i = 0;
    i < keys.size (); i ++) {
        map.put (keys.get (i), values.get (i));
    }
    System.out.println (map);
}

public static void main (String [] args) {
    ArrayList < String > keys = new ArrayList < > (Arrays.asList ("1", "1", "1", "2", "2", "3"));
    ArrayList < String > values = new ArrayList < > (Arrays.asList ("2016-06-22 07:18:45", "2016-06-22 08:18:45", "2016-06-22 09:18:45", "2016-06-22 03:18:45", "2016-06-22 04:18:45", "2016-06-22 01:18:45"));
    HashMap < String, String > map = new HashMap < String, String > ();
    for (int i = 0;
    keys.size () == values.size () && i < keys.size (); i ++) {
        String key = keys.get (i);
        String value = values.get (i);
        if (! map.containsKey (key) || dateAsNo (value) > dateAsNo (map.get (key))) {
            map.put (key, value);
        }
    }
    System.out.println (map);
}

}
