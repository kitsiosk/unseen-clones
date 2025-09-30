public class Clone591 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2570410
*  Stack Overflow answer #:47226967
*  And Stack Overflow answer#:31361225
*/
public static void main (String [] args) throws Exception {
    AuthMethod auth = new TokenAuthMethod (API_KEY, API_SECRET);
    NexmoClient client = new NexmoClient (auth);
    TextMessage message = new TextMessage (FROM_NUMBER, TO_NUMBER, "Hello from Nexmo!");
    SmsSubmissionResult [] responses = client.getSmsClient ().submitMessage (message);
    for (SmsSubmissionResult response : responses) {
        System.out.println (response);
    }
}

public static void main (String args []) {
    GSMConnect gsm = new GSMConnect (comPort);
    if (gsm.init ()) {
        try {
            System.out.println ("Initialization Success");
            gsm.connect ();
            Thread.sleep (5000);
            gsm.checkStatus ();
            Thread.sleep (5000);
            gsm.sendMessage ("+91XXXXXXXX", "Trial Success");
            Thread.sleep (1000);
            gsm.hangup ();
            Thread.sleep (1000);
            gsm.closePort ();
            gsm.outCommand ();
            System.exit (1);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    } else {
        System.out.println ("Can't init this card");
    }
}

}
