package com.ut.print.app.model;

import java.util.ArrayList;
import java.util.List;

public class BulkReqVO {

	private String requestBank;
	private String bankAddress;
	private long phoneNo;
	private long mobileNo;
	private long MicrNo;
	private long transactionCode;
	private String accountType;
	List<BulkReqParticulars> bulkReqParticulars;

	public String getRequestBank() {
		return requestBank;
	}

	public void setRequestBank(String requestBank) {
		this.requestBank = requestBank;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(long transactionCode) {
		this.transactionCode = transactionCode;
	}

	public long getMicrNo() {
		return MicrNo;
	}

	public void setMicrNo(long micrNo) {
		MicrNo = micrNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<BulkReqParticulars> getBulkReqParticulars() {
		if(bulkReqParticulars==null)bulkReqParticulars=new ArrayList<>();
		return bulkReqParticulars;
	}

	public void setBulkReqParticulars(List<BulkReqParticulars> bulkReqParticulars) {
		this.bulkReqParticulars = bulkReqParticulars;
	}

}
