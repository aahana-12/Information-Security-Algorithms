package ISPractical;
import java.security.MessageDigest;
public class MD5Example {

    public static String bytesToHex(byte[] bytes){
       StringBuilder hexText=new StringBuilder();
        for(byte b : bytes){
            hexText.append(String.format("%02x",b));
        }
       return hexText.toString();
    }

    public static String hashMD5(String text) throws Exception{
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hashBytes = digest.digest(text.getBytes());
        return bytesToHex(hashBytes);
    }

    public static void main(String[] args) throws Exception{
        String str = "Encrypt this juice ayoooo";
        String hash = hashMD5(str);
        System.out.println("The original string "+str);
        System.out.println("The encrypted string "+hash);
    }
}
