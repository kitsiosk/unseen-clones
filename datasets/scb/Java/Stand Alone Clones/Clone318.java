public class Clone318 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:779519
*  Stack Overflow answer #:47964817
*  And Stack Overflow answer#:32655090
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

public static void deleteRecursive (File path) {
    path.listFiles (new FileFilter () {
        @Override
        public boolean accept (File pathname) {
            if (pathname.isDirectory ()) {
                pathname.listFiles (this);
                pathname.delete ();
            } else {
                pathname.delete ();
            }
            return false;
        }}
    );
    path.delete ();
}

}
