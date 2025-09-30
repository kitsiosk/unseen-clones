public class Clone474 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15968883
*  Stack Overflow answer #:35158142
*  And Stack Overflow answer#:32052016
*/
public static void pack (final Path folder, final Path zipFilePath) throws IOException {
    try (FileOutputStream fos = new FileOutputStream (zipFilePath.toFile ()); ZipOutputStream zos = new ZipOutputStream (fos)) {
        Files.walkFileTree (folder, new SimpleFileVisitor < Path > () {
            public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
                zos.putNextEntry (new ZipEntry (folder.relativize (file).toString ()));
                Files.copy (file, zos);
                zos.closeEntry ();
                return FileVisitResult.CONTINUE;
            } public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException {
                zos.putNextEntry (new ZipEntry (folder.relativize (dir).toString () + "/"));
                zos.closeEntry ();
                return FileVisitResult.CONTINUE;
            }}
        );
    }
}

public static void pack (String sourceDirPath, String zipFilePath) throws IOException {
    Path p = Files.createFile (Paths.get (zipFilePath));
    try (ZipOutputStream zs = new ZipOutputStream (Files.newOutputStream (p))) {
        Path pp = Paths.get (sourceDirPath);
        Files.walk (pp).filter (path -> ! Files.isDirectory (path)).forEach (path -> {
            ZipEntry zipEntry = new ZipEntry (pp.relativize (path).toString ());
            try {
                zs.putNextEntry (zipEntry);
                Files.copy (path, zs);
                zs.closeEntry ();
            } catch (IOException e) {
                System.err.println (e);
            }
        });
    }
}

}
