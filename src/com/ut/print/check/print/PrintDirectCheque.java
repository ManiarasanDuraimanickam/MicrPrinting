package com.ut.print.check.print;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ut.print.app.model.PrintingContent;
import com.ut.print.check.aligment_position_serialize;

public class PrintDirectCheque implements Printable {
	
	private static final Log LOG = LogFactory.getLog(PrintDirectCheque.class);
	private List<PrintingContent> printingContentList;
	private PrintingContent printContent;
	private int[] value;
	private int[] pagebreak;

	public PrintDirectCheque(List<PrintingContent> printingContent) {
		this.printingContentList = printingContent;
	}

	public void initprocess() {
		this.printContent = ((PrintingContent) this.printingContentList.get(0));
		int from = Integer.parseInt(this.printContent.getNofrom());
		int to = Integer.parseInt(this.printContent.getNumto());
		int value_diff = to - from;
		int loop_end = value_diff + 1;
		this.value = new int[loop_end];
		System.out.println("size:==" + this.value.length);
		System.out.println(value_diff + "  " + loop_end);
		for (int i = 0; i < loop_end; i++) {
			this.value[i] = from;

			from += 1;
		}
		System.out.println("size:==" + this.value.length);
	}

	public int print(Graphics g, PageFormat pf, int pageindex) throws PrinterException {
		LOG.info("-------print----- pageindex = "+pageindex);
		initprocess();

		int linesperpage = 3;
		int numbreakes = (this.value.length - 1) / linesperpage;
		System.out.println("num breaks" + numbreakes);
		this.pagebreak = new int[numbreakes];

		for (int j = 0; j < numbreakes; j++) {
			this.pagebreak[j] = ((j + 1) * linesperpage);
		}

		System.out.print(" length: " + this.pagebreak.length);
		if (pageindex > this.pagebreak.length) {
			return 1;
		}
		Font f1 = new Font("Arial", 0, 8);
		Font f2 = new Font("MICR", 0, 10);
		Font f3 = new Font("Arial", 1, 8);
		Font f4 = new Font("Arial", 1, 11);
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		ImageIcon imgico = new ImageIcon(this.printContent.getUrlimage1());
		ImageIcon imgico1 = new ImageIcon(this.printContent.getUrlimage2());
		Image img = imgico.getImage();
		Image img1 = imgico1.getImage();
		int side_x = 0;
		int side_y = 0;
		int center_x = 0;
		int center_y = 0;
		int micr_x = 0;
		int micr_y = 0;
		int Acc_len = 0;
		int ifsc_len=0;
		int ifsc_heg=0;
		side_x = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getSd_Addr_leg11());
		side_y = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getSd_Addr_heg12());
		int side_gap = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getSd_Addr_spa13());
		center_x = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getCn_Addr_leg11());
		center_y = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getCn_Addr_heg12());
		int center_gap = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getCn_Addr_spa123());
		micr_x = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getChequenum_len11());
		micr_y = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getChequenum_heg12());
		Acc_len = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccNo_len());
		int Acc_heg = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccNo_heg());
		int Org_len = Integer.parseInt(
				((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccOrganisationName_len());
		int Org_length = this.printContent.getAccOrganisation().length();
		Org_len = Org_len - Org_length - 1;
		int Org_heg = Integer.parseInt(
				((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccOrganisationName_heg());
		int HolderName_len = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccHolderName_len());
		int HolderName_length = this.printContent.getAccHolderName().length();
		HolderName_len = HolderName_len - HolderName_length - 1;
		int HolderName_heg = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccHolderName_heg());
		int AccType_len = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccountType_len());
		int AccType_length = this.printContent.getAccountType().length();
		AccType_len = AccType_len - AccType_length - 1;
		int AccType_heg = Integer
				.parseInt(((aligment_position_serialize) this.printContent.getAli_ser().get(0)).getAccountType_heg());
		ifsc_heg=Integer.parseInt(this.printContent.getAli_ser().get(0).getIfscCodeHeight());
		ifsc_len=Integer.parseInt(this.printContent.getAli_ser().get(0).getIfscCodeLen());
		int micrstart_y = 234;
		int repeart_y = 264;
		int micrstart_imgy = 226;

		g.setFont(f1);
		g.drawString(this.printContent.getSideaddress1(), side_x, side_y);
		g.drawString(this.printContent.getSideaddress2(), side_x, side_y + side_gap);
		g.setFont(f3);
		g.drawString(this.printContent.getCenteraddress1(), center_x, center_y);
		int center_y1 = center_y + center_gap;
		g.drawString(this.printContent.getCenteraddress2(), center_x, center_y1);
		int center_y2 = center_y1 + center_gap;
		g.drawString(this.printContent.getCenteraddress3(), center_x, center_y2);
		int center_y3 = center_y2 + center_gap;
		g.drawString(this.printContent.getCenteraddress4(), center_x, center_y3);
		g.setFont(f4);
		g.drawString(this.printContent.getAccNo(), Acc_len, Acc_heg);
		g.setFont(f3);
		g.drawString(this.printContent.getIfscCode(), ifsc_len, ifsc_heg);
		int newLineCount = Org_heg;
		for (String newLine : this.printContent.getAccOrganisation().split("\n")) {
			g.drawString(newLine, Org_len, newLineCount);
			newLineCount += 10;
		}
		g.drawString(this.printContent.getAccHolderName(), HolderName_len, HolderName_heg);
		g.setFont(f3);
		g.drawString(this.printContent.getAccountType(), AccType_len, AccType_heg);

		int micr_x4 = micr_x + 77;
		g.setFont(f2);
		int micr_x5 = micr_x4 + 85;
		if (this.printContent.getBankcode() != null) {
			g.drawString(this.printContent.getBankcode(), micr_x4, micrstart_y);
			g.drawImage(img1, micr_x5, micrstart_imgy, 7, 8, null);
		}
		int micr_x6 = micr_x5 + 12;
		int micr_x7 = micr_x6 + 59;
		if ((this.printContent.getBankcode1() != null) && (this.printContent.getBankcode1().length() > 0)) {
			g.drawString(this.printContent.getBankcode1(), micr_x6, micrstart_y);
			g.drawImage(img, micr_x7, micrstart_imgy, 7, 8, null);
		}
		int micr_x8 = micr_x7 + 17;
		g.drawString(this.printContent.getBankcode2(), micr_x8, micrstart_y);

		g.setFont(f1);
		int side_y1 = side_y + repeart_y;
		g.drawString(this.printContent.getSideaddress1(), side_x, side_y1);
		g.drawString(this.printContent.getSideaddress2(), side_x, side_y1 + side_gap);
		g.setFont(f3);
		int center_2y = center_y + repeart_y;
		g.drawString(this.printContent.getCenteraddress1(), center_x, center_2y);
		int center_2y1 = center_2y + center_gap;
		g.drawString(this.printContent.getCenteraddress2(), center_x, center_2y1);
		int center_2y2 = center_2y1 + center_gap;
		g.drawString(this.printContent.getCenteraddress3(), center_x, center_2y2);
		int center_2y3 = center_2y2 + center_gap;
		g.drawString(this.printContent.getCenteraddress4(), center_x, center_2y3);

		g.setFont(f4);

		g.drawString(this.printContent.getAccNo(), Acc_len, Acc_heg + repeart_y);
		g.setFont(f3);
		g.drawString(this.printContent.getIfscCode(), ifsc_len, ifsc_heg+ repeart_y);
		int newLineCount1 = Org_heg + repeart_y;
		for (String newLine : this.printContent.getAccOrganisation().split("\n")) {
			g.drawString(newLine, Org_len, newLineCount1);
			newLineCount1 += 10;
		}

		g.drawString(this.printContent.getAccHolderName(), HolderName_len, HolderName_heg + repeart_y);
		g.setFont(f3);
		g.drawString(this.printContent.getAccountType(), AccType_len, AccType_heg + repeart_y);

		g.setFont(f2);
		int micrstart_y2 = micrstart_y + repeart_y;
		int micrstart_imgy2 = micrstart_imgy + repeart_y;
		if (this.printContent.getBankcode() != null) {
			g.drawString(this.printContent.getBankcode(), micr_x4, micrstart_y2);
			g.drawImage(img1, micr_x5, micrstart_imgy2, 7, 8, null);
		}
		if ((this.printContent.getBankcode1() != null) && (this.printContent.getBankcode1().length() > 0)) {
			g.drawString(this.printContent.getBankcode1(), micr_x6, micrstart_y2);
			g.drawImage(img, micr_x7, micrstart_imgy2, 7, 8, null);
		}
		g.drawString(this.printContent.getBankcode2(), micr_x8, micrstart_y2);

		g.setFont(f1);
		int side_y2 = side_y1 + repeart_y;
		g.drawString(this.printContent.getSideaddress1(), side_x, side_y2);
		g.drawString(this.printContent.getSideaddress2(), side_x, side_y2 + side_gap);
		g.setFont(f3);
		int center_3y = center_2y + repeart_y;
		g.drawString(this.printContent.getCenteraddress1(), center_x, center_3y);
		int center_3y1 = center_3y + center_gap;
		g.drawString(this.printContent.getCenteraddress2(), center_x, center_3y1);
		int center_3y2 = center_3y1 + center_gap;
		g.drawString(this.printContent.getCenteraddress3(), center_x, center_3y2);
		int center_3y3 = center_3y2 + center_gap;
		g.drawString(this.printContent.getCenteraddress4(), center_x, center_3y3);

		g.setFont(f4);
		g.drawString(this.printContent.getAccNo(), Acc_len, Acc_heg + repeart_y * 2);
		g.setFont(f3);
		g.drawString(this.printContent.getIfscCode(), ifsc_len, ifsc_heg+ repeart_y*2);
		int newLineCount2 = Org_heg + repeart_y * 2;
		for (String newLine : this.printContent.getAccOrganisation().split("\n")) {
			g.drawString(newLine, Org_len, newLineCount2);
			newLineCount2 += 10;
		}
		g.drawString(this.printContent.getAccHolderName(), HolderName_len, HolderName_heg + repeart_y * 2);
		g.setFont(f3);
		g.drawString(this.printContent.getAccountType(), AccType_len, AccType_heg + repeart_y * 2);

		g.setFont(f2);
		int micrstart_y3 = micrstart_y2 + repeart_y;
		int micrstart_imgy3 = micrstart_imgy2 + repeart_y;
		if (this.printContent.getBankcode() != null) {
			g.drawString(this.printContent.getBankcode(), micr_x4, micrstart_y3);
			g.drawImage(img1, micr_x5, micrstart_imgy3, 7, 8, null);
		}
		if ((this.printContent.getBankcode1() != null) && (this.printContent.getBankcode1().length() > 0)) {
			g.drawString(this.printContent.getBankcode1(), micr_x6, micrstart_y3);
			g.drawImage(img, micr_x7, micrstart_imgy3, 7, 8, null);
		}
		g.drawString(this.printContent.getBankcode2(), micr_x8, micrstart_y3);

		int start = pageindex == 0 ? 0 : this.pagebreak[(pageindex - 1)];
		int end = pageindex == this.pagebreak.length ? this.value.length : this.pagebreak[pageindex];
		g.setFont(f2);

		for (int line = start; line < end; line++) {
			g.drawImage(img, micr_x, micrstart_imgy, 7, 8, null);
			int micr_x1 = micr_x + 6;
			g.drawString("" + String.format("%06d", new Object[] { Integer.valueOf(this.value[line]) }), micr_x1,
					micrstart_y);
			int micr_x2 = micr_x1 + 57;
			g.drawImage(img, micr_x2, micrstart_imgy, 7, 8, null);
			micrstart_imgy += 264;
			micrstart_y += 264;
		}
		return 0;
	}
}
