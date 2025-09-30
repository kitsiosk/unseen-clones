public class Clone6 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29076439
*  Stack Overflow answer #:34254130
*  And Stack Overflow answer#:29819001
*/
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

static void copyFolder (File src, File dest) {
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
    String strAbsPathSrc = src.getAbsolutePath ();
    String strAbsPathDest = dest.getAbsolutePath ();
    try {
        Files.walkFileTree (src.toPath (), new SimpleFileVisitor < Path > () {
            @Override
            public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
                File dstFile = new File (strAbsPathDest + file.toAbsolutePath ().toString ().substring (strAbsPathSrc.length ()));
                if (dstFile.exists ()) return FileVisitResult.CONTINUE;
                if (! dstFile.getParentFile ().exists ()) dstFile.getParentFile ().mkdirs ();
                Files.copy (file, dstFile.toPath ());
                return FileVisitResult.CONTINUE;
            }}
        );
    } catch (IOException e) {
        return;
    }
    return;
}

}
