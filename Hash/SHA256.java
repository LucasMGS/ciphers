package Hash;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    public static String CreateHash(String Message) throws NoSuchAlgorithmException
     {
        
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

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

    public static void Run(String originalString) throws NoSuchAlgorithmException {
        String hash = CreateHash(originalString);
        System.out.println("A hash SHA-256 do texto \""+ originalString + "\" é " + hash);
    }
}