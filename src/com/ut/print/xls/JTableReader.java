package com.ut.print.xls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ut.print.ComponentFactory;
import com.ut.print.app.model.BulkReqParticulars;
import com.ut.print.app.model.BulkReqVO;
import com.ut.print.dao.CommonJDBCRepo;
import com.ut.print.exceptions.BankNotFoundException;
import com.ut.print.xls.XLSReader.ColumnNames;

public class JTableReader extends XLSReader {
	private static final Log log = LogFactory.getLog("JTableReader");
	private CommonJDBCRepo commonJDBCRepo = ComponentFactory.getBeanByType(CommonJDBCRepo.class);
	private JTable xlTable;
	private String errorMsg;

	@Deprecated
	public JTableReader(File selectedFile) throws FileNotFoundException, IOException {
		super(selectedFile);
		// TODO Auto-generated constructor stub
	}

	public JTableReader(JTable jTable) throws FileNotFoundException, IOException {
		super(null);
		this.xlTable = jTable;
	}

	public boolean isUploaded() {
		if (validateTableData())
			return doProcess(xlTable);
		else
			return false;
	}

	private boolean validateTableData() {
		List<String> tableSelectedHeaders = new ArrayList<>();
		errorMsg = "";
		boolean headerSelected = false;
		String colVal = null;
		if (xlTable.getColumnModel().getColumnCount() == 0) {
			errorMsg = "Table is empyt so please selecte a file. " + colVal;
			return false;
		}
		for (int count = 0; count < 1; count++) {
			for (int j = 0; j < xlTable.getColumnModel().getColumnCount(); j++) {
				colVal = (String) xlTable.getValueAt(count, j);
				if (colVal.equalsIgnoreCase(XLSFileProcessor.DO_SELECT)
						|| colVal.equalsIgnoreCase(ColumnNames.DONOT_INCLUDE.getColValue())) {
					continue;
				} else if (!tableSelectedHeaders.contains(colVal)) {
					headerSelected = true;
					tableSelectedHeaders.add(colVal);
				} else if (tableSelectedHeaders.contains(colVal)) {
					errorMsg = "Dublicate header found " + colVal;
					return false;
				}

			}

		}
		if (!headerSelected) {
			errorMsg = "Please select the Headers.";
			return false;
		}
		return headerSelected;
	}

	protected boolean doProcess(JTable xlTable) {
		BulkReqVO bulkReqVO = new BulkReqVO();
		BulkReqParticulars reqParticulars = null;
		for (int count = 0; count < xlTable.getModel().getRowCount(); count++) {
			if (count == 0)
				continue;
			reqParticulars = new BulkReqParticulars();
			for (int j = 0; j < xlTable.getColumnModel().getColumnCount(); j++) {
				buildBulkReqMO((String) xlTable.getValueAt(0, j), xlTable.getValueAt(count, j), bulkReqVO,
						reqParticulars);
				log.info(xlTable.getValueAt(0, j) + "=" + xlTable.getValueAt(count, j));
			}
			bulkReqVO.setUpdateBulkReqVO(false);
			bulkReqVO.getBulkReqParticulars().add(reqParticulars);
		}
		doPrint(bulkReqVO);
		return false;
	}

	private void buildBulkReqMO(String header, Object colValue, BulkReqVO bulkReqVO,
			BulkReqParticulars reqParticulars) {
		if (ColumnNames.SL_NO.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.DONOT_INCLUDE.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.PHONE.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.MOBILE.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.NO_OF_BOOKS.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.NO_OF_LEAVES.getColValue().equalsIgnoreCase(header)) {
			return;
		} else if (ColumnNames.ACCOUNT_NO.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setAccountNo(Long.parseLong("" + colValue));
		} else if (ColumnNames.BANK.getColValue().equalsIgnoreCase(header)) {
			if (!bulkReqVO.isUpdateBulkReqVO())
				return;
			Map<String, Object> bankDetails = this.commonJDBCRepo.getBank(((String) colValue).trim());
			buildBankAddressInfo(bankDetails, bulkReqVO);
		} else if (ColumnNames.ACCOUNT_TYPE.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setAccountType(getAccountType(bulkReqVO, colValue));
		} else if (ColumnNames.CHQ_NO_FROM.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setChqNoFrom((int) colValue);
		} else if (ColumnNames.CHQ_NO_TO.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setChqNoTo((int) colValue);
		} else if (ColumnNames.IFSC_CODE.getColValue().equalsIgnoreCase(header)) {
			if (!bulkReqVO.isUpdateBulkReqVO())
				return;
			bulkReqVO.setIfscCode((String) colValue);
		} else if (ColumnNames.MICR.getColValue().equalsIgnoreCase(header)) {
			if (!bulkReqVO.isUpdateBulkReqVO())
				return;
			bulkReqVO.setMicrNo(Long.parseLong("" + colValue));
		} else if (ColumnNames.NAME.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setNameToBePrinted((String) colValue);
		} else if (ColumnNames.OTHER_DETAILS.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setOtherDetailsToBePrinted((String) colValue);
		} else if (ColumnNames.TRANSACTION_CODE.getColValue().equalsIgnoreCase(header)) {
			if (!bulkReqVO.isUpdateBulkReqVO())
				return;
			bulkReqVO.setTransactionCode(Long.parseLong("" + colValue));
		}
	}

	private String getAccountType(BulkReqVO bulkReqVO, Object colValue) {
		if (null == colValue) {
			return "";
		} else {
			String accType = (String) colValue;
			if (!accType.isEmpty()) {
				return accType;
			} else {
				if (bulkReqVO.getBulkReqParticulars().size() > 0) {
					return bulkReqVO.getBulkReqParticulars().get(0).getAccountType();
				} else {
					return "";
				}
			}
		}
	}

	private void buildBankAddressInfo(Map<String, Object> bankDetails, BulkReqVO bulkReqVO) {
		if (null == bankDetails || bankDetails.isEmpty())
			throw new BankNotFoundException("Incorrect Bank Name, Please verify that");
		bulkReqVO.getSideAddress().add((String) bankDetails.get("side1"));
		bulkReqVO.getSideAddress().add((String) bankDetails.get("side2"));
		bulkReqVO.getCenterAddress().add((String) bankDetails.get("center1"));
		bulkReqVO.getCenterAddress().add((String) bankDetails.get("center2"));
		bulkReqVO.getCenterAddress().add((String) bankDetails.get("center3"));
		bulkReqVO.getCenterAddress().add((String) bankDetails.get("center4"));

	}

	public String getErrorMsg() {
		// TODO Auto-generated method stub
		return errorMsg;
	}

}
