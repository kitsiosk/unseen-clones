public class Clone514 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27865113
*  Stack Overflow answer #:27865831
*  And Stack Overflow answer#:27867176
*/
public static void main (String [] args) throws java.lang.Exception {
    List < Data > data = new ArrayList < Data > ();
    data.add (new Data ("Title1", "Link1", 8));
    data.add (new Data ("Title2", "Link2", 1));
    data.add (new Data ("Title3", "Link3", 3));
    for (Data d : data) {
        System.out.print (d.getNumber () + " ");
    }
    System.out.println ();
    Collections.sort (data);
    for (Data d : data) {
        System.out.print (d.getNumber () + " ");
    }
}

public static void main (String [] args) {
    ArrayList < HashMap < String, String > > yourArrayList = new ArrayList < HashMap < String, String > > ();
    HashMap < String, String > myHashMap = new HashMap < String, String > ();
    myHashMap.put ("title", "first Title");
    myHashMap.put ("date", "This is 1st date");
    myHashMap.put ("number", "5");
    yourArrayList.add (0, myHashMap);
    myHashMap = new HashMap < String, String > ();
    myHashMap.put ("title", "Second Title");
    myHashMap.put ("date", "This is 2nd date");
    myHashMap.put ("number", "2");
    yourArrayList.add (1, myHashMap);
    myHashMap = new HashMap < String, String > ();
    myHashMap.put ("title", "Third Title");
    myHashMap.put ("date", "This is 3rd date");
    myHashMap.put ("number", "7");
    yourArrayList.add (2, myHashMap);
    myHashMap = new HashMap < String, String > ();
    myHashMap.put ("title", "Fourth Title");
    myHashMap.put ("date", "This is 4th date");
    myHashMap.put ("number", "0");
    yourArrayList.add (3, myHashMap);
    System.out.println ("=================");
    System.out.println ("BEFORE SORTING");
    System.out.println ("=================");
    for (int i = 0;
    i < yourArrayList.size (); i ++) {
        System.out.println (yourArrayList.get (i));
    }
    HashMap < String, String > temporary;
    for (int c = 0;
    c < (yourArrayList.size () - 1); c ++) {
        for (int d = 0;
        d < (yourArrayList.size () - c - 1); d ++) {
            if (Integer.parseInt (yourArrayList.get (d).get ("number")) > Integer.parseInt (yourArrayList.get (d + 1).get ("number"))) {
                temporary = yourArrayList.get (d);
                yourArrayList.set (d, yourArrayList.get (d + 1));
                yourArrayList.set (d + 1, temporary);
            }
        }
    }
    System.out.println ("=================");
    System.out.println ("AFTER SORTING");
    System.out.println ("=================");
    for (int i = 0;
    i < yourArrayList.size (); i ++) {
        System.out.println (yourArrayList.get (i));
    }
}

}
