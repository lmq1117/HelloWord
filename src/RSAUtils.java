//package test.preloan;
//
//
//import org.apache.commons.codec.binary.Base64;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.crypto.Cipher;
//import java.security.KeyFactory;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.Signature;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
///**
// * 从支付组cashpay-common迁移过来
// * 部分方法与RSASignature不同，会导致错误，为了兼容，继续使用此类
// */
//public class RSAUtils {
//  private static final Logger LOGGER = LoggerFactory.getLogger(RSAUtils.class);
//  public static final String KEY_ALGORITHM = "RSA";
//  public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
//  public static final String ENCODING = "utf-8";
//  public static final String X509 = "X.509";
//
//  /**
//   * 获取公钥
//   *
//   * @param key
//   * @return
//   * @throws Exception
//   */
//  public static PublicKey getPublicKey(String key) throws Exception {
//    byte[] keyBytes = Base64.decodeBase64(key);
//    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
//    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//    PublicKey publicKey = keyFactory.generatePublic(keySpec);
//    return publicKey;
//  }
//
//  /**
//   * 获取私钥
//   *
//   * @param key
//   * @return
//   * @throws Exception
//   */
//  public static PrivateKey getPrivateKey(String key) throws Exception {
//    byte[] keyBytes = Base64.decodeBase64(key.getBytes(ENCODING));
//    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
//    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
//    PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
//    return privateKey;
//  }
//
//  /**
//   * RSA私钥签名
//   *
//   * @param content
//   *            待签名数据
//   * @param privateKey
//   *            私钥
//   * @return 签名值
//   */
//  public static String signByPrivateKey(String content, String privateKey) {
//    try {
//      PrivateKey priKey = getPrivateKey(privateKey);
//      Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//      signature.initSign(priKey);
//      signature.update(content.getBytes(ENCODING));
//      byte[] signed = signature.sign();
//      return new String(Base64.encodeBase64URLSafe(signed), ENCODING);
//    } catch (Exception e) {
//      LOGGER.warn("sign error, content: {}, priKey: {}", new Object[]{content, privateKey});
//      LOGGER.error("sign error", e);
//    }
//    return null;
//  }
//
//  public static boolean verifySignByPublicKey(String content, String sign, String publicKey) {
//    try {
//      PublicKey pubKey = getPublicKey(publicKey);
//
//      Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
//      signature.initVerify(pubKey);
//      signature.update(content.getBytes(ENCODING));
//
//      return signature.verify(Base64.decodeBase64(sign.getBytes(ENCODING)));
//
//    } catch (Exception e) {
//      LOGGER.warn("sign error, content: {}, sign: {}, pubKey: {}", new Object[]{content, sign, publicKey});
//      LOGGER.error("sign error", e);
//    }
//    return false;
//  }
//
//  public static String encryptByPublicKey(String plainText, String publicKey) {
//    try {
//      PublicKey pubKey = getPublicKey(publicKey);
//      Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
//      cipher.init(Cipher.ENCRYPT_MODE, pubKey);
//      byte[] enBytes = cipher.doFinal(plainText.getBytes(ENCODING));
//      return Base64.encodeBase64String(enBytes);
//    } catch (Exception e) {
//      LOGGER.error("encrypt error", e);
//    }
//    return null;
//  }
//
//  public static String decryptByPrivateKey(String enStr, String privateKey) {
//    try {
//      PrivateKey priKey = getPrivateKey(privateKey);
//      Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
//      cipher.init(Cipher.DECRYPT_MODE, priKey);
//      byte[] deBytes = cipher.doFinal(Base64.decodeBase64(enStr));
//      return new String(deBytes);
//    } catch (Exception e) {
//      LOGGER.error("decrypt error", e);
//    }
//    return null;
//  }
//
//
//}
//
