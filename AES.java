package ISPractical;
import javax.crypto.Cipher;
import javax.crypto.spec.*;
import java.util.*;

public class AES {
    public static String encrypt(String plaintext,String mode,String algo,byte[] key,byte[] iv){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key,algo);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher c = Cipher.getInstance(algo+"/"+mode+"/"+"PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);
            //byte array
            byte[] encArray = c.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encArray);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //encrypt method for ECB mode
    public static String encrypt(String plaintext,String algo,String mode,byte[] key){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key,algo);
            Cipher c = Cipher.getInstance(algo+"/"+mode+"/"+"PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE,keySpec);
            byte[] encArray = c.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encArray);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //decrypt method
    public static String decrypt(String cipher,String algo,String mode,byte[] key,byte[] iv){
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key,algo);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            Cipher c=Cipher.getInstance(algo+"/"+mode+"/"+"PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);

            byte[] decArray = Base64.getDecoder().decode(cipher.getBytes());
            byte[] decrypted = c.doFinal(decArray);
            return new String(decrypted);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){

    }
}
