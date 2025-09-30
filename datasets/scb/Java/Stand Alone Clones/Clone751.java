public class Clone751 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33010209
*  Stack Overflow answer #:33045659
*  And Stack Overflow answer#:33011923
*/
public static void main (String [] args) throws Exception {
    BigInteger bad1 = new BigInteger (DH_GRP_14_P);
    BigInteger good1 = new BigInteger (1, DH_GRP_14_P);
    byte [] augmentedBytes = new byte [DH_GRP_14_P.length + 1];
    System.arraycopy (DH_GRP_14_P, 0, augmentedBytes, 1, DH_GRP_14_P.length);
    BigInteger good2 = new BigInteger (augmentedBytes);
    System.out.println (bad1);
    System.out.println (good1);
    System.out.println (good1.equals (good2));
    System.out.println (good1.isProbablePrime (50));
}

public static void main (String [] args) throws Exception {
    KeyPairGenerator hostKeyGen = KeyPairGenerator.getInstance ("DH");
    BigInteger p = new BigInteger (modp2048, 16);
    BigInteger g = BigInteger.valueOf (2L);
    System.out.println ("p bits: " + p.bitLength ());
    System.out.println ("g bits: " + g.bitLength ());
    DHParameterSpec dhGrp14KeySpec = new DHParameterSpec (p, p);
    hostKeyGen.initialize (dhGrp14KeySpec);
    System.out.println ("Creating Host DH private key...");
    KeyPair hostKey = hostKeyGen.generateKeyPair ();
    System.out.println ("Initiating host side Schannel...");
    KeyAgreement schannel = KeyAgreement.getInstance ("DH");
    schannel.init (hostKey.getPrivate ());
}

}
