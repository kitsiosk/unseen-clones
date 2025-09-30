public class Clone277 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:620993
*  Stack Overflow answer #:13533390
*  And Stack Overflow answer#:39903784
*/
public static boolean isBinaryFile (File f) throws FileNotFoundException, IOException {
    FileInputStream in = new FileInputStream (f);
    int size = in.available ();
    if (size > 1024) size = 1024;
    byte [] data = new byte [size];
    in.read (data);
    in.close ();
    int ascii = 0;
    int other = 0;
    for (int i = 0;
    i < data.length; i ++) {
        byte b = data [i];
        if (b < 0x09) return true;
        if (b == 0x09 || b == 0x0A || b == 0x0C || b == 0x0D) ascii ++;
        else if (b >= 0x20 && b <= 0x7E) ascii ++;
        else other ++;
    }
    if (other == 0) return false;
    return 100 * other / (ascii + other) > 95;
}

boolean isBinaryFile (File f) throws IOException {
    String type = Files.probeContentType (f.toPath ());
    if (type == null) {
        return true;
    } else if (type.startsWith ("text")) {
        return false;
    } else {
        return true;
    }
}

}
