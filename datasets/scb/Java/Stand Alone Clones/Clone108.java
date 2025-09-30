public class Clone108 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:617414
*  Stack Overflow answer #:1305966
*  And Stack Overflow answer#:8998916
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
    File baseDir = new File (System.getProperty ("java.io.tmpdir"));
    String baseName = System.currentTimeMillis () + "-";
    for (int counter = 0;
    counter < TEMP_DIR_ATTEMPTS; counter ++) {
        File tempDir = new File (baseDir, baseName + counter);
        if (tempDir.mkdir ()) {
            return tempDir;
        }
    }
    throw new IllegalStateException ("Failed to create directory within " + TEMP_DIR_ATTEMPTS + " attempts (tried " + baseName + "0 to " + baseName + (TEMP_DIR_ATTEMPTS - 1) + ')');
}

}
