package com.ut.print.app.model;

public class BulkReqParticulars {
	private String nameToBePrinted;
	private long accountNo;
	private String otherDetailsToBePrinted;
	private int chqNoFrom;
	private int chqNoTo;
	private String accountType;

	public String getNameToBePrinted() {
		return nameToBePrinted;
	}

	public void setNameToBePrinted(String nameToBePrinted) {
		this.nameToBePrinted = nameToBePrinted;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
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
}
