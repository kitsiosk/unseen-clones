public class Clone658 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:51267328
*  Stack Overflow answer #:51267934
*  And Stack Overflow answer#:51268304
*/
private static String findFirstCharacter (String s) {
    Set < Integer > singles = new LinkedHashSet < > (), duplicates = new HashSet < > ();
    s.codePoints ().forEach (ch -> {
        if (! duplicates.contains (ch) && ! singles.add (ch)) {
            singles.remove (ch);
            duplicates.add (ch);
        }
    });
    return (singles.isEmpty () ? null : new String (new int [] {singles.iterator ().next ()}, 0, 1));
}

private static char findFirstCharacter (String s) {
    HashSet < Character > unique = new LinkedHashSet < > (), seen = new HashSet < > ();
    for (int i = 0;
    i < s.length (); i ++) {
        char c = s.charAt (i);
        if (seen.add (c)) unique.add (c);
        else unique.remove (c);
    }
    return unique.isEmpty () ? '_' : unique.iterator ().next ();
}

}
