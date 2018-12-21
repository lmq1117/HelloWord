package security;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class EncodeAndDecode {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncodeAndDecode.class);
    public static final String KEY_ALGORITHM = "AES";
    public static final String ENCODING = "utf-8";

    public static String generateAESKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();
        byte[] keyExternal = key.getEncoded();
        return Base64.encodeBase64String(keyExternal);
    }

    public static String aesEncrypt(String content, String key) {
        try {
            byte[] bytesKey = Base64.decodeBase64(key);
            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
            byte[] byteContent = content.getBytes(ENCODING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);// 初始化
            byte[] result = cipher.doFinal(byteContent);// 加密
            return Base64.encodeBase64String(result);
        } catch (Exception e) {
            LOGGER.error("aes encrypt error", e);
        }
        return null;
    }

    public static String aesDecrypt(String content, String key) {
        try {
            byte[] bytesKey = Base64.decodeBase64(key);
            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, secretKey);// 初始化
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));// 解密
            return new String(result);
        } catch (Exception e) {
            LOGGER.error("aes decrypt error", e);
        }
        return null;
    }



    /**
     * Md5加密
     * @param str
     * @return
     */
    public static String Md5encode(String str) {
        return DigestUtils.md5Hex(str);
    }

    /**
     * Base64加密
     * @param str
     * @return
     */
    public static String Base64encode(String str) {
        byte[] b = Base64.encodeBase64(str.getBytes(), true);
        return new String(b);
    }
    /**
     * Base64解密
     * @param str
     * @return
     */
    public static String Base64decode(String str) {
        byte[] b = Base64.decodeBase64(str.getBytes());
        return new String(b);
    }

    /**
     * 生成SHA1
     */
    public static String SHA1encode(String str) {
        return DigestUtils.sha1Hex(str);
    }
    
}
