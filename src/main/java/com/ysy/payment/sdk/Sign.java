package com.ysy.payment.sdk;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.ysy.payment.sdk.dto.RegistVO;
import com.ysy.payment.sdk.test.SignVO;
import com.ysy.payment.sdk.util.JSONUtils;
import com.ysy.payment.sdk.util.ReflectUtils;

public class Sign {

	static Logger log = LoggerFactory.getLogger(Sign.class);
	
	public static void main(String[] args) throws Exception {
		//文档支付费用接口加签
//		RegistVO regist = new RegistVO();
//		regist.setVersion("1.2");
//		regist.setAgentno("4403010001");
//		regist.setFullName("Moyq5");
//		regist.setMerchName("护城河");
//		regist.setLegalName("莫勇强");
//		regist.setIdentityCard("450881198812287118");
//		regist.setMobile("15012918802");
//		regist.setProvince("广东省");
//		regist.setCity("深圳市");
//		regist.setAreaName("南山区");
//		regist.setAddress("科技园");
//		regist.setAreaCode("220303");
//		regist.setEmail("mo_yq5@163.com");
//		regist.setAccountName("莫勇强");
//		regist.setAccountno("6226097559749198");
//		regist.setAccountType("1");
//		regist.setBankName("招商银行深圳分行莲花支行");
//		regist.setBankno("308584001725");
//		regist.setPayFeeD0("2.00");
//		regist.setPayFeeT1("2.00");
//		regist.setQuickPayD0Rate(new BigDecimal(0.0047));
//		regist.setQuickPayT1Rate(new BigDecimal(0.0047));
//		signVO.setPayAmt("54.75");
//		signVO.setBankCode("CGB");
//		signVO.setPayCardNo("1234567891234567");
//		signVO.setRepayCreditCardNo("1234567891234567");
//		signVO.setPayCardName("***");
//		signVO.setPayBankName("广发银行");
//		signVO.setValiDate("0123");
//		signVO.setSecurCode("456");
//		signVO.setPhone("12345678912");
//		signVO.setRepayStartDate("2018-03-27");
//		signVO.setRepayEndDate("2018-03-28");
//		signVO.setRepayAmt("10000");
//		signVO.setMarginAmt("3000");
//		signVO.setServiceFee("81");
//		signVO.setPhaseNum(6);
//		signVO.setMarginRatio("30");
		
		SignVO vo = new SignVO();
		vo.setAddresIp("test");
		vo.setVersion("1.0");
		vo.setDeviceId("android");
		vo.setDeviceType("android");
		vo.setLongitude("1");
		vo.setLatitude("1");
		vo.setMerchno("200541100000535");
		vo.setPhoneNo("12345678911");
		vo.setBillDay("06");
		vo.setRepayDay("24");
		vo.setSmsCode("1124");
		vo.setVerifyCode("N2QyYWIwMDM5ZWQyMGMxMWViZTA4ZTIyOTI1MzBiOWR8MTUyMTc5NTcxODQ5Ng==");
		vo.setCardName("曾云龙");
		vo.setCardNo("123456789234568");
		vo.setIdentityCard("123456789456");
		//vo.setWithdrawAmt("2.00");
		//vo.setKey("E471CD46A8C226667B9C30D043853A0D");
		
		Map<String, String> param = convertToMaps(vo);
		System.out.println(param);
		String sign = genSign("E471CD46A8C226667B9C30D043853A0D", createLinkString(paraFilter(param)));
		System.out.println(sign);
		//56CE8947ED3B5DDAEC608DD30DB31A19
	}
	
	public static String genSign(String key,String str){
		System.out.println(str);
		System.out.println(key);
		return md5(str+"&key="+key).toUpperCase();
	}
	
	public static String md5(String plainText) {
        try {
            return Encodes.encodeHex(Digests.md5(new ByteArrayInputStream(plainText.getBytes("utf-8"))));
        } catch (Exception ex) {
            return "";   
        }
    }
	
	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 鎷兼帴鏃讹紝涓嶅寘鎷渶鍚庝竴涓�&瀛楃
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}
	
	/** 
     * 将泛型形参给出的类中设置的属性值转换为Map形式的键值对 
     * t一般是pojo类 
     *  
     * @param params 
     * @param t 
     */  
    public static <T extends Object> Map<String, String> convertToMaps(T t) {  
        Map<String, String> params = new HashMap<String, String>();
        DecimalFormat formater = new DecimalFormat("###0.0000");
        DecimalFormat formater2 = new DecimalFormat("###0.00");
        if( t == null)  
            return params;  
          
        Class<?> clazz = t.getClass() ;  
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
            try {  
                Field[] fields = clazz.getDeclaredFields() ;  
                  
                for (int j = 0; j < fields.length; j++) { // 遍历所有属性  
                    String name = fields[j].getName(); // 获取属性的名字  
                    Object value = null;  
                      
                    if(log.isDebugEnabled())  
                        log.debug(ReflectUtils.class + "method flushParams attribute name:" + name + "  ");  
                          
                    if(!"serialVersionUID".equals(name)){  
                        Method method = t.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));  
                        value = method.invoke(t);  
  
                        if(log.isDebugEnabled())  
                            log.debug(ReflectUtils.class + "attribute value:" + value);  
                        
                        if(value != null) 
                        {
                            if(value instanceof List)  
                            {
                                Object[] objs = ((List)value).toArray();
                                List<Object> list = new ArrayList<Object>();
                                for(Object obj : objs)
                                {
                                    Map<String, String> para =convertToMaps(obj);
                                    list.add(para);
                                }
                                
                                params.put(name, JSONUtils.obj2json(list));  
                            }else if(value instanceof String)
                            {
                                params.put(name, value.toString());  
                            }else if(value instanceof BigDecimal){
                                params.put(name, formater.format(value));  
                            }else if(value instanceof Double){
                                params.put(name, formater2.format(value));  
                            }else
                            {
                                params.put(name, value.toString());
                            }
                        }
                            
                    }  
                }  
            } catch (Exception e) {}   
        }
        return params;
    }  
    
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		DecimalFormat formater = new DecimalFormat("###0.00");
		DecimalFormat formater2 = new DecimalFormat("###0.0000");
		for (String key : sArray.keySet()) {
			String finalValue = null;
			Object value = sArray.get(key);
			if(value instanceof BigDecimal){
				finalValue = formater2.format(value);
			}else if(value instanceof Double){
			    finalValue = formater.format(value);
			}else {
				finalValue =  String.valueOf(value);
			}
			if (value == null || value.equals("")
					|| key.equalsIgnoreCase("sign")) {
				continue;
			}
			result.put(key, finalValue);
		}

		return result;
	}
}
