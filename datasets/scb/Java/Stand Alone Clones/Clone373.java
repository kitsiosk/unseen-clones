public class Clone373 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1146153
*  Stack Overflow answer #:34019204
*  And Stack Overflow answer#:35637942
*/
public static void main (String [] args) {
    InputStream inStream = null;
    OutputStream outStream = null;
    try {
        File afile = new File ("C:\\folderA\\Afile.txt");
        File bfile = new File ("C:\\folderB\\Afile.txt");
        inStream = new FileInputStream (afile);
        outStream = new FileOutputStream (bfile);
        byte [] buffer = new byte [1024];
        int length;
        while ((length = inStream.read (buffer)) > 0) {
            outStream.write (buffer, 0, length);
        }
        inStream.close ();
        outStream.close ();
        afile.delete ();
        System.out.println ("File is copied successful!");
    } catch (IOException e) {
        e.printStackTrace ();
    }
}

public static void main (String [] args) throws IOException {
    Path source = Paths.get ("/path/to/source/dir");
    Path destination = Paths.get ("/path/to/dest/dir");
    List < Path > sources = Files.walk (source).collect (toList ());
    List < Path > destinations = sources.stream ().map (source :: relativize).map (destination :: resolve).collect (toList ());
    for (int i = 0;
    i < sources.size (); i ++) {
        Files.copy (sources.get (i), destinations.get (i));
    }
}

}
