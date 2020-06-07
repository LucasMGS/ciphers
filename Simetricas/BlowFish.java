package Simetricas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

 

public class BlowFish {
    private static final String ALGORITHM = "Blowfish";
 
    private static void encrypt(final String key, final File inputFile, final File outputFile) {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    private static void decrypt(final String key, final File inputFile, final File outputFile) {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    private static void doCrypto(final int cipherMode, final String key, final File inputFile, final File outputFile)
     {
        try {
            final Key secretKey = new SecretKeySpec(key.getBytes(),ALGORITHM);
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(cipherMode, secretKey);

            final FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            final FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            ex.printStackTrace();
            System.out.println("Erro: " + ex.toString());
        }
    }
    public static void Run(){
        String _currentDir = System.getProperty("user.dir");
        String key = "blowfishkey123456";
        File inputFile = new File(_currentDir + "/arquivos/simetricas/Blowfish/inputFile.txt");
        File encryptedFile = new File(_currentDir + "/arquivos/simetricas/Blowfish/Encrypted.txt");
        File decryptedFile = new File(_currentDir + "/arquivos/simetricas/Blowfish/Decrypted.txt");
        encrypt(key, inputFile, encryptedFile);
        decrypt(key, encryptedFile, decryptedFile);
    }
}