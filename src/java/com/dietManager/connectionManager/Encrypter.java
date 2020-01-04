package com.dietManager.connectionManager;

import com.dietManager.model.UserDetails.General;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Encrypter {
    public static String md5Encrypt(String pswd){
        String md5encrypt="";
        try{
        MessageDigest md=MessageDigest.getInstance("MD5");
            md.reset();
            md.update(pswd.getBytes("UTF-8"));
            byte[] digest=md.digest();
            BigInteger bigINT=new BigInteger(1,digest);
            String hash=bigINT.toString(16);
            while(hash.length()<32)
                hash="0"+hash;
            md5encrypt+=hash;
                       
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md5encrypt;
    }
    public static String shaEncrypt(String pswd){
        String shaEncrypt="";
        try{
        MessageDigest md=MessageDigest.getInstance("SHA");
            md.reset();
            md.update(pswd.getBytes("UTF-8"));
            byte[] digest=md.digest();
            BigInteger bigINT=new BigInteger(1,digest);
            String hash=bigINT.toString(16);
            while(hash.length()<32)
                hash="0"+hash;
            shaEncrypt+=hash;
                       
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shaEncrypt;
    }
    
}
