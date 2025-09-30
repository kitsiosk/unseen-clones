public class Clone3 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29076439
*  Stack Overflow answer #:29801090
*  And Stack Overflow answer#:46030326
*/
static private void copyFolder (File src, File dest) {
    if (src == null || dest == null) return;
    if (! src.isDirectory ()) return;
    if (dest.exists ()) {
        if (! dest.isDirectory ()) {
            return;
        }
    } else {
        dest.mkdir ();
    }
    if (src.listFiles () == null || src.listFiles ().length == 0) return;
    for (File file : src.listFiles ()) {
        File fileDest = new File (dest, file.getName ());
        if (file.isDirectory ()) {
            copyFolder (file, fileDest);
        } else {
            if (fileDest.exists ()) continue;
            try {
                Files.copy (file.toPath (), fileDest.toPath ());
            } catch (IOException e) {
            }
        }
    }
}

public static void copyFolder (Path src, Path dest) {
    try {
        Files.walk (src).forEach (s -> {
            try {
                Path d = dest.resolve (src.relativize (s));
                if (Files.isDirectory (s)) {
                    if (! Files.exists (d)) Files.createDirectory (d);
                    return;
                }
                Files.copy (s, d);
            } catch (Exception e) {
                e.printStackTrace ();
            }
        });
    } catch (Exception ex) {
        ex.printStackTrace ();
    }
}

}
