public class Clone109 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:617414
*  Stack Overflow answer #:1305966
*  And Stack Overflow answer#:375997
*/
public static File createTempDir () throws IOException {
    final File sysTempDir = new File (System.getProperty ("java.io.tmpdir"));
    File newTempDir;
    final int maxAttempts = 9;
    int attemptCount = 0;
    do {
        attemptCount ++;
        if (attemptCount > maxAttempts) {
            throw new IOException ("The highly improbable has occurred! Failed to " + "create a unique temporary directory after " + maxAttempts + " attempts.");
        }
        String dirName = UUID.randomUUID ().toString ();
        newTempDir = new File (sysTempDir, dirName);
    } while (newTempDir.exists ());
    if (newTempDir.mkdirs ()) {
        return newTempDir;
    } else {
        throw new IOException ("Failed to create temp dir named " + newTempDir.getAbsolutePath ());
    }
}

public static File createTempDir () {
    final String baseTempPath = System.getProperty ("java.io.tmpdir");
    Random rand = new Random ();
    int randomInt = 1 + rand.nextInt ();
    File tempDir = new File (baseTempPath + File.separator + "tempDir" + randomInt);
    if (tempDir.exists () == false) {
        tempDir.mkdir ();
    }
    tempDir.deleteOnExit ();
    return tempDir;
}

}
