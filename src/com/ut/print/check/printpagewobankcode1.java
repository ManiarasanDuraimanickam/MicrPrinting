package com.ut.print.check;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.net.URL;

import javax.swing.ImageIcon;

class printpagewobankcode1 implements Printable {
	String side_address1 = null;
	String side_address2 = null;
	String center_address1 = null;
	String center_address2 = null;
	String center_address3 = null;
	String center_address4 = null;
	String no_from = null;
	String num_to = null;
	String bank_code = null;
	String bank_code2 = null;
	URL urlimage1;
	URL urlimage2;
	String side_length = null;
	String side_height = null;
	String side_space = null;
	String center_length = null;
	String center_height = null;
	String center_space = null;
	String chequeNum_len = null;
	String chequeNum_heg = null;
	int[] value;
	int[] pagebreak;

	public printpagewobankcode1(String sideaddress1, String sideaddress2, String centeraddress1, String centeraddress2,
			String centeraddress3, String centeraddress4, String nofrom, String numto, String bankcode,
			String bankcode2, String sidelength, String sideheight, String sidespace, String centerlength,
			String centerheight, String centerspace, String chequeNumlen, String chequeNumheg, URL urlimage1,
			URL urlimage2) {
		this.side_address1 = sideaddress1;
		this.side_address2 = sideaddress2;
		this.center_address1 = centeraddress1;
		this.center_address2 = centeraddress2;
		this.center_address3 = centeraddress3;
		this.center_address4 = centeraddress4;
		this.no_from = nofrom;
		this.num_to = numto;
		this.bank_code = bankcode;
		this.bank_code2 = bankcode2;
		this.side_length = sidelength;
		this.side_height = sideheight;
		this.side_space = sidespace;
		this.center_length = centerlength;
		this.center_height = centerheight;
		this.center_space = centerspace;
		this.chequeNum_len = chequeNumlen;
		this.chequeNum_heg = chequeNumheg;
		this.urlimage1 = urlimage1;
		this.urlimage2 = urlimage2;
	}

	public void initprocess() {
		int from = Integer.parseInt(this.no_from);
		int to = Integer.parseInt(this.num_to);
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

	public int print(Graphics g, PageFormat pf, int pageindex) {
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
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		ImageIcon imgico = new ImageIcon(this.urlimage1);
		ImageIcon imgico1 = new ImageIcon(this.urlimage2);
		Image img = imgico.getImage();
		Image img1 = imgico1.getImage();
		int side_x = 0;
		int side_y = 0;
		int center_x = 0;
		int center_y = 0;
		int micr_x = 0;
		int micr_y = 0;
		side_x = Integer.parseInt(this.side_length);
		side_y = Integer.parseInt(this.side_height);
		int side_gap = Integer.parseInt(this.side_space);
		center_x = Integer.parseInt(this.center_length);
		center_y = Integer.parseInt(this.center_height);
		int center_gap = Integer.parseInt(this.center_space);
		micr_x = Integer.parseInt(this.chequeNum_len);
		micr_y = Integer.parseInt(this.chequeNum_heg);
		int micrstart_y = 234;
		int repeart_y = 264;
		int micrstart_imgy = 226;

		g.setFont(f1);
		g.drawString(this.side_address1, side_x, side_y);
		g.drawString(this.side_address2, side_x, side_y + side_gap);
		g.setFont(f3);
		g.drawString(this.center_address1, center_x, center_y);
		int center_y1 = center_y + center_gap;
		g.drawString(this.center_address2, center_x, center_y1);
		int center_y2 = center_y1 + center_gap;
		g.drawString(this.center_address3, center_x, center_y2);
		int center_y3 = center_y2 + center_gap;
		g.drawString(this.center_address4, center_x, center_y3);

		int micr_x4 = micr_x + 77;
		g.setFont(f2);
		g.drawString(this.bank_code, micr_x4, micrstart_y);
		int micr_x5 = micr_x4 + 85;
		g.drawImage(img1, micr_x5, micrstart_imgy, 7, 8, null);
		int micr_x6 = micr_x5 + 12;

		int micr_x7 = micr_x6 + 59;

		int micr_x8 = micr_x7 + 17;
		g.drawString(this.bank_code2, micr_x8, micrstart_y);

		g.setFont(f1);
		int side_y1 = side_y + repeart_y;
		g.drawString(this.side_address1, side_x, side_y1);
		g.drawString(this.side_address2, side_x, side_y1 + side_gap);
		g.setFont(f3);
		int center_2y = center_y + repeart_y;
		g.drawString(this.center_address1, center_x, center_2y);
		int center_2y1 = center_2y + center_gap;
		g.drawString(this.center_address2, center_x, center_2y1);
		int center_2y2 = center_2y1 + center_gap;
		g.drawString(this.center_address3, center_x, center_2y2);
		int center_2y3 = center_2y2 + center_gap;
		g.drawString(this.center_address4, center_x, center_2y3);

		g.setFont(f2);
		int micrstart_y2 = micrstart_y + repeart_y;
		int micrstart_imgy2 = micrstart_imgy + repeart_y;
		g.drawString(this.bank_code, micr_x4, micrstart_y2);
		g.drawImage(img1, micr_x5, micrstart_imgy2, 7, 8, null);

		g.drawString(this.bank_code2, micr_x8, micrstart_y2);

		int side_y2 = side_y1 + repeart_y;
		g.setFont(f1);
		g.drawString(this.side_address1, side_x, side_y2);
		g.drawString(this.side_address2, side_x, side_y2 + side_gap);
		g.setFont(f3);
		int center_3y = center_2y + repeart_y;
		g.drawString(this.center_address1, center_x, center_3y);
		int center_3y1 = center_3y + center_gap;
		g.drawString(this.center_address2, center_x, center_3y1);
		int center_3y2 = center_3y1 + center_gap;
		g.drawString(this.center_address3, center_x, center_3y2);
		int center_3y3 = center_3y2 + center_gap;
		g.drawString(this.center_address4, center_x, center_3y3);

		g.setFont(f2);
		int micrstart_y3 = micrstart_y2 + repeart_y;
		int micrstart_imgy3 = micrstart_imgy2 + repeart_y;
		g.drawString(this.bank_code, micr_x4, micrstart_y3);
		g.drawImage(img1, micr_x5, micrstart_imgy3, 7, 8, null);

		g.drawString(this.bank_code2, micr_x8, micrstart_y3);

		int y = 234;
		int imgy = 226;
		int start = pageindex == 0 ? 0 : this.pagebreak[(pageindex - 1)];
		int end = pageindex == this.pagebreak.length ? this.value.length : this.pagebreak[pageindex];
		System.out.println("Start==" + start);
		System.out.println("end==" + end);
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
