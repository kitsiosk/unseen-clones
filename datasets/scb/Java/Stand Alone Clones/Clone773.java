public class Clone773 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:780541
*  Stack Overflow answer #:35433641
*  And Stack Overflow answer#:28856660
*/
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
