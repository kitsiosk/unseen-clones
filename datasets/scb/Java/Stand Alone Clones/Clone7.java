public class Clone7 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:29076439
*  Stack Overflow answer #:46030326
*  And Stack Overflow answer#:29819001
*/
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
