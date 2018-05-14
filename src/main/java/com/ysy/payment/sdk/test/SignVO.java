package com.ysy.payment.sdk.test;

public class SignVO{

	/**
     * �����IP��ַ
     */
    private String addresIp;
    
    /**
     * �ͻ�������İ汾
     */
    private String version;
    
    /**
     * �����IMEI�豸��
     */
    private String deviceId;
    
    /**
     * �豸����
     */
    private String deviceType;
    
    /**
     * ��ȡ�ֻ�����
     */
    private String longitude;
    
    /**
     * ��ȡ�ֻ�γ��
     */
    private String latitude;
    
    private String merchno;
    
	private Integer id;
	
	/**
     * 持卡�?
     */
    private String cardName;
    
    /**
     * 卡号
     */
    private String cardNo;
    
    /**
     * 银行预留手机�?
     */
    private String phoneNo;
    
    /**
     * 信用卡账单日
     */
    private String billDay;
    
    /**
     * 信用卡还款日
     */
    private String repayDay;
    
    /**
     * 身份�?
     */
    private String identityCard;
    
    /**
     * 短信校验�?
     */
    private String verifyCode;
    
    /**
     * 短信验证�?
     */
    private String smsCode;
    
    /**
     * 还款�?始时�?
     */
    private String repayStartDate;
    
    /**
     * 还款结束时间
     */
    private String repayEndDate;
    
    /**
     * 还款金额
     */
    private String repayAmt;
    
    /**
     * 保证金额
     */
    private String marginAmt;
    
    /**
     * 付款金额
     */
    private String payAmt;
    
    /**
     * 银行编码
     */
    private String bankCode;
    
    /**
     * 付款卡号
     */
    private String payCardNo;
    
    /**
     * 付款银行
     */
    private String payBankName;
    
    /**
     * 代还信用卡号
     */
    private String repayCreditCardNo;
    
    /**
     * 付款持卡人姓�?
     */
    private String payCardName;
    
    /**
     * 付款卡有效期
     */
    private String valiDate;
    
    /**
     * 付款卡安全码
     */
    private String securCode;
    
    /**
     * 付款卡号预留手机�?
     */
    private String phone;
    
    /**
     * 服务�?
     */
    private String serviceFee;
    
    /**
     * 分期�?
     */
    private Integer phaseNum;
    
    /**
     * 保证金比�?
     */
    private String marginRatio;

    private Integer pageSize;
    
    private Integer pageNum;
    
    private String repayStatus;
    
    /**
     * 提现开始时间
     */
    private String withdrawStartTime;
    
    /**
     * 提现结束时间
     */
    private String withdrawEndTime;
    
    /**
     * 提现状态
     */
    private String payStatus;
    
    /**
     * 提现金额
     */
    private String withdrawAmt;
    
    private String key;
    
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWithdrawAmt() {
		return withdrawAmt;
	}

	public void setWithdrawAmt(String withdrawAmt) {
		this.withdrawAmt = withdrawAmt;
	}

	public String getWithdrawStartTime() {
		return withdrawStartTime;
	}

	public void setWithdrawStartTime(String withdrawStartTime) {
		this.withdrawStartTime = withdrawStartTime;
	}

	public String getWithdrawEndTime() {
		return withdrawEndTime;
	}

	public void setWithdrawEndTime(String withdrawEndTime) {
		this.withdrawEndTime = withdrawEndTime;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getRepayStatus() {
		return repayStatus;
	}

	public void setRepayStatus(String repayStatus) {
		this.repayStatus = repayStatus;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getAddresIp() {
		return addresIp;
	}

	public void setAddresIp(String addresIp) {
		this.addresIp = addresIp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getBillDay() {
		return billDay;
	}

	public void setBillDay(String billDay) {
		this.billDay = billDay;
	}

	public String getRepayDay() {
		return repayDay;
	}

	public void setRepayDay(String repayDay) {
		this.repayDay = repayDay;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getRepayStartDate() {
		return repayStartDate;
	}

	public void setRepayStartDate(String repayStartDate) {
		this.repayStartDate = repayStartDate;
	}

	public String getRepayEndDate() {
		return repayEndDate;
	}

	public void setRepayEndDate(String repayEndDate) {
		this.repayEndDate = repayEndDate;
	}

	public String getRepayAmt() {
		return repayAmt;
	}

	public void setRepayAmt(String repayAmt) {
		this.repayAmt = repayAmt;
	}

	public String getMarginAmt() {
		return marginAmt;
	}

	public void setMarginAmt(String marginAmt) {
		this.marginAmt = marginAmt;
	}

	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getPayCardNo() {
		return payCardNo;
	}

	public void setPayCardNo(String payCardNo) {
		this.payCardNo = payCardNo;
	}

	public String getPayBankName() {
		return payBankName;
	}

	public void setPayBankName(String payBankName) {
		this.payBankName = payBankName;
	}

	public String getRepayCreditCardNo() {
		return repayCreditCardNo;
	}

	public void setRepayCreditCardNo(String repayCreditCardNo) {
		this.repayCreditCardNo = repayCreditCardNo;
	}

	public String getPayCardName() {
		return payCardName;
	}

	public void setPayCardName(String payCardName) {
		this.payCardName = payCardName;
	}

	public String getValiDate() {
		return valiDate;
	}

	public void setValiDate(String valiDate) {
		this.valiDate = valiDate;
	}

	public String getSecurCode() {
		return securCode;
	}

	public void setSecurCode(String securCode) {
		this.securCode = securCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Integer getPhaseNum() {
		return phaseNum;
	}

	public void setPhaseNum(Integer phaseNum) {
		this.phaseNum = phaseNum;
	}

	public String getMarginRatio() {
		return marginRatio;
	}

	public void setMarginRatio(String marginRatio) {
		this.marginRatio = marginRatio;
	}

	public String getMerchno() {
		return merchno;
	}

	public void setMerchno(String merchno) {
		this.merchno = merchno;
	}
}
