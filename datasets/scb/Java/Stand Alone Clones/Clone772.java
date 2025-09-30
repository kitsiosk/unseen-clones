public class Clone772 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:780541
*  Stack Overflow answer #:52076047
*  And Stack Overflow answer#:28856660
*/
public static void main (String [] args) {
    Map < String, String > map = new HashMap < > ();
    map.put ("b", "dd");
    map.put ("c", "cc");
    map.put ("a", "aa");
    map = new TreeMap < > (map);
    for (String key : map.keySet ()) {
        System.out.println (key + "=" + map.get (key));
    }
}

public static void main (String [] args) {
    Map < Object, Object > handler = new LinkedHashMap < Object, Object > ();
    handler.put ("item", "Value");
    handler.put (2, "Movies");
    handler.put ("isAlive", true);
    for (Map.Entry < Object, Object > entrY : handler.entrySet ()) System.out.println (entrY.getKey () + "><![CDATA[>" + entrY.getValue ());
    List < Map.Entry < String, Integer > > entries = new ArrayList < Map.Entry < String, Integer > > ();
    Collections.sort (entries, new Comparator < Map.Entry < String, Integer > > () {
        public int compare (Map.Entry < String, Integer > a, Map.Entry < String, Integer > b) {
            return a.getValue ().compareTo (b.getValue ());
        }}
    );
}

}
