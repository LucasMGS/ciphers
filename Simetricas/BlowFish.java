package Simetricas;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class BlowFish {
    private static final String key = "123";

    private static String encrypt(String password) 
    {
        try {
            byte[] keyData = (key).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData,"Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] hasil = cipher.doFinal(password.getBytes());
            return new String(Base64.getEncoder().encode(hasil));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        
    }
    private static String decrypt(String msgCriptografada) {
        try {
            byte[] keyData = (key).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData,"Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            byte[] hasil = cipher.doFinal(java.util.Base64.getDecoder().decode(msgCriptografada));
            return new String(hasil);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void Run(String text){
        String palavraCriptografada = encrypt(text);
        String palavraDescriptografada = decrypt(palavraCriptografada);
        System.out.println("Mensagem original: " + text);
        System.out.println("Mensagem encriptada: " + palavraCriptografada);
        System.out.println("Mensagem descriptografada: " + palavraDescriptografada);
        System.out.println();
    }
}