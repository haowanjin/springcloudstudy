package com.ddup.quartz.thread;


import lombok.val;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author wanjin.hao@woqutech.com
 * @Date 18-07-2020
 */
public class ThreadPoolDemo {

    private static final String KEY = "QWERTYUIOPLKJHGF";


    public static void main(String[] args) throws Exception {
      /*  ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> System.out.println("新年好!"));*/
        System.out.println(aes("abc"));
        System.out.println(des(aes("abc")));

    }

    private static String aes(String pwd) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(KEY.getBytes(), "AES");//恢复密钥
        Cipher cipher = Cipher.getInstance("AES");//Cipher完成加密或解密工作类
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);//对Cipher初始化，解密模式
        byte[] cipherByte = cipher.doFinal(pwd.getBytes());//加密data

        return Base64.getEncoder().encodeToString(cipherByte);
    }

    private static String des(String pwd) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        System.out.println(pwd);

        SecretKey secretKey = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");//恢复密钥
        Cipher cipher = Cipher.getInstance("AES");//Cipher完成加密或解密工作类
        cipher.init(Cipher.DECRYPT_MODE, secretKey);//对Cipher初始化，解密模式

        byte[] encrypted1 = Base64.getDecoder().decode(pwd);//先用base64解密
        byte[] original = cipher.doFinal(encrypted1);

        return new String(original, StandardCharsets.UTF_8);
    }

}
