public class Clone376 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14522239
*  Stack Overflow answer #:39584230
*  And Stack Overflow answer#:40787814
*/
private static void verifyDirsAreEqual (Path one, Path other) throws IOException {
    Files.walkFileTree (one, new SimpleFileVisitor < Path > () {
        @Override
        public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
            FileVisitResult result = super.visitFile (file, attrs);
            Path relativize = one.relativize (file);
            Path fileInOther = other.resolve (relativize);
            log.debug ("=== comparing: {} to {}", file, fileInOther);
            byte [] otherBytes = Files.readAllBytes (fileInOther);
            byte [] thisBytes = Files.readAllBytes (file);
            if (! Arrays.equals (otherBytes, thisTypes)) {
                throw new AssertionFailedError (file + " is not equal to " + fileInOther);
            }
            return result;
        }}
    );
}

private static void verifyDirsAreEqual (File expected, File generated) throws IOException {
    assertTrue ("Generated Folder doesn't exist: " + generated, generated.exists ());
    assertTrue ("Generated is not a folder?!?!: " + generated, generated.isDirectory ());
    assertTrue ("Expected Folder doesn't exist: " + expected, expected.exists ());
    assertTrue ("Expected is not a folder?!?!: " + expected, expected.isDirectory ());
    Files.walkFileTree (expected.toPath (), new SimpleFileVisitor < Path > () {
        @Override
        public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException {
            FileVisitResult result = super.preVisitDirectory (dir, attrs);
            Path relativize = expected.toPath ().relativize (dir);
            File otherDir = generated.toPath ().resolve (relativize).toFile ();
            log.debug ("=== preVisitDirectory === compare " + dir + " to " + otherDir);
            assertEquals ("Folders doesn't contain same file!?!?", Arrays.toString (dir.toFile ().list ()), Arrays.toString (otherDir.list ()));
            return result;
        }@Override
        public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
            FileVisitResult result = super.visitFile (file, attrs);
            Path relativize = expected.toPath ().relativize (file);
            File fileInOther = generated.toPath ().resolve (relativize).toFile ();
            log.debug ("=== comparing: " + file + " to " + fileInOther);
            String expectedContents = FileUtils.readFileToString (file.toFile ());
            String generatedContents = FileUtils.readFileToString (fileInOther);
            assertEquals ("(" + fileInOther + ")  csv standard doesn't match expected (" + file + ")!", expectedContents, generatedContents);
            return result;
        }}
    );
}

}
