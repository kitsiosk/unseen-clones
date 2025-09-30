public class Clone144 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8532328
*  Stack Overflow answer #:8572520
*  And Stack Overflow answer#:13135156
*/
public void authenticate (String apiKeyAndSessionKey, String host, String applicationSecret) throws IOException, XMPPException {
    if (apiKeyAndSessionKey == null || applicationSecret == null) {
        throw new IllegalArgumentException ("Invalid parameters");
    }
    String [] keyArray = apiKeyAndSessionKey.split ("\\|", 2);
    if (keyArray.length < 2) {
        throw new IllegalArgumentException ("API key or session key is not present");
    }
    this.apiKey = keyArray [0];
    this.applicationSecret = applicationSecret;
    this.sessionKey = keyArray [1];
    this.authenticationId = sessionKey;
    this.password = applicationSecret;
    this.hostname = host;
    String [] mechanisms = {"DIGEST-MD5"};
    Map < String, String > props = new HashMap < String, String > ();
    this.sc = Sasl.createSaslClient (mechanisms, null, "xmpp", host, props, this);
    authenticate ();
}

public void authenticate (String username, String host, String password) throws IOException, XMPPException {
    authenticationId = username;
    this.password = password;
    hostname = host;
    String mechanisms [] = {getName ()};
    java.util.Map props = new HashMap ();
    sc = Sasl.createSaslClient (mechanisms, null, "xmpp", host, props, this);
    super.authenticate ();
}

}
