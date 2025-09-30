public class Clone284 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:65035
*  Stack Overflow answer #:17634958
*  And Stack Overflow answer#:36116269
*/
public static void main (String args []) {
    DataInputStream cin = new DataInputStream (System.in);
    try {
        int i = Integer.parseInt (cin.readLine ());
    } catch (ArithmeticException e) {
    } catch (Exception e) {
        System.exit (0);
    } finally {
        System.out.println ("Won't be executed");
        System.out.println ("No error");
    }
}

public static void main (String args []) {
    Runnable runnable = new Runnable () {
        @Override
        public void run () {
            try {
                printThreads ("Daemon Thread printing");
                Thread.sleep (10000);
            } catch (Exception e) {
            } finally {
                System.out.println ("finally");
            }
        }}
    ;
    Thread daemonThread = new Thread (runnable);
    daemonThread.setDaemon (Boolean.TRUE);
    daemonThread.setName ("My Daemon Thread");
    daemonThread.start ();
    printThreads ("main Thread Printing");
}

}
