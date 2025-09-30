public class Clone282 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:44685943
*  Stack Overflow answer #:44686377
*  And Stack Overflow answer#:44686381
*/
public static void main (String [] args) {
    String strExample = "{'27': [], '10864': [u'8344', u'7769', u'7207', u'3735']}";
    List < String > keys = new ArrayList < String > ();
    List < String > values = new ArrayList < String > ();
    for (String component : strExample.replace ("{", "").split ("][,}]")) {
        String kv [] = component.split (": ");
        keys.add (kv [0]);
        values.add (kv [1] + "]");
    }
    System.out.println ("Keys: ");
    for (String key : keys) {
        System.out.println (key);
    }
    System.out.println ("\nValues: ");
    for (String value : values) {
        System.out.println (value);
    }
}

public static void main (String [] args) {
    String input = "{'27': [], '10864': [u'8344', u'7769', u'7207', u'3735']}";
    String pattern = "('([\w]*)': (\\[[u'0-9, ]*])?)";
    List < String > keys = new ArrayList < > ();
    List < String > values = new ArrayList < > ();
    Matcher m = Pattern.compile (pattern).matcher (input);
    while (m.find ()) {
        keys.add (m.group (2));
        values.add (m.group (3));
    }
    System.out.println ("Keys: " + keys.toString ());
    System.out.println ("Values: " + values.toString ());
}

}
