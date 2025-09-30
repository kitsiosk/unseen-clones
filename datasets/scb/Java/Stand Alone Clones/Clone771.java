public class Clone771 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:780541
*  Stack Overflow answer #:52076047
*  And Stack Overflow answer#:35433641
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
    Map < String, Integer > unSortedMap = new LinkedHashMap < String, Integer > ();
    unSortedMap.put ("A", 2);
    unSortedMap.put ("V", 1);
    unSortedMap.put ("G", 5);
    System.out.println ("Unsorted Map :\n");
    for (Map.Entry < String, Integer > entry : unSortedMap.entrySet ()) {
        System.out.println (entry.getKey () + "   " + entry.getValue ());
    }
    System.out.println ("\n");
    System.out.println ("Sorting Map Based on Keys :\n");
    Map < String, Integer > keySortedMap = new TreeMap < String, Integer > (unSortedMap);
    for (Map.Entry < String, Integer > entry : keySortedMap.entrySet ()) {
        System.out.println (entry.getKey () + "   " + entry.getValue ());
    }
    System.out.println ("\n");
    System.out.println ("Sorting Map Based on Values :\n");
    List < Entry < String, Integer > > entryList = new ArrayList < Entry < String, Integer > > (unSortedMap.entrySet ());
    Collections.sort (entryList, new Comparator < Entry < String, Integer > > () {
        @Override
        public int compare (Entry < String, Integer > obj1, Entry < String, Integer > obj2) {
            return obj1.getValue ().compareTo (obj2.getValue ());
        }}
    );
    unSortedMap.clear ();
    for (Entry < String, Integer > entry : entryList) {
        unSortedMap.put (entry.getKey (), entry.getValue ());
        System.out.println (entry.getKey () + "   " + entry.getValue ());
    }
}

}
