import Assimetricas.RSA;
import Hash.Bitcoin;
import Hash.Md5;
import Hash.SHA1;
import Hash.SHA256;
import Simetricas.AES;
import Simetricas.BlowFish;
import Simetricas.TripleDES;

//Aluno: Lucas Moreira Guerra Silva
//Prof Claudio
//github: https://github.com/LucasMGS/ciphers
public class Main {
    
    public static void main(String[] args) throws Exception {
        
    // Todos as classes (exceto BitcoinHash) possuem um arquivo txt de teste específico no diretório "/arquivos";
    // Simétricas: Todas as chaves se encontram dentro do método "Run" de cada classe
    // Todos simétricos e assimétrico leêm um arquivo "inputFile.txt" e gera outro "encrypted.txt" e "decrypted.txt" no diretório "/arquivos";
        AES.Run(); 
        BlowFish.Run(); 
        TripleDES.Run(); 
    // Assimétricas
        RSA.Run();  // as chaves públicas e privadas sao geradas dentro da classe de forma automática! 
    // Hashs 
        Md5.Run(); // gera um hash MD5 para o arquivo inputFile.txt
        SHA1.Run(); // gera um hash SHA-1 para o arquivo inputFile.txt
        SHA256.Run(); // gera um hash SHA-256 para o arquivo inputFile.txt
        Bitcoin.Run(); // gera um simples array de blocks (blockchain) e cada block possui uma hash SHA-256
    }
}