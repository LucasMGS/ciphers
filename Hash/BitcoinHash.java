package Hash;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class BitcoinHash {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void Run() throws NoSuchAlgorithmException {

        blockchain.add(new Block("Primeiro Bloco", "0"));
        blockchain.add(new Block("Segundo bloco", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Terceiro bloco :D", blockchain.get(blockchain.size() - 1).hash));

        
		System.out.println(blockchain);
    }


   

}