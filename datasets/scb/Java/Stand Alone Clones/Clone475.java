public class Clone475 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15968883
*  Stack Overflow answer #:31557287
*  And Stack Overflow answer#:15969656
*/
static private void addFolderToZip (String path, String srcFolder, ZipOutputStream zip) throws Exception {
    File folder = new File (srcFolder);
    for (String fileName : folder.list ()) {
        if (path.equals ("")) {
            addFileToZip (folder.getName (), srcFolder + "/" + fileName, zip);
        } else {
            addFileToZip (path + "/" + folder.getName (), srcFolder + "/" + fileName, zip);
        }
    }
}

private void addFolderToZip (String path, String srcFolder, ZipOutputStream zip) throws IOException {
    File folder = new File (srcFolder);
    if (folder.list ().length == 0) {
        addFileToZip (path, srcFolder, zip, true);
    } else {
        for (String fileName : folder.list ()) {
            if (path.equals ("")) {
                addFileToZip (folder.getName (), srcFolder + "/" + fileName, zip, false);
            } else {
                addFileToZip (path + "/" + folder.getName (), srcFolder + "/" + fileName, zip, false);
            }
        }
    }
}

}
