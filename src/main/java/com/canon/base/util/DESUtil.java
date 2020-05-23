package com.canon.base.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @Author Canon
 * @Date:Created in 1:31 2020/5/21
 * @Modify By: canon
 * @Despricction:DES加密介绍
 *  * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 *  * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 *  * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 *  * 。
 *  * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 * @since 1.0
 */
public class DESUtil {
    public static final String  SAKT_FIGURE = "GoodHomePlus" ;
    private static String charset = "utf-8";
    private static String secretyype = "DES";

    /**
     * 加密
     * @param content 待加密数据
     * @param password 密钥
     * @return 加密后的二进制数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes(charset));
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(secretyype);
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(secretyype);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(content);
    }

    /**
     * 解密
     * @param content 待解密数据
     * @param password 密钥
     * @return 解密后的二进制数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, String password) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes(charset));
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(secretyype);
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(secretyype);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(content);
    }

    /**
     * 加密
     * @param content 待加密字符串
     * @param password 密钥
     * @return 加密数据的16进制格式
     * @throws Exception
     */
    public static String encrypt(String content, String password) throws Exception {
        byte[] data = content.getBytes(charset);
        byte[] encrypted = encrypt(data, password);
        return HexUtil.bytesToHex(encrypted);
    }

    /**
     * 加密
     * @param content 待加密字符串
     * @return 加密数据的16进制格式
     * @throws Exception
     */
    public static String encryptDefault(String content) throws Exception {

        return encrypt(content,SAKT_FIGURE);
    }

    /**
     * 解密
     * @param content 已加密数据的16进制格式
     * @param password 密钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decrypt(String content, String password) throws Exception {
        byte[] data = HexUtil.hexToBytes(content);
        byte[] result = decrypt(data, password);
        return new String(result, charset);
    }

    /**
     * 解密
     * @param content 已加密数据的16进制格式
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String decryptDefault(String content) throws Exception {

        return decrypt ( content ,SAKT_FIGURE );
    }


    /**
     * 测试
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception {
        // 待加密内容
        String content = "lujuns123";
        // 密码，长度要是8的倍数
        //  String password = "password.123 ";

        String result = DESUtil.encryptDefault(content);
        System.out.println("加密后：" + result);
        // 直接将如上内容解密
        String decryResult = DESUtil.decryptDefault(result);
          System.out.println("解密后：" + decryResult);
    }
}
