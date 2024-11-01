package ISPractical;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAwithAPI {
    public static KeyPair pairGenerator() throws Exception{
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public static String encryptbyRSA(String plaintext, PublicKey pubKey) throws Exception{
        Cipher c=Cipher.getInstance("RSA");
        c.init(Cipher.ENCRYPT_MODE,pubKey);
        byte[] hashBytes = c.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public static String decryptbyRSA(String cipher, PrivateKey pvtKey) throws Exception{
        Cipher c= Cipher.getInstance("RSA");
        c.init(Cipher.DECRYPT_MODE,pvtKey);
        byte[] decoded = Base64.getDecoder().decode(cipher);
        byte[] decBytes = c.doFinal(decoded);
        return new String(decBytes);
    }

    public static void main(String[] args) throws Exception {
        String str = "Ocon.";
        KeyPair keypair = pairGenerator();
        PublicKey pubKey = keypair.getPublic();
        PrivateKey pvtKey = keypair.getPrivate();
        String enc = encryptbyRSA(str,pubKey);
        System.out.println(enc);
        String dec = decryptbyRSA(enc,pvtKey);
        System.out.println(dec);

    }
}
