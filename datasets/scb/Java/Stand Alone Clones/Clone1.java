public class Clone1 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21771566
*  Stack Overflow answer #:21772074
*  And Stack Overflow answer#:44045533
*/
public static void main (String [] args) {
    String text = "the quick brown fox jumps fox fox over the lazy dog brown";
    String [] keys = text.split (" ");
    String [] uniqueKeys;
    int count = 0;
    System.out.println (text);
    uniqueKeys = getUniqueKeys (keys);
    for (String key : uniqueKeys) {
        if (null == key) {
            break;
        }
        for (String s : keys) {
            if (key.equals (s)) {
                count ++;
            }
        }
        System.out.println ("Count of [" + key + "] is : " + count);
        count = 0;
    }
}

public static void main (String [] args) {
    String s = "this is a this is this a this yes this is a this what it may be i do not care about this";
    String a [] = s.split (" ");
    Map < String, Integer > words = new HashMap < > ();
    for (String str : a) {
        if (words.containsKey (str)) {
            words.put (str, 1 + words.get (str));
        } else {
            words.put (str, 1);
        }
    }
    System.out.println (words);
}

}
