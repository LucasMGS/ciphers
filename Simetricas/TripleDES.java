package Simetricas;
import javax.crypto.*;
import java.security.*;

import java.io.*;

public class TripleDES {
    private static final String ALGORITHM = "DESede";

    public static void Run() {
        try {
            final String _currentDir = System.getProperty("user.dir");
            final File inputFile = new File(_currentDir + "/arquivos/simetricas/3DES/inputFile.txt");
            final File encryptedFile = new File(_currentDir + "/arquivos/simetricas/3DES/Encrypted.txt");
            final File decryptedFile = new File(_currentDir + "/arquivos/simetricas/3DES/Decrypted.txt");

            final SecretKey key = generateKey();
 
            encrypt(key, inputFile, encryptedFile);
            decrypt(key, encryptedFile, decryptedFile);

        } catch (final Exception e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }

    private static SecretKey generateKey() throws NoSuchAlgorithmException {

        final KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
        return keygen.generateKey();
    }

    private static void encrypt(final SecretKey key, final File inputFile, final File outputFile)
            throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IOException,
            IllegalBlockSizeException, BadPaddingException {
        EncryptOrDecrypt(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    private static void decrypt(final SecretKey key, final File inputFile, final File outputFile)
            throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException

    {
        EncryptOrDecrypt(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    public static void EncryptOrDecrypt(final int cipherMode, final SecretKey key, final File inputFile,
            final File outputFile) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
            IOException, IllegalBlockSizeException, BadPaddingException {

        final Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(cipherMode, key);

        final FileInputStream inputStream = new FileInputStream(inputFile);
        final byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);

        final byte[] outputBytes = cipher.doFinal(inputBytes);

        final FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);
        
        inputStream.close();
        outputStream.close();
       

    }
}