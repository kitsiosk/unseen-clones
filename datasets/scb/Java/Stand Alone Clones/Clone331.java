public class Clone331 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13119926
*  Stack Overflow answer #:48723167
*  And Stack Overflow answer#:42205630
*/
public static void main (String [] args) {
    String string = "check duplicate charcters in string";
    string = string.toLowerCase ();
    char [] charAr = string.toCharArray ();
    Arrays.sort (charAr);
    for (int i = 1;
    i < charAr.length;) {
        int count = recursiveMethod (charAr, i, 1);
        if (count > 1) {
            System.out.println ("'" + charAr [i] + "' comes " + count + " times");
            i = i + count;
        } else i ++;
    }
}

public static void main (String [] args) {
    String name = "AnuvratAnuvra";
    char [] arr = name.toCharArray ();
    HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
    for (char val : arr) {
        map.put (val, map.containsKey (val) ? map.get (val) + 1 : 1);
    }
    for (Entry < Character, Integer > entry : map.entrySet ()) {
        if (entry.getValue () > 1) {
            Character key = entry.getKey ();
            Object value = entry.getValue ();
            System.out.println (key + ":" + value);
        }
    }
}

}
