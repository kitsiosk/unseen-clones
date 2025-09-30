public class Clone816 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:52350940
*  Stack Overflow answer #:52350983
*  And Stack Overflow answer#:52351254
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

public static void countString (String str, char searchKey) {
    String count = "";
    for (int i = 0;
    i < str.length (); i ++) {
        if (str.charAt (i) == searchKey) count += str.charAt (i) + "\n";
    }
    System.out.println (count + "\nNumber of Occurrence of " + searchKey + " is " + count.length () + " in string " + str);
}

}
