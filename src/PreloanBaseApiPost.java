package test.preloan;

/**
 * @author wjh on 18-5-31.
 */
public class PreloanBaseApiPost {

  //山东爱财
//  public static final String mer_code = "aicai";
//  public static final String produt_code = "AC0001";             //  固定RRH004
//////
//  public static final String mer_code = "paipai";
//  public static final String produt_code = "G00000";

//
//////小米测试
//  public static final String mer_code = "mitest";
//  public static final String produt_code = "xz_xiaomi";

////
// public static final String mer_code = "paipai";
// public static final String produt_code = "G00000";
  public static final String mer_code = "xiaomi";
  public static final String produt_code = "xiaomi";


//  public static final String mer_code = "中赢谷";
//  public static final String produt_code = "G00001";             //  固定RRH004

  /**
   * 内网测试：
   * 192.168.0.222:9084
   */


//  public static final String Contract_Applay="http://192.168.0.222:9084/preloan/api/asset/v1/contract/"+mer_code+"/"+produt_code;//用信申请接口
  public static final String Credit_Applay="http://192.168.0.222:9084/preloan/api/credit/v1/credit-application/"+mer_code+"/"+produt_code;//授信申请接口
  public static final String Credit_Select = "http://192.168.0.222:9084/preloan/api/credit/v1/credit-application/query/"+mer_code+"/"+produt_code;//授信查询接口
//  public static final String Credit_Select = "http://192.168.69.19:8870/preloan/api/credit/v1/credit-application/query/"+mer_code+"/"+produt_code;//授信查询接口
//  public static final String Credit_Applay="http://192.168.69.19:8870/preloan/api/credit/v1/credit-application/"+mer_code+"/"+produt_code;//授信申请接口
  public static final String Contract_Select = "http://192.168.0.222:9084/preloan/api/asset/v1/contract/query/"+mer_code+"/"+produt_code;//用信查询接口
//  public static final String Adjust_Apply = "http://192.168.0.222:9084/preloan/api/credit/xiaomi/adjustAmount/"+mer_code+"/"+produt_code;//调额申请接口
//  public static final String Adjust_Select = "http://192.168.0.222:9084/preloan/api/credit/xiaomi/adjustAmount/query/"+mer_code+"/"+produt_code;//调额查询接口
//  public static final String Loan_Applay = "http://192.168.0.222:9084/preloan/api/remittance/v1/remittance-application/"+mer_code+"/"+produt_code;//放款申请接口
//  public static final String Loan_Applay_Select = "http://192.168.0.222:9084/preloan/api/remittance/v1/remittance-application/query/"+mer_code+"/"+produt_code;//放款查询接口
//  public static final String Repayment_Plan_Push = "http://192.168.0.222:9084/preloan/api/asset/v1/assetSet/"+mer_code+"/"+produt_code;  //还款计划推送接口
//  public static final String Repayment_Plan_Select = "http://192.168.0.222:9084/preloan/api/asset/v1/assetSet/query/"+mer_code+"/"+produt_code;  //还款计划查询接口
//  public static final String File_upload="http://192.168.0.222:9084/zuul/preloan/api/asset/v1/file/upload/"+ mer_code+ "/"+produt_code;//附件上传接口
//  public static final String File_Select="http://192.168.0.222:9084/zuul/preloan/api/asset/v1/file/getFiles/"+ mer_code+ "/"+produt_code;//附件查询接口
//  public static final String multi_File_upload="http://192.168.0.222:9084/zuul/preloan/api/asset/v2/file/upload/"+ mer_code+ "/"+produt_code;


  /**
   * 外网测试
   * cbhb.5veda.net
   */

