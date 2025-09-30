public class Clone628 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:267025
*  Stack Overflow answer #:14396304
*  And Stack Overflow answer#:14396304
*/
private void parseComments (String tmpFile, Workbook workbook) {
    try {
        FileInputStream fin = new FileInputStream (tmpFile);
        final ZipInputStream zin = new ZipInputStream (fin);
        InputStream in = getInputStream (zin);
        while (true) {
            ZipEntry entry = zin.getNextEntry ();
            if (entry == null) break;
            String name = entry.getName ();
            if (name.endsWith (".xml")) {
                if (name.contains (COMMENTS)) {
                    parseComments (in, workbook);
                }
            }
            zin.closeEntry ();
        }
        in.close ();
        zin.close ();
        fin.close ();
    } catch (FileNotFoundException e) {
        System.out.println (e);
    } catch (IOException e) {
        e.printStackTrace ();
    }
}

private void parseComments (InputStream in, Workbook workbook) {
    try {
        DefaultHandler handler = getCommentHandler (workbook);
        SAXParser saxParser = getSAXParser ();
        saxParser.parse (in, handler);
    } catch (Exception e) {
        e.printStackTrace ();
    }
}

}
