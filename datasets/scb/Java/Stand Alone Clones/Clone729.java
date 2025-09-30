public class Clone729 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3382996
*  Stack Overflow answer #:27050680
*  And Stack Overflow answer#:40125872
*/
public static void unzip (File zipFile, File targetDirectory) throws IOException {
    ZipInputStream zis = new ZipInputStream (new BufferedInputStream (new FileInputStream (zipFile)));
    try {
        ZipEntry ze;
        int count;
        byte [] buffer = new byte [8192];
        while ((ze = zis.getNextEntry ()) != null) {
            File file = new File (targetDirectory, ze.getName ());
            File dir = ze.isDirectory () ? file : file.getParentFile ();
            if (! dir.isDirectory () && ! dir.mkdirs ()) throw new FileNotFoundException ("Failed to ensure directory: " + dir.getAbsolutePath ());
            if (ze.isDirectory ()) continue;
            FileOutputStream fout = new FileOutputStream (file);
            try {
                while ((count = zis.read (buffer)) != - 1) fout.write (buffer, 0, count);
            } finally {
                fout.close ();
            }
        }
    } finally {
        zis.close ();
    }
}

public void unzip () {
    try {
        FileInputStream fin = new FileInputStream (_zipFile);
        ZipInputStream zin = new ZipInputStream (fin);
        ZipEntry ze = null;
        while ((ze = zin.getNextEntry ()) != null) {
            Log.v ("Decompress", "Unzipping " + ze.getName ());
            if (ze.isDirectory ()) {
                _dirChecker (ze.getName ());
            } else {
                FileOutputStream fout = new FileOutputStream (_location + ze.getName ());
                BufferedOutputStream bufout = new BufferedOutputStream (fout);
                byte [] buffer = new byte [1024];
                int read = 0;
                while ((read = zin.read (buffer)) != - 1) {
                    bufout.write (buffer, 0, read);
                }
                bufout.close ();
                zin.closeEntry ();
                fout.close ();
            }
        }
        zin.close ();
        Log.d ("Unzip", "Unzipping complete. path :  " + _location);
    } catch (Exception e) {
        Log.e ("Decompress", "unzip", e);
        Log.d ("Unzip", "Unzipping failed");
    }
}

}
