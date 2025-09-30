public class Clone461 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18142745
*  Stack Overflow answer #:18143616
*  And Stack Overflow answer#:30896438
*/
public static byte [] hash (char [] password, byte [] salt) {
    PBEKeySpec spec = new PBEKeySpec (password, salt, ITERATIONS, KEY_LENGTH);
    Arrays.fill (password, Character.MIN_VALUE);
    try {
        SecretKeyFactory skf = SecretKeyFactory.getInstance ("PBKDF2WithHmacSHA1");
        return skf.generateSecret (spec).getEncoded ();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        throw new AssertionError ("Error while hashing a password: " + e.getMessage (), e);
    } finally {
        spec.clearPassword ();
    }
}

public byte [] hash (String password, byte [] salt) {
    Validate.notNull (password, "Password must not be null");
    Validate.notNull (salt, "Salt must not be null");
    try {
        final byte [] passwordBytes = password.getBytes ("UTF-8");
        final byte [] all = ArrayUtils.addAll (passwordBytes, salt);
        SHA3.DigestSHA3 md = new SHA3.Digest512 ();
        md.update (all);
        return md.digest ();
    } catch (UnsupportedEncodingException e) {
        final String message = String.format ("Caught UnsupportedEncodingException e: <%s>", e.getMessage ());
        LOGGER.error (message);
    }
    return new byte [0];
}

}
