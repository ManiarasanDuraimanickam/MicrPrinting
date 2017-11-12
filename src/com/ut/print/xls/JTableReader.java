package com.ut.print.xls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
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
import com.ut.print.exceptions.ColumnNull;
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
						reqParticulars, count, j);
				// log.info(xlTable.getValueAt(0, j) + "=" + xlTable.getValueAt(count, j));
			}
			bulkReqVO.getBulkReqParticulars().add(reqParticulars);
		}
		doPrint(bulkReqVO);
		return false;
	}

	private void buildBulkReqMO(String header, Object colValue, BulkReqVO bulkReqVO, BulkReqParticulars reqParticulars,
			int rowNum, int columnNum) {
		if (ColumnNames.SL_NO.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.DONOT_INCLUDE.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.PHONE.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.MOBILE.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.NO_OF_BOOKS.getColValue().equalsIgnoreCase(header)
				|| ColumnNames.NO_OF_LEAVES.getColValue().equalsIgnoreCase(header)) {
			return;

		} else if (ColumnNames.ACCOUNT_NO.getColValue().equalsIgnoreCase(header)) {
			// if (colValue == null)throwNullExceptions("Account no found as null, verify
			// Row-{0} and column -{1}", rowNum, columnNum);
			reqParticulars.setAccountNo(colValue != null ? "" + colValue : "");

		} else if (ColumnNames.BANK.getColValue().equalsIgnoreCase(header)) {
			if (colValue == null)
				throwNullExceptions("Bank name found as null, verify the Row-{0} and column -{1}", rowNum, columnNum);
			reqParticulars.setRequestBank(((String) colValue).trim());
			setBankaddressDetails(bulkReqVO, reqParticulars);

		} else if (ColumnNames.ACCOUNT_TYPE.getColValue().equalsIgnoreCase(header)) {
			// if (colValue == null)throwNullExceptions("Account Type found as null, verify
			// the Row-{0} and column -{1}", rowNum,columnNum);
			reqParticulars.setAccountType(colValue != null ? (String) colValue : "");

		} else if (ColumnNames.CHQ_NO_FROM.getColValue().equalsIgnoreCase(header)) {
			if (colValue == null)
				throwNullExceptions("Cheque From found as null, verify the Row-{0} and column -{1}", rowNum, columnNum);
			reqParticulars.setChqNoFrom((int) colValue);

		} else if (ColumnNames.CHQ_NO_TO.getColValue().equalsIgnoreCase(header)) {
			if (colValue == null)
				throwNullExceptions("Cheque To found as null, verify the Row-{0} and column -{1}", rowNum, columnNum);
			reqParticulars.setChqNoTo((int) colValue);

		} else if (ColumnNames.IFSC_CODE.getColValue().equalsIgnoreCase(header)) {
			// if (colValue == null)throwNullExceptions("IFS code found as null, verify the
			// Row-{0} and column -{1}", rowNum, columnNum);
			reqParticulars.setIfscCode(colValue != null ? "" + colValue : "");

		} else if (ColumnNames.MICR.getColValue().equalsIgnoreCase(header)) {
			// if (colValue == null)throwNullExceptions("MICR found as null, verify the
			// Row-{0} and column -{1}", rowNum, columnNum);
			reqParticulars.setMicrNo(colValue != null ? "" + colValue : "");

		} else if (ColumnNames.NAME.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setNameToBePrinted(colValue != null ? (String) colValue : "");

		} else if (ColumnNames.OTHER_DETAILS.getColValue().equalsIgnoreCase(header)) {
			reqParticulars.setOtherDetailsToBePrinted(colValue != null ? (String) colValue : "");

		} else if (ColumnNames.TRANSACTION_CODE.getColValue().equalsIgnoreCase(header)) {
			// if (colValue == null)throwNullExceptions("Transaction code found as null,
			// verify the Row-{0} and column -{1}", rowNum,columnNum);
			reqParticulars.setTransactionCode(colValue != null ? "" + colValue : "");
		}
	}

	private void setBankaddressDetails(BulkReqVO bulkReqVO, BulkReqParticulars reqParticulars) {
		if (!bulkReqVO.getBulkReqParticulars().isEmpty()) {
			String lastBankname = bulkReqVO.getBulkReqParticulars().get(bulkReqVO.getBulkReqParticulars().size() - 1)
					.getRequestBank();
			if (lastBankname.equalsIgnoreCase(reqParticulars.getRequestBank())) {
				reqParticulars.setSideAddress(bulkReqVO.getBulkReqParticulars()
						.get(bulkReqVO.getBulkReqParticulars().size() - 1).getSideAddress());
				reqParticulars.setCenterAddress(bulkReqVO.getBulkReqParticulars()
						.get(bulkReqVO.getBulkReqParticulars().size() - 1).getCenterAddress());
				return;
			}
		}
		Map<String, Object> bankDetails = this.commonJDBCRepo.getBank(reqParticulars.getRequestBank());
		buildBankAddressInfo(bankDetails, bulkReqVO, reqParticulars);

	}

	private ColumnNull throwNullExceptions(String msg, int row, int col) {
		String formatedMsg = MessageFormat.format(msg, row, col);
		throw new ColumnNull(formatedMsg);
	}

	private void buildBankAddressInfo(Map<String, Object> bankDetails, BulkReqVO bulkReqVO,
			BulkReqParticulars reqParticulars) {
		if (null == bankDetails || bankDetails.isEmpty())
			throw new BankNotFoundException("Incorrect Bank Name, Please verify that");
		reqParticulars.getSideAddress().add((String) bankDetails.get("side1"));
		reqParticulars.getSideAddress().add((String) bankDetails.get("side2"));
		reqParticulars.getCenterAddress().add((String) bankDetails.get("center1"));
		reqParticulars.getCenterAddress().add((String) bankDetails.get("center2"));
		reqParticulars.getCenterAddress().add((String) bankDetails.get("center3"));
		reqParticulars.getCenterAddress().add((String) bankDetails.get("center4"));
	}

	public String getErrorMsg() {
		// TODO Auto-generated method stub
		return errorMsg;
	}

}
