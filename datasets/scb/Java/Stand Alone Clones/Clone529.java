public class Clone529 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33418502
*  Stack Overflow answer #:34491866
*  And Stack Overflow answer#:34491866
*/
public void run () {
    try {
        String line = null;
        BufferedReader in = new BufferedReader (new InputStreamReader (inStream));
        while ((line = in.readLine ()) != null) {
            println (line);
        }
    } catch (Exception e) {
        e.printStackTrace ();
    }
    System.out.println ("Exit reading process output");
}

public void run () {
    try {
        int retValue = pro.waitFor ();
        println ("Command exit with return value " + retValue);
        outStream.close ();
        outStream = null;
    } catch (InterruptedException e) {
        e.printStackTrace ();
    } catch (IOException e) {
        e.printStackTrace ();
    }
}

}
