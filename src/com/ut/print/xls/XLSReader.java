package com.ut.print.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSReader {

	private static final Log LOG = LogFactory.getLog(XLSReader.class);

	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row;
	private XSSFCell cell;

	public XLSReader(File selectedFile) throws FileNotFoundException, IOException {
		workbook = new XSSFWorkbook(new FileInputStream(selectedFile));
		sheet = workbook.getSheetAt(0);
	}

	private boolean doProcess() {
		sheet.forEach(row -> {
			row.forEach(cell -> {
				// LOG.info("cell Iterator" + cell.getCellTypeEnum());
				if (cell.getCellTypeEnum() == CellType.STRING) {
					LOG.info(cell.getStringCellValue());
				}
			});
		});
		return true;
	}

	public boolean isUploaded() {
		return doProcess();
	}
}
