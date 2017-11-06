package com.ut.print.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ut.print.app.model.BulkReqParticulars;
import com.ut.print.app.model.BulkReqVO;
import com.ut.print.app.model.PrintingContent;
import com.ut.print.app.model.PrintingObject;
import com.ut.print.check.aligment_position_serialize;
import com.ut.print.check.print.PrintChequeNo;
import com.ut.print.common.Utils;

public class XLSReader {

	public static enum ColumnNames {
		PHONE("PHONE NO. :"), MOBILE("MOBILE NO. :"), ACCOUNT_TYPE("TYPE OF ACCOUNT :"),
		MICR("MICR CODE :"), TRANSACTION_CODE("TRANSACTION CODE :"), SL_NO("SL. NO."), 
		NAME("NAME TO BE PRINTED"), ACCOUNT_NO("ACCOUNT NO."), OTHER_DETAILS("OTHER DETAILS TO BE PRINTED"),
		NO_OF_BOOKS("NO. OF BOOKS"), NO_OF_LEAVES("NO. OF LEAVES"), CHQ_NO_FROM("CHQ NO. FROM"), CHQ_NO_TO("CHQ NO. TO"),
		DONOT_INCLUDE("DONOT_INCLUDE"), BANK("BANK"),IFSC_CODE("IFSC_CODE");
		private final String colValue;

		ColumnNames(String val) {
			this.colValue = val;
		}

		public String getColValue() {
			return colValue;
		}
	}

	private static final Log LOG = LogFactory.getLog(XLSReader.class);

	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	public XLSReader(File selectedFile) throws FileNotFoundException, IOException {
		if(null!=selectedFile) {
		workbook = new XSSFWorkbook(new FileInputStream(selectedFile));
		sheet = workbook.getSheetAt(0);
		}  
	}

