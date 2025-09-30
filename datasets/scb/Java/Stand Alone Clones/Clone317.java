public class Clone317 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:779519
*  Stack Overflow answer #:4026761
*  And Stack Overflow answer#:6514188
*/
public static boolean deleteRecursive (File path) throws FileNotFoundException {
    if (! path.exists ()) throw new FileNotFoundException (path.getAbsolutePath ());
    boolean ret = true;
    if (path.isDirectory ()) {
        for (File f : path.listFiles ()) {
            ret = ret && deleteRecursive (f);
        }
    }
    return ret && path.delete ();
}

public void deleteRecursive (File path) {
    File [] c = path.listFiles ();
    System.out.println ("Cleaning out folder:" + path.toString ());
    for (File file : c) {
        if (file.isDirectory ()) {
            System.out.println ("Deleting file:" + file.toString ());
            deleteRecursive (file);
            file.delete ();
        } else {
            file.delete ();
        }
    }
    path.delete ();
}

}
