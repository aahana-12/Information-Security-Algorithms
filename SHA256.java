package ISPractical;
import java.security.MessageDigest;
public class SHA256 {

    public static String bytesToHex(byte[] bytes){
        StringBuilder str = new StringBuilder();
        for(byte b:bytes){
            str.append(String.format("%02x",b));
        }
        return str.toString();
    }

    public static String hashSHA256(String text) throws Exception{
        MessageDigest dgst = MessageDigest.getInstance("SHA-256");
        byte[] hashes = dgst.digest(text.getBytes());
        return bytesToHex(hashes);
    }

    public static void main(String[] args) throws Exception{
        String str = "Encrypt this juice ayoooo";
        String hash = hashSHA256(str);
        System.out.println("The original string "+str);
        System.out.println("The encrypted string "+hash);
    }
}
