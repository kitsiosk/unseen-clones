public class Clone375 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:30204203
*  Stack Overflow answer #:30204307
*  And Stack Overflow answer#:30204307
*/
public void run () {
    while (appRunning) {
        System.out.println ("App running...");
        try {
            Thread.sleep (1000);
        } catch (InterruptedException e) {
        }
        if (pause > 0) {
            System.out.println ("App pausing for " + pause + " ms");
            try {
                Thread.sleep (pause);
            } catch (InterruptedException e) {
            }
            pause = 0;
        }
    }
}

public void run () {
    {
        System.out.println ("New Communication Thread Started");
        try {
            PrintWriter out = new PrintWriter (clientSocket.getOutputStream (), true);
            BufferedReader in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream ()));
            String inputLine;
            while ((inputLine = in.readLine ()) != null) {
                System.out.println ("Received: " + inputLine);
                try {
                    long pauseCommand = Long.parseLong (inputLine);
                    pause = pauseCommand;
                    out.println ("OK, pausing for " + inputLine + " ms");
                } catch (NumberFormatException e) {
                }
                if (inputLine.equals ("BYE")) {
                    out.println ("OK, bye!");
                    break;
                }
                if (inputLine.equals ("STOP")) {
                    out.println ("OK, stopping!");
                    System.exit (1);
                }
            }
            out.close ();
            in.close ();
            clientSocket.close ();
        } catch (IOException e) {
            System.err.println ("Problem with Communication Server");
            System.exit (1);
        }
    }}

}
