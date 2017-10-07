package com.ut.print.app.model;

public class BulkReqVO {
	private int slNo;
	private String nameToBePrinted;
	private long accountNo;
	private String otherDetailsToBePrinted;
	private int noOfBooks;
	private int noOfLeaves;
	private int chqNoFrom;
	private int chqNoTo;
	private int MicrNo;
	private String accountType;

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

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

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public int getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
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

	public int getMicrNo() {
		return MicrNo;
	}

	public void setMicrNo(int micrNo) {
		MicrNo = micrNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
