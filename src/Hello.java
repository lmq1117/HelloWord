import security.EncodeAndDecode;

public class Hello {
    public static void main(String[] args) {
        /*//MD5 && BASE64
        System.out.println("123456_MD5:" + EncodeAndDecode.Md5encode("123456") + "\r\n");//MD5加密
        System.out.println("123456_base64encode:" + EncodeAndDecode.Base64encode("123456") + "\r\n");//base64编码
        System.out.println("MTIzNDU2_base64decode:" + EncodeAndDecode.Base64decode("MTIzNDU2") + "\r\n");//base64解码
        System.out.println("MTIzNDU2_base64decode:" + EncodeAndDecode.Base64decode("MTIzNDU2") + "\r\n");//base64解码*/

        //java aes加密解密
        String content = "123456";
        String aesKey = EncodeAndDecode.generateAESKey();
        System.out.println("content:" + content + "\r\n");//待加密的字符
        System.out.println("aesKey:" + aesKey + "\r\n");//AES 加密 key
        String encrypted = EncodeAndDecode.aesEncrypt(content,aesKey);
        System.out.println("encrypted:" + encrypted + "\r\n");//AES 加密后
        String decrypted = EncodeAndDecode.aesDecrypt(encrypted,aesKey);
        System.out.println("decrypted:" + decrypted + "\r\n");//AES 解密后

    }
}
