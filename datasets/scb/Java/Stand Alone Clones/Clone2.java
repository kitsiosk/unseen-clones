public class Clone2 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29076439
*  Stack Overflow answer #:29801090
*  And Stack Overflow answer#:34254130
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

public void copyFolder (File src, File dest) throws IOException {
    try (Stream < Path > stream = Files.walk (src.toPath ())) {
        stream.forEachOrdered (sourcePath -> {
            try {
                Files.copy (sourcePath, src.toPath ().resolve (dest.toPath ().relativize (sourcePath)));
            } catch (Exception e) {
                e.printStackTrace ();
            }
        });
    }
}

}
