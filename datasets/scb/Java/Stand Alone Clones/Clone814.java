public class Clone814 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:52350940
*  Stack Overflow answer #:52350983
*  And Stack Overflow answer#:52351040
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

}
