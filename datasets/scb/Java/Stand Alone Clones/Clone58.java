public class Clone58 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29330983
*  Stack Overflow answer #:29331381
*  And Stack Overflow answer#:29331301
*/
public static void main (String [] args) throws FileNotFoundException, IOException {
    Path myPath = Paths.get ("e:\\", "1.txt");
    List < String > ls;
    ls = Files.readAllLines (myPath, StandardCharsets.US_ASCII);
    PrintWriter out = new PrintWriter ("e:\\2.txt");
    for (int i = 0;
    i < ls.size (); i ++) {
        String [] temp = ls.get (i).split (":");
        if (temp.length > 1) {
            out.println (ls.get (i));
        }
    }
    out.close ();
}

public static void main (String [] args) throws FileNotFoundException, IOException {
    FileInputStream fin = new FileInputStream ("line.srt");
    BufferedReader reader = new BufferedReader (new InputStreamReader (fin));
    PrintWriter out = new PrintWriter ("newline.srt");
    int i = 0;
    String line = reader.readLine ();
    while (line != null) {
        if (! line.trim ().equals ("")) {
            out.println (line);
        }
        line = reader.readLine ();
    }
    out.close ();
}

}
