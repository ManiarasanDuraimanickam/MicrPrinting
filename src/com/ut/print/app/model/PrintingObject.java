package com.ut.print.app.model;

import java.util.ArrayList;
import java.util.List;

public class PrintingObject {
	private PRINTTYPE printtype;

	public PRINTTYPE getPrinttype() {
		return this.printtype;
	}

	public void setPrinttype(PRINTTYPE printtype) {
		this.printtype = printtype;
	}

	public static enum PRINTTYPE {
		DIRECTPRINT, ALTERNATEPRINT,EXCELIMPORT_PRINT;

		private PRINTTYPE() {
		}
	}

	private List<PrintingContent> printingContent = new ArrayList<>();

	public List<PrintingContent> getPrintingContent() {
		return this.printingContent;
	}

	public void setPrintingContent(List<PrintingContent> printingContent) {
		this.printingContent = printingContent;
	}
}