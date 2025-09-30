public class Clone464 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1429172
*  Stack Overflow answer #:28057735
*  And Stack Overflow answer#:39974405
*/
public static void main (String [] args) throws URISyntaxException, IOException {
    URI uri = ResourceWalker.class.getResource ("/resources").toURI ();
    Path myPath;
    if (uri.getScheme ().equals ("jar")) {
        FileSystem fileSystem = FileSystems.newFileSystem (uri, Collections.< String, Object > emptyMap ());
        myPath = fileSystem.getPath ("/resources");
    } else {
        myPath = Paths.get (uri);
    }
    Stream < Path > walk = Files.walk (myPath, 1);
    for (Iterator < Path > it = walk.iterator ();
    it.hasNext ();) {
        System.out.println (it.next ());
    }
}

public static void main (String [] args) throws URISyntaxException, IOException {
    URI uri = ResourceWalker.class.getResource ("/resources").toURI ();
    System.out.println ("Starting from: " + uri);
    try (FileSystem fileSystem = (uri.getScheme ().equals ("jar") ? FileSystems.newFileSystem (uri, Collections.< String, Object > emptyMap ()) : null)) {
        Path myPath = Paths.get (uri);
        Files.walkFileTree (myPath, new SimpleFileVisitor < Path > () {
            @Override
            public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println (file);
                return FileVisitResult.CONTINUE;
            }}
        );
    }
}

}
