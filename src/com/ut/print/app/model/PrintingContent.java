package com.ut.print.app.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.ut.print.check.aligment_position_serialize;

public class PrintingContent {
	public String getFirstMicr() {
		return this.FirstMicr;
	}

	public void setFirstMicr(String FirstMicr) {
		this.FirstMicr = FirstMicr;
	}

	private List<aligment_position_serialize> ali_ser = new ArrayList<>();
	private URL urlimage1 = null;
	private URL urlimage2 = null;

	private String sideaddress1 = null;
	private String sideaddress2 = null;
	private String centeraddress1 = null;
	private String centeraddress2 = null;
	private String centeraddress3 = null;
	private String centeraddress4 = null;
	private String nofrom = null;
	private String numto = null;
	private String bankcode = null;
	private String bankcode1 = null;
	private String bankcode2 = null;
	private String accNo = null;
	private String accHolderName = null;
	private String accOrganisation = null;
	private String AccountType = null;
	private String FirstMicr = null;
	private String ifscCode;

	public String getSideaddress1() {
		return this.sideaddress1;
	}

	public void setSideaddress1(String sideaddress1) {
		this.sideaddress1 = sideaddress1;
	}

	public String getSideaddress2() {
		return this.sideaddress2;
	}

	public void setSideaddress2(String sideaddress2) {
		this.sideaddress2 = sideaddress2;
	}

	public String getCenteraddress1() {
		return this.centeraddress1;
	}

	public void setCenteraddress1(String centeraddress1) {
		this.centeraddress1 = centeraddress1;
	}

	public String getCenteraddress2() {
		return this.centeraddress2;
	}

	public void setCenteraddress2(String centeraddress2) {
		this.centeraddress2 = centeraddress2;
	}

	public String getCenteraddress3() {
		return this.centeraddress3;
	}

	public void setCenteraddress3(String centeraddress3) {
		this.centeraddress3 = centeraddress3;
	}

	public String getCenteraddress4() {
		return this.centeraddress4;
	}

	public void setCenteraddress4(String centeraddress4) {
		this.centeraddress4 = centeraddress4;
	}

	public String getNofrom() {
		return this.nofrom;
	}

	public void setNofrom(String nofrom) {
		this.nofrom = nofrom;
	}

	public String getNumto() {
		return this.numto;
	}

	public void setNumto(String numto) {
		this.numto = numto;
	}

	public String getBankcode() {
		return this.bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBankcode1() {
		return this.bankcode1;
	}

	public void setBankcode1(String bankcode1) {
		this.bankcode1 = bankcode1;
	}

	public String getBankcode2() {
		return this.bankcode2;
	}

	public void setBankcode2(String bankcode2) {
		this.bankcode2 = bankcode2;
	}

	public String getAccNo() {
		return this.accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return this.accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccOrganisation() {
		return this.accOrganisation;
	}

	public void setAccOrganisation(String accOrganisation) {
		this.accOrganisation = accOrganisation;
	}

	public String getAccountType() {
		return this.AccountType;
	}

	public void setAccountType(String AccountType) {
		this.AccountType = AccountType;
	}

	public URL getUrlimage1() {
		return this.urlimage1;
	}

	public void setUrlimage1(URL urlimage1) {
		this.urlimage1 = urlimage1;
	}

	public URL getUrlimage2() {
		return this.urlimage2;
	}

	public void setUrlimage2(URL urlimage2) {
		this.urlimage2 = urlimage2;
	}

	public List<aligment_position_serialize> getAli_ser() {
		return this.ali_ser;
	}

	public void setAli_ser(List<aligment_position_serialize> ali_ser) {
		this.ali_ser = ali_ser;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}