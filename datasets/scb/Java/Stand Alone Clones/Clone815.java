public class Clone815 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:52350940
*  Stack Overflow answer #:52350983
*  And Stack Overflow answer#:52351119
*/
private static void countString (String str, Character character) {
    int [] counts = new int [MAX_CHAR];
    char [] chars = str.toCharArray ();
    for (char ch : chars) {
        if (character != null && character != ch) {
            continue;
        }
        counts [ch] ++;
    }
    for (int i = 0;
    i < counts.length; i ++) {
        if (counts [i] > 0) {
            System.out.println ("Character " + (char) i + " appeared " + counts [i] + " times");
        }
    }
}

public static void countString (String str, char value) {
    String [] arr = str.split ("");
    StringBuffer tempString = new StringBuffer ();
    for (String s : arr) {
        tempString.append (s);
        for (char ch : s.toCharArray ()) {
            System.out.println ("Number of Occurrence of " + ch + " is:" + tempString.chars ().filter (i -> i == ch).count ());
        }
    }
    if (! (Character.toString (value).isEmpty ())) {
        StringBuffer tempString2 = new StringBuffer ();
        for (String s : arr) {
            tempString2.append (s);
            for (char ch : s.toCharArray ()) {
                if (ch == value) {
                    System.out.println ("Number of Occurrence of " + ch + " is:" + tempString2.chars ().filter (i -> i == ch).count ());
                }
            }
        }
    }
}

}
