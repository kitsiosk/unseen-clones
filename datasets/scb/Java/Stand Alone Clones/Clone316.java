public class Clone316 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:779519
*  Stack Overflow answer #:4026761
*  And Stack Overflow answer#:32655090
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
