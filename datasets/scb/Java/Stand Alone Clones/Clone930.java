public class Clone930 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3468987
*  Stack Overflow answer #:43464825
*  And Stack Overflow answer#:3469086
*/
public static void main (String [] args) {
    final String USERNAME = "abc";
    final String PASSWORD = "abc";
    final String host = "3.98.22.10";
    final int port = 22;
    HashMap < String, List < String > > result = new HashMap < String, List < String > > ();
    exec_linux_cmd ex = new exec_linux_cmd ();
    result = ex.exec_cmd (USERNAME, PASSWORD, host, port, cmd);
    System.out.println ("Result ---> " + result.get ("result"));
    System.out.println ("Error Msg ---> " + result.get ("error"));
}

public static void main (String args []) throws InterruptedException, IOException {
    List < String > command = new ArrayList < String > ();
    command.add (args [0]);
    ProcessBuilder builder = new ProcessBuilder (command);
    Map < String, String > environ = builder.environment ();
    final Process process = builder.start ();
    InputStream is = process.getInputStream ();
    InputStreamReader isr = new InputStreamReader (is);
    BufferedReader br = new BufferedReader (isr);
    String line;
    while ((line = br.readLine ()) != null) {
        System.out.println (line);
    }
    System.out.println ("Program terminated!");
}

}
