//package test.preloan;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
////import com.umpay.api.log.SysOutLogger;
//import java.io.BufferedReader;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.*;
//
//import com.demo2do.core.utils.JsonUtils;
//import lombok.extern.slf4j.Slf4j;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ByteArrayEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.security.PrivateKey;
//import java.security.PublicKey;
//
//@Slf4j
//public class PreLoanTest {
//
//  String requestNO = UUID.randomUUID().toString();
//
//
////  private static final String privateKeyString = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMyYDfS68R/TqZT/CcKtU+2a+/sA+cG0JKs9R/nTC9gNbZtyzAwQrdEBQAKXzl3co9CwzZdiIgRX6ALKag/lYoKezY7UifF07vFyTM2gfpuP1ORh5Dt854n2do5+ovBYaLq+zq9NAlRktvcWAI+uVsgzEKADr4aRLiRapfZ71gU7AgMBAAECgYAWsHY7wc+j2/FemLoYYOiB3UI8n+sS1EuMwgsNZZ5Wo4aYSq7eV6svFphmsTctqZ5xMmpac4OaP7V3OcNxZ9r4tqhMANq00mNwNMCzcsPZ/wXE2+jGLy54OatuT908imRqLE9zLR5OxRtVc3nm5MHTidn8cr666pMzzKSDUkyzoQJBAOcp7Jfw+zXJh+PqgmgV0WGJDMs7Rk9juI7Qo0bFf6Lih7jXSL6iVAYqiJYX3Ts9ZjZVP117Id+lHcHIPjev7FcCQQDik1ZlgGNCGH/zgx1O+gWtP3KmqgLYiMUkdHduH8kzurthfR/zD2pXJenSWnQ5BsZQOhlVFH5KL+YOf+Mjmh+9AkEAyPMV/CN9jY1qtwNmZ6sHwD0ORSF7BoqOpn/SYDRRtzwrddCYKTgdyNpyr9+A7v15/CNxGQdwM+Vqj8lN5MTmswJAHl5BJjmfFCzUeX8JXpyERkRKyavf1cX/JnO1zjzUauqMUvTCY4GdbzDVtiwJh9swmXAwFQc6JhdlbmwVtZ/iwQJBAL9Vihy19dm+T9OXiutV1gS1abIsBwjeyZbx+jBrm+PJQCLkzZlFXELFg7z7qR3Iwrgh/CvWd7mo2Zv5SKzoncs=";
//  private static final String privateKeyString = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMlE75u+g93Qj/KvOnXA7kNbH8WQ6UsUbkkeF6TJwDSAbj3TAP2R6h7B8yAUlex1lL08zZUp8t6zUHMcLx8wSsGld1oQVftkI+Fm8C7Hd+YLRE3gf8SBP6v+TPAk+6kNERiXTptdkQRr5Y+QXwFhirsOZUHzj+9c8hFCJHEMOlZBAgMBAAECgYAwW3G+V73TE4Miadt/40Tbxg8SJskGkvgUdTh1DUwy0RCrpgC868v2a98APDHxSCbeeLdkOVnzC94uaf0gXzf2dau4gCoprl35CrGpUGt3YE9wWrTwglQ5sGlcQWmxSDUbYsxQoR7OPSVj27qyZMT6I7uhTQtPTrth/Lbd6R0CYQJBAOpAPKfzQmvQIrCtM3rWD7ZUvJYnk5PQKv6ZtWNgeM9YKM0C8epBq+WMESK0Hl+j21JAoMKS7IMN0e54E9w8xW0CQQDb9Mdv0jDImVbYKiOePDHmqP8gs+ZIPclN8xSaKjdEJ3+UEDtLdEtr64H8qitdWP20DOBDBl69wPz1sAc3CBOlAkBMx7tZ7WEDB5inQk4SYCGMSN/7c4NquputEeKjbRaMF8Bf2ixC9T2LospnDpS6EnIr1qUawZ+mIRyDRnZ0BLNNAkBaN+eJvRwXW5XcakRbxfLt2klzH3cIEJe+KkM8DK7IfK7+iz3W8CdzZ5DUkvPggPzm2hUuSLGZgUwAdigvcVelAkEAxdf2hKCK08CG19E8avSHFjawO5+zR2vinPXulGx3AJ9jxVeYpiuRQHuMM90h7QWrtoYq6+HhTXCvCBemZJ3exg==";
////    private static final String publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMmA30uvEf06mU/wnCrVPtmvv7APnBtCSrPUf50wvYDW2bcswMEK3RAUACl85d3KPQsM2XYiIEV+gCymoP5WKCns2O1InxdO7xckzNoH6bj9TkYeQ7fOeJ9naOfqLwWGi6vs6vTQJUZLb3FgCPrlbIMxCgA6+GkS4kWqX2e9YFOwIDAQAB";
//  private static final String publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMmA30uvEf06mU/wnCrVPtmvv7APnBtCSrPUf50wvYDW2bcswMEK3RAUACl85d3KPQsM2XYiIEV+gCymoP5WKCns2O1InxdO7xckzNoH6bj9TkYeQ7fOeJ9naOfqLwWGi6vs6vTQJUZLb3FgCPrlbIMxCgA6+GkS4kWqX2e9YFOwIDAQAB";
//
////  private static final String publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8Xo7lJE/xPdSIVUj66tmaTKnf16rmMLO144I/664eZ39Q9iX+rfvK16gAYRAL5ycfrm/F4gTP4UtSdwq7HlVR0Q0g/E0TAgIoTXpF8G0G+7nZ4Jo6NFVUDersl6CTfHI8tqkeoPp9txp5ODzqWhJIqba/J8HmufU3feKCcjBytwIDAQAB";
////  private static final String privateKeyString = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOXUGOKdEkssOI1zqNw4pb6emH1o1JYxooyTQ7FN1IBNqTJLuvA3GsswXIkuQj0imce6ywG/XOCwc9R1l5FwcORtwx2FihGCl7eBkhUwnT0EwGOEARPh96ey+TfvsvRaHOn672v1TEhajAftgm4l7fJDtHdGBjHOs+5Mlir9Z65RAgMBAAECgYEArtAiUZR5yrYLGgTEhyWLZK+Le7CWKtv8MQL+tUlm/mST8s7JlVfEyJKzgCCwf4HnCJXbPiwJgFqW8B61uAmXw6cEoPftEnzvKBTyISt/iEf7DTWKGkDBnlYM9sFU6pU61jw17XEDQRtSBG6cfrlGSelqf25+c8onxu4YwTeLH/ECQQD/H69tPy0FYRvCJ5yXdXEVCKshNN01P+UdDzGtyysE/gmpalbewT+uznApa0qFntcYb8eSpUJzrUlItSCBGUpdAkEA5p4r3qF+4g5V7MBHm3+v1l9JKxYK76990AQJa122rfkY2EEVuvU+8KIAQpVflu/HpDe8QH4mQZTsZj24Skt8hQJAL5j2vrgRqzZB2ohPY8aKcXUrkEdvmdaw5SoHh7gm74iBvvTS/j4ppnBnZqLYxXMsCCgaoNZqPnCvAnygctWIFQJAHm2KLkKyohLwJV+tUwgC5E8IMWYkJUHLYNHXiFICE2xFaesUeel313oYfLCGvzx9493yubOrSoXitw63rR3OnQJBALwGSnGYodmJB5k7un0X6LlO4nSu/+SX9lweloZ1AUg15IuCIYxHAFKwOtOJmx/eMcITaLq8l1qzZ907UXY+Mfs=" ;
//
//
//  private String httpUtils1(String url, Map<String, Object> requestBody) throws Exception {
//    HttpPost httpPost = new HttpPost(url);
//
//    String envelopOriginal = getRandomAesKey();
//
//    PublicKey publicKeyEnvelop = KeyUtil1.getPublicKey(publicKeyString);
//    String envelop = KeyUtil1.rsaEncrypt(envelopOriginal, publicKeyEnvelop);
//
//    String request = JSON.toJSONString(requestBody);
////    String requestDecrypted = KeyUtil.aesEncrypt(request, envelopOriginal);
//
//
//    PrivateKey privateKey = KeyUtil1.getPrivate(privateKeyString);
////    String sign = KeyUtil.sign(requestDecrypted, privateKey);
//
//
//    httpPost.setHeader(HeaderConstant.ENVELOPE, envelop);
////    httpPost.setHeader(HeaderConstant.SIGN, sign);//multipart/form-data
//    httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
////    httpPost.setEntity(new ByteArrayEntity(requestDecrypted.getBytes()));
//    httpPost.setEntity(new ByteArrayEntity(request.getBytes()));
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
//
//    String response = EntityUtils.toString(closeableHttpResponse.getEntity());
//    return response;
//
////
////    JSONObject responseData = JSONObject.parseObject(response);
////    String result = responseData.getString("data");
////    JSONObject result1 = JSONObject.parseObject(result);
////    String resultObject = result1.getString("data");
////    String resultString = KeyUtil1.aesDecrypt(resultObject, KeyUtil1.getAesKey());
////    System.out.println(resultString);
////
////    return resultString;
//
////    JSONObject jsonObject = JSONObject.parseObject(response);
////    String data = jsonObject.getString("data");
////    System.out.println("data:" + data);
//
////   /* if (!StringUtils.isEmpty(data)) {
////
////      String resposeEnvelope = closeableHttpResponse.getFirstHeader(HeaderConstant.ENVELOPE).getValue();
////
////      String resposeSign = closeableHttpResponse.getFirstHeader(HeaderConstant.SIGN).getValue();
////
////      String aseKey = KeyUtil.rsaDecrypt(resposeEnvelope, privateKey); //rsaDecrpt
////
////      Boolean verify = KeyUtil.verify(response, resposeSign, publicKeyEnvelop);
////
////      if (verify) {
////        String deData = KeyUtil.aesDecrypt(data, aseKey);    //aesDescrypt
////        jsonObject.put("data", deData);
////      }
////    }
////
////    return jsonObject.toJSONString();*/
//  }
//
//
//
//  //加密key
//  public String  encryptionKey(String publicKey)throws Exception{
//    String aesKey = KeyUtil1.getAesKey();
//    String enKey = KeyUtil1.rsaEncrypt(aesKey, KeyUtil1.getPublicKey(publicKey));
//    return enKey;
//  }
//
//
//  //加密sign
//  public String encryptionSign(String privateKey)throws Exception{
//    String enSign = KeyUtil1.sign(adjustAmountApplyXZ(), KeyUtil1.getPrivate(privateKey),"SHA1withRSA");
//    return enSign;
//  }
//
//
//  /*加密data
//  * 授信申请：creditApplayXZ()
//  * 授信查询：creditSelectXZ()
//  * 用信申请：contracApplyXZ()
//  * 用信查询：contractSelectXZ()
//  * 调额申请：adjustAmountApplyXZ()
//  * 调额查询: adjustAmountSelectXZ()
//  */
//  public String encryptData(String data)throws Exception {
//
//    String aesKey = KeyUtil1.getAesKey();
//    String enData = KeyUtil1.aesEncrypt(data, aesKey);
//    return enData;
//  }
//
//
//  //解密data
//  public String decryptData(String enData)throws Exception{
//    String aesKey = KeyUtil1.getAesKey();
//    String deData = KeyUtil1.aesDecrypt(enData, aesKey);
//    System.out.println("解密data数据开始");
////    System.out.println(deData);
//    System.out.println("解密data数据结束");
//    return deData;
//  }
//
//
//
//  //解密响应结果
//  public void decryptResponse(String responseResult) throws Exception{
//
//
//
//    JSONObject result = JSONObject.parseObject(responseResult);
//    String data = result.getString("data");
//    String key = result.getString("key");
//    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
//    key = KeyUtil.rsaDecrypt(key, privateKey);
//    result.put("key", key);
//    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//  }
//
//  /*请求
//   * 授信申请：Credit_Applay
//   * 授信查询：Credit_Select
//   * 用信申请：Contract_Applay
//   * 用信查询：Contract_Select
//   * 调额申请：Adjust_Apply
//   * 调额查询：Adjust_Select
//   */
//  public String requestAdjustApply(String enKey,String enSign,String enData,String url) throws Exception{
//
//    Map<String, Object> requestBody = new HashMap<>();
//    requestBody.put("key", enKey);
//    requestBody.put("sign", enSign);
//    requestBody.put("data", enData);
//
//    String result = httpUtils1(url,requestBody);
//    return result;
//  }
//
//
////  //请求-小米
////  @Test
////  public void testXM() throws Exception {
////
////
////    int n = 10;
////
////    for(int i = 0;i < n;i++){
////      test();
////
////      int j =i+1;
////
////      System.out.println("这是第"+j+"次请求");
////
////    }
////  }
//
//
//
//
//  @Test
//  public void testMulti1() throws Exception{
//    //    String uid = "123007";
//    String uid = String.valueOf(new Date().getTime());
//    String uid1 = uid;
//
////    String serialNum = "123008";
//    String serialNum = String.valueOf(new Date().getTime());
//    String serialNum1 = serialNum;
//
//  }
//
//
//
//  @Test
//  public void testMulti() throws Exception{
//
//
////    String uid = "123007";
//    String uid = String.valueOf(new Date().getTime());
//    String uid1 = uid;
//
////    String serialNum = "123008";
//    String serialNum = String.valueOf(new Date().getTime());
//    String serialNum1 = serialNum;
//
////    System.out.println(uid+";"+uid1+";"+serialNum+";"+serialNum1);
//
//    int time = 1;//次数
//
//
//    int pauseTime = 10000;
////    int pauseTime = (int)Math.pow(time,2);
//
//    System.out.println("循环"+time+"次授信和用信接口");
////    int pauseTime = time*time*time;
//
//    for(int i = 0; i < time;i++) {
//
//      testa(uid+i, serialNum+i);
//
//    }
//
//    //暂停5秒
//    try {
//      Thread.currentThread().sleep(pauseTime);
//    }catch (InterruptedException e){
//      e.printStackTrace();
//    }
//    System.out.println(time+"次授信申请结束\n");
//
//    for (int a =0;a<time;a++){
//      testb(serialNum+a);
//    }
//
//    //暂停5秒
//    try {
//      Thread.currentThread().sleep(pauseTime);
//    }catch (InterruptedException e){
//      e.printStackTrace();
//    }
//    System.out.println(time+"次授信查询结束\n");
//
//    for (int j = 0;j<time;j++) {
//      testc(uid1+j, serialNum1+j);
//    }
//
//    //暂停5秒
//    try {
//      Thread.currentThread().sleep(pauseTime);
//    }catch (InterruptedException e){
//      e.printStackTrace();
//    }
//    System.out.println(time+"次用信申请结束\n");
//
//
//    for (int b =0;b<time;b++){
//      testd(serialNum1+b);
//    }
//    System.out.println(time+"次用信查询结束\n");
//
//  }
//
//
//
//  //1授信申请请求-小米
//  public void testa(String uid,String serialNum) throws Exception {
//    String aesKey = AESUtils.generateAESKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
//    String sign = KeyUtil1.sign(creditApplayXZ1(uid,serialNum), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//授信申请
//
//    //”data“数据加密
//    String data1 = AESUtils.encrypt(creditApplayXZ1(uid,serialNum), aesKey);
//    //"data"数据解密
////    System.out.println("-----------------------------------");
////    System.out.println("“data”请求数据体（解密）");
////    System.out.println("INFO:------------------------------");
////    System.out.println(data1);
////    System.out.println("-----------------------------------");
//
//    //1授信申请
//    Map<String, Object> requestBody = new HashMap<>();
//    requestBody.put("key", key);
//    requestBody.put("sign", sign);
//    requestBody.put("data", data1);
//
//    String result1 = httpUtils1(PreloanBaseApiPost.Credit_Applay, requestBody);//授信申请
//
////    System.out.println("-----------------------------------");
////    System.out.println("授信申请结果" + result1);
////    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result1);
//    String data = result.getString("data");
//    key = result.getString("key");
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//  }
//
//  //2授信查询请求-小米
//  public void testb(String serialNum) throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
//    String sign1 = KeyUtil1.sign(creditSelectXZ1(serialNum), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//授信查询
//
//    //”data“数据加密
//    String data2 = AESUtils.encrypt(creditSelectXZ1(serialNum), aesKey);
//    //"data"数据解密
////    System.out.println("-----------------------------------");
////    System.out.println("“data”请求数据体（解密）");
////    System.out.println("INFO:------------------------------");
////    System.out.println(data2);
////    System.out.println("-----------------------------------");
//
//    Map<String, Object> requestBody1 = new HashMap<>();
//    requestBody1.put("key", key);
//    requestBody1.put("sign", sign1);
//    requestBody1.put("data", data2);
//
//    String result2 = httpUtils1(PreloanBaseApiPost.Credit_Select, requestBody1);//授信查询
//
////    System.out.println("-----------------------------------");
////    System.out.println("授信查询结果" + result2);
////    System.out.println("-----------------------------------");
//
//    JSONObject result = JSONObject.parseObject(result2);
//    String data = result.getString("data");
//    key = result.getString("key");
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//
//
//  }
//
//  //3用信申请请求-小米
//  public void testc(String uid,String serialNum) throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
//    String sign2 = KeyUtil1.sign(contracApplyXZ1(uid,serialNum), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
//
//
//    //”data“数据加密
//    String data2 = AESUtils.encrypt(contracApplyXZ1(uid,serialNum), aesKey);
//    //"data"数据解密
////    System.out.println("-----------------------------------");
////    System.out.println("“data”请求数据体（解密）");
////    System.out.println("INFO:------------------------------");
////    System.out.println(data2);
////    System.out.println("-----------------------------------");
//
//
//    //4用信申请
//    Map<String, Object> requestBody2 = new HashMap<>();
//    requestBody2.put("key", key);
//    requestBody2.put("sign", sign2);
//    requestBody2.put("data", data2);
//
//    String result3 = httpUtils1(PreloanBaseApiPost.Contract_Applay, requestBody2);//用信申请
////    System.out.println("-----------------------------------");
////    System.out.println("用信申请结果" + result3);
////    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result3);
//    String data = result.getString("data");
//    key = result.getString("key");
////    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////    key = KeyUtil.rsaDecrypt(key, privateKey);
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
////    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//
//  }
//
//  //4用信查询请求-小米
//  public void testd(String serialNum) throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
//    String sign3 = KeyUtil1.sign(contractSelectXZ1(serialNum), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
//
//
//    //”data“数据加密
//    String data3 = AESUtils.encrypt(contractSelectXZ1(serialNum), aesKey);
//    //"data"数据解密
////    System.out.println("-----------------------------------");
////    System.out.println("“data”请求数据体（解密）");
////    System.out.println("INFO:------------------------------");
////    System.out.println(data3);
////    System.out.println("-----------------------------------");
//
//
//    Map<String, Object> requestBody3 = new HashMap<>();
//    requestBody3.put("key", key);
//    requestBody3.put("sign", sign3);
//    requestBody3.put("data", data3);
//
//    String result4 = httpUtils1(PreloanBaseApiPost.Contract_Select, requestBody3);//用信申请
//
////    System.out.println("-----------------------------------");
////    System.out.println("用信查询结果" + result4);
////    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result4);
//    String data = result.getString("data");
//    key = result.getString("key");
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//
//  }
//
//
//  //授信申请接口-西藏小米
//  public String creditApplayXZ1(String uid,String serialNum) {
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
//      requestBody.put("uid",uid);
//      requestBody.put("serialNum", serialNum);
//      requestBody.put("provider", "XZXT");
//      requestBody.put("userName", "测试"+System.currentTimeMillis());
//      requestBody.put("mobile", "18519199209");
//      requestBody.put("idNum", "429006199208143613");
//      requestBody.put("idType", "CNI");
//      requestBody.put("creditAmount", 3500000L);
//      requestBody.put("bankCardNum", "6214830105694052");
//      requestBody.put("bankMobile", "18519199209");
//      requestBody.put("rate", 500L);
//      requestBody.put("rateType", "D");
//      requestBody.put("timeStamp", System.currentTimeMillis());
//
//
//
//      Map<String, Object> extraData = new HashMap<>();
//      Map<String, Object> riskData = new HashMap<>();
//      riskData.put("credit_repay_count_m3_model","0");
//      riskData.put("credit_repay_count_m6_model","0");
//      riskData.put("credit_repay_money_m12_model","0");
//      riskData.put("credit_repay_money_m1_model","0");
//      riskData.put("credit_repay_money_m3_model","0");
//      riskData.put("credit_repay_money_m6_model","0");
//      riskData.put("ratings_bank_app_install_index","0");
//      riskData.put("ratings_finance_app_install_index","0");
//      riskData.put("ratings_food_app_install_index","0");
//      riskData.put("ratings_fund_app_install_index","0");
//      riskData.put("ratings_game_app_install_index","0");
//      riskData.put("ratings_loan_app_install_index","0");
//      riskData.put("ratings_shopping_app_install_index","0");
//      riskData.put("ratings_social_app_install_index","0");
//      riskData.put("ratings_travel_app_install_index","0");
//      riskData.put("ratings_user_bank_interest_score","0");
//      riskData.put("ratings_user_credit_history_score","0");
//      riskData.put("ratings_user_finance_interest_score","0");
//      riskData.put("ratings_user_food_interest_score","0");
//      riskData.put("ratings_user_fund_interest_score","0");
//      riskData.put("ratings_user_game_interest_score","0");
//      riskData.put("ratings_user_general_score","0");
//      riskData.put("ratings_user_loan_interest_score","0");
//      riskData.put("ratings_user_mi_consume_score","0");
//      riskData.put("ratings_user_shopping_interest_score","0");
//      riskData.put("ratings_user_smartdevice_interest_score","0");
//      riskData.put("ratings_user_social_interest_score","0");
//      riskData.put("ratings_user_travel_interest_sco","0");
//      extraData.put("riskData",riskData);
//
//      requestBody.put("extraData",extraData);
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return null;
//  }
//
//
//  //授信查询接口-西藏小米
//  public String creditSelectXZ1(String serialNum) {
//
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
//      requestBody.put("serialNum", serialNum);//授信流水号
//      requestBody.put("timeStamp", 1532414437175L);//时间戳
//
//      Map<String, Object> extraData = new HashMap<>();
//      extraData.put("behavior_consumer_book_count_m12_model", "0");
//      extraData.put("behavior_consumer_book_money_m12_model", "0");
//      requestBody.put("extraData", JsonUtils.toJsonString(extraData));
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//
//      e.printStackTrace();
//      Assert.fail();
//
//    }
//
//    return null;
//  }
//
//
//  //用信申请接口-西藏小米
//  public String contracApplyXZ1(String uid,String serialNum) {
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("uid", uid);
//      requestBody.put("serialNum", serialNum);
//      requestBody.put("userName", "测试");
//      requestBody.put("mobile", "15288887777");
//      requestBody.put("idNum", "320103190001012118");
//      requestBody.put("idType", "CNI");
//      requestBody.put("bankCardNum", "627768456");
//      requestBody.put("loanAmount", 3600000L);
//      requestBody.put("bankAmount", 3500000L);
//      requestBody.put("loanUse", "旅游");
//      requestBody.put("term", 6L);
//      requestBody.put("loanRate", 500L);
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return null;
//  }
//
//
//  //用信查询接口-西藏小米
//  public String contractSelectXZ1(String serialNum) {
//
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("serialNum", serialNum);
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//
//    return null;
//  }
//
//
//
//  //1授信申请请求-小米
//  @Test
//  public void test() throws Exception {
//    String aesKey = AESUtils.generateAESKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
//    String sign = KeyUtil1.sign(creditApplayXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//授信申请
//
//    //”data“数据加密
//    String data1 = AESUtils.encrypt(creditApplayXZ(), aesKey);
//    //"data"数据解密
//    System.out.println("-----------------------------------");
//    System.out.println("“data”请求数据体（解密）");
//    System.out.println("INFO:------------------------------");
//    System.out.println(data1);
//    System.out.println("-----------------------------------");
//
//    //1授信申请
//    Map<String, Object> requestBody = new HashMap<>();
//    requestBody.put("key", key);
//    requestBody.put("sign", sign);
//    requestBody.put("data", data1);
//
//    String result1 = httpUtils1(PreloanBaseApiPost.Credit_Applay, requestBody);//授信申请
//
//    System.out.println("-----------------------------------");
//    System.out.println("授信申请结果" + result1);
//    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result1);
//    String data = result.getString("data");
//    key = result.getString("key");
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//  }
//
//  //2授信查询请求-小米
//  @Test
//  public void test1() throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
////    String aesKey = KeyUtil1.getAesKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
////    String key = KeyUtil1.rsaEncrypt(aesKey, KeyUtil1.getPublicKey(publicKeyString));
//    String sign1 = KeyUtil1.sign(creditSelectXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//授信查询
////    String sign1 = KeyUtil1.sign(creditSelectXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//授信查询
//
//    //”data“数据加密
//    String data2 = AESUtils.encrypt(creditSelectXZ(), aesKey);
////    String data2 = KeyUtil1.aesEncrypt(creditSelectXZ(), aesKey);
//    //"data"数据解密
////    String encodeData1 = KeyUtil1.aesDecrypt(data2, aesKey);
//
//    System.out.println("-----------------------------------");
//    System.out.println("“data”请求数据体（解密）");
//    System.out.println("INFO:------------------------------");
//    System.out.println(data2);
////    System.out.println(encodeData1);
//    System.out.println("-----------------------------------");
//
//    Map<String, Object> requestBody1 = new HashMap<>();
//    requestBody1.put("key", key);
//    requestBody1.put("sign", sign1);
//    requestBody1.put("data", data2);
//
//    String result2 = httpUtils1(PreloanBaseApiPost.Credit_Select, requestBody1);//授信查询
//
//    System.out.println("-----------------------------------");
//    System.out.println("授信查询结果" + result2);
//    System.out.println("-----------------------------------");
//
//    JSONObject result = JSONObject.parseObject(result2);
//    String data = result.getString("data");
//    key = result.getString("key");
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
////    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////    key = KeyUtil.rsaDecrypt(key, privateKey);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
////    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//
//
//  }
//
//  //3用信申请请求-小米
//  @Test
//  public void test4() throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
////    String aesKey = KeyUtil1.getAesKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
////    String key = KeyUtil1.rsaEncrypt(aesKey, KeyUtil1.getPublicKey(publicKeyString));
//    String sign2 = KeyUtil1.sign(contracApplyXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
////    String sign2 = KeyUtil1.sign(contracApplyXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
//
//
//    //”data“数据加密
//    String data2 = AESUtils.encrypt(contracApplyXZ(), aesKey);
////    String data2 = KeyUtil1.aesEncrypt(contracApplyXZ(), aesKey);
//    //"data"数据解密
////    String encodeData2 = KeyUtil1.aesDecrypt(data2, aesKey);
//    System.out.println("-----------------------------------");
//    System.out.println("“data”请求数据体（解密）");
//    System.out.println("INFO:------------------------------");
//    System.out.println(data2);
//    System.out.println("-----------------------------------");
//
//
//    //4用信申请
//    Map<String, Object> requestBody2 = new HashMap<>();
//    requestBody2.put("key", key);
//    requestBody2.put("sign", sign2);
//    requestBody2.put("data", data2);
//
//    String result3 = httpUtils1(PreloanBaseApiPost.Contract_Applay, requestBody2);//用信申请
//    System.out.println("-----------------------------------");
//    System.out.println("用信申请结果" + result3);
//    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result3);
//    String data = result.getString("data");
//    key = result.getString("key");
////    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////    key = KeyUtil.rsaDecrypt(key, privateKey);
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
////    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//
//  }
//
//  //4用信查询请求-小米
//  @Test
//  public void test3() throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
////    String aesKey = KeyUtil1.getAesKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
////    String key = KeyUtil1.rsaEncrypt(aesKey, KeyUtil1.getPublicKey(publicKeyString));
//    String sign3 = KeyUtil1.sign(contractSelectXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
////    String sign3 = KeyUtil1.sign(contractSelectXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
//
//
//    //”data“数据加密
//    String data3 = AESUtils.encrypt(contractSelectXZ(), aesKey);
////    String data3 = KeyUtil1.aesEncrypt(contractSelectXZ(), aesKey);
//    //"data"数据解密
////    String encodeData3 = KeyUtil1.aesDecrypt(data3, aesKey);
//    System.out.println("-----------------------------------");
//    System.out.println("“data”请求数据体（解密）");
//    System.out.println("INFO:------------------------------");
//    System.out.println(data3);
//    System.out.println("-----------------------------------");
//
//
//    Map<String, Object> requestBody3 = new HashMap<>();
//    requestBody3.put("key", key);
//    requestBody3.put("sign", sign3);
//    requestBody3.put("data", data3);
//
//    String result4 = httpUtils1(PreloanBaseApiPost.Contract_Select, requestBody3);//用信申请
//
//    System.out.println("-----------------------------------");
//    System.out.println("用信查询结果" + result4);
//    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result4);
//    String data = result.getString("data");
//    key = result.getString("key");
////    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////    key = KeyUtil.rsaDecrypt(key, privateKey);
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
////    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//
//  }
//
//  //5调额申请请求-小米
//  @Test
//  public void test5() throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
////    String aesKey = KeyUtil1.getAesKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
////    String key = KeyUtil1.rsaEncrypt(aesKey, KeyUtil1.getPublicKey(publicKeyString));
//    String sign5 = KeyUtil1.sign(adjustAmountApplyXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
////    String sign5 = KeyUtil1.sign(adjustAmountApplyXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
//
//
//    //”data“数据加密
//    String data5 = AESUtils.encrypt(adjustAmountApplyXZ(), aesKey);
////    String data5 = KeyUtil1.aesEncrypt(adjustAmountApplyXZ(), aesKey);
//    //"data"数据解密
////    String encodeData2 = KeyUtil1.aesDecrypt(data5, aesKey);
//    System.out.println("-----------------------------------");
//    System.out.println("“data”请求数据体（解密）");
//    System.out.println("INFO:------------------------------");
//    System.out.println(data5);
//    System.out.println("-----------------------------------");
//
//
//    //4调额申请
//    Map<String, Object> requestBody5 = new HashMap<>();
//    requestBody5.put("key", key);
//    requestBody5.put("sign", sign5);
//    requestBody5.put("data", data5);
//
//    String result5 = httpUtils1(PreloanBaseApiPost.Adjust_Apply,requestBody5);//调额申请
//    System.out.println("-----------------------------------");
//    System.out.println("用信申请结果" + result5);
//    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result5);
//    String data = result.getString("data");
//    key = result.getString("key");
////    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////    key = KeyUtil.rsaDecrypt(key, privateKey);
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
////    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//
//  }
//
//
//  //6调额查询请求-小米
//  @Test
//  public void test6() throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
////    String aesKey = KeyUtil1.getAesKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
////    String key = KeyUtil1.rsaEncrypt(aesKey, KeyUtil1.getPublicKey(publicKeyString));
//    String sign6 = KeyUtil1.sign(adjustAmountSelectXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
////    String sign6 = KeyUtil1.sign(adjustAmountSelectXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
//
//
//    //”data“数据加密
//    String data6 = AESUtils.encrypt(adjustAmountSelectXZ(), aesKey);
////    String data6 = KeyUtil1.aesEncrypt(adjustAmountSelectXZ(), aesKey);
//    //"data"数据解密
////    String encodeData6 = KeyUtil1.aesDecrypt(data6, aesKey);
//    System.out.println("-----------------------------------");
//    System.out.println("“data”请求数据体（解密）");
//    System.out.println("INFO:------------------------------");
//    System.out.println(data6);
//    System.out.println("-----------------------------------");
//
//
//    Map<String, Object> requestBody6 = new HashMap<>();
//    requestBody6.put("key", key);
//    requestBody6.put("sign", sign6);
//    requestBody6.put("data", data6);
//
//    String result6 = httpUtils1(PreloanBaseApiPost.Adjust_Select, requestBody6);//用信申请
//
//    System.out.println("-----------------------------------");
//    System.out.println("调额查询结果" + result6);
//    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result6);
//    String data = result.getString("data");
//    key = result.getString("key");
////    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////    key = KeyUtil.rsaDecrypt(key, privateKey);
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
////    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//  }
//
//
//  //法大大
//  @Test
//  public void test7() throws Exception {
//
//    String aesKey = AESUtils.generateAESKey();
////    String aesKey = KeyUtil1.getAesKey();
//    String key = RSAUtils.encryptByPublicKey(aesKey, publicKeyString);
////    String key = KeyUtil1.rsaEncrypt(aesKey, KeyUtil1.getPublicKey(publicKeyString));
//    String sign6 = KeyUtil1.sign(multiFileUplaodXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
////    String sign6 = KeyUtil1.sign(adjustAmountSelectXZ(), KeyUtil1.getPrivate(privateKeyString),"SHA1withRSA");//用信申请
//
//
//    //”data“数据加密
//    String data6 = AESUtils.encrypt(multiFileUplaodXZ(), aesKey);
////    String data6 = KeyUtil1.aesEncrypt(adjustAmountSelectXZ(), aesKey);
//    //"data"数据解密
////    String encodeData6 = KeyUtil1.aesDecrypt(data6, aesKey);
//    System.out.println("-----------------------------------");
//    System.out.println("“data”请求数据体（解密）");
//    System.out.println("INFO:------------------------------");
//    System.out.println(data6);
//    System.out.println("-----------------------------------");
//
//
//    Map<String, Object> requestBody6 = new HashMap<>();
//    requestBody6.put("key", key);
//    requestBody6.put("sign", sign6);
//    requestBody6.put("data", data6);
//
//    String result6 = httpUtils1(PreloanBaseApiPost.multi_File_upload, requestBody6);//用信申请
//
//    System.out.println("-----------------------------------");
//    System.out.println("调额查询结果" + result6);
//    System.out.println("-----------------------------------");
//
//
//    JSONObject result = JSONObject.parseObject(result6);
//    String data = result.getString("data");
//    key = result.getString("key");
////    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////    key = KeyUtil.rsaDecrypt(key, privateKey);
//    key = RSAUtils.decryptByPrivateKey(key, privateKeyString);
//    result.put("key", key);
//    data = AESUtils.decrypt(data, key);
////    data = KeyUtil.aesDecrypt(data, key);
//    result.put("data", data);
//    System.out.println("响应结果："+JSONObject.toJSONString(result));
//
//  }
//
//
//  //授信申请接口-西藏小米
//  public String creditApplayXZ() {
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
////      requestBody.put("bankCardNum", "320925199301302515");//银行卡号
////      requestBody.put("bankMobile", "13961800411");//银行预留手机号
////      requestBody.put("creditAmount", 1000000L);//授信额度 单位：分
//////      requestBody.put("creditAmount", 31500000L);//授信额度 单位：分
//////      requestBody.put("idNum", "42900619800814363");//证件号码
////      requestBody.put("idNum", "350423198507050035");//证件号码
//////      requestBody.put("idNum", "429006196308143615");//证件号码
////      requestBody.put("idType", "CNI");//证件类型 默认CNI表示身份证
////      requestBody.put("mobile", "13859121817");//手机号码
////      requestBody.put("orgId", "315");//
////      requestBody.put("provider", "XXBANK");//合作渠道标记
//////      requestBody.put("rate", 500);//利率
//////      requestBody.put("rate", 500);//0.18
////      requestBody.put("rate", 666);//0.2398
//////      requestBody.put("rate", 667);//0.2401
//////      requestBody.put("rate", 1800);//利率 日利率万三用300表示
//////      requestBody.put("rate", 2400);//利率 日利率万三用300表示
////
////      requestBody.put("rateType", "D");//利率类型 默认'D' 表示日利率; 年化×360
//////      requestBody.put("serialNum", System.currentTimeMillis());//流水号
////      requestBody.put("serialNum",System.currentTimeMillis());//流水号
//////      requestBody.put("serialNum", "test100001");//流水号
////      requestBody.put("timeStamp", 1532414437175L);//时间戳
////      requestBody.put("uid", System.currentTimeMillis());//用户ID
//////      requestBody.put("uid", "3");//用户ID
//////      requestBody.put("userName","test"+System.currentTimeMillis());//用户
////      requestBody.put("userName","邹德伟");//用户
//////      requestBody.put("userName", "\\u738b\\u535a\\u6587");//用户
////
////      Map<String, Object> extraData = new HashMap<>();//行方需要的其他数据
////      Map<String, Object> riskData = new HashMap<>();
////      riskData.put("credit_repay_count_m3_model","0");
////      riskData.put("credit_repay_count_m6_model","0");
////      riskData.put("credit_repay_money_m12_model","0");
////      riskData.put("credit_repay_money_m1_model","0");
////      riskData.put("credit_repay_money_m3_model","0");
////      riskData.put("credit_repay_money_m6_model","0");
////      riskData.put("ratings_bank_app_install_index","0");
////      riskData.put("ratings_finance_app_install_index","0");
////      riskData.put("ratings_food_app_install_index","0");
////      riskData.put("ratings_fund_app_install_index","0");
////      riskData.put("ratings_game_app_install_index","0");
////      riskData.put("ratings_loan_app_install_index","0");
////      riskData.put("ratings_shopping_app_install_index","0");
////      riskData.put("ratings_social_app_install_index","0");
////      riskData.put("ratings_travel_app_install_index","0");
////      riskData.put("ratings_user_bank_interest_score","0");
////      riskData.put("ratings_user_credit_history_score","0");
////      riskData.put("ratings_user_finance_interest_score","0");
////      riskData.put("ratings_user_food_interest_score","0");
////      riskData.put("ratings_user_fund_interest_score","0");
////      riskData.put("ratings_user_game_interest_score","0");
////      riskData.put("ratings_user_general_score","0");
////      riskData.put("ratings_user_loan_interest_score","0");
////      riskData.put("ratings_user_mi_consume_score","0");
////      riskData.put("ratings_user_shopping_interest_score","0");
////      riskData.put("ratings_user_smartdevice_interest_score","0");
////      riskData.put("ratings_user_social_interest_score","0");
////      riskData.put("ratings_user_travel_interest_sco","0");
////      extraData.put("riskData",riskData);
////
////      requestBody.put("extraData",extraData);
//      requestBody.put("uid", System.currentTimeMillis());
////      requestBody.put("uid", "");
//      requestBody.put("serialNum", System.currentTimeMillis());
////      requestBody.put("serialNum", "");
//      requestBody.put("provider", "XZXT");
////      requestBody.put("provider", "");
//      requestBody.put("userName", "测试"+System.currentTimeMillis());
////      requestBody.put("userName", "");
//      requestBody.put("mobile", "15964929161");
////      requestBody.put("mobile", "");
//      requestBody.put("idNum", "231084197504112712");
////      requestBody.put("idNum", "");
//      requestBody.put("idType", "CNI");
////      requestBody.put("idType", "");
//      requestBody.put("creditAmount", 6000000L);
////      requestBody.put("creditAmount", null);
//      requestBody.put("bankCardNum", "6214830105694052");
////      requestBody.put("bankCardNum", "");
//      requestBody.put("bankMobile", "18519199209");
////      requestBody.put("bankMobile", "");
//      requestBody.put("rate", 500L);
////      requestBody.put("rate", null);
//      requestBody.put("rateType", "D");
////      requestBody.put("rateType", "");
//      requestBody.put("timeStamp", System.currentTimeMillis());
////      requestBody.put("timeStamp", "");
//
//
//      Map<String, Object> extraData = new HashMap<>();
//      Map<String, Object> riskData = new HashMap<>();
//      riskData.put("credit_repay_count_m3_model","0");
//      riskData.put("credit_repay_count_m6_model","0");
//      riskData.put("credit_repay_money_m12_model","0");
//      riskData.put("credit_repay_money_m1_model","0");
//      riskData.put("credit_repay_money_m3_model","0");
//      riskData.put("credit_repay_money_m6_model","0");
//      riskData.put("ratings_bank_app_install_index","0");
//      riskData.put("ratings_finance_app_install_index","0");
//      riskData.put("ratings_food_app_install_index","0");
//      riskData.put("ratings_fund_app_install_index","0");
//      riskData.put("ratings_game_app_install_index","0");
//      riskData.put("ratings_loan_app_install_index","0");
//      riskData.put("ratings_shopping_app_install_index","0");
//      riskData.put("ratings_social_app_install_index","0");
//      riskData.put("ratings_travel_app_install_index","0");
//      riskData.put("ratings_user_bank_interest_score","0");
//      riskData.put("ratings_user_credit_history_score","0");
//      riskData.put("ratings_user_finance_interest_score","0");
//      riskData.put("ratings_user_food_interest_score","0");
//      riskData.put("ratings_user_fund_interest_score","0");
//      riskData.put("ratings_user_game_interest_score","0");
//      riskData.put("ratings_user_general_score","0");
//      riskData.put("ratings_user_loan_interest_score","0");
//      riskData.put("ratings_user_mi_consume_score","0");
//      riskData.put("ratings_user_shopping_interest_score","0");
//      riskData.put("ratings_user_smartdevice_interest_score","0");
//      riskData.put("ratings_user_social_interest_score","0");
//      riskData.put("ratings_user_travel_interest_sco","0");
//      extraData.put("riskData",riskData);
//
//      requestBody.put("extraData",extraData);
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return null;
//  }
//
//
//  //授信查询接口-西藏小米
//  public String creditSelectXZ() {
//
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
////      requestBody.put("serialNum", "1540536935689");//授信流水号
//      requestBody.put("serialNum", "tcsafsf002");//授信流水号
//      requestBody.put("timeStamp", 1532414437175L);//时间戳
////      requestBody.put("timeStamp", 1532414437175L);//时间戳
////      requestBody.put("extraData", null);//行方需要的其他数据
//
//      Map<String, Object> extraData = new HashMap<>();
//      extraData.put("behavior_consumer_book_count_m12_model", "0");
//      extraData.put("behavior_consumer_book_money_m12_model", "0");
//
//      requestBody.put("extraData", JsonUtils.toJsonString(extraData));
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//
//      e.printStackTrace();
//      Assert.fail();
//
//    }
//
//    return null;
//  }
//
//
//  //用信申请接口-西藏小米
//  public String contracApplyXZ() {
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
////      requestBody.put("uid", "1540784829704");//用户ID
//////      requestBody.put("uid", "4");//用户ID
////      requestBody.put("serialNum", "1540784829705");//流水号
//////      requestBody.put("serialNum", "test001");//流水号
////      requestBody.put("userName", "测试1540784829704");//客户姓名
//////      requestBody.put("userName", "测试4");//客户姓名
////      requestBody.put("mobile", "18519199209");//手机号码
////      requestBody.put("idNum", "429006198008143636");//证件号码
//////      requestBody.put("idNum", "429006199208143616");//证件号码
////      requestBody.put("idType", "CNI");//证件类型 默认CNI表示身份证
////      requestBody.put("bankCardNum", "6214830105694053");//银行卡号
////      requestBody.put("loanAmount", 3500000L);//贷款总额 分为单位
//////      requestBody.put("loanAmount", 31500000L);//贷款总额 分为单位
////      requestBody.put("bankAmount", 3500000L);//渠道方金额 分为单位
//////      requestBody.put("bankAmount", 31500000L);//渠道方金额 分为单位
//////      requestBody.put("loanUse", "个人日常消费");//贷款用途
////      requestBody.put("loanUse", "装修房屋");//贷款用途
//////      requestBody.put("loanUse", "教育");//贷款用途
//////      requestBody.put("loanUse", "医疗");//贷款用途
//////      requestBody.put("loanUse", "旅游");//贷款用途
////      requestBody.put("term", "6");//贷款期数
////      requestBody.put("loanRate", 500L);//贷款利率，单位百万分之一，万三日利率用300表示;*360/10000;0.18-0.24
//////      requestBody.put("loanRate", 500L);//贷款利率，0.18
//////      requestBody.put("loanRate", 667L);//贷款利率，0.241
//////      requestBody.put("loanRate", 666L);//贷款利率，0.239
//
////      requestBody.put("uid", "3150039453");
//      requestBody.put("uid", "2.0:usLncbWoqYgOk0jxi9GStHqTTQA=");
////      requestBody.put("uid", "2.0:usLncbWoqYgOk0jxi9GStHqTTQA=");
//      requestBody.put("serialNum", System.currentTimeMillis());
//      requestBody.put("userName", "41474794190");
//      requestBody.put("mobile", "14705305521");
//      requestBody.put("idNum", "342529199512114417");
//      requestBody.put("idType", "CNI");
//      requestBody.put("bankCardNum", "627768456");
//      requestBody.put("loanAmount", 3600000L);
//      requestBody.put("bankAmount", 3500000L);
//      requestBody.put("loanUse", "旅游");
//      requestBody.put("term", 6L);
//      requestBody.put("loanRate", 500L);
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return null;
//  }
//
//
//  //用信查询接口-西藏小米
//  public String contractSelectXZ() {
//
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
//      requestBody.put("serialNum", "1541154879558");
////      requestBody.put("provider", "XZXT");
////      requestBody.put("serialNum", "1540440198497");
//
//      return JSON.toJSONString(requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//
//    return null;
//  }
//
//
//  //调额申请接口-西藏小米
//  public String adjustAmountApplyXZ() {
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
//////      requestBody.put("serialNum", "1540882870005");//调额流水
////      requestBody.put("serialNum", System.currentTimeMillis());//调额流水
//////      requestBody.put("serialNum", "100030289956");//调额流水
////      requestBody.put("orgId", "123");//合作方渠道标记
//////      requestBody.put("provider", "XZXT");//合作方渠道标记
////
////      requestBody.put("timeStamp", System.currentTimeMillis());//时间戳
////      requestBody.put("fileName", "/home/sftp/wf_yizhangtong/download/201810/1540882870003_result.txt");//文件
//////      requestBody.put("fileName", "/home/sftp/wf_yizhangtong/download/201810/adjust.txt");
////
////      Map<String, Object> extraData = new HashMap<>();
////      extraData.put("behavior_consumer_book_count_m12_model", "0");
////      extraData.put("behavior_consumer_book_money_m12_model", "0");
//////
////      requestBody.put("extraData", extraData);
//
//
////      requestBody.put("serialNum", System.currentTimeMillis());
//      requestBody.put("serialNum", "154fdd14624.txt");
//      requestBody.put("provider", "XZXT");
//      requestBody.put("orgId", "330");
////      requestBody.put("provider", "");
//      requestBody.put("timeStamp", System.currentTimeMillis());
////      requestBody.put("timeStamp", "");
////      requestBody.put("fileName", "/home/sftp/wf_yizhangtong/download/201810/1540882870003_result.txt");
////      requestBody.put("fileName", "");
//      requestBody.put("fileName", "/adjust/20181102/1541146181155.txt");
////      requestBody.put("fileName", "/home/test2/test3/test4/adjust/20181101/1540882870003_result.txt");
//
//
//      return JSON.toJSONString(requestBody);
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return null;
//  }
//
//
//  //调额查询接口-西藏小米
//  public String adjustAmountSelectXZ() {
//
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
//      requestBody.put("serialNum", "1541129681531");
//      requestBody.put("orgId", "330");
////      requestBody.put("orgId", "123");
//      requestBody.put("timeStamp", System.currentTimeMillis());
////      requestBody.put("timeStamp", 1531972872L);
////      requestBody.put("extraData", "");
//
////      Map<String, Object> extraData = new HashMap<>();
////      extraData.put("behavior_consumer_book_count_m12_model", "0");
////      extraData.put("behavior_consumer_book_money_m12_model", "0");
////
////      requestBody.put("extraData", extraData);
//
//      return JSON.toJSONString(requestBody);
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//
//    return null;
//  }
//
//
//  //批量文件上传接口-山东
//  public String multiFileUplaodXZ()
//  {
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
//      requestBody.put("requestNo", requestNO);//请求编号
//      requestBody.put("productCode", "xiaomi");//产品代码
//      requestBody.put("merchantContractNo", "1541416468574");//商户借款合同编号,二选一
//      requestBody.put("merchantCreditNo", "1541416355000");//商户授信编号
//      requestBody.put("vedaCreditNo", "SX256900674120130560");//五维授信编号
//      requestBody.put("callbackUrl", null);//回调地址
//
//
//
//      String pathName = "/home/zsh2014/桌面/1541385460000";
//      File file = new File(pathName);
//
//      FileInputStream fileInputStream = null;
//      fileInputStream = new FileInputStream(file);
//      byte[] bytes = new byte[0];
//      bytes = new byte[fileInputStream.available()];
//      fileInputStream.read(bytes);
//      fileInputStream.close();
//      String fileSteam = new String(Base64Util.Base64Encode(bytes));
//
//
//      //属性
//      Map<String,Object> fileObj = new HashMap<>();
//      fileObj.put("fileDoc",fileSteam);//Base64-文件流
//      fileObj.put("extension", "pdf");
//
//      //文件信息集
//      List<Map<String, Object>> fileList = new ArrayList<>();
//      Map<String, Object> fileList1 = new HashMap<>();
//      fileList1.put("fileType", "3");
//      fileList1.put("fileName", "预签章文件");
//      fileList1.put("fileRemoteAddress", null);
//      fileList1.put("fileObj",fileObj);
//      fileList1.put("fileSize","75");//文件信息集
//      fileList1.put("md5Value","8c6d793689945a991762517f66fee5c9");
//      fileList.add(fileList1);
//
//
//      requestBody.put("fileList",fileList);//文件信息集
//
//
//
//
//      return JSON.toJSONString(requestBody);
//
//    }catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return  null;
//  }
//
//
//  //文件转Base64码
//  public static void  conversionToBase64(String filePath){
//
//    try {
//      File file = new File(filePath);
//      FileInputStream fileInputStream = null;
//      fileInputStream = new FileInputStream(file);
//      byte[] bytes = new byte[0];
//      bytes = new byte[fileInputStream.available()];
//      fileInputStream.read(bytes);
//      fileInputStream.close();
//      String fileSteam = new String(Base64Util.Base64Encode(bytes));
//      System.out.println(fileSteam);
//    }catch (Exception e) {
//      e.printStackTrace();
//    }
//
//  }
//
//  //批量文件上传接口-山东
//  public void multiFileUplaod(String merchantContractNo,String vedaContractNo,String merchantCreditNo,String vedaCreditNo)
//  {
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//
//      requestBody.put("requestNo", requestNO);//请求编号
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);//产品代码
//      requestBody.put("merchantContractNo", merchantContractNo);//商户借款合同编号,二选一
//      requestBody.put("vedaContractNo", vedaContractNo);//五维借款合同编号,二选一
//      requestBody.put("merchantCreditNo", merchantCreditNo);//商户授信编号
//      requestBody.put("vedaCreditNo", vedaCreditNo);//五维授信编号
//      requestBody.put("callbackUrl", null);//回调地址
//
//
//
//      String pathName = "/home/zsh2014/桌面/1541385460000";
//      File file = new File(pathName);
//
//      FileInputStream fileInputStream = null;
//      fileInputStream = new FileInputStream(file);
//      byte[] bytes = new byte[0];
//      bytes = new byte[fileInputStream.available()];
//      fileInputStream.read(bytes);
//      fileInputStream.close();
//      String fileSteam = new String(Base64Util.Base64Encode(bytes));
//
//
//
//      //属性
//      Map<String,Object> fileObj = new HashMap<>();
//      fileObj.put("fileDoc","1234");//Base64-文件流
//      fileObj.put("extension", "ppt");
//
//
//      Map<String,Object> fileObj1 = new HashMap<>();
//      fileObj1.put("fileDoc",fileSteam);//Base64-文件流
//      fileObj1.put("extension", "xlsx");
//
//
//      Map<String,Object> fileObj2 = new HashMap<>();
//      fileObj2.put("fileDoc","4567");//Base64-文件流
//      fileObj2.put("extension", "xlsx");
//
//
//
//      //文件信息集
//      List<Map<String, Object>> fileList = new ArrayList<>();
//      Map<String, Object> fileList1 = new HashMap<>();
//      fileList1.put("fileType", "3");
//      fileList1.put("fileName", "预签章文件");
//      fileList1.put("fileRemoteAddress", null);
//      fileList1.put("fileObj",fileObj);
//
//
//      Map<String, Object> fileList2 = new HashMap<>();
//      fileList2.put("fileType", "31");
//      fileList2.put("fileName", "31");
//      fileList2.put("fileRemoteAddress", null);
//      fileList2.put("fileObj", fileObj1);
//
//
//      Map<String, Object> fileList3 = new HashMap<>();
//      fileList3.put("fileType", "32");
//      fileList3.put("fileName", "32");
//      fileList3.put("fileRemoteAddress", null);
//      fileList3.put("fileObj", fileObj2);
//
//
//
//      Map<String, Object> fileList4 = new HashMap<>();
//      fileList4.put("fileType", "33");
//      fileList4.put("fileName", "33");
//      fileList4.put("fileRemoteAddress", "https://www.17.com");
//      fileList4.put("fileObj", null);
//
//
//      Map<String, Object> fileList5 = new HashMap<>();
//      fileList5.put("fileType", "34");
//      fileList5.put("fileName", "34");
//      fileList5.put("fileRemoteAddress", "https://www.18.com");
//      fileList5.put("fileObj", null);
//
//
//      Map<String, Object> fileList6 = new HashMap<>();
//      fileList6.put("fileType", "35");
//      fileList6.put("fileName", "35");
//      fileList6.put("fileRemoteAddress", "https://dldir1.qq.com/music/clntupate/QQMusicSetup.exe");
//      fileList3.put("fileObj", null);
//
//
//
//      fileList.add(fileList1);
////      fileList.add(fileList2);
////      fileList.add(fileList3);
////      fileList.add(fileList4);
////      fileList.add(fileList5);
////      fileList.add(fileList6);
//
//
//      requestBody.put("fileList",fileList);//文件信息集
//
//
//      String result = httpUtils(PreloanBaseApiPost.multi_File_upload, requestBody);
//      System.out.println("结果" + result);
//
//      //打印fileList内容
////      System.out.println("------FileList-------");
////      System.out.println("fileList:"+requestBody.get(fileList));
////      System.out.println("------FileList-------");
//
//      System.out.println(requestBody);
//
//    }catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//  }
//
//  //授信申请接口
//  public void creditApplay(String merchantCredit_no, String applyAmount) {
//
//
//    //授信人信息
//    String name = "test";
//    String certificateNo = "830889197106161510";
//    String birthDate = "1971-06-16";
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);//请求编号
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);//产品代码
//      requestBody.put("merchantCreditNo", merchantCredit_no);//商户授信编号
//      requestBody.put("roleType", 1); //角色分类 0:自然人 1:法人
//      requestBody.put("callbackUrl", "https://apihades-pre.nongfenqi.net/api/callback/credit");
//
//
//// 基础信息段
//      Map<String, Object> baseInfoSectionMap = new HashMap<>();
////      baseInfoSectionMap.put("name","B Pelson");                      //必填
//      baseInfoSectionMap.put("name", name);                      //必填
////      baseInfoSectionMap.put("certificateType", "0");                    //固定0身份证 必填
//      baseInfoSectionMap.put("certificateType", "0");                    //固定0身份证 必填
////      baseInfoSectionMap.put("certificateNo","511424197106167657"); //必
//      baseInfoSectionMap.put("certificateNo", certificateNo); //必填
////      baseInfoSectionMap.put("certificateIndate", "2050-12-31");
//      baseInfoSectionMap.put("certificateIndate", "2050-12-31");
////      baseInfoSectionMap.put("mobile", "18888888888");      //必填
//      baseInfoSectionMap.put("mobile", "18888888888");      //必填
////      baseInfoSectionMap.put("email", "1@1.com");
//      baseInfoSectionMap.put("email", "1@1.com");
////      baseInfoSectionMap.put("gender", "2");       //必填   1或2
//      baseInfoSectionMap.put("gender", "2");       //必填   1或2
////      baseInfoSectionMap.put("birthDate", "1971-06-16");      //必填  和身份证匹配
//      baseInfoSectionMap.put("birthDate", birthDate);      //必填  和身份证匹配
////      baseInfoSectionMap.put("permanentAddress", "杭州万塘路");      //必填
//      baseInfoSectionMap.put("permanentAddress", "杭州万塘路");      //必填
////      baseInfoSectionMap.put("applyAmount", applyAmount);     // 申请额度
//      baseInfoSectionMap.put("applyAmount", applyAmount);     // 申请额度
////
////教育信息段
//
//      Map<String, Object> eduInfoSectionMap = new HashMap<>();
////      eduInfoSectionMap.put("highestDiploma", "99");       //必填 0-8
//      eduInfoSectionMap.put("highestDiploma", "1");       //必填 0-8
////      eduInfoSectionMap.put("highestDegree", "99");        //必填 0-4
//      eduInfoSectionMap.put("highestDegree", "4");        //必填 0-4
//
////职业信息段
//      Map<String, Object> jobInfoSectionMap = new HashMap<>();
////      jobInfoSectionMap.put("jobCategory", "99");    //必填 0-7
//      jobInfoSectionMap.put("jobCategory", "99");    //必填 0-7
////      jobInfoSectionMap.put("job", "99");  //必填   0-3 99
//      jobInfoSectionMap.put("job", "99");  //必填   0-3 99
////      jobInfoSectionMap.put("jobTitle", "99");   //必填  0-3  99
//      jobInfoSectionMap.put("jobTitle", "99");   //必填  0-3  99
////      jobInfoSectionMap.put("organizationName", "无");   //必填
//      jobInfoSectionMap.put("organizationName", "无");   //必填
////      jobInfoSectionMap.put("organizationTel","15671556698");
//      jobInfoSectionMap.put("organizationTel", "15671556698");
////      jobInfoSectionMap.put("organizationIndustry", "99");      //必填 0-19
//      jobInfoSectionMap.put("organizationIndustry", "14");      //必填 0-19
////      jobInfoSectionMap.put("annualIncome", "100000");     //必填
//      jobInfoSectionMap.put("annualIncome", "100000");     //必填
////      jobInfoSectionMap.put("organizationStartYear", "2015");
//      jobInfoSectionMap.put("organizationStartYear", "2015");
////      jobInfoSectionMap.put("organizationPostalcode", "434155");
//      jobInfoSectionMap.put("organizationPostalcode", "434155");
////      jobInfoSectionMap.put("organizationAddress", "杭州市西湖区");
//      jobInfoSectionMap.put("organizationAddress", "杭州市西湖区");
////      jobInfoSectionMap.put("organizationProvince", "110000"); //中文文本
//      jobInfoSectionMap.put("organizationProvince", "110000"); //中文文本
////      jobInfoSectionMap.put("organizationCity", "130500");
//      jobInfoSectionMap.put("organizationCity", "110100");
////
////婚姻信息段
//      Map<String, Object> marriageInfoSectionMap = new HashMap<>();
////      marriageInfoSectionMap.put("maritalStatus", "99"); // 0 2 3 6 7 8 99
//      marriageInfoSectionMap.put("maritalStatus", "99"); // 0 2 3 6 7 8 99
////      marriageInfoSectionMap.put("spouseName", "配偶姓名");
//      marriageInfoSectionMap.put("spouseName", "配偶姓名");
////      marriageInfoSectionMap.put("spouseMobile", "123456");
//      marriageInfoSectionMap.put("spouseMobile", "123456");
////      marriageInfoSectionMap.put("spouseCertificateType", "99");
//      marriageInfoSectionMap.put("spouseCertificateType", "0");
////      marriageInfoSectionMap.put("spouseCertificateNo","123456");
//      marriageInfoSectionMap.put("spouseCertificateNo", "123456");
////      marriageInfoSectionMap.put("spouseCertificateIndate", "2018-07-12");
//      marriageInfoSectionMap.put("spouseCertificateIndate", "2018-07-12");
////      marriageInfoSectionMap.put("spouseOrganizationName","单位地址");
//      marriageInfoSectionMap.put("spouseOrganizationName", "单位地址");
//
////居住信息段
//      Map<String, Object> residenceInfoSectionMap = new HashMap<>();
////      residenceInfoSectionMap.put("residenceProvince", "110000");
//      residenceInfoSectionMap.put("residenceProvince", "110000");
////      residenceInfoSectionMap.put("residenceCity", "110100");
//      residenceInfoSectionMap.put("residenceCity", "110100");
////      residenceInfoSectionMap.put("residenceAddress", "杭州市西湖区");         //必填
//      residenceInfoSectionMap.put("residenceAddress", "杭州市西湖区");         //必填
////      residenceInfoSectionMap.put("residencePostalcode", "434410");
//      residenceInfoSectionMap.put("residencePostalcode", "434410");
////      residenceInfoSectionMap.put("residenceCondition","99");       //必填 0-6 99
//      residenceInfoSectionMap.put("residenceCondition", "99");       //必填 0-6 99
////      residenceInfoSectionMap.put("residenceTel", "4555698");      //必填
//      residenceInfoSectionMap.put("residenceTel", "4555698");      //必填
//
////银行卡信息段
//      Map<String, Object> bankcardInfoSectionMap = new HashMap<>();
////      bankcardInfoSectionMap.put("bankcardNo","46454554135");
//      bankcardInfoSectionMap.put("bankcardNo", "46454554135");
////      bankcardInfoSectionMap.put("bankName", "C10103");
//      bankcardInfoSectionMap.put("bankName", "C10102");
////      bankcardInfoSectionMap.put("bankBranchName", "杭州分行");
//      bankcardInfoSectionMap.put("bankBranchName", "杭州分行");
////      bankcardInfoSectionMap.put("bankBranchProvince","110000");
//      bankcardInfoSectionMap.put("bankBranchProvince", "110000");
////      bankcardInfoSectionMap.put("bankBranchCity", "110100");
//      bankcardInfoSectionMap.put("bankBranchCity", "110100");
////      bankcardInfoSectionMap.put("bankcardBindingMobile", "15671556669");
//      bankcardInfoSectionMap.put("bankcardBindingMobile", "15671556669");
//
////联系人信息段
//      List<Map<String, Object>> contactInfoSection = new ArrayList<>();
//      //信息1
//      Map<String, Object> contactInfoSectionMap1 = new HashMap<>();
////      contactInfoSectionMap1.put("relationship","99");
//      contactInfoSectionMap1.put("relationship", "99"); //9:配偶
////      contactInfoSectionMap1.put("name", "tom");
//      contactInfoSectionMap1.put("name", "Jacky");
////      contactInfoSectionMap1.put("mobile", "15671554478");
//      contactInfoSectionMap1.put("mobile", "15671554478");
////      contactInfoSectionMap1.put("certificateType", "99");
//      contactInfoSectionMap1.put("certificateType", "0");
////      contactInfoSectionMap1.put("certificateNo", "421024199511225566");
//      contactInfoSectionMap1.put("certificateNo", "421024199511225566");
////      contactInfoSectionMap1.put("certificateIndate", "2022-11-20");
//      contactInfoSectionMap1.put("certificateIndate", "2022-11-20");
////      contactInfoSectionMap1.put("organizationName", "suidifu");
//      contactInfoSectionMap1.put("organizationName", "杭州随地付网络科技有限公司");
//      contactInfoSection.add(contactInfoSectionMap1);
//
////      //信息2
////      Map<String, Object> contactInfoSectionMap2 = new HashMap<>();
//////      contactInfoSectionMap2.put("relationship","2");
////      contactInfoSectionMap2.put("relationship", "");
//////      contactInfoSectionMap2.put("name", "tom");
////      contactInfoSectionMap2.put("name", "tommy");
//////      contactInfoSectionMap2.put("mobile", "15671554478");
////      contactInfoSectionMap2.put("mobile", "15671554478");
//////      contactInfoSectionMap2.put("certificateType", "0");
////      contactInfoSectionMap2.put("certificateType", "0");
//////      contactInfoSectionMap2.put("certificateNo", "421024199511225566");
////      contactInfoSectionMap2.put("certificateNo", "421024199511225566");
//////      contactInfoSectionMap2.put("certificateIndate", "2022-11-20");
////      contactInfoSectionMap2.put("certificateIndate", "2022-11-20");
//////      contactInfoSectionMap2.put("organizationName", "suidifu");
////      contactInfoSectionMap2.put("organizationName", "杭州随地付网络科技有限公司");
////      contactInfoSection.add(contactInfoSectionMap2);
////
////      //信息3
////      Map<String, Object> contactInfoSectionMap3 = new HashMap<>();
//////      contactInfoSectionMap1.put("relationship","99");
////      contactInfoSectionMap3.put("relationship", "9"); //9:配偶
//////      contactInfoSectionMap1.put("name", "tom");
////      contactInfoSectionMap3.put("name", "");
//////      contactInfoSectionMap1.put("mobile", "15671554478");
////      contactInfoSectionMap3.put("mobile", "15671554478");
//////      contactInfoSectionMap1.put("certificateType", "99");
////      contactInfoSectionMap3.put("certificateType", "0");
//////      contactInfoSectionMap1.put("certificateNo", "421024199511225566");
////      contactInfoSectionMap3.put("certificateNo", "421024199511225566");
//////      contactInfoSectionMap1.put("certificateIndate", "2022-11-20");
////      contactInfoSectionMap3.put("certificateIndate", "2022-11-20");
//////      contactInfoSectionMap1.put("organizationName", "suidifu");
////      contactInfoSectionMap3.put("organizationName", "杭州随地付网络科技有限公司");
////      contactInfoSection.add(contactInfoSectionMap3);
////
////      //信息1
////      Map<String, Object> contactInfoSectionMap4 = new HashMap<>();
//////      contactInfoSectionMap1.put("relationship","99");
////      contactInfoSectionMap4.put("relationship", "9"); //9:配偶
//////      contactInfoSectionMap1.put("name", "tom");
////      contactInfoSectionMap4.put("name", "Jacky");
//////      contactInfoSectionMap1.put("mobile", "15671554478");
////      contactInfoSectionMap4.put("mobile", "");
//////      contactInfoSectionMap1.put("certificateType", "99");
////      contactInfoSectionMap4.put("certificateType", "0");
//////      contactInfoSectionMap1.put("certificateNo", "421024199511225566");
////      contactInfoSectionMap4.put("certificateNo", "421024199511225566");
//////      contactInfoSectionMap1.put("certificateIndate", "2022-11-20");
////      contactInfoSectionMap4.put("certificateIndate", "2022-11-20");
//////      contactInfoSectionMap1.put("organizationName", "suidifu");
////      contactInfoSectionMap4.put("organizationName", "杭州随地付网络科技有限公司");
////      contactInfoSection.add(contactInfoSectionMap4);
////
////      //信息5
////      Map<String, Object> contactInfoSectionMap5 = new HashMap<>();
//////      contactInfoSectionMap1.put("relationship","99");
////      contactInfoSectionMap5.put("relationship", "9"); //9:配偶
//////      contactInfoSectionMap1.put("name", "tom");
////      contactInfoSectionMap5.put("name", "Jacky");
//////      contactInfoSectionMap1.put("mobile", "15671554478");
////      contactInfoSectionMap5.put("mobile", "15671554478");
//////      contactInfoSectionMap1.put("certificateType", "99");
////      contactInfoSectionMap5.put("certificateType", "");
//////      contactInfoSectionMap1.put("certificateNo", "421024199511225566");
////      contactInfoSectionMap5.put("certificateNo", "421024199511225566");
//////      contactInfoSectionMap1.put("certificateIndate", "2022-11-20");
////      contactInfoSectionMap5.put("certificateIndate", "2022-11-20");
//////      contactInfoSectionMap1.put("organizationName", "suidifu");
////      contactInfoSectionMap5.put("organizationName", "杭州随地付网络科技有限公司");
////      contactInfoSection.add(contactInfoSectionMap5);
//
//
//      //保单信息段
//      Map<String, Object> policyInfoSectionMap = new HashMap<>();
////      policyInfoSectionMap.put("policyCorporationName", "中国平安");
//      policyInfoSectionMap.put("policyCorporationName", "中国平安");
////      policyInfoSectionMap.put("policyStatus", "0");
//      policyInfoSectionMap.put("policyStatus", "0");
////      policyInfoSectionMap.put("policyPaymentWay", "0");
//      policyInfoSectionMap.put("policyPaymentWay", "0");
////      policyInfoSectionMap.put("policyValidDate", "2018-01-01");
//      policyInfoSectionMap.put("policyValidDate", "2018-01-01");
////      policyInfoSectionMap.put("policyPaymentDeadline", "");                    //值>=3
//      policyInfoSectionMap.put("policyPaymentDeadline", "");                    //值>=3
////      policyInfoSectionMap.put("policyPaymentStatus", "0");
//      policyInfoSectionMap.put("policyPaymentStatus", "0");
////      policyInfoSectionMap.put("policyAnnualPaymentAmount", "5151.12");
//      policyInfoSectionMap.put("policyAnnualPaymentAmount", "5151.12");
//
////公基金信息段
//      Map<String, Object> providentFundInfoSectionMap = new HashMap<>();
////      providentFundInfoSectionMap.put("providentFundIdentityConsistent", "0");
//      providentFundInfoSectionMap.put("providentFundIdentityConsistent", "0");
////      providentFundInfoSectionMap.put("providentFundAccountStatus", "0");
//      providentFundInfoSectionMap.put("providentFundAccountStatus", "0");
////      providentFundInfoSectionMap.put("providentFundPaymentStatus", "0");
//      providentFundInfoSectionMap.put("providentFundPaymentStatus", "0");
////      providentFundInfoSectionMap.put("providentFundPaymentRecord", "0");
//      providentFundInfoSectionMap.put("providentFundPaymentRecord", "0");
////      providentFundInfoSectionMap.put("providentFundMonthBaseNum", "1515.12");
//      providentFundInfoSectionMap.put("providentFundMonthBaseNum", "1515.12");
//
////附加内容
//      Map<String, Object> attachedContentSectionMap = new HashMap<>();
//
//      //渤海贷前附加字段
//      attachedContentSectionMap.put("mortgagorName", "Scoco");
////      attachedContentSectionMap.put("mortgagorName","mortgagorName");
//      attachedContentSectionMap.put("mortgagorCertificateType", "99");
////      attachedContentSectionMap.put("mortgagorCertificateType","2");
//      attachedContentSectionMap.put("mortgagorCertificateNo", "2");
////      attachedContentSectionMap.put("mortgagorCertificateNo","123456789");
//      attachedContentSectionMap.put("mortgagorPermanentAddress", "SAN Street");
////      attachedContentSectionMap.put("mortgagorPermanentAddress","mortgagorPermanentAddress");
//      attachedContentSectionMap.put("mortgagorFixedTel", "12814124");
////      attachedContentSectionMap.put("mortgagorFixedTel","123456789");
//      attachedContentSectionMap.put("mortgagorMobile", "123456789");
////      attachedContentSectionMap.put("mortgagorMobile","123456789");
//      attachedContentSectionMap.put("pawnProvince", "220000");
////      attachedContentSectionMap.put("pawnProvince","");
//      attachedContentSectionMap.put("pawnCity", "220200");
////      attachedContentSectionMap.put("pawnCity","");
//      attachedContentSectionMap.put("pawnDetailedAddress", "Fix Street");
////      attachedContentSectionMap.put("pawnDetailedAddress","pawnDetailedAddress");
//      attachedContentSectionMap.put("buildingProperty", "99");
////      attachedContentSectionMap.put("buildingProperty","1");
//      attachedContentSectionMap.put("buildingAge", "1");
////      attachedContentSectionMap.put("buildingAge","1");
//      attachedContentSectionMap.put("buildingArea", "1");
////      attachedContentSectionMap.put("buildingArea","1");
//      attachedContentSectionMap.put("pawnOwner", "1");
////      attachedContentSectionMap.put("pawnOwner","pawnOwner");
//      attachedContentSectionMap.put("pawnStatus", "0");
////      attachedContentSectionMap.put("pawnStatus","0");
//      attachedContentSectionMap.put("evaluationTime", "2018");
////      attachedContentSectionMap.put("evaluationTime","2018");
//      attachedContentSectionMap.put("evaluationCompany", "CallMeLILI");
////      attachedContentSectionMap.put("evaluationCompany","evaluationCompany");
//      attachedContentSectionMap.put("assessedValuationValue", "100");
////      attachedContentSectionMap.put("assessedValuationValue","100");
//      attachedContentSectionMap.put("isSecondmortgage", "1");
////      attachedContentSectionMap.put("isSecondmortgage","0");
//      attachedContentSectionMap.put("firstMortgagee", "csgo");
////      attachedContentSectionMap.put("firstMortgagee","firstMortgagee");
//      attachedContentSectionMap.put("firstMortgageAmount", "100");
////      attachedContentSectionMap.put("firstMortgageAmount","100");
//      attachedContentSectionMap.put("firstMortgageOrganization", "SendACoin");
////      attachedContentSectionMap.put("firstMortgageOrganization","firstMortgageOrganization");
//      attachedContentSectionMap.put("hasHousingLoan", "1");
////      attachedContentSectionMap.put("hasHousingLoan","0");
//      attachedContentSectionMap.put("loanBalance", "1");
////      attachedContentSectionMap.put("loanBalance","1");
//      attachedContentSectionMap.put("overdueCondition", "1");
////      attachedContentSectionMap.put("overdueCondition","0");
//      attachedContentSectionMap.put("overduePeriods", "0");
////      attachedContentSectionMap.put("overduePeriods","0");
//      attachedContentSectionMap.put("currentOverdueAmount", "0");
////      attachedContentSectionMap.put("currentOverdueAmount","0");
//      attachedContentSectionMap.put("historyOverduePeriods", "1");
////      attachedContentSectionMap.put("historyOverduePeriods","1");
//      attachedContentSectionMap.put("historyHighestOverdueAmount", "100");
////      attachedContentSectionMap.put("historyHighestOverdueAmount","100");
//      attachedContentSectionMap.put("otherPenaltiesRecord", "99");
////      attachedContentSectionMap.put("otherPenaltiesRecord","0");
//      attachedContentSectionMap.put("mortgageOwnerName", "Bob");
//      attachedContentSectionMap.put("mortgageCertificateNo", "Bob123456");
//      attachedContentSectionMap.put("mortgageProperty", "抵押物性质");
//      attachedContentSectionMap.put("located", "杭州市");
//      attachedContentSectionMap.put("evaluateValue", "99987");
//      attachedContentSectionMap.put("mortgageRate", "0.99");
//      attachedContentSectionMap.put("otherWarrantNo", "5784999");
//
//
////外围客户编号集
//      List<Map<String, Object>> externalCustomerNoSection = new ArrayList<>();
//      Map<String, Object> externalCustomerNoSectionMap1 = new HashMap<>();
//      externalCustomerNoSectionMap1.put("no1", "1234");
//      externalCustomerNoSectionMap1.put("no2", "4321");
//
//      externalCustomerNoSection.add(externalCustomerNoSectionMap1);
//      Map<String, Object> externalCustomerNoSectionMap2 = new HashMap<>();
//      externalCustomerNoSectionMap2.put("no1", "abcd");
//      externalCustomerNoSectionMap2.put("no2", "qwer");
//      externalCustomerNoSection.add(externalCustomerNoSectionMap2);
//
//      requestBody.put("baseInfoSection", baseInfoSectionMap);//
//      requestBody.put("eduInfoSection", eduInfoSectionMap);
//      requestBody.put("jobInfoSection", jobInfoSectionMap);
//      requestBody.put("marriageInfoSection", marriageInfoSectionMap);
//      requestBody.put("residenceInfoSection", residenceInfoSectionMap);
//      requestBody.put("bankcardInfoSection", bankcardInfoSectionMap);
//      requestBody.put("contactInfoSection", contactInfoSection);//联系人信息
//      requestBody.put("policyInfoSection", policyInfoSectionMap);
//      requestBody.put("providentFundInfoSection", providentFundInfoSectionMap);
//
//      requestBody.put("attachedContentSection",JsonUtils.toJsonString(attachedContentSectionMap));
//      requestBody.put("externalCustomerNoSection",JsonUtils.toJsonString(externalCustomerNoSection));
//
//      String result = httpUtils(PreloanBaseApiPost.Credit_Applay, requestBody);
//      System.out.println("结果" + result);
//      System.out.println("请求信息" + requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//  }
//
///*
// *潍坊
// *授信申请接口
// */
// public void creditApplayWf(String name,String certificateNo,String birthDate,String merchantCredit_no, String applyAmount) {
//
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);//请求编号
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);//产品代码
//      requestBody.put("merchantCreditNo", merchantCredit_no);//商户授信编号
//      requestBody.put("roleType", 1); //角色分类 0:自然人 1:法人
//      requestBody.put("callbackUrl", "https://apihades-pre.nongfenqi.net/api/callback/credit");
//
//// 基础信息段
//      Map<String, Object> baseInfoSectionMap = new HashMap<>();
//      baseInfoSectionMap.put("name", name);                      //必填
//      baseInfoSectionMap.put("certificateType", "0");                    //固定0身份证 必填
//      baseInfoSectionMap.put("certificateNo", certificateNo); //必填
//      baseInfoSectionMap.put("certificateIndate", "2050-12-31");
//      baseInfoSectionMap.put("mobile", "18888888888");      //必填
//      baseInfoSectionMap.put("email", "1@1.com");
//      baseInfoSectionMap.put("gender", "2");       //必填   1或2
//      baseInfoSectionMap.put("birthDate", birthDate);      //必填  和身份证匹配
//      baseInfoSectionMap.put("permanentAddress", "杭州万塘路");      //必填
//      baseInfoSectionMap.put("applyAmount", applyAmount);     // 申请额度
//
////教育信息段
//      Map<String, Object> eduInfoSectionMap = new HashMap<>();
//      eduInfoSectionMap.put("highestDiploma", "1");       //必填 0-8
//      eduInfoSectionMap.put("highestDegree", "4");        //必填 0-4
//
////职业信息段
//      Map<String, Object> jobInfoSectionMap = new HashMap<>();
//      jobInfoSectionMap.put("jobCategory", "99");    //必填 0-7
//      jobInfoSectionMap.put("job", "99");  //必填   0-3 99
//      jobInfoSectionMap.put("jobTitle", "99");   //必填  0-3  99
//      jobInfoSectionMap.put("organizationName", "无");   //必填
//      jobInfoSectionMap.put("organizationTel", "15671556698");
//      jobInfoSectionMap.put("organizationIndustry", "14");      //必填 0-19
//      jobInfoSectionMap.put("annualIncome", "100000");     //必填
//      jobInfoSectionMap.put("organizationStartYear", "2015");
//      jobInfoSectionMap.put("organizationPostalcode", "434155");
//      jobInfoSectionMap.put("organizationAddress", "杭州市西湖区");
//      jobInfoSectionMap.put("organizationProvince", "110000"); //中文文本
//      jobInfoSectionMap.put("organizationCity", "110100");
//
////婚姻信息段
//      Map<String, Object> marriageInfoSectionMap = new HashMap<>();
//      marriageInfoSectionMap.put("maritalStatus", "99"); // 0 2 3 6 7 8 99
//      marriageInfoSectionMap.put("spouseName", "配偶姓名");
//      marriageInfoSectionMap.put("spouseMobile", "123456");
//      marriageInfoSectionMap.put("spouseCertificateType", "0");
//      marriageInfoSectionMap.put("spouseCertificateNo", "123456");
//      marriageInfoSectionMap.put("spouseCertificateIndate", "2018-07-12");
//      marriageInfoSectionMap.put("spouseOrganizationName", "单位地址");
//
////居住信息段
//      Map<String, Object> residenceInfoSectionMap = new HashMap<>();
//      residenceInfoSectionMap.put("residenceProvince", "110000");
//      residenceInfoSectionMap.put("residenceCity", "110100");
//      residenceInfoSectionMap.put("residenceAddress", "杭州市西湖区");         //必填
//      residenceInfoSectionMap.put("residencePostalcode", "434410");
//      residenceInfoSectionMap.put("residenceCondition", "99");       //必填 0-6 99
//      residenceInfoSectionMap.put("residenceTel", "4555698");      //必填
//
////银行卡信息段
//      Map<String, Object> bankcardInfoSectionMap = new HashMap<>();
//      bankcardInfoSectionMap.put("bankcardNo", "46454554135");
//      bankcardInfoSectionMap.put("bankName", "C10102");
//      bankcardInfoSectionMap.put("bankBranchName", "杭州分行");
//      bankcardInfoSectionMap.put("bankBranchProvince", "110000");
//      bankcardInfoSectionMap.put("bankBranchCity", "110100");
//      bankcardInfoSectionMap.put("bankcardBindingMobile", "15671556669");
//
////联系人信息段
//      List<Map<String, Object>> contactInfoSection = new ArrayList<>();
//      //信息1
//      Map<String, Object> contactInfoSectionMap1 = new HashMap<>();
//      contactInfoSectionMap1.put("relationship", "99"); //9:配偶
//      contactInfoSectionMap1.put("name", "Jacky");
//      contactInfoSectionMap1.put("mobile", "15671554478");
//      contactInfoSectionMap1.put("certificateType", "0");
//      contactInfoSectionMap1.put("certificateNo", "421024199511225566");
//      contactInfoSectionMap1.put("certificateIndate", "2022-11-20");
//      contactInfoSectionMap1.put("organizationName", "杭州随地付网络科技有限公司");
//      contactInfoSection.add(contactInfoSectionMap1);
//
//      //保单信息段
//      Map<String, Object> policyInfoSectionMap = new HashMap<>();
//      policyInfoSectionMap.put("policyCorporationName", "中国平安");
//      policyInfoSectionMap.put("policyStatus", "0");
//      policyInfoSectionMap.put("policyPaymentWay", "0");
//      policyInfoSectionMap.put("policyValidDate", "2018-01-01");
//      policyInfoSectionMap.put("policyPaymentDeadline", "");                    //值>=3
//      policyInfoSectionMap.put("policyPaymentStatus", "0");
//      policyInfoSectionMap.put("policyAnnualPaymentAmount", "5151.12");
//
////公基金信息段
//      Map<String, Object> providentFundInfoSectionMap = new HashMap<>();
//      providentFundInfoSectionMap.put("providentFundIdentityConsistent", "0");
//      providentFundInfoSectionMap.put("providentFundAccountStatus", "0");
//      providentFundInfoSectionMap.put("providentFundPaymentStatus", "0");
//      providentFundInfoSectionMap.put("providentFundPaymentRecord", "0");
//      providentFundInfoSectionMap.put("providentFundMonthBaseNum", "1515.12");
//
////附加内容
//      Map<String, Object> attachedContentSectionMap = new HashMap<>();
////潍坊贷前附加字段
//      attachedContentSectionMap.put("agricultureRelated","2");
//      attachedContentSectionMap.put("ruralFinancialCustomer", "2");
//      attachedContentSectionMap.put("familyMonthlyIncome", "200000.00");
//      attachedContentSectionMap.put("flfcType", "A09");
//      attachedContentSectionMap.put("housePurchaseSituation", "001");
//      attachedContentSectionMap.put("economicNature", "18");
//      attachedContentSectionMap.put("industryType", "F5299");
//      attachedContentSectionMap.put("mainGuaranteeMode", "005");
//      attachedContentSectionMap.put("useDescription", "买东西");
//      attachedContentSectionMap.put("industryTypeNew", "F5299");
//
////外围客户编号集
//      List<Map<String, Object>> externalCustomerNoSection = new ArrayList<>();
//      Map<String, Object> externalCustomerNoSectionMap1 = new HashMap<>();
//      externalCustomerNoSectionMap1.put("no1", "1234");
//      externalCustomerNoSectionMap1.put("no2", "4321");
//
//      externalCustomerNoSection.add(externalCustomerNoSectionMap1);
//      Map<String, Object> externalCustomerNoSectionMap2 = new HashMap<>();
//      externalCustomerNoSectionMap2.put("no1", "abcd");
//      externalCustomerNoSectionMap2.put("no2", "qwer");
//      externalCustomerNoSection.add(externalCustomerNoSectionMap2);
//
//      requestBody.put("baseInfoSection", baseInfoSectionMap);//
//      requestBody.put("eduInfoSection", eduInfoSectionMap);
//      requestBody.put("jobInfoSection", jobInfoSectionMap);
//      requestBody.put("marriageInfoSection", marriageInfoSectionMap);
//      requestBody.put("residenceInfoSection", residenceInfoSectionMap);
//      requestBody.put("bankcardInfoSection", bankcardInfoSectionMap);
//      requestBody.put("contactInfoSection", contactInfoSection);//联系人信息
//      requestBody.put("policyInfoSection", policyInfoSectionMap);
//      requestBody.put("providentFundInfoSection", providentFundInfoSectionMap);
//
//      requestBody.put("attachedContentSection",JsonUtils.toJsonString(attachedContentSectionMap));
//      requestBody.put("externalCustomerNoSection",JsonUtils.toJsonString(externalCustomerNoSection));
//
//      String creditUrl = "http://124.133.252.132:5802/preloan/api/credit/v1/credit-application/paipai/G00000";
//      String result = httpUtils(creditUrl, requestBody);
//      System.out.println("结果" + result);
//      System.out.println("请求信息" + requestBody);
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//  }
//
//
//  //授信查询接口
//  public String creditApplaySelect(String merchantCredit_no,String vedaCreditNo) {
//
//    try {
//
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);//请求编号
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);//产品代码
//      requestBody.put("merchantCreditNo", merchantCredit_no);//商户授信编号
//      requestBody.put("vedaCreditNo",vedaCreditNo);//商户授信编号
//
//
//      String result = httpUtils(PreloanBaseApiPost.Credit_Select, requestBody);
//      System.out.println("响应结果:" + result);
//
//      Map maps = JSON.parseObject(result);
//      Map data = JSON.parseObject((String) maps.get("data"));
////      System.out.println(data);
////      System.out.println(data.get("vedaCreditNo"));
//      vedaCreditNo = (String) data.get("vedaCreditNo");
//
//    } catch (Exception e) {
//      e.printStackTrace();
//
//      Assert.fail();
//    }
//
//    return vedaCreditNo;
//
//  }
//
//
//  //授信查询接口
//  public String creditApplaySelectWf(String merchantCredit_no,String vedaCreditNo) {
//
//    try {
//
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);//请求编号
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);//产品代码
//      requestBody.put("merchantCreditNo", merchantCredit_no);//商户授信编号
//      requestBody.put("vedaCreditNo",vedaCreditNo);//商户授信编号
//
//
//      String creditSelectUrl = "http://124.133.252.132:5802/preloan/api/credit/v1/credit-application/query/paipai/G00000";
//      String result = httpUtils(creditSelectUrl, requestBody);
////      System.out.println("响应结果:" + result);
//
//      Map maps = JSON.parseObject(result);
//      Map data = JSON.parseObject((String) maps.get("data"));
//      System.out.println(data);
//      System.out.println(data.get("vedaCreditNo"));
//      vedaCreditNo = (String) data.get("vedaCreditNo");
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//
//    return vedaCreditNo;
//  }
//
//  //用信申请接口-渤海
//  public void testSave(String merchantCredit_no,String vedaCreditNo, String loanAmount) {
//
//
//    String signDate = "2020-10-27";//合同签订日期
//    String effectiveDate = "2020-10-27";//合同开始日期
//    String expirationDate = "2020-12-27";//合同到期日期
//    String valueDate = "2020-10-27";//合同起息日期
//
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);
//      requestBody.put("merchantContractNo", UUID.randomUUID().toString());
////      requestBody.put("merchantContractNo", "3299158304273460000");
////      requestBody.put("merchantContractNo", merchantContract_no);
//      requestBody.put("merchantCreditNo", merchantCredit_no);
//      requestBody.put("vedaCreditNo", vedaCreditNo);
//      requestBody.put("txType", "0");      //必填     0
//      requestBody.put("principalSum", loanAmount);  //1200.00 //必填
//      requestBody.put("interestSum", "120");   //10.12    //必填
//      requestBody.put("costSum", "12");      //1210.12
//      requestBody.put("signDate", signDate);   //2018-01-01
//      requestBody.put("effectiveDate", effectiveDate);  //2018-01-01    //必填
//      requestBody.put("expirationDate",expirationDate);  //    必填
//      requestBody.put("valueDate", valueDate);    //2018-11-01
//      requestBody.put("dueDate", "27");
//      requestBody.put("interestRate", "0.18");     //0.1      //必填  大于4
//      requestBody.put("interestRateCycle", "2");       //0
//      requestBody.put("payInterestCycle", "1");        // 付息周期，1：月
//      requestBody.put("repaymentMode", "2");            //3分期付息到期还本
//      requestBody.put("repaymentPeriodsCount", "2");   //3
//      requestBody.put("intendedUse", "99");             //1
//      requestBody.put("cooperationPlatformProductName", "汇付天下");  //100
//      requestBody.put("cooperationPlatformGrade", "100");       //
//      requestBody.put("callbackUrl", "http://www.baidu.com");     //http://www.baidu.com
//
////放款信息段
//      List<Map<String, Object>> loanInfoSection = new ArrayList<>();
//      Map<String, Object> loanInfoSectionMap = new HashMap<>();
//      loanInfoSectionMap.put("payeeType", "0");                   //0
////      loanInfoSectionMap.put("payeeBankAccountNo", "123456");      //123456
//      loanInfoSectionMap.put("payeeBankAccountNo", "6225880142526030");      //123456
//      loanInfoSectionMap.put("payeeBankAccountName", "tom");      //tom
//      loanInfoSectionMap.put("payeeBankCode", "C10920");            //cb1221
//      loanInfoSectionMap.put("payeeBankName", "杭州银行");         //杭州银行
//      loanInfoSectionMap.put("payeeBankCnapsCode", "011456213054");      //123456
//      loanInfoSectionMap.put("payeeBankProvince", "330000");          //浙江
//      loanInfoSectionMap.put("payeeBankCity", "330100");              //杭州
//      loanInfoSectionMap.put("loanAmount", "10000");              //1000.12
//      loanInfoSection.add(loanInfoSectionMap);
//
////      Map<String, Object> loanInfoSectionMap2 = new HashMap<>();
////      loanInfoSectionMap2.put("payeeType","1");                   //0
////      loanInfoSectionMap2.put("payeeBankAccountNo","2789456");      //123456
////      loanInfoSectionMap2.put("payeeBankAccountName","tommy");      //tom
////      loanInfoSectionMap2.put("payeeBankCode","C10920");            //cb1221
////      loanInfoSectionMap2.put("payeeBankName","温州银行");         //杭州银行
////      loanInfoSectionMap2.put("payeeBankCnapsCode","011456213055");      //123456
////      loanInfoSectionMap2.put("payeeBankProvince","330000");          //浙江
////      loanInfoSectionMap2.put("payeeBankCity","330100");              //杭州
////      loanInfoSectionMap2.put("loanAmount","30000");              //1000.12
////      loanInfoSection.add(loanInfoSectionMap2);
//
//
//
////外围资产编号集
//      List<Map<String, Object>> externalNoSection = new ArrayList<>();
//
//      //多组测试编号
//      Map<String, Object> externalNoSectionMap = new HashMap<>();
//      externalNoSectionMap.put("supervisionReportBusinessNo", "DYWY-GCBGZA-1403002-@!@#$%^&*()");
//      externalNoSection.add(externalNoSectionMap);
////
////      Map<String, Object> externalNoSectionMap2 = new HashMap<>();
////      externalNoSectionMap2.put("supervisionReportBusinessNo", "DYWY-GCBGZA-14030  0    3");  //123
////      externalNoSection.add(externalNoSectionMap2);
////
////      Map<String, Object> externalNoSectionMap3 = new HashMap<>();
////      externalNoSectionMap3.put("supervisionReportBusinessNo", "D");
////      externalNoSection.add(externalNoSectionMap3);
////
////      Map<String, Object> externalNoSectionMap4 = new HashMap<>();
////      externalNoSectionMap4.put("supervisionReportBusinessNo", "1");
////      externalNoSection.add(externalNoSectionMap4);
////
////      Map<String, Object> externalNoSectionMap5 = new HashMap<>();
////      externalNoSectionMap5.put("supervisionReportBusinessNo", "@");
////      externalNoSection.add(externalNoSectionMap5);
////
////      Map<String, Object> externalNoSectionMap6 = new HashMap<>();
////      externalNoSectionMap6.put("supervisionReportBusinessNo", "123456789987654321123456789987654321");
////      externalNoSection.add(externalNoSectionMap6);
//
////附加内容
//      Map<String, Object> attachedContentSectionMap = new HashMap<>();
////      attachedContentSectionMap.put("agricultureRelated", "1");
////      attachedContentSectionMap.put("ruralFinancialCustomer", "1");
////      attachedContentSectionMap.put("familyMonthlyIncome", "100");
////      attachedContentSectionMap.put("flfcType", "A01");
////      attachedContentSectionMap.put("housePurchaseSituation", "001");
////      attachedContentSectionMap.put("economicNature", "06");
////      attachedContentSectionMap.put("industryType", "A01");
////      attachedContentSectionMap.put("mainGuaranteeMode", "005");
////      attachedContentSectionMap.put("useDescription", "吃饭");
////      attachedContentSectionMap.put("industryTypeNew", "A011");
////
//
//      attachedContentSectionMap.put("cur_date", "20170118");
//      attachedContentSectionMap.put("leader", "XIAOMI");
//      attachedContentSectionMap.put("partner", "DXAL_BANK");
//      attachedContentSectionMap.put("cust_name", "李志飞");
//      attachedContentSectionMap.put("cert_type", "1");
//      attachedContentSectionMap.put("cert_no", "416328198003013000");
//      attachedContentSectionMap.put("bank_card_no", "6225880142526030");
//      attachedContentSectionMap.put("seq_no", "3299158456744800000");
//      attachedContentSectionMap.put("currency", "156");
//      attachedContentSectionMap.put("total_terms", "6");
//      attachedContentSectionMap.put("grace_day", "3");
//      attachedContentSectionMap.put("fund_status", "2");
//
//
//      requestBody.put("loanInfoSection", loanInfoSection);
//      requestBody.put("externalNoSection", JsonUtils.toJsonString(externalNoSection));
//      requestBody.put("attachedContentSection", JsonUtils.toJsonString(attachedContentSectionMap));
//
//      String result = httpUtils(PreloanBaseApiPost.Contract_Applay, requestBody);
//
//
//      System.out.println(result);
//      System.out.println("请求信息"+requestBody.toString());
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//  }
//
//  //用信申请接口-潍坊
//  public void testSaveWf(String signDate,String effectiveDate,String expirationDate,String valueDate,String merchantCredit_no, String merchantContract_no, String vedaCreditNo, String principalSum) {
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);
//      requestBody.put("merchantCreditNo", merchantCredit_no);
//      requestBody.put("merchantContractNo", merchantContract_no);
//      requestBody.put("vedaCreditNo", vedaCreditNo);
//      requestBody.put("txType", "0");
//      requestBody.put("principalSum", principalSum);
//      requestBody.put("interestSum", "120");
//      requestBody.put("costSum", "12");
//      requestBody.put("signDate", signDate);
//      requestBody.put("effectiveDate", effectiveDate);
//      requestBody.put("expirationDate",expirationDate);
//      requestBody.put("valueDate", valueDate);
////      requestBody.put("dueDate", "27");
//      requestBody.put("dueDate", "20");
//      requestBody.put("interestRate", "0.18");
//      requestBody.put("interestRateCycle", "2");
//      requestBody.put("payInterestCycle", "1");
//      requestBody.put("repaymentMode", "1");
//      requestBody.put("repaymentPeriodsCount", "2");
//      requestBody.put("intendedUse", "99");
//      requestBody.put("cooperationPlatformProductName", "汇付天下");
//      requestBody.put("cooperationPlatformGrade", "100");       //
//      requestBody.put("callbackUrl", "http://www.baidu.com");
//
////放款信息段
//      List<Map<String, Object>> loanInfoSection = new ArrayList<>();
//      Map<String, Object> loanInfoSectionMap = new HashMap<>();
//      loanInfoSectionMap.put("payeeType", "0");
//      loanInfoSectionMap.put("payeeBankAccountNo", "123456");
//      loanInfoSectionMap.put("payeeBankAccountName", "tom");
//      loanInfoSectionMap.put("payeeBankCode", "C10920");
//      loanInfoSectionMap.put("payeeBankName", "杭州银行");
//      loanInfoSectionMap.put("payeeBankCnapsCode", "011456213054");
//      loanInfoSectionMap.put("payeeBankProvince", "330000");
//      loanInfoSectionMap.put("payeeBankCity", "330100");
//      loanInfoSectionMap.put("loanAmount", "10000");
//      loanInfoSection.add(loanInfoSectionMap);
//
////附加内容
//      Map<String, Object> attachedContentSectionMap = new HashMap<>();
//      attachedContentSectionMap.put("agricultureRelated", "1");
//      attachedContentSectionMap.put("ruralFinancialCustomer", "1");
//      attachedContentSectionMap.put("familyMonthlyIncome", "100");
//      attachedContentSectionMap.put("flfcType", "A01");
//      attachedContentSectionMap.put("housePurchaseSituation", "001");
//      attachedContentSectionMap.put("economicNature", "06");
//      attachedContentSectionMap.put("industryType", "A01");
//      attachedContentSectionMap.put("mainGuaranteeMode", "005");
//      attachedContentSectionMap.put("useDescription", "吃饭");
//      attachedContentSectionMap.put("industryTypeNew", "A011");
//
//      requestBody.put("loanInfoSection", loanInfoSection);
//      requestBody.put("attachedContentSection", JsonUtils.toJsonString(attachedContentSectionMap));
//
//
//      //用信地址-测试环境
//      String ContractUrl = "http://124.133.252.132:5802/preloan/api/asset/v1/contract/paipai/G00000";
//
//      String result = httpUtils(ContractUrl, requestBody);
//
//
//      System.out.println(result);
//      System.out.println("请求信息"+requestBody.toString());
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//  }
//
//  //用信查询接口
//  public String testSelect(String merchantContract_no) {
//    String vedaContractNo = "";
//    try {
//
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);
//      requestBody.put("merchantContractNo", merchantContract_no);
//
//      String result = httpUtils(PreloanBaseApiPost.Contract_Select, requestBody);
//
//      JSONObject maps = JSON.parseObject(result);
//      System.out.println(maps.getString("data"));
//      String str = JSONObject.parseObject(maps.getString("data")).toJSONString();
//      System.out.println("str=========" + str);
//
//      vedaContractNo = (String) JSON.parseObject(str).get("vedaContractNo");
//      System.out.println("vedaContractNo:" + vedaContractNo);
//      System.out.println(result);
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return vedaContractNo;
//  }
//
//  //用信查询接口-潍坊
//  public String testSelectWf(String merchantContract_no) {
//    String vedaContractNo = "";
//
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);
//      requestBody.put("merchantContractNo", merchantContract_no);
//
//      String contractSelectUrl = "http://124.133.252.132:5802/preloan/api/asset/v1/contract/query/paipai/G00000";
//      String result = httpUtils(contractSelectUrl, requestBody);
//
//      JSONObject maps = JSON.parseObject(result);
//      System.out.println(maps.getString("data"));
//      String str = JSONObject.parseObject(maps.getString("data")).toJSONString();
//      System.out.println("str=========" + str);
//
//      vedaContractNo = (String) JSON.parseObject(str).get("vedaContractNo");
//
//      System.out.println("vedaContractNo:" + vedaContractNo);
//      System.out.println(result);
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//    return vedaContractNo;
//
//  }
//
//  // 放款申请接口
//  public void loanApplay(String merchantLoanOrder_no, String merchantContract_no, String vedaContractNo, String loanAmount) {
//    try {
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo",
//          UUID.randomUUID().toString()); //请求编号          //2d839adb-15ee-4788-8e89-db771997fab4
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);//产品代码
//      requestBody.put("merchantLoanOrderNo", merchantLoanOrder_no);//商户放款订单号
//      requestBody.put("merchantContractNo", merchantContract_no);//商户借款合同编号
//      requestBody.put("vedaContractNo", vedaContractNo);//五维借款合同编号
//      requestBody.put("loanAmount", loanAmount);
//
//      requestBody.put("loanStrategy", "0");
//      requestBody.put("remark", "花花");
//      requestBody.put("auditor", "");
//      requestBody.put("auditTime", "2018-01-01 12:01:54");
//      requestBody.put("callbackUrl", "https://apihades-pre.nongfenqi.net/api/callback/loan");
//
//      List<Map<String, Object>> loanDetail = new ArrayList<>();
//      Map<String, Object> loanDetailMap = new HashMap<>();
////      loanDetailMap.put("detailRecordNo", UUID.randomUUID().toString());
//      loanDetailMap.put("detailRecordNo", "00000001");
//      loanDetailMap.put("payeeType", "0");
//      loanDetailMap.put("payeeBankAccountNo", "6216600100005555338");
//      loanDetailMap.put("payeeBankAccountName", "张三"); //必填
//      loanDetailMap.put("payeeBankCode", "C10920");
//      loanDetailMap.put("payeeBankName", "杭州银行");
//      loanDetailMap.put("payeeBankCnapsCode", "");
//      loanDetailMap.put("payeeCertificateNo", "");
//      loanDetailMap.put("payeeBankProvince", "330000");
//      loanDetailMap.put("payeeBankCity", "330100");
//      loanDetailMap.put("loanAmount", loanAmount);
//      loanDetailMap.put("planExeDate", "2018-01-01 12:01:54");
//      loanDetail.add(loanDetailMap);
//
//
////      Map<String, Object> loanDetailMap1 = new HashMap<>();
//////      loanDetailMap.put("detailRecordNo", UUID.randomUUID().toString());
////      loanDetailMap1.put("detailRecordNo", "00000002");
////      loanDetailMap1.put("payeeType", "1");
////      loanDetailMap1.put("payeeBankAccountNo", "6216600100005555337");
////      loanDetailMap1.put("payeeBankAccountName", "李四"); //必填
////      loanDetailMap1.put("payeeBankCode", "C10920");
////      loanDetailMap1.put("payeeBankName", "温州银行");
////      loanDetailMap1.put("payeeBankCnapsCode", "");
////      loanDetailMap1.put("payeeCertificateNo", "");
////      loanDetailMap1.put("payeeBankProvince", "330000");
////      loanDetailMap1.put("payeeBankCity", "330100");
////      loanDetailMap1.put("loanAmount", "15000");
////      loanDetailMap1.put("planExeDate", "2018-01-01 12:01:54");
////      loanDetail.add(loanDetailMap1);
//////
//
//      requestBody.put("loanDetail", loanDetail);
//
//
//      String result = httpUtils(PreloanBaseApiPost.Loan_Applay, requestBody);
////      System.out.println(JSONObject.toJSON(requestBody));
//      System.out.println(result);
//
////      System.out.println("merchantLoanOrder_no:"+merchantLoanOrder_no);
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//
//    }
//  }
//
//  // 放款申请接口-潍坊
//  public void loanApplayWf(String merchantLoanOrder_no, String merchantContract_no, String vedaContractNo, String loanAmount) {
//    try {
//
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo",
//          UUID.randomUUID().toString()); //请求编号          //2d839adb-15ee-4788-8e89-db771997fab4
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);//产品代码
//      requestBody.put("merchantLoanOrderNo", merchantLoanOrder_no);//商户放款订单号
//      requestBody.put("merchantContractNo", merchantContract_no);//商户借款合同编号
//      requestBody.put("vedaContractNo", vedaContractNo);//五维借款合同编号
//      requestBody.put("loanAmount", loanAmount);
//
//      requestBody.put("loanStrategy", "0");
//      requestBody.put("remark", "花花");
//      requestBody.put("auditor", "");
//      requestBody.put("auditTime", "2018-01-01 12:01:54");
//      requestBody.put("callbackUrl", "https://apihades-pre.nongfenqi.net/api/callback/loan");
//
//      List<Map<String, Object>> loanDetail = new ArrayList<>();
//      Map<String, Object> loanDetailMap = new HashMap<>();
//      loanDetailMap.put("detailRecordNo", "00000001");
//      loanDetailMap.put("payeeType", "0");
//      loanDetailMap.put("payeeBankAccountNo", "6216600100005555338");
//      loanDetailMap.put("payeeBankAccountName", "张三"); //必填
//      loanDetailMap.put("payeeBankCode", "C10920");
//      loanDetailMap.put("payeeBankName", "杭州银行");
//      loanDetailMap.put("payeeBankCnapsCode", "");
//      loanDetailMap.put("payeeCertificateNo", "");
//      loanDetailMap.put("payeeBankProvince", "330000");
//      loanDetailMap.put("payeeBankCity", "330100");
//      loanDetailMap.put("loanAmount", loanAmount);
//      loanDetailMap.put("planExeDate", "2018-01-01 12:01:54");
//      loanDetail.add(loanDetailMap);
//      requestBody.put("loanDetail", loanDetail);
//
//      String LoanUrl = "http://124.133.252.132:5802/preloan/api/remittance/v1/remittance-application/paipai/G00000";
//      String result = httpUtils(LoanUrl, requestBody);
//      System.out.println(result);
//
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//  }
//
//  //放款查询接口
//  public void loanApplaySelect(String merchantContract_no,String vedaContractNo,String merchantLoanOrderNo,String remittanceApplicationUuid) {
//    try {
//
//      Map<String, Object> requestBody = new HashMap<>();
//
//      requestBody.put("requestNo", "201809122106000513");
////      requestBody.put("requestNo",request_no);
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);
//      requestBody.put("merchantContractNo",merchantContract_no );//商户借款合同编号
//      requestBody.put("vedaContractNo", vedaContractNo);//五维借款合同编号
//      requestBody.put("merchantLoanOrderNo", merchantLoanOrderNo);//商户放款订单号
//      requestBody.put("remittanceApplicationUuid",remittanceApplicationUuid);//五维放款订单号
//
//
//      String result = httpUtils(PreloanBaseApiPost.Loan_Applay_Select, requestBody);
//      System.out.println("响应结果:" + result);
//      Map maps = JSON.parseObject(result);
//      Map data = JSON.parseObject((String) maps.get("data"));
//
//      System.out.println("业务数据节点:" + data);
//      System.out.println("明细数据节点:" + data.get("applicationDetailVOS"));
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//
//    }
//  }
//
//  //还款计划推送接口
//  public void repaymentPlanPush(String merchantContract_no, String costDetailAmount, String merchantRepaymentPlanNo, String repaymentDate) {
//    try {
//
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);
//      requestBody.put("productCode", PreloanBaseApiPost.produt_code);
//      requestBody.put("merchantContractNo", merchantContract_no);//商户借款合同编号
//      requestBody.put("vedaContractNo", "");  //五维借款合同编号
//      requestBody.put("callbackUrl", "");
//
//      //费用集1
//      List<Map<String, Object>> costDetail = new ArrayList<>();
//      Map<String, Object> costDetailMap = new HashMap<>();
//      costDetailMap.put("costDetailType", "0");
//      costDetailMap.put("costDetailAmount", costDetailAmount);//明细金额
//      costDetail.add(costDetailMap);
//
//      //还款计划集
//      List<Map<String, Object>> assetSet = new ArrayList<>();
//      Map<String, Object> assetSetMap = new HashMap<>();
//      assetSetMap.put("merchantRepaymentPlanNo", merchantRepaymentPlanNo);//商户还款计划编号
//      assetSetMap.put("repaymentDate", repaymentDate);//计划还款日期
//      assetSetMap.put("costDetail", costDetail);//费用集
//      assetSet.add(assetSetMap);
//
//
////      List<Map<String,Object>> costDetail1 = new ArrayList<>();
////      Map<String,Object> costDetailMap5 = new HashMap<>();
////      costDetailMap5.put("costDetailType", "0");
////      costDetailMap5.put("costDetailAmount", "10000");//明细金额
////      costDetail.add(costDetailMap2);
//////
////      Map<String,Object> costDetailMap6 = new HashMap<>();
////      costDetailMap6.put("costDetailType", "1");
////      costDetailMap6.put("costDetailAmount", "0");
////      costDetail.add(costDetailMap3);
//////
//////
////      //还款计划集
////
////      Map<String, Object> assetSetMap1 = new HashMap<>();
////      assetSetMap1.put("merchantRepaymentPlanNo", "cs2018080304");//商户还款计划编号
////      assetSetMap1.put("repaymentDate", "2018-09-19");//计划还款日期
////      assetSetMap1.put("costDetail", costDetail1);//费用集
////      assetSet.add(assetSetMap1);
////
//////
//////
////
////      List<Map<String,Object>> costDetail2 = new ArrayList<>();
////      Map<String,Object> costDetailMap7 = new HashMap<>();
////      costDetailMap5.put("costDetailType", "0");
////      costDetailMap5.put("costDetailAmount", "5000");//明细金额
////      costDetail.add(costDetailMap7);
//////
////      Map<String,Object> costDetailMap8 = new HashMap<>();
////      costDetailMap8.put("costDetailType", "1");
////      costDetailMap8.put("costDetailAmount", "0");
////      costDetail.add(costDetailMap8);
//////
////
////      Map<String, Object> assetSetMap2 = new HashMap<>();
////      assetSetMap2.put("merchantRepaymentPlanNo", "cs073102x");//商户还款计划编号
////      assetSetMap2.put("repaymentDate", "2018-08-31");//计划还款日期
////      assetSetMap2.put("costDetail", costDetail2);//费用集
////      assetSet.add(assetSetMap2);
//
//      requestBody.put("assetSet", assetSet);
//
//      String result = httpUtils(PreloanBaseApiPost.Repayment_Plan_Push, requestBody);
//
//      System.out.println(result);
//
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//    }
//  }
//
//  //还款计划查询接口
//  public void repaymentPlanSelect(String merchantContract_no) {
//    try {
//
//      Map<String, Object> requestBody = new HashMap<>();
//      requestBody.put("requestNo", requestNO);
//      requestBody.put("productCode", "G00000");
////      requestBody.put("productCode", PreloanBaseApiPost.produt_code);
//      requestBody.put("merchantContractNo", merchantContract_no);
//
//      String result = httpUtils(PreloanBaseApiPost.Repayment_Plan_Select, requestBody);
//      System.out.println("------------------");
//      System.out.println(result);
//      System.out.println("-------------------");
//
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      Assert.fail();
//
//    }
//
//  }
//
//
//  /**
//   * 附件上传接口
//   * 注意: url中替换merCode productCode
//   */
//  @Test
//  public void upload() {
//    String filepath = "/home/zsh2014/桌面/桌面.zip";
////    注意: url中替换merCode productCode
//    String urlStr = "http://preloan.5veda.net/zuul/preloan/api/asset/v1/file/upload/paipai/G00000";
//    Map<String, String> textMap = new HashMap<String, String>();
//    textMap.put("productCode", "G00000");
//    textMap.put("fileType", "1");
//    textMap.put("merchantCreditNo", "1034707557465051136");
//    textMap.put("fileName", "桌面.zip");
//    Map<String, String> fileMap = new HashMap<String, String>();
//    fileMap.put("file", filepath);
//    String ret = formUpload(urlStr, textMap, fileMap);
//    System.out.println(ret);
//  }
//
//  public static String formUpload(String urlStr, Map<String, String> textMap,
//      Map<String, String> fileMap) {
//    String res = "";
//    HttpURLConnection conn = null;
//    String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
//    try {
//      URL url = new URL(urlStr);
//      conn = (HttpURLConnection) url.openConnection();
//      conn.setConnectTimeout(5000);
//      conn.setReadTimeout(30000);
//      conn.setDoOutput(true);
//      conn.setDoInput(true);
//      conn.setUseCaches(false);
//      conn.setRequestMethod("POST");
//      conn.setRequestProperty("Connection", "Keep-Alive");
//      conn.setRequestProperty("User-Agent",
//          "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
//      conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
//
//      OutputStream out = new DataOutputStream(conn.getOutputStream());
//      // text
//      if (textMap != null) {
//        StringBuffer strBuf = new StringBuffer();
//        Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
//        while (iter.hasNext()) {
//          Map.Entry<String, String> entry = iter.next();
//          String inputName = (String) entry.getKey();
//          String inputValue = (String) entry.getValue();
//          if (inputValue == null) {
//            continue;
//          }
//          strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
//          strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
//          strBuf.append(inputValue);
//        }
//        out.write(strBuf.toString().getBytes());
//      }
//
//      // file
//      if (fileMap != null) {
//        Iterator<Map.Entry<String, String>> iter = fileMap.entrySet().iterator();
//        while (iter.hasNext()) {
//          Map.Entry<String, String> entry = iter.next();
//          String inputName = (String) entry.getKey();
//          String inputValue = (String) entry.getValue();
//          if (inputValue == null) {
//            continue;
//          }
//          File file = new File(inputValue);
//          String filename = file.getName();
////                    MagicMatch match = Magic.getMagicMatch(file, false, true);
////                    String contentType = match.getMimeType();
//
//          StringBuffer strBuf = new StringBuffer();
//          strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
//          strBuf.append(
//              "Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
//                  + "\"\r\n");
//          strBuf.append("Content-Type:" + "multipart/form-data;charset=UTF-8" + "\r\n\r\n");
//
//          out.write(strBuf.toString().getBytes());
//
//          DataInputStream in = new DataInputStream(new FileInputStream(file));
//          int bytes = 0;
//          byte[] bufferOut = new byte[1024];
//          while ((bytes = in.read(bufferOut)) != -1) {
//            out.write(bufferOut, 0, bytes);
//          }
//          in.close();
//        }
//      }
//
//      byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
//      out.write(endData);
//      out.flush();
//      out.close();
//
//      // 读取返回数据
//      StringBuffer strBuf = new StringBuffer();
//      BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//      String line = null;
//      while ((line = reader.readLine()) != null) {
//        strBuf.append(line).append("\n");
//      }
//      res = strBuf.toString();
//      System.out.println(res);
//      reader.close();
//      reader = null;
//    } catch (Exception e) {
//      System.out.println("发送POST请求出错。" + urlStr);
//      e.printStackTrace();
//    } finally {
//      if (conn != null) {
//        conn.disconnect();
//        conn = null;
//      }
//    }
//    return res;
//  }
//
//  //附件查询接口
////  @Test
////  public void fileSelect(String requestNo, String productCode, String merchantCreditNo,
////      String vedaCreditNo, String merchantContract_no, String vedaContractNo) throws Exception {
//////    String productCode="G00000";
//////    String vedaContractNo="HT202104940343349248";
////    //String vedaCreditNo="SX190832289539051520";
////    try {
////      Map<String, Object> requestBody = new HashMap();
////      requestBody.put("requestNo", requestNo);
//////      requestBody.put("requestNo",request_no);
////      requestBody.put("productCode", productCode);
//////      requestBody.put("productCode",PreloanBaseApiPost.produt_code);
////      requestBody.put("merchantCreditNo", merchantCreditNo);
////      requestBody.put("vedaCreditNo", vedaCreditNo);
////      requestBody.put("merchantContractNo", merchantContract_no);
////      requestBody.put("vedaContractNo", vedaContractNo);
//////      requestBody.put("vedaContractNo",vedaContractNo);
////      requestBody.put("fileType", "18");
////      System.out.println("111111");
////      String result = httpUtils(PreloanBaseApiPost.File_Select, requestBody);
////      System.out.println("------------------");
////      System.out.println(result);
////      System.out.println("-------------------");
////    } catch (Exception e) {
////      e.printStackTrace();
////      Assert.fail();
////    }
////
////  }
//
//
//  private String httpUtils(String url, Map<String, Object> requestBody) throws Exception {
//    HttpPost httpPost = new HttpPost(url);
//
//    String envelopOriginal = getRandomAesKey();
//
//    PublicKey publicKeyEnvelop = KeyUtil.getPublicKey(publicKeyString);
//    String envelop = KeyUtil.rsaEncrypt(envelopOriginal, publicKeyEnvelop);
//
//    String request = JSON.toJSONString(requestBody);
//    String requestDecrypted = KeyUtil.aesEncrypt(request, envelopOriginal);
//
//    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
//    String sign = KeyUtil.sign(requestDecrypted, privateKey);
//
//    httpPost.setHeader(HeaderConstant.ENVELOPE, envelop);
//    httpPost.setHeader(HeaderConstant.SIGN, sign);//multipart/form-data
//    httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
//    httpPost.setEntity(new ByteArrayEntity(requestDecrypted.getBytes()));
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
//
////        System.out.println(EntityUtils.toString(closeableHttpResponse.getEntity()));
//    String response = EntityUtils.toString(closeableHttpResponse.getEntity());
//    System.out.println(response);
//    JSONObject jsonObject = JSONObject.parseObject(response);
//    String data = jsonObject.getString("data");
//    System.out.println("data:" + data);
////
//    if (!StringUtils.isEmpty(data)) {
//
//      String resposeEnvelope = closeableHttpResponse.getFirstHeader(HeaderConstant.ENVELOPE).getValue();
//
//      String resposeSign = closeableHttpResponse.getFirstHeader(HeaderConstant.SIGN).getValue();
//
//      String aseKey = KeyUtil.rsaDecrypt(resposeEnvelope, privateKey); //rsaDecrpt
//
//      Boolean verify = KeyUtil.verify(response, resposeSign, publicKeyEnvelop);
//
//      if (verify) {
//        String deData = KeyUtil.aesDecrypt(data, aseKey);    //aesDescrypt
//        jsonObject.put("data", deData);
//      }
//    }
//
//    return jsonObject.toJSONString();
//  }
//
//
//
//  /**
//   * 将byte[] 转换成字符串
//   */
//  private static String byte2Hex(byte[] srcBytes) {
//    StringBuilder hexRetSB = new StringBuilder();
//    for (byte b : srcBytes) {
//      String hexString = Integer.toHexString(0x00ff & b);
//      hexRetSB.append(hexString.length() == 1 ? 0 : "").append(hexString);
//    }
//    return hexRetSB.toString();
//  }
//
//
//  /**
//   * 随机生成秘钥 64bit 密钥长度为16位
//   */
//  private static String getRandomAesKey() {
//    Random random = new Random();
//    random.setSeed(System.currentTimeMillis());
//    byte[] bys = new byte[8];
//    random.nextBytes(bys);
//    String s = byte2Hex(bys);
//    System.out.println("秘钥 ： " + s);
//    return s;
//  }
//
//
//
//  public static void main(String[] args) {
//    for (int i = 0; i <= 50; i++) {
//      String[] cycle = {"0", "1", "3", "6", "12"};
//      int o = (int) (Math.random() * cycle.length);
//      String payInterestCycle = cycle[o];     //付息周期-填1、3、6、12、0
//      System.out.println(payInterestCycle);
//    }
//  }
//
//  private String httpUtils(String url, String sign, String requestDecrypted, String envelop)
//      throws Exception {
//    HttpPost httpPost = new HttpPost(url);
//
////    String envelopOriginal = getRandomAesKey();
//
//    PublicKey publicKeyEnvelop = KeyUtil.getPublicKey(publicKeyString);
////    String envelop = KeyUtil.rsaEncrypt(envelopOriginal, publicKeyEnvelop);
//
////        String request = JSON.toJSONString(requestBody);
////        String requestDecrypted = KeyUtil.aesEncrypt(request, envelopOriginal);
//
//    PrivateKey privateKey = KeyUtil.getPrivate(privateKeyString);
////        String sign = KeyUtil.sign(requestDecrypted, privateKey);
//
//    httpPost.setHeader(HeaderConstant.ENVELOPE, envelop);
//    httpPost.setHeader(HeaderConstant.SIGN, sign);
//    httpPost.setHeader("Content-Type", "data/form");
//    httpPost.setEntity(new ByteArrayEntity(requestDecrypted.getBytes()));
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
//
////        System.out.println(EntityUtils.toString(closeableHttpResponse.getEntity()));
//    String response = EntityUtils.toString(closeableHttpResponse.getEntity());
//    JSONObject jsonObject = JSONObject.parseObject(response);
//    String data = jsonObject.getString("data");
//    if (!StringUtils.isEmpty(data)) {
//
//      String resposeEnvelope = closeableHttpResponse.getFirstHeader(HeaderConstant.ENVELOPE)
//          .getValue();
//
//      String resposeSign = closeableHttpResponse.getFirstHeader(HeaderConstant.SIGN).getValue();
//
//      String aseKey = KeyUtil.rsaDecrypt(resposeEnvelope, privateKey);
//
//      Boolean verify = KeyUtil.verify(response, resposeSign, publicKeyEnvelop);
//
//      if (verify) {
//
//        String deData = KeyUtil.aesDecrypt(data, aseKey);
//        jsonObject.put("data:", deData);
//      }
//
//    }
//
//    return jsonObject.toJSONString();
//  }
//}
