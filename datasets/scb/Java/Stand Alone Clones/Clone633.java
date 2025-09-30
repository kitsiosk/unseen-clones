public class Clone633 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6470651
*  Stack Overflow answer #:6650413
*  And Stack Overflow answer#:12395504
*/
public static void main (String [] args) throws Exception {
    Class unsafeClass = Class.forName ("sun.misc.Unsafe");
    Field f = unsafeClass.getDeclaredField ("theUnsafe");
    f.setAccessible (true);
    Unsafe unsafe = (Unsafe) f.get (null);
    System.out.print ("4..3..2..1...");
    try {
        for (;;) unsafe.allocateMemory (1024 * 1024);
    } catch (Error e) {
        System.out.println ("Boom :)");
        e.printStackTrace ();
    }
}

public static void main (String [] args) throws IOException {
    ZipOutputStream zos = new ZipOutputStream (new FileOutputStream (new File ("big.jar")));
    zos.putNextEntry (new ZipEntry ("resource.txt"));
    zos.write ("not too much in here".getBytes ());
    zos.closeEntry ();
    zos.putNextEntry (new ZipEntry ("largeFile.out"));
    for (int i = 0;
    i < 10000000; i ++) {
        zos.write ((int) (Math.round (Math.random () * 100) + 20));
    }
    zos.closeEntry ();
    zos.close ();
}

}
