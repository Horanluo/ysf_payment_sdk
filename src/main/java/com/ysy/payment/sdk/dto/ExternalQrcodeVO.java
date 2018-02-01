/*
 * 类文件名:  QrcodeOrderDTO.java
 * 著作版权:  深圳市云智恒生科技有限公司 Copyright 2012-2022, E-mail: 283912449@qq.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  曾云龙
 * 创建时间:  2017年7月25日
 * 功能版本:  V001Z0001
 */
package com.ysy.payment.sdk.dto;

/**
 * 二维码订单
 * 
 * @author 曾云龙
 * @version V001Z0001
 * @date 2017年7月25日
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ExternalQrcodeVO
{
    /**
     * 平台分配的商户号
     */
    private String merchno;
    
    /**
     * 外部流水号
     */
    private String traceno;
    
    /**
     * 交易金额
     */
    private double amount;
    
    /**
     * 支付方式
     */
    private int payType;
    
    /**
     * 返回地址
     */
    private String notifyUrl;
    
    /**
     * 商品名称
     */
    private String goodsName;
    
    /**
     * 支付渠道
     */
    private String channel;
    
    /**
     * 附加数据
     */
    private String attach;
    
    /**
     * 签名
     */
    private String sign;
    
    /**
     * 前端回调地址
     */
    private String callbackUrl;

    private String openid;
    
	public String getMerchno() {
		return merchno;
	}

	public void setMerchno(String merchno) {
		this.merchno = merchno;
	}

	public String getTraceno() {
		return traceno;
	}

	public void setTraceno(String traceno) {
		this.traceno = traceno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
