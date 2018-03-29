//package com.ysy.payment.sdk.proxy;
//
//import java.util.Arrays;
//import java.util.Map;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//public class Test {
//
//	public static void main(String[] args) {
////		String paydetail_1="wnf-trans-953882466286829503^批量代付1^6214856555342173^曾云龙^0.01^个人^储蓄卡^招商银行^^^^^测试代付1^ ";
////		String paydetail_2="wnf-trans-953882466286829504^批量代付2^6214856555342173^曾云龙^0.01^个人^储蓄卡^招商银行^^^^^测试代付2^ ";
////		String paydetail=paydetail_1+"|"+paydetail_2;
////		
////		String[] paydetails=paydetail.split("\\|");
////		System.out.println(Arrays.toString(paydetails));
////		
////		String[] details;
////		String businessnumber;
////		String subject;
////		String bankcardnumber;
////		String bankcardname;
////		String transactionamount;
////		String bankcardtype;
////		String bankaccounttype;
////		String bankname;
////		String description;
////		for(String str:paydetails){
////			ProxyDTO proxyDto = new ProxyDTO();
////			details=str.split("\\^");
////			System.out.println(Arrays.toString(details));
////			businessnumber=details[0];
////			subject=details[1];
////			bankcardnumber=details[2];
////			bankcardname=details[3];
////			transactionamount=details[4];
////			bankcardtype=details[5];
////			bankaccounttype=details[6];
////			bankname=details[7];
////			description=details[12];
////			
////			proxyDto.setBusinessnumber(businessnumber);
////			proxyDto.setSubject(subject);
////			proxyDto.setBankcardnumber(bankcardnumber);
////			proxyDto.setBankcardname(bankcardname);
////			proxyDto.setTransactionamount(transactionamount);
////			proxyDto.setBankcardtype(bankcardtype);
////			proxyDto.setBankaccounttype(bankaccounttype);
////			proxyDto.setBankname(bankname);
////			proxyDto.setDescription(description);
////			
////			System.out.println(proxyDto);
////		}
////		System.out.println(new BigDecimal(2.00).subtract(null));
////		System.out.println(new BigDecimal(2.00).subtract(null).setScale(2));
//		String str="wnf-trans-953882466286829520^批量代付16^6214856555342173^曾云龙^2^个人^储蓄卡^招商银行^^^^^测试代付^ |"
//				+ "wnf-trans-953882466286829521^批量代付17^6214856555342173^曾云龙^2^个人^储蓄卡^招商银行^^^^^测试代付^ ";
//		
//		test(str,0);
//	}
//	
//	public static String test(String str,int i){
//		String str1="{'code':'','count':'','data':"
//				+ "[{'payAmount':1.50,'inputDate':'20180125211013'},{'payAmount':2.50,'inputDate':'20180125211014'}],"
//				+ "'msg':'查询成功','result':'success'}";
//		
//		String str2 = "{    \"code\": \"\","
//				+ "    \"count\": \"\",  "
//				+ "    \"data\":"
//				+ " [     {"
//				+ "            \"batchNo\": \"batbat20180124174548\","
//				+ "            \"payAmount\": 1,"
//				+ "            \"bankCardNumber\": \"6214856555342173\","
//				+ "            \"subject\": \"批量代付16\","
//				+ "            \"remark\": \"\","
//				+ "            \"businessNumber\": \"wnf-trans-953882466286829520\","
//				+ "            \"stampDate\": \"20180125181218\","
//				+ "            \"bankCardName\": \"曾云龙\","
//				+ "            \"inputDate\": \"20180125181218\","
//				+ "            \"status\": \"待处理\""
//				+ "        },"
//				+ "        {"
//				+ "            \"batchNo\": \"batbat20180124174548\","
//				+ "            \"payAmount\": 1,"
//				+ "            \"bankCardNumber\": \"6214856555342173\","
//				+ "            \"subject\": \"批量代付17\","
//				+ "            \"remark\": \"\","
//				+ "            \"businessNumber\": \"wnf-trans-953882466286829521\","
//				+ "            \"stampDate\": \"20180125181218\","
//				+ "            \"bankCardName\": \"曾云龙\","
//				+ "            \"inputDate\": \"20180125181218\","
//				+ "            \"status\": \"待处理\""
//				+ "        }"
//				+ "    ],"
//				+ "    \"msg\": \"查询成功\","
//				+ "    \"result\": \"success\""
//				+ "}";
//		
//		
//		System.out.println(str2);
//		JSONObject json = JSONObject.parseObject(str1);
////		JSONArray data = json.getJSONArray("data");
////		System.out.println(data);
//		
//		
//		
//		System.out.println(json.getString("data"));
//		JSONArray jsonArray = JSONArray.parseArray(json.getString("data"));
//		for(int j=0;j<jsonArray.size();j++){
//			System.out.println(jsonArray.get(j).toString());
//		}
//		return null;
//	}
//}
