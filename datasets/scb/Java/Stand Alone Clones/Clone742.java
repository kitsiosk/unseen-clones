public class Clone742 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20281835
*  Stack Overflow answer #:42641329
*  And Stack Overflow answer#:42372854
*/
static public boolean deleteDirectory (File path) {
    if (path.exists ()) {
        File [] files = path.listFiles ();
        for (int i = 0;
        i < files.length; i ++) {
            if (files [i].isDirectory ()) {
                deleteDirectory (files [i]);
            } else {
                files [i].delete ();
            }
        }
    }
    return (path.delete ());
}

public static void deleteDirectory (String directoryFilePath) throws IOException {
    Path directory = Paths.get (directoryFilePath);
    if (Files.exists (directory)) {
        Files.walkFileTree (directory, new SimpleFileVisitor < Path > () {
            @Override
            public FileVisitResult visitFile (Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                Files.delete (path);
                return FileVisitResult.CONTINUE;
            }@Override
            public FileVisitResult postVisitDirectory (Path directory, IOException ioException) throws IOException {
                Files.delete (directory);
                return FileVisitResult.CONTINUE;
            }}
        );
    }
}

}
