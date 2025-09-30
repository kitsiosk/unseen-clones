public class Clone817 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:52350940
*  Stack Overflow answer #:52351040
*  And Stack Overflow answer#:52351119
*/
public static void countString (String str) {
    if (str != null) {
        int length = str.length ();
        char ch [] = str.toCharArray ();
        Arrays.sort (ch);
        if (length > 0) {
            char x = ch [0];
            int count = 1;
            for (int i = 1;
            i < length; i ++) {
                if (ch [i] == x) {
                    count ++;
                } else {
                    System.out.println ("Number of Occurrence of '" + ch [i - 1] + "' is: " + count);
                    x = ch [i];
                    count = 1;
                }
            }
            System.out.println ("Number of Occurrence of '" + ch [length - 1] + "' is: " + count);
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
