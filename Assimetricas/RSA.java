package Assimetricas;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSA {
    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        KeyPair pair = generator.generateKeyPair();
    
        return pair;
    }

    private static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
    
        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes("UTF-8"));
    
        return Base64.getEncoder().encodeToString(cipherText);
    }

    private static String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(cipherText);
    
        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);
    
        return new String(decriptCipher.doFinal(bytes),"UTF-8");
    }

    public static void Run(String Message) throws Exception {
        //Gerando a chave pública/privada
        KeyPair pair = generateKeyPair();

        String msgCriptografada = RSA.encrypt(Message, pair.getPublic());
        String msgDescriptografada = decrypt(msgCriptografada, pair.getPrivate());

        System.out.println("Mensagem original: " + Message);
        System.out.println("Mensagem criptografada: "+ msgCriptografada);
        System.out.println("Mensagem descriptografada: " + msgDescriptografada);
        System.out.println();
    }
    
}