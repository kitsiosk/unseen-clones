public class Clone319 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:779519
*  Stack Overflow answer #:47964817
*  And Stack Overflow answer#:6514188
*/
private void deleteRecursive (File f) throws Exception {
    try {
        if (f.isDirectory ()) {
            for (File c : f.listFiles ()) {
                deleteRecursive (c);
            }
        }
        if (! f.delete ()) {
            throw new Exception ("Delete command returned false for file: " + f);
        }
    } catch (Exception e) {
        throw new Exception ("Failed to delete the folder: " + f, e);
    }
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
