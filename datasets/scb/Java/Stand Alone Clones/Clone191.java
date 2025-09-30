public class Clone191 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1945618
*  Stack Overflow answer #:34784290
*  And Stack Overflow answer#:18927870
*/
public boolean handleMessage (SOAPMessageContext context) {
    Boolean isRequest = (Boolean) context.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if (isRequest) {
        System.out.println ("is Request");
    } else {
        System.out.println ("is Response");
    }
    SOAPMessage message = context.getMessage ();
    try {
        SOAPEnvelope envelope = message.getSOAPPart ().getEnvelope ();
        SOAPHeader header = envelope.getHeader ();
        message.writeTo (System.out);
    } catch (SOAPException | IOException e) {
        e.printStackTrace ();
    }
    return true;
}

public boolean handleMessage (SOAPMessageContext context) {
    SOAPMessage msg = context.getMessage ();
    try {
        msg.writeTo (System.out);
    } catch (Exception ex) {
        Logger.getLogger (LogMessageHandler.class.getName ()).log (Level.SEVERE, null, ex);
    }
    return true;
}

}
