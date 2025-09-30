public class Clone590 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2570410
*  Stack Overflow answer #:29105532
*  And Stack Overflow answer#:31361225
*/
public static void main (String [] args) throws TwilioRestException {
    TwilioRestClient client = new TwilioRestClient (ACCOUNT_SID, AUTH_TOKEN);
    List < NameValuePair > params = new ArrayList < NameValuePair > ();
    params.add (new BasicNameValuePair ("Body", "Test Twilio message"));
    params.add (new BasicNameValuePair ("To", "+14159352345"));
    params.add (new BasicNameValuePair ("From", "+14158141829"));
    MessageFactory messageFactory = client.getAccount ().getMessageFactory ();
    Message message = messageFactory.create (params);
    System.out.println (message.getSid ());
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
