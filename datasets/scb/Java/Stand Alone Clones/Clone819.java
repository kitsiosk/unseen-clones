public class Clone819 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:52350940
*  Stack Overflow answer #:52351119
*  And Stack Overflow answer#:52351254
*/
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

public static void countString (String str, char searchKey) {
    String count = "";
    for (int i = 0;
    i < str.length (); i ++) {
        if (str.charAt (i) == searchKey) count += str.charAt (i) + "\n";
    }
    System.out.println (count + "\nNumber of Occurrence of " + searchKey + " is " + count.length () + " in string " + str);
}

}
