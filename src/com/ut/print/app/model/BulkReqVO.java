package com.ut.print.app.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BulkReqVO {

	private boolean updateBulkReqVO = true;
	private String requestBank;
	private List<String> sideAddress;
	private List<String> centerAddress;
	private long MicrNo;
	private long bankCode1;
	private long transactionCode;
	private String ifscCode;
	List<BulkReqParticulars> bulkReqParticulars;

	public String getRequestBank() {
		return requestBank;
	}

	public void setRequestBank(String requestBank) {
		this.requestBank = requestBank;
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

	public long getBankCode1() {
		return bankCode1;
	}

	public void setBankCode1(long bankCode1) {
		this.bankCode1 = bankCode1;
	}

	public List<BulkReqParticulars> getBulkReqParticulars() {
		if (bulkReqParticulars == null)
			bulkReqParticulars = new LinkedList<>();
		return bulkReqParticulars;
	}

	public void setBulkReqParticulars(List<BulkReqParticulars> bulkReqParticulars) {
		this.bulkReqParticulars = bulkReqParticulars;
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

	public boolean isUpdateBulkReqVO() {
		return updateBulkReqVO;
	}

	public void setUpdateBulkReqVO(boolean updateBulkReqVO) {
		this.updateBulkReqVO = updateBulkReqVO;
	}

}
