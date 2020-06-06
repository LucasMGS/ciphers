package Hash;
import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA1 {
    public static void Run(String Message){
		String sha1 = "";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(Message.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}

        System.out.println("O SHA1 de \""+ Message + "\" é: " + sha1);
        System.out.println();

    }
}