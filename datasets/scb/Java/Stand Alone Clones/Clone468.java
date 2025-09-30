public class Clone468 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11506321
*  Stack Overflow answer #:14110872
*  And Stack Overflow answer#:11506847
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

public static void main (String [] args) throws UnknownHostException, IOException {
    InetAddress inet;
    inet = InetAddress.getByAddress (new byte [] {127, 0, 0, 1});
    System.out.println ("Sending Ping Request to " + inet);
    System.out.println (inet.isReachable (5000) ? "Host is reachable" : "Host is NOT reachable");
    inet = InetAddress.getByAddress (new byte [] {(byte) 173, (byte) 194, 32, 38});
    System.out.println ("Sending Ping Request to " + inet);
    System.out.println (inet.isReachable (5000) ? "Host is reachable" : "Host is NOT reachable");
}

}
