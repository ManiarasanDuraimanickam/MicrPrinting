package com.ut.print.check.print;

import java.awt.print.Book;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ut.print.app.model.PrintingContent;
import com.ut.print.app.model.PrintingObject;
import com.ut.print.check.aligment_position_serialize;

public class PrintChequeNo {
	private static final Log LOG = LogFactory.getLog(PrintChequeNo.class.getName());
	private PrintingObject printData;
	private int maxLimitCount = 0;

	public PrintChequeNo(PrintingObject printData) {
		this.printData = printData;
	}

	public void print() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.getPrintService();
		addlineSperatorForOranzarionName();
		if (this.printData.getPrinttype().equals(PrintingObject.PRINTTYPE.DIRECTPRINT)) {
			job.setPrintable(new PrintDirectCheque(this.printData.getPrintingContent()));
		} else if (this.printData.getPrinttype().equals(PrintingObject.PRINTTYPE.EXCELIMPORT_PRINT)) {
			job.setPrintable(new PrintDirectBulkCheque(this.printData.getPrintingContent()));
		} else {
			job.setPrintable(new PrintAlternate(this.printData.getPrintingContent()));
		}
		if (job.printDialog()) {
			try {
				job.print();
				JOptionPane.showMessageDialog(null, "Success");
			} catch (PrinterException ex) {
				LOG.error(ex);
			}
		}
	}

	private void addlineSperatorForOranzarionName() {
		if (this.printData.getPrintingContent() == null) {
			return;
		}
		this.maxLimitCount = Integer
				.parseInt(((aligment_position_serialize) ((PrintingContent) this.printData.getPrintingContent().get(0))
						.getAli_ser().get(0)).getOrgCharLen());
		int currentCount = 0;
		for (PrintingContent printContent : this.printData.getPrintingContent()) {
			String[] Accorg = printContent.getAccOrganisation().split(" ");
			int count = Accorg.length;
			for (int i = 0; i < count; i++) {
				currentCount += Accorg[i].length();
				if ((currentCount > this.maxLimitCount) && (i > 0)) {
					Accorg[(i - 1)] = Accorg[(i - 1)].concat(System.lineSeparator());
					this.maxLimitCount += this.maxLimitCount;
				}
			}

			printContent.setAccOrganisation(convertToString(Accorg));
		}
	}

	private String convertToString(String[] strArr) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr) {
			if (!str.contains("\n"))
				sb.append(str).append(" ");
			else
				sb.append(str);
		}
		return sb.toString();
	}
}