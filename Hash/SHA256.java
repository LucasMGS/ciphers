package Hash;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    private static final String ALGORITHM = "SHA-256";

    public static void Run() throws NoSuchAlgorithmException, IOException
    {
        String _currentDir = System.getProperty("user.dir");
        File file = new File(_currentDir + "/arquivos/hash/SHA-256/inputFile.txt");
        String checkSum = getFileChecksum(file);
        System.out.println("CheckSum(SHA-256) do arquivo : " + checkSum);
        System.out.println();
    }

    public static String CreateHash(String Message) throws NoSuchAlgorithmException
     {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);

        byte[] encodedhash = digest.digest(
            Message.getBytes(StandardCharsets.UTF_8));
  
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < encodedhash.length; i++) {
        String hex = Integer.toHexString(0xff & encodedhash[i]);
        if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static String getFileChecksum(File file) throws IOException, NoSuchAlgorithmException 
    {   
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);

        FileInputStream inputStream = new FileInputStream(file);

        byte[] byteArray = new byte[1024];
        int bytesCount = 0; 
        
        while ((bytesCount = inputStream.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };
        
        inputStream.close();
        
        byte[] bytes = digest.digest();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

    return sb.toString();
    }
}