	protected boolean doProcess() {
		Iterator<Row> iterator = sheet.iterator();
		BulkReqVO bulkReqVO = new BulkReqVO();
		boolean bulkParticulars = false;
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			BulkReqParticulars reqParticulars = null;
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellTypeEnum()) {
				case STRING: {
					if (!bulkParticulars) {
						buildBulkReqMO(currentRow, cell, bulkReqVO);
						if (cell.getStringCellValue().trim().equalsIgnoreCase(ColumnNames.CHQ_NO_TO.getColValue())) {
							bulkParticulars = true;
						}
						break;
					} else {
						switch (cell.getColumnIndex()) {
						case 1:
							reqParticulars.setNameToBePrinted(cell.getStringCellValue().trim());
							break;
						case 3:
							reqParticulars.setOtherDetailsToBePrinted(cell.getStringCellValue().trim());
							break;
						default:
							break;
						}
					}
					break;
				}
				case NUMERIC: {
					if (!bulkParticulars) {
						break;
					}
					switch (cell.getColumnIndex()) {
					case 0:
						reqParticulars = new BulkReqParticulars();
						//reqParticulars.setSlNo(((Double) cell.getNumericCellValue()).intValue());
						break;
					case 2:
						reqParticulars.setAccountNo(((Double) cell.getNumericCellValue()).longValue());
						break;

					case 4:
					//	reqParticulars.setNoOfBooks(((Double) cell.getNumericCellValue()).intValue());
						break;
					case 5:
						//reqParticulars.setNoOfLeaves(((Double) cell.getNumericCellValue()).intValue());
						break;
					case 6:
						reqParticulars.setChqNoFrom(((Double) cell.getNumericCellValue()).intValue());
						break;
					case 7:
						reqParticulars.setChqNoTo(((Double) cell.getNumericCellValue()).intValue());
						bulkReqVO.getBulkReqParticulars().add(reqParticulars);
						break;
					default:
						break;
					}
					break;
				}

				default:
					break;
				}
			}
		}

		doPrint(bulkReqVO);
		return true;
	}

	protected void doPrint(BulkReqVO bulkReqVO) {
		aligment_position_serialize alig = Utils.getAligment_Position_Serialize();
		PrintingObject printData = new PrintingObject();

		for (int index = 0; index < bulkReqVO.getBulkReqParticulars().size(); index++) {
			PrintingContent printContent = gePrintingData(bulkReqVO, index);
			printContent.getAli_ser().add(alig);
			printData.getPrintingContent().add(printContent);
		}
		printData.setPrinttype(PrintingObject.PRINTTYPE.EXCELIMPORT_PRINT);
		new PrintChequeNo(printData).print();
		// SetPrintingData(printContent);
	}

	protected PrintingContent gePrintingData(BulkReqVO bulkReqVO, int index) {
		PrintingContent printContent = new PrintingContent();
		// printContent.getAli_ser().clear();
		// printContent.getAli_ser().add(this.ali_ser);

		java.net.URL urlimage1 = Utils.getImageURLFromDefaultLocation("MICR121.gif");
		java.net.URL urlimage2 = Utils.getImageURLFromDefaultLocation("MICR122.gif");
		printContent.setUrlimage1(urlimage1);
		printContent.setUrlimage2(urlimage2);
		printContent.setSideaddress1(bulkReqVO.getSideAddress()!=null && bulkReqVO.getSideAddress().size()>0 ? bulkReqVO.getSideAddress().get(0):"");
		printContent.setSideaddress2(bulkReqVO.getSideAddress()!=null && bulkReqVO.getSideAddress().size()>1 ? bulkReqVO.getSideAddress().get(1):"");
		printContent.setCenteraddress1(bulkReqVO.getCenterAddress()!=null && bulkReqVO.getCenterAddress().size()>0?bulkReqVO.getCenterAddress().get(0):"");
		printContent.setCenteraddress2(bulkReqVO.getCenterAddress()!=null && bulkReqVO.getCenterAddress().size()>1?bulkReqVO.getCenterAddress().get(1):"");
		printContent.setCenteraddress3(bulkReqVO.getCenterAddress()!=null && bulkReqVO.getCenterAddress().size()>2?bulkReqVO.getCenterAddress().get(2):"");
		printContent.setCenteraddress4(bulkReqVO.getCenterAddress()!=null && bulkReqVO.getCenterAddress().size()>3?bulkReqVO.getCenterAddress().get(3):"");
		printContent.setNofrom("" + bulkReqVO.getBulkReqParticulars().get(index).getChqNoFrom());
		printContent.setNumto("" + bulkReqVO.getBulkReqParticulars().get(index).getChqNoTo());
		printContent.setBankcode("" + bulkReqVO.getMicrNo());
		// printContent.setBankcode1(this.txtbankcode1.getText().trim());
		printContent.setBankcode2("" + bulkReqVO.getTransactionCode());
		printContent.setAccNo(bulkReqVO.getBulkReqParticulars().get(index).getAccountNo()>0 ?""+bulkReqVO.getBulkReqParticulars().get(index).getAccountNo():"");
		printContent.setIfscCode(bulkReqVO.getIfscCode()!=null ? bulkReqVO.getIfscCode():"");
		if (bulkReqVO.getBulkReqParticulars().get(index).getOtherDetailsToBePrinted() == null
				|| bulkReqVO.getBulkReqParticulars().get(index).getOtherDetailsToBePrinted().isEmpty()) {
			printContent.setAccHolderName(bulkReqVO.getBulkReqParticulars().get(index).getNameToBePrinted());
			printContent.setAccOrganisation("");
		} else {
			printContent.setAccHolderName(bulkReqVO.getBulkReqParticulars().get(index).getOtherDetailsToBePrinted());
			printContent.setAccOrganisation(bulkReqVO.getBulkReqParticulars().get(index).getNameToBePrinted());
		}
		printContent.setAccountType(bulkReqVO.getBulkReqParticulars().get(index).getAccountType()!=null?bulkReqVO.getBulkReqParticulars().get(index).getAccountType():"");
		return printContent;
	}

	private void buildBulkReqMO(Row currentRow, Cell cell, BulkReqVO bulkReqVO) {
		if (cell.getStringCellValue().isEmpty() && cell.getStringCellValue().length() <= 0) {
			return;
		} else if (cell.getStringCellValue().trim().toUpperCase().endsWith("BANK")) {
			bulkReqVO.setRequestBank(cell.getStringCellValue().trim());
			return;
		} /*else if (bulkReqVO.getRequestBank() != null && bulkReqVO.getBankAddress() == null) {
			bulkReqVO.setBankAddress(cell.getStringCellValue().trim());
			return;
		} else if (cell.getStringCellValue().trim().equalsIgnoreCase(ColumnNames.PHONE.getColValue())) {
			bulkReqVO.setPhoneNo(
					((Double) currentRow.getCell(cell.getColumnIndex() + 1).getNumericCellValue()).longValue());
			return;
		} else if (cell.getStringCellValue().trim().equalsIgnoreCase(ColumnNames.MOBILE.getColValue())) {
			bulkReqVO.setMobileNo(
					((Double) currentRow.getCell(cell.getColumnIndex() + 1).getNumericCellValue()).longValue());
			return;
		} else if (cell.getStringCellValue().trim().equalsIgnoreCase(ColumnNames.ACCOUNT_TYPE.getColValue())) {
			bulkReqVO.setAccountType(currentRow.getCell(cell.getColumnIndex() + 1).getStringCellValue());
			return;
		}*/ else if (cell.getStringCellValue().trim().equalsIgnoreCase(ColumnNames.MICR.getColValue())) {
			bulkReqVO.setMicrNo(
					((Double) currentRow.getCell(cell.getColumnIndex() + 1).getNumericCellValue()).longValue());
			return;
		} else if (cell.getStringCellValue().trim().equalsIgnoreCase(ColumnNames.TRANSACTION_CODE.getColValue())) {
			bulkReqVO.setTransactionCode(
					((Double) currentRow.getCell(cell.getColumnIndex() + 1).getNumericCellValue()).longValue());
			return;
		}
	}

	public boolean isUploaded() {
		return doProcess();
	}
}
