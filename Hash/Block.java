package Hash;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; 
    private long timeStamp; 

    public Block(String data,String previousHash ) throws NoSuchAlgorithmException {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

    private String createSHA256Hash(String text) throws NoSuchAlgorithmException {
        return SHA256.CreateHash(text);
    }

    private String calculateHash() throws NoSuchAlgorithmException {
        String calculatedhash = createSHA256Hash(
                previousHash +
                Long.toString(timeStamp) +
                data);
        return calculatedhash;
    }

   
}