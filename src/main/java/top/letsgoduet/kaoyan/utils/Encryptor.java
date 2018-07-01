package top.letsgoduet.kaoyan.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
    public static String md5(String originStr){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(originStr.getBytes());
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return originStr;
    }
}
