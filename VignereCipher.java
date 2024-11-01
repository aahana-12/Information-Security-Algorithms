package ISPractical;

public class VignereCipher {

    public static String encrypt(String key,String text){
        String encrypted ="";
        int j=0;
        for(int i=0;i<text.length();i++){
           char letter = text.charAt(i);
           encrypted += (char)(((letter -65) + (key.charAt(j)-65))%26 + 65)+"";
           j = ++j%key.length();
        }
        return encrypted;
    }

    public static String decrypt(String key,String text){
        String answer ="";
        int j=0;
        for(int i=0;i<text.length();i++){
            answer += (char)(((text.charAt(i))-(key.charAt(j)) + 26) % 26 + 65)+"";
            j=++j%key.length();
        }
        return answer;
    }

    public static void main(String[] args){
        String test1 ="SHEISLISTENING";
        String key = "PASCAL";
        String answer = encrypt(key,test1);
        System.out.println("the encrypted text is "+answer);
        String dec = decrypt(key,answer);
        System.out.println("the decrypted text is "+dec);
    }

}
