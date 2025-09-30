public class Clone733 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1901838
*  Stack Overflow answer #:1901915
*  And Stack Overflow answer#:1901854
*/
public String getInput (String file) {
    StringBuilder ret = new StringBuilder ();
    String buf;
    BufferedReader inFile = null;
    try {
        inFile = new BufferedReader (new FileReader (filename));
        while (buf = inFile.readLine ()) ret.append (buf);
    } catch (FileNotFoundException e) {
        ret.append ("Couldn't find " + file);
    } catch (IOException e) {
        ret.append ("There was an error reading the file.");
    } finally {
        if (inFile != null) {
            try {
                inFile.close ();
            } catch (IOException aargh) {
            }
        }
    }
    return ret.toString ();
}

public String getInput (String filename) {
    BufferedReader infile = null;
    try {
        infile = new BufferedReader (new FileReader (filename));
        String response = infile.readLine ();
        return response;
    } catch (IOException e) {
    } finally {
        try {
            infile.close ();
        } catch (IOException e) {
        }
    }
    return null;
}

}
