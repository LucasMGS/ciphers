package Simetricas;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class AES {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    private static void setKey(String myKey) 
    {
        MessageDigest sha1 = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha1 = MessageDigest.getInstance("SHA-1");
            key = sha1.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    private static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    private static String decrypt(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Erro ao descriptografar: " + e.toString());
        }
        return null;
    }

    public static void Run(String text) {
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String encryptedString = encrypt(text, secretKey) ;
        String decryptedString = decrypt(encryptedString, secretKey) ;
        
        System.out.println("Mensagem original: " + text) ;
        System.out.println("Mensagem encriptada: "  + encryptedString);
        System.out.println("Mensagem descriptografada: " + decryptedString);
    }
}
