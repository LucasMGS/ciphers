import Simetricas.AES;
import Simetricas.BlowFish;
import Simetricas.TripleDES;
import Assimetricas.RSA;
import Hash.BitcoinHash;
import Hash.Md5;
import Hash.SHA1;
import Hash.SHA256;

// import Simetricas.AES;
// import Simetricas.BlowFish;
// import Simetricas.TripleDES;

public class Main {
    public static void main(String[] args) throws Exception {
    // Simétricas
        AES.Run("Texto teste AES");
        BlowFish.Run("Texto teste BlowFish");
        TripleDES.Run("01234567"); // deve ser multiplo de 8

    // Assimétricas       
        RSA.Run("Texto teste RSA");
    // Hashs
        Md5.Run("Texto teste MD5"); // retorna uma hash MD5 de acordo com o texto passado
        SHA1.Run("Texto teste SHA1"); // retorna uma hash SHA-1 de acordo com o texto passado
        SHA256.Run("Texto teste SHA256"); // retorna uma hash SHA-256 de acordo com o texto passado
        BitcoinHash.Run(); //retorna um array de blocks (blockchain)
    }
}