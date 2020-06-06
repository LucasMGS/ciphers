package Hash;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Md5 {
    public static void Run(String Message) throws Exception{
   
        MessageDigest md5=MessageDigest.getInstance("MD5");
        md5.update(Message.getBytes(),0,Message.length());
        System.out.println("MD5 de \"" + Message + "\" é: " + new BigInteger(1,md5.digest()).toString(16));
     }
}