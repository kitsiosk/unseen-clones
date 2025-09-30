public class Clone934 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1844688
*  Stack Overflow answer #:13532147
*  And Stack Overflow answer#:52440140
*/
public static void listFilesForFolder (final File folder) {
    for (final File fileEntry : folder.listFiles ()) {
        if (fileEntry.isDirectory ()) {
            listFilesForFolder (fileEntry);
        } else {
            if (fileEntry.isFile ()) {
                temp = fileEntry.getName ();
                if ((temp.substring (temp.lastIndexOf ('.') + 1, temp.length ()).toLowerCase ()).equals ("txt")) System.out.println ("File= " + folder.getAbsolutePath () + "\\" + fileEntry.getName ());
            }
        }
    }
}

public static void listFilesForFolder (final File folder) {
    for (final File fileEntry : folder.listFiles ()) {
        if (fileEntry.isDirectory ()) {
            listFilesForFolder (fileEntry);
        } else {
            System.out.println (fileEntry.getName ());
        }
    }
}

}
