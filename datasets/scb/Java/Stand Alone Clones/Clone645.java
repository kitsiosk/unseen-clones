public class Clone645 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32672371
*  Stack Overflow answer #:32672679
*  And Stack Overflow answer#:32672701
*/
public static void main (final String...args) {
    if (args.length == 0) throw new IllegalArgumentException ("missing pattern as an argument");
    final Pattern pattern = Pattern.compile (args [0]);
    final Charset cs = Charset.defaultCharset ();
    final CharsetDecoder decoder = cs.newDecoder ().onMalformedInput (CodingErrorAction.REPORT);
    try (final Reader r = new InputStreamReader (System.in, decoder); final BufferedReader reader = new BufferedReader (r)) {
        String line;
        while ((line = reader.readLine ()) != null) if (pattern.matcher (line).find ()) System.out.println (line);
    }
}

public static void main (String [] args) throws FileNotFoundException {
    String s = "this is line one\n" + "this is line two\n" + "This is line three";
    Pattern p = Pattern.compile ("this");
    Scanner scanner = new Scanner (s);
    while (scanner.hasNextLine ()) {
        String line = scanner.nextLine ();
        Matcher m = p.matcher (line);
        if (m.find ()) {
            System.out.println (line);
        }
    }
}

}
