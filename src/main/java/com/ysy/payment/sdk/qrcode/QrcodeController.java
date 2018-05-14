package com.ysy.payment.sdk.qrcode;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ysy.payment.sdk.dto.ExternalQrcodeVO;
import com.ysy.payment.sdk.test.SignVO;
import com.ysy.payment.sdk.util.HttpsClientUtil;
import com.ysy.payment.sdk.util.JSONUtils;
import com.ysy.payment.sdk.util.ReflectUtils;
import com.ysy.payment.sdk.util.SignUtil;

public class QrcodeController {

	static Logger log = LoggerFactory.getLogger(QrcodeController.class);
	
	//下单url  线上地址
	//private String tran_url="http://120.24.13.203:9001/services/pay/gateway/api/backTransReq";
	//测试地址
	private String tran_url="http://120.24.98.96:9001/services/pay/gateway/api/backTransReq";
	
	//查询订单url   线上地址
	private String query_url="http://120.24.13.203:9001/services/pay/gateway/api/queryTran";
	//测试地址
	//private String query_url="http://192.168.0.101:8082/gateway/api/queryTran";
	
	//退款url  测试地址
	private String refund_url="http://cp.esyto.com:9000/gateway/api/refundTransReq";
	
	//加签密钥
	private String merchKey = "83763B6487FB8E910A5BB1ADAB2732D6";
	
	/**
	 * 发起订单交易
	 * @return
	 * @throws Exception 
	 */
	public String backTransRequest() throws Exception{
		ExternalQrcodeVO qrcodeVO = new ExternalQrcodeVO();
		qrcodeVO.setMerchno("200440348120003");
		qrcodeVO.setGoodsName("安致兰德");
		qrcodeVO.setTraceno("AZLD"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		//qrcodeVO.setTraceno("tuikuan20180112155860");
		qrcodeVO.setAmount(new BigDecimal(1).setScale(2).doubleValue());
		qrcodeVO.setCallbackUrl("");
		qrcodeVO.setNotifyUrl("");
		qrcodeVO.setPayType(2);
		qrcodeVO.setAttach("");
		
		Map<String, String> param = ReflectUtils.convertToMaps(qrcodeVO);
		String sign = SignUtil.genSign(merchKey, SignUtil.createLinkString(SignUtil.paraFilter(param)));
		qrcodeVO.setSign(sign);
		
		String postStr = (String)JSONUtils.obj2json(qrcodeVO);
		log.info("请求参数:{}",postStr);
		//HttpsClientUtil.sendRequest(tran_url, postStr, "application/json");
		
		String result = HttpsClientUtil.sendRequest(tran_url, postStr, "application/json");
		log.info("响应结果:{}",result);
		
		return result;
	}
	
	/**
	 * 发起小程序支付订单交易
	 * @return
	 * @throws Exception 
	 */
	public String miniTransRequest() throws Exception{
		ExternalQrcodeVO qrcodeVO = new ExternalQrcodeVO();
		qrcodeVO.setMerchno("200440357220002");
		qrcodeVO.setTraceno("TL"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		qrcodeVO.setAmount(new BigDecimal(1).setScale(2).doubleValue());
		qrcodeVO.setOpenid("ohgYk0Zxx_BXJGYAgLCP79xGYgCc");
		qrcodeVO.setPayType(2);
		
		Map<String, String> param = ReflectUtils.convertToMaps(qrcodeVO);
		String sign = SignUtil.genSign("410502F860CCAC24A971771CB9B1CD27", SignUtil.createLinkString(SignUtil.paraFilter(param)));
		qrcodeVO.setSign(sign);
		
		String postStr = (String)JSONUtils.obj2json(qrcodeVO);
		log.info("请求参数:{}",postStr);
		
		String result = HttpsClientUtil.sendRequest(tran_url, postStr, "application/json");
		log.info("响应结果:{}",result);
		
		return result;
	}
	
	/**
	 * 发起查询订单交易
	 * @return
	 * @throws Exception 
	 */
	public String queryTransRequest() throws Exception{
		ExternalQrcodeVO qrcodeVO = new ExternalQrcodeVO();
		qrcodeVO.setMerchno("200440348120003");
		qrcodeVO.setTraceno("tuikuan20180112155859");
		
		Map<String, String> param = ReflectUtils.convertToMaps(qrcodeVO);
		String sign = SignUtil.genSign("83763B6487FB8E910A5BB1ADAB2732D6", SignUtil.createLinkString(SignUtil.paraFilter(param)));
		qrcodeVO.setSign(sign);
		
		String postStr = (String)JSONUtils.obj2json(qrcodeVO);
		log.info("请求参数:{}",postStr);
		
		String result = HttpsClientUtil.sendRequest(query_url, postStr, "application/json");
		log.info("响应结果:{}",result);
		
		return result;
	}
	
	/**
	 * 发起扫码--退款交易
	 * @return
	 * @throws Exception 
	 */
	public String refundTransRequest() throws Exception{
		ExternalQrcodeVO qrcodeVO = new ExternalQrcodeVO();
		qrcodeVO.setMerchno("200440348120003");
		qrcodeVO.setRefundReason("");
		qrcodeVO.setTraceno("tuikuan20180112155860");
		qrcodeVO.setAmount(new BigDecimal(1).setScale(0).doubleValue());
		qrcodeVO.setPayType(2);
		
		Map<String, String> param = ReflectUtils.convertToMaps(qrcodeVO);
		String sign = SignUtil.genSign(merchKey, SignUtil.createLinkString(SignUtil.paraFilter(param)));
		qrcodeVO.setSign(sign);
		
		System.out.println(qrcodeVO);
		String postStr = (String)JSONUtils.obj2json(qrcodeVO);
		log.info("请求参数:{}",postStr);
		//HttpsClientUtil.sendRequest(tran_url, postStr, "application/json");
		
		String result = HttpsClientUtil.sendRequest(refund_url, postStr, "application/json");
		log.info("响应结果:{}",result);
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		new QrcodeController().backTransRequest();
		//new QrcodeController().queryTransRequest();
		//new QrcodeController().refundTransRequest();
//		SignVO signVO = new SignVO();
//		signVO.setAddresIp("127.0.0.1");
//		signVO.setVersion("1.0.0");
//		signVO.setDeviceId("355311080070412");
//		signVO.setDeviceType("iphone");
//		signVO.setLongitude("113.950723");
//		signVO.setLatitude("22.558888");
//		signVO.setMerchno("200440154110014");
//		signVO.setPayAmt("54.75");
//		signVO.setBankCode("CGB");
//		signVO.setPayCardNo("6258101649353374");
//		signVO.setRepayCreditCardNo("6258101649353374");
//		signVO.setPayCardName("曾云龙");
//		signVO.setPayBankName("广发银行");
//		signVO.setValiDate("1221");
//		signVO.setSecurCode("106");
//		signVO.setPhone("13510492707");
//		signVO.setRepayStartDate("2018-03-27");
//		signVO.setRepayEndDate("2018-03-28");
//		signVO.setRepayAmt("100");
//		signVO.setMarginAmt("50");
//		signVO.setServiceFee("4.75");
//		signVO.setPhaseNum(4);
//		signVO.setMarginRatio("50");
//		
//		Map<String, String> param = ReflectUtils.convertToMaps(signVO);
//		System.out.println(param);
//		String sign = SignUtil.genSign("56CE8947ED3B5DDAEC608DD30DB31A19", SignUtil.createLinkString(SignUtil.paraFilter(param)));
//		System.out.println(sign);
	}
}
