package com.ddup.decryption;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author wanjin.hao@woqutech.com
 * @Date 18-07-2020
 */
public class AESSecrete {

    private static final String KEY = "GOODLUCKEVERYONE";
    private static final String ASE_MODEL = "AES/ECB/PKCS5Padding";


    public static void main(String[] args) throws Exception {

        /**
         * 密码长度不超过15位，生成的字符串长度为24位
         */
        String pwd = "123";
        System.out.println(aes(pwd));
        System.out.println(des(aes(pwd)));

    }

    private static String aes(String pwd) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY.getBytes(), "AES");//恢复密钥
        Cipher cipher;//Cipher完成加密或解密工作类
        byte[] cipherByte = null;
        cipher = Cipher.getInstance(ASE_MODEL);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);//对Cipher初始化，解密模式
        cipherByte = cipher.doFinal(pwd.getBytes());//加密data
        return Base64.getEncoder().encodeToString(cipherByte);
    }

    private static String des(String pwd) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");//恢复密钥
        Cipher cipher = null;//Cipher完成加密或解密工作类
        byte[] original = null;
        cipher = Cipher.getInstance(ASE_MODEL);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);//对Cipher初始化，解密模式
        byte[] encrypted1 = Base64.getDecoder().decode(pwd);//先用base64解密
        original = cipher.doFinal(encrypted1);

        return new String(original, StandardCharsets.UTF_8);
    }

}
