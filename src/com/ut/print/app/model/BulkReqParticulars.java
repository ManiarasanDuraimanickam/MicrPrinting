package com.ut.print.app.model;

import java.util.LinkedList;
import java.util.List;

public class BulkReqParticulars {

	private int chqNoFrom;
	private int chqNoTo;

	private String accountNo;
	private String MicrNo;
	private String bankCode1;
	private String transactionCode;

	private String accountType;
	private String ifscCode;
	private String nameToBePrinted;
	private String otherDetailsToBePrinted;
	private String requestBank;

	private List<String> centerAddress;
	private List<String> sideAddress;

	public String getNameToBePrinted() {
		return nameToBePrinted;
	}

	public void setNameToBePrinted(String nameToBePrinted) {
		this.nameToBePrinted = nameToBePrinted;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOtherDetailsToBePrinted() {
		return otherDetailsToBePrinted;
	}

	public void setOtherDetailsToBePrinted(String otherDetailsToBePrinted) {
		this.otherDetailsToBePrinted = otherDetailsToBePrinted;
	}

	public int getChqNoFrom() {
		return chqNoFrom;
	}

	public void setChqNoFrom(int chqNoFrom) {
		this.chqNoFrom = chqNoFrom;
	}

	public int getChqNoTo() {
		return chqNoTo;
	}

	public void setChqNoTo(int chqNoTo) {
		this.chqNoTo = chqNoTo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getRequestBank() {
		return requestBank;
	}

	public void setRequestBank(String requestBank) {
		this.requestBank = requestBank;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getMicrNo() {
		return MicrNo;
	}

	public void setMicrNo(String micrNo) {
		MicrNo = micrNo;
	}

	public String getBankCode1() {
		return bankCode1;
	}

	public void setBankCode1(String bankCode1) {
		this.bankCode1 = bankCode1;
	}

	public List<String> getSideAddress() {
		if (null == sideAddress) {
			sideAddress = new LinkedList<>();
		}
		return sideAddress;
	}

	public void setSideAddress(List<String> sideAddress) {
		this.sideAddress = sideAddress;
	}

	public List<String> getCenterAddress() {
		if (null == centerAddress) {
			centerAddress = new LinkedList<>();
		}
		return centerAddress;
	}

	public void setCenterAddress(List<String> centerAddress) {
		this.centerAddress = centerAddress;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}
