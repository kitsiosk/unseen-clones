public class Clone467 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11506321
*  Stack Overflow answer #:14110872
*  And Stack Overflow answer#:29460716
*/
public static void main (String args []) throws IOException {
    JavaPingExampleProgram ping = new JavaPingExampleProgram ();
    List < String > commands = new ArrayList < String > ();
    commands.add ("ping");
    commands.add ("-c");
    commands.add ("5");
    commands.add ("74.125.236.73");
    ping.doCommand (commands);
}

public static void main (String [] args) {
    try {
        InetAddress address = InetAddress.getByName ("192.168.1.103");
        boolean reachable = address.isReachable (10000);
        System.out.println ("Is host reachable? " + reachable);
    } catch (Exception e) {
        e.printStackTrace ();
    }
}

}