  public static final String Contract_Applay = "http://cbhb.5veda.net/preloan/api/asset/v1/contract/"+ mer_code+ "/"+produt_code;//用信申请接口
//  public static final String Credit_Applay = "http://cbhb.5veda.net/preloan/api/credit/v1/credit-application/"+ mer_code+ "/"+produt_code;//授信申请接口
//  public static final String Credit_Select = "http://cbhb.5veda.net/preloan/api/credit/v1/credit-application/query/"+ mer_code+ "/"+produt_code;//授信查询接口
//  public static final String Contract_Select = "http://cbhb.5veda.net/preloan/api/asset/v1/contract/query/"+ mer_code+ "/"+produt_code;//用信查询接口
  public static final String Loan_Applay = "http://cbhb.5veda.net/preloan/api/remittance/v1/remittance-application/"+ mer_code+ "/"+produt_code;//放款申请接口
  public static final String Loan_Applay_Select = "http://cbhb.5veda.net/preloan/api/remittance/v1/remittance-application/query/"+ mer_code+ "/"+produt_code; //放款查询接口
  public static final String Repayment_Plan_Push = "http://cbhb.5veda.net/preloan/api/asset/v1/assetSet/"+ mer_code+ "/"+produt_code;//还款计划推送接口
  public static final String Repayment_Plan_Select = "http://cbhb.5veda.net/preloan/api/asset/v1/assetSet/query/"+ mer_code+ "/"+produt_code;//还款计划查询接口
  public static final String File_upload= "http://cbhb.5veda.net/zuul/preloan/api/asset/v1/file/upload/"+ mer_code+ "/"+produt_code;//附件上传接口
  public static final String multi_File_upload="http://cbhb.5veda.net/zuul/preloan/api/asset/v2/file/upload/"+ mer_code+ "/"+produt_code;
  public static final String Adjust_Apply = "http://cbhb.5veda.net/preloan/api/credit/xiaomi/adjustAmount/"+mer_code+"/"+produt_code;//调额申请接口
  public static final String Adjust_Select = "http://cbhb.5veda.net/preloan/api/credit/xiaomi/adjustAmount/query/"+mer_code+"/"+produt_code;//调额查询接口

  //public static final String multi_File_upload="http://cbhb.5veda.net/zuul/preloan/api/asset/v2/file/upload/"+ mer_code+ "/"+produt_code;

  /**
   * wf贷前
   * 公网测试
   * 124.133.252.132:5802
   */


//  public static final String Contract_Applay = "http://124.133.252.132:5802/preloan/api/asset/v1/contract/"+ mer_code+ "/"+produt_code;
//  public static final String Credit_Applay = "http://124.133.252.132:5802/preloan/api/credit/v1/credit-application/"+ mer_code+ "/"+produt_code;//授信申请接口
//  public static final String Credit_Select = "http://124.133.252.132:5802/preloan/api/credit/v1/credit-application/query/"+ mer_code+ "/"+produt_code;//授信信查询接口
//  public static final String Contract_Select = "http://124.133.252.132:5802/preloan/api/asset/v1/contract/query/"+ mer_code+ "/"+produt_code;//用信查询接口
//  public static final String Loan_Applay = "http://124.133.252.132:5802/preloan/api/remittance/v1/remittance-application/"+ mer_code+ "/"+produt_code;//放款申请接口
//  public static final String Loan_Applay_Select = "http://124.133.252.132:5802/preloan/api/remittance/v1/remittance-application/query/"+ mer_code+ "/"+produt_code; //放款查询接口
//  public static final String Repayment_Plan_Push = "http://124.133.252.132:5802/preloan/api/asset/v1/assetSet/"+ mer_code+ "/"+produt_code;//还款计划推送接口
//  public static final String Repayment_Plan_Select = "http://124.133.252.132:5802/preloan/api/asset/v1/assetSet/query/"+ mer_code+ "/"+produt_code;//还款计划查询接口
//  public static final String File_upload="http://124.133.252.132:5802/zuul/preloan/api/asset/v1/file/upload/"+ mer_code+ "/"+produt_code;//附件上传接口
//  public static final String File_Select="http://124.133.252.132:5802/zuul/preloan/api/asset/v1/file/getFiles/"+ mer_code+ "/"+produt_code;//附件查询接口


}
