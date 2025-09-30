public class Clone555 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3904579
*  Stack Overflow answer #:41267270
*  And Stack Overflow answer#:31260192
*/
public static String capitalizer (final String texto) {
    String [] palavras = texto.split (" ");
    StringBuilder sb = new StringBuilder ();
    List < String > excessoes = new ArrayList < String > (Arrays.asList ("de", "da", "das", "do", "dos", "na", "nas", "no", "nos", "a", "e", "o", "em", "com"));
    for (String palavra : palavras) {
        if (excessoes.contains (palavra.toLowerCase ())) sb.append (palavra.toLowerCase ()).append (" ");
        else sb.append (Character.toUpperCase (palavra.charAt (0))).append (palavra.substring (1).toLowerCase ()).append (" ");
    }
    return sb.toString ().trim ();
}

private String capitalizer (String word) {
    String [] words = word.split (" ");
    StringBuilder sb = new StringBuilder ();
    if (words [0].length () > 0) {
        sb.append (Character.toUpperCase (words [0].charAt (0)) + words [0].subSequence (1, words [0].length ()).toString ().toLowerCase ());
        for (int i = 1;
        i < words.length; i ++) {
            sb.append (" ");
            sb.append (Character.toUpperCase (words [i].charAt (0)) + words [i].subSequence (1, words [i].length ()).toString ().toLowerCase ());
        }
    }
    return sb.toString ();
}

}
