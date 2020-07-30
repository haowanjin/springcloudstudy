package ddup;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author wanjin.hao@woqutech.com
 * @Date 2020/7/30
 */
public class AesPassword {
    private static final String KEY = "GOODLUCKEVERYONE";
    private static final String ASE_MODEL = "AES/ECB/PKCS5Padding";


    public static void main(String[] args) throws Exception {
        if (args[0] == "-d") {
            for (int i = 1; i < args.length; i++) {
                System.out.println(args[i] + ": " + decrypt(args[i]));
            }
        }else if (args[0].equalsIgnoreCase("-e")) {
            for (int i = 1; i < args.length; i++) {
                System.out.println(args[i] + ": " + encrypt(args[i]));
            }
        }else {
            System.out.println("usage: java -jar aes-1.0-SNAPSHOT.jar -e <需要加密的密码：123 password>|| -d <需要解密的密码：oAVQmoAxGMEFR6SOH4VAmw== TW4NIOj+YHteV0mi8vXQGA==>");
        }
    }

    private static String encrypt(String pwd) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY.getBytes(), "AES");//恢复密钥
        Cipher cipher;//Cipher完成加密或解密工作类
        byte[] cipherByte = null;
        cipher = Cipher.getInstance(ASE_MODEL);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);//对Cipher初始化，解密模式
        cipherByte = cipher.doFinal(pwd.getBytes());//加密data
        return Base64.getEncoder().encodeToString(cipherByte);
    }

    private static String decrypt(String pwd) throws Exception {
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
