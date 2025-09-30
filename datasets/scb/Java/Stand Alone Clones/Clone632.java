public class Clone632 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6470651
*  Stack Overflow answer #:6650413
*  And Stack Overflow answer#:6787206
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

public static void main (String [] args) throws InterruptedException {
    while (makeMore) {
        new Leakee (0).check ();
    }
    while (true) {
        Thread.sleep (1000);
        System.out.println ("memory=" + Runtime.getRuntime ().freeMemory () + " / " + Runtime.getRuntime ().totalMemory ());
    }
}

}
