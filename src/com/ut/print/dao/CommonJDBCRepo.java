package com.ut.print.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommonJDBCRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean validateCredential(String user, String pass) {

		String query = "select * from credentials where UserId=? and Password=?";

		Map<String, Object> userCredentials = (Map<String, Object>) this.jdbcTemplate.queryForMap(query,
				new Object[] { user, pass });

		if (userCredentials != null && userCredentials.get("UserId") != null)
			return true;
		else
			return false;
	}

	public List<String> getBankList() {
		String query = "select bankname from bankaddress where status=1 order by bankname";
		List<String> bankList = (List<String>) this.jdbcTemplate.query(query, (ResultSet rs, int row) -> {
			return rs.getString("bankname");
		});
		return bankList;
	}

	public Map<String, Object> getBank(String bankName) {
		String query = "select * from bankaddress where bankname=? and status=1";
		Map<String, Object> bankDetails = (Map<String, Object>) this.jdbcTemplate.queryForMap(query,
				new Object[] { bankName });
		return bankDetails;
	}

	public boolean insertBankName(String bank, String side, String nextside, String center_first, String center_second,
			String center_third, String bank_9digits, String bank_6digits, String center_four, String accno,
			String holdername, String orgname) {
		String sql = "insert into bankaddress(bankname,side1,side2,center1,center2,center3,bankcode9digits,bankcode6digits,center4,AccNo,AccHolderName,AccHolderOrg) values (?, ? , ?,?,?,?,?,?,?,?,?,?)";
		int insertStatus = this.jdbcTemplate.update(sql, new Object[] { bank, side, nextside, center_first,
				center_second, center_third, bank_9digits, bank_6digits, center_four, accno, holdername, orgname });
		return insertStatus > 0 ? true : false;
	}

	public boolean updateBankdetailsByBankName(String side, String nextside, String center_first, String center_second,
			String center_third, String bank_9digits, String bank_6digits, String center_four, String Accno,
			String HolderName, String OrganisationName, String bank) {
		String sql = "update bankaddress set side1= ? ,side2=?,center1=? ,center2=? ,center3= ?,bankcode9digits= ?,bankcode6digits=? ,center4= ?,AccNo=? ,AccHolderName= ? ,AccHolderOrg=? where  bankname= ?";
		int updateSttaus = this.jdbcTemplate.update(sql, new Object[] { side, nextside, center_first, center_second,
				center_third, bank_9digits, bank_6digits, center_four, Accno, HolderName, OrganisationName, bank });
		return updateSttaus > 0 ? true : false;
	}

	public boolean updateBankAlldetailsByOldBankName(String bank, String side, String nextside, String center_first,
			String center_second, String center_third, String bank_9digits, String bank_6digits, String center_four,
			String Accno, String HolderName, String OrganisationName, String bank_name) {
		String sql = "update bankaddress set bankname=?,side1=?,side2=?,center1=?,center2=?,center3=?,bankcode9digits=?,bankcode6digits=?,center4=?,AccNo=?,AccHolderName=?,AccHolderOrg=? where  bankname=?";
		int updateSttaus = this.jdbcTemplate.update(sql,
				new Object[] { bank, side, nextside, center_first, center_second, center_third, bank_9digits,
						bank_6digits, center_four, Accno, HolderName, OrganisationName, bank_name });
		return updateSttaus > 0 ? true : false;
	}

	public boolean deleteBankDetails(String bank) {
		String sql = "update bankaddress set status=0 where bankname=?";
		int updateSttaus = this.jdbcTemplate.update(sql, new Object[] { bank });
		return updateSttaus > 0 ? true : false;
	}
}
