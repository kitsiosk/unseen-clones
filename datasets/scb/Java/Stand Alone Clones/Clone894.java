public class Clone894 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16330960
*  Stack Overflow answer #:16330976
*  And Stack Overflow answer#:26175204
*/
public static void main (String args []) {
    FileReader fr = null;
    FileWriter fw = null;
    try {
        fr = new FileReader ("1.txt");
        fw = new FileWriter ("2.txt");
        int c = fr.read ();
        while (c != - 1) {
            fw.write (c);
            c = fr.read ();
        }
    } catch (IOException e) {
        e.printStackTrace ();
    } finally {
        close (fr);
        close (fw);
    }
}

public static void main (String [] args) throws IOException {
    File dir = new File (".");
    String source = dir.getCanonicalPath () + File.separator + "Code.txt";
    String dest = dir.getCanonicalPath () + File.separator + "Dest.txt";
    File fin = new File (source);
    FileInputStream fis = new FileInputStream (fin);
    BufferedReader in = new BufferedReader (new InputStreamReader (fis));
    FileWriter fstream = new FileWriter (dest, true);
    BufferedWriter out = new BufferedWriter (fstream);
    String aLine = null;
    while ((aLine = in.readLine ()) != null) {
        out.write (aLine);
        out.newLine ();
    }
    in.close ();
    out.close ();
}

}
