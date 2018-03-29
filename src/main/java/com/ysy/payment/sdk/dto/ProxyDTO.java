/*
 * 类文件名:  MerchDTO.java
 * 著作版权:  深圳市云智恒生科技有限公司 Copyright 2012-2022, E-mail: 283912449@qq.com, All rights reserved
 * 功能描述:  <描述>
 * 类创建人:  曾云龙
 * 创建时间:  2017年7月23日
 * 功能版本:  V001Z0001
 */
package com.ysy.payment.sdk.dto;

/**
 * 商户注册信息
 * 
 * @author   Horanluo
 * @version  V001Z0001
 * @date     2018年01月22日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ProxyDTO
{
	private String merchno;
	private String businessnumber;
	private String subject;
	private String transactionamount;
	private String bankcardnumber;
	private String bankcardname;
	private String bankname;
	private String bankcardtype;
	private String bankaccounttype;
	private String province;
	private String city;
	private String branchbankname;
	private String banknumber;
	private String backurl;
	private String terminal;
	private String sign;
	private String description;
	private String batchno;
	private String batchnum;
	private String batchamount;
	private String paydate;
	private String paydetail;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMerchno() {
		return merchno;
	}
	public void setMerchno(String merchno) {
		this.merchno = merchno;
	}
	public String getBusinessnumber() {
		return businessnumber;
	}
	public void setBusinessnumber(String businessnumber) {
		this.businessnumber = businessnumber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(String transactionamount) {
		this.transactionamount = transactionamount;
	}
	public String getBankcardnumber() {
		return bankcardnumber;
	}
	public void setBankcardnumber(String bankcardnumber) {
		this.bankcardnumber = bankcardnumber;
	}
	public String getBankcardname() {
		return bankcardname;
	}
	public void setBankcardname(String bankcardname) {
		this.bankcardname = bankcardname;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankcardtype() {
		return bankcardtype;
	}
	public void setBankcardtype(String bankcardtype) {
		this.bankcardtype = bankcardtype;
	}
	public String getBankaccounttype() {
		return bankaccounttype;
	}
	public void setBankaccounttype(String bankaccounttype) {
		this.bankaccounttype = bankaccounttype;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBranchbankname() {
		return branchbankname;
	}
	public void setBranchbankname(String branchbankname) {
		this.branchbankname = branchbankname;
	}
	public String getBanknumber() {
		return banknumber;
	}
	public void setBanknumber(String banknumber) {
		this.banknumber = banknumber;
	}
	public String getBackurl() {
		return backurl;
	}
	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public String getBatchnum() {
		return batchnum;
	}
	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}
	public String getBatchamount() {
		return batchamount;
	}
	public void setBatchamount(String batchamount) {
		this.batchamount = batchamount;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	public String getPaydetail() {
		return paydetail;
	}
	public void setPaydetail(String paydetail) {
		this.paydetail = paydetail;
	}
	@Override
	public String toString() {
		return "ProxyDTO [merchno=" + merchno + ", businessnumber=" + businessnumber + ", subject=" + subject
				+ ", transactionamount=" + transactionamount + ", bankcardnumber=" + bankcardnumber + ", bankcardname="
				+ bankcardname + ", bankname=" + bankname + ", bankcardtype=" + bankcardtype + ", bankaccounttype="
				+ bankaccounttype + ", province=" + province + ", city=" + city + ", branchbankname=" + branchbankname
				+ ", banknumber=" + banknumber + ", backurl=" + backurl + ", terminal=" + terminal + ", sign=" + sign
				+ ", description=" + description + "]";
	}
}
