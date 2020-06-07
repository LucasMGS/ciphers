package Assimetricas;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.*;


public class RSA {
    private static final String ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static PublicKey publicKey = null;
    private static PrivateKey privateKey = null;

    private static void encrypt(PublicKey publicKey,File inputFile, File outputFile)  {
        try{
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                

            final FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            final FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void decrypt(PrivateKey privateKey,File inputFile, File outputFile) {
        try{
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            
            final FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            final FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
            
            inputStream.close();
            outputStream.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        privateKey = pair.getPrivate();
        publicKey = pair.getPublic();
    }

    public static void Run(){
        try {
            RSAKeyPairGenerator();
            String _currentDir = System.getProperty("user.dir");
            File inputFile = new File(_currentDir + "/arquivos/assimetricas/RSA/inputFile.txt");
            File encryptedFile = new File(_currentDir + "/arquivos/assimetricas/RSA/encrypted.txt");
            File decryptedFile = new File(_currentDir + "/arquivos/assimetricas/RSA/decrypted.txt");
            encrypt(publicKey, inputFile, encryptedFile);
            decrypt(privateKey, encryptedFile, decryptedFile);
            
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }

    }
}