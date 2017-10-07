package com.ut.print.check;

import java.io.Serializable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class aligment_position_serialize implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _sd_Addr_leg11;

	private String _sd_Addr_heg12;

	private String _sd_Addr_spa13;

	private String _cn_Addr_leg11;

	private String _cn_Addr_heg12;

	private String _cn_Addr_spa123;

	private String _chquenum_img_leg11;

	private String _chequenum_img_heg12;

	private String _chequenum_len11;

	private String _chequenum_heg12;

	private String _chequenum_img2_len11;

	private String _chequenum_img2_heg12;

	private String _bankcode_9dig_len11;

	private String _bankcode_9dig_heg12;
	private String _bankcode_img_len11;
	private String _bankcode_img_heg12;
	private String _bankcode_6dig_len11;
	private String _bankcode_6dig_heg12;
	private String _bankcode_img2_len11;
	private String _bankcode_img2_heg12;
	private String _bankcode_2dig_len11;
	private String _bankcode_2dig_heg12;
	private String AccNo_len;
	private String AccNo_heg;
	private String AccHolderName_len;
	private String AccHolderName_heg;
	private String AccOrganisationName_len;
	private String AccOrganisationName_heg;
	private String AccountType_len;
	private String AccountType_heg;
	private String orgCharLen;

	public String getSd_Addr_leg11() {
		return this._sd_Addr_leg11;
	}

	public void setSd_Addr_leg11(String sd_Addr_leg11) {
		this._sd_Addr_leg11 = sd_Addr_leg11;
	}

	public String getSd_Addr_heg12() {
		return this._sd_Addr_heg12;
	}

	public void setSd_Addr_heg12(String sd_Addr_heg12) {
		this._sd_Addr_heg12 = sd_Addr_heg12;
	}

	public String getSd_Addr_spa13() {
		return this._sd_Addr_spa13;
	}

	public void setSd_Addr_spa13(String sd_Addr_spa13) {
		this._sd_Addr_spa13 = sd_Addr_spa13;
	}

	public String getCn_Addr_leg11() {
		return this._cn_Addr_leg11;
	}

	public void setCn_Addr_leg11(String cn_Addr_leg11) {
		this._cn_Addr_leg11 = cn_Addr_leg11;
	}

	public String getCn_Addr_heg12() {
		return this._cn_Addr_heg12;
	}

	public void setCn_Addr_heg12(String cn_Addr_heg12) {
		this._cn_Addr_heg12 = cn_Addr_heg12;
	}

	public String getCn_Addr_spa123() {
		return this._cn_Addr_spa123;
	}

	public void setCn_Addr_spa123(String cn_Addr_spa123) {
		this._cn_Addr_spa123 = cn_Addr_spa123;
	}

	public String getChquenum_img_leg11() {
		return this._chquenum_img_leg11;
	}

	public void setChquenum_img_leg11(String chquenum_img_leg11) {
		this._chquenum_img_leg11 = chquenum_img_leg11;
	}

	public String getChequenum_img_heg12() {
		return this._chequenum_img_heg12;
	}

	public void setChequenum_img_heg12(String chequenum_img_heg12) {
		this._chequenum_img_heg12 = chequenum_img_heg12;
	}

	public String getChequenum_len11() {
		return this._chequenum_len11;
	}

	public void setChequenum_len11(String chequenum_len11) {
		this._chequenum_len11 = chequenum_len11;
	}

	public String getChequenum_heg12() {
		return this._chequenum_heg12;
	}

	public void setChequenum_heg12(String chequenum_heg12) {
		this._chequenum_heg12 = chequenum_heg12;
	}

	public String getChequenum_img2_len11() {
		return this._chequenum_img2_len11;
	}

	public void setChequenum_img2_len11(String chequenum_img2_len11) {
		this._chequenum_img2_len11 = chequenum_img2_len11;
	}

	public String getChequenum_img2_heg12() {
		return this._chequenum_img2_heg12;
	}

	public void setChequenum_img2_heg12(String chequenum_img2_heg12) {
		this._chequenum_img2_heg12 = chequenum_img2_heg12;
	}

	public String getBankcode_9dig_len11() {
		return this._bankcode_9dig_len11;
	}

	public void setBankcode_9dig_len11(String bankcode_9dig_len11) {
		this._bankcode_9dig_len11 = bankcode_9dig_len11;
	}

	public String getBankcode_9dig_heg12() {
		return this._bankcode_9dig_heg12;
	}

	public void setBankcode_9dig_heg12(String bankcode_9dig_heg12) {
		this._bankcode_9dig_heg12 = bankcode_9dig_heg12;
	}

	public String getBankcode_img_len11() {
		return this._bankcode_img_len11;
	}

	public void setBankcode_img_len11(String bankcode_img_len11) {
		this._bankcode_img_len11 = bankcode_img_len11;
	}

	public String getBankcode_img_heg12() {
		return this._bankcode_img_heg12;
	}

	public void setBankcode_img_heg12(String bankcode_img_heg12) {
		this._bankcode_img_heg12 = bankcode_img_heg12;
	}

	public String getBankcode_6dig_len11() {
		return this._bankcode_6dig_len11;
	}

	public void setBankcode_6dig_len11(String bankcode_6dig_len11) {
		this._bankcode_6dig_len11 = bankcode_6dig_len11;
	}

	public String getBankcode_6dig_heg12() {
		return this._bankcode_6dig_heg12;
	}

	public void setBankcode_6dig_heg12(String bankcode_6dig_heg12) {
		this._bankcode_6dig_heg12 = bankcode_6dig_heg12;
	}

	public String getBankcode_img2_len11() {
		return this._bankcode_img2_len11;
	}

	public void setBankcode_img2_len11(String bankcode_img2_len11) {
		this._bankcode_img2_len11 = bankcode_img2_len11;
	}

	public String getBankcode_img2_heg12() {
		return this._bankcode_img2_heg12;
	}

	public void setBankcode_img2_heg12(String bankcode_img2_heg12) {
		this._bankcode_img2_heg12 = bankcode_img2_heg12;
	}

	public String getBankcode_2dig_len11() {
		return this._bankcode_2dig_len11;
	}

	public void setBankcode_2dig_len11(String bankcode_2dig_len11) {
		this._bankcode_2dig_len11 = bankcode_2dig_len11;
	}

	public String getBankcode_2dig_heg12() {
		return this._bankcode_2dig_heg12;
	}

	public void setBankcode_2dig_heg12(String bankcode_2dig_heg12) {
		this._bankcode_2dig_heg12 = bankcode_2dig_heg12;
	}

	public String getAccNo_len() {
		return this.AccNo_len;
	}

	public void setAccNo_len(String AccNo_len) {
		this.AccNo_len = AccNo_len;
	}

	public String getAccNo_heg() {
		return this.AccNo_heg;
	}

	public void setAccNo_heg(String AccNo_heg) {
		this.AccNo_heg = AccNo_heg;
	}

	public String getAccHolderName_len() {
		return this.AccHolderName_len;
	}

	public void setAccHolderName_len(String AccHolderName_len) {
		this.AccHolderName_len = AccHolderName_len;
	}

	public String getAccHolderName_heg() {
		return this.AccHolderName_heg;
	}

	public void setAccHolderName_heg(String AccHolderName_heg) {
		this.AccHolderName_heg = AccHolderName_heg;
	}

	public String getAccOrganisationName_len() {
		return this.AccOrganisationName_len;
	}

	public void setAccOrganisationName_len(String AccOrganisationName_len) {
		this.AccOrganisationName_len = AccOrganisationName_len;
	}

	public String getAccOrganisationName_heg() {
		return this.AccOrganisationName_heg;
	}

	public void setAccOrganisationName_heg(String AccOrganisationName_heg) {
		this.AccOrganisationName_heg = AccOrganisationName_heg;
	}

	public String getAccountType_len() {
		return this.AccountType_len;
	}

	public void setAccountType_len(String AccountType_len) {
		this.AccountType_len = AccountType_len;
	}

	public String getAccountType_heg() {
		return this.AccountType_heg;
	}

	public void setAccountType_heg(String AccountType_heg) {
		this.AccountType_heg = AccountType_heg;
	}

	public String getOrgCharLen() {
		return this.orgCharLen;
	}

	public void setOrgCharLen(String orgCharLen) {
		this.orgCharLen = orgCharLen;
	}
}