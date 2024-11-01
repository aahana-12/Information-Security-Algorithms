package ISPractical;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.*;

public class DES {
    //for modes other than ECB
    public static String encrypt(String plaintext,String mode,String algo,byte[] iv,byte[] keyV){
           try{
              SecretKeySpec key = new SecretKeySpec(keyV,algo);
              IvParameterSpec ivSpec = new IvParameterSpec(iv);
              Cipher c = Cipher.getInstance(algo+"/"+mode+"/"+"PKCS5Padding");
              c.init(Cipher.ENCRYPT_MODE,key,ivSpec);
              //declare byte array
               byte[] encBytes = c.doFinal(plaintext.getBytes());
               return Base64.getEncoder().encodeToString(encBytes);
           }
           catch(Exception e){
                e.printStackTrace();
        }
           return null;
    }
    //for ECB, no iv needed
    public static String encrypt(String plaintext,String mode,String algo,byte[] key){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key,algo);
            Cipher c = Cipher.getInstance(algo+"/"+mode+"/"+"PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE,keySpec);
            //declaring array of encrypted bytes
            byte[] encBytes = c.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encBytes);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //METHODS FOR DECRYPTION
    public static String decrypt(String text,String algo,String mode,byte[] key,byte[] iv){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key,algo);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher c = Cipher.getInstance(algo+"/"+mode+"/"+"PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
            //byte array to store decoded DES
            byte[] decodedArray = Base64.getDecoder().decode(text);
            //final byte array
            byte[] decArray = c.doFinal(decodedArray);
            return new String(decArray);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String decrypt(String text,String algo,String mode,byte[] key){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key,algo);
            Cipher c = Cipher.getInstance(algo+"/"+mode+"/"+"PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE,keySpec);
            //byte array
            byte[] decoded = Base64.getDecoder().decode(text);
            byte[] decArray = c.doFinal(decoded);
            return new String(decArray);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        String keyValue="EIGHTLET";
        String encrypted=encrypt("THIS IS AAHANA","ECB","DES",keyValue.getBytes());
        System.out.println(encrypted);
    }
}
