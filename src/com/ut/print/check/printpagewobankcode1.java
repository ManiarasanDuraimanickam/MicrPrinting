/*     */ package com.ut.print.check;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Printable;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class printpagewobankcode1
/*     */   implements Printable
/*     */ {
/*  25 */   String side_address1 = null;
/*  26 */   String side_address2 = null;
/*  27 */   String center_address1 = null;
/*  28 */   String center_address2 = null;
/*  29 */   String center_address3 = null;
/*  30 */   String center_address4 = null;
/*  31 */   String no_from = null;
/*  32 */   String num_to = null;
/*  33 */   String bank_code = null;
/*  34 */   String bank_code2 = null;
/*     */   URL urlimage1;
/*  36 */   URL urlimage2; String side_length = null; String side_height = null; String side_space = null; String center_length = null; String center_height = null; String center_space = null; String chequeNum_len = null; String chequeNum_heg = null;
/*     */   int[] value;
/*     */   int[] pagebreak;
/*     */   
/*     */   public printpagewobankcode1(String sideaddress1, String sideaddress2, String centeraddress1, String centeraddress2, String centeraddress3, String centeraddress4, String nofrom, String numto, String bankcode, String bankcode2, String sidelength, String sideheight, String sidespace, String centerlength, String centerheight, String centerspace, String chequeNumlen, String chequeNumheg, URL urlimage1, URL urlimage2) {
/*  41 */     this.side_address1 = sideaddress1;
/*  42 */     this.side_address2 = sideaddress2;
/*  43 */     this.center_address1 = centeraddress1;
/*  44 */     this.center_address2 = centeraddress2;
/*  45 */     this.center_address3 = centeraddress3;
/*  46 */     this.center_address4 = centeraddress4;
/*  47 */     this.no_from = nofrom;
/*  48 */     this.num_to = numto;
/*  49 */     this.bank_code = bankcode;
/*  50 */     this.bank_code2 = bankcode2;
/*  51 */     this.side_length = sidelength;
/*  52 */     this.side_height = sideheight;
/*  53 */     this.side_space = sidespace;
/*  54 */     this.center_length = centerlength;
/*  55 */     this.center_height = centerheight;
/*  56 */     this.center_space = centerspace;
/*  57 */     this.chequeNum_len = chequeNumlen;
/*  58 */     this.chequeNum_heg = chequeNumheg;
/*  59 */     this.urlimage1 = urlimage1;
/*  60 */     this.urlimage2 = urlimage2;
/*     */   }
/*     */   
/*     */   public void initprocess() {
/*  64 */     int from = Integer.parseInt(this.no_from);
/*  65 */     int to = Integer.parseInt(this.num_to);
/*  66 */     int value_diff = to - from;
/*  67 */     int loop_end = value_diff + 1;
/*  68 */     this.value = new int[loop_end];
/*  69 */     System.out.println("size:==" + this.value.length);
/*  70 */     System.out.println(value_diff + "  " + loop_end);
/*  71 */     for (int i = 0; i < loop_end; i++)
/*     */     {
/*  73 */       this.value[i] = from;
/*     */       
/*  75 */       from += 1;
/*     */     }
/*  77 */     System.out.println("size:==" + this.value.length);
/*     */   }
/*     */   
/*     */   public int print(Graphics g, PageFormat pf, int pageindex)
/*     */   {
/*  82 */     initprocess();
/*     */     
/*  84 */     int linesperpage = 3;
/*  85 */     int numbreakes = (this.value.length - 1) / linesperpage;
/*  86 */     System.out.println("num breaks" + numbreakes);
/*  87 */     this.pagebreak = new int[numbreakes];
/*     */     
/*  89 */     for (int j = 0; j < numbreakes; j++) {
/*  90 */       this.pagebreak[j] = ((j + 1) * linesperpage);
/*     */     }
/*     */     
/*  93 */     System.out.print(" length: " + this.pagebreak.length);
/*  94 */     if (pageindex > this.pagebreak.length) {
/*  95 */       return 1;
/*     */     }
/*  97 */     Font f1 = new Font("Arial", 0, 8);
/*  98 */     Font f2 = new Font("MICR", 0, 10);
/*  99 */     Font f3 = new Font("Arial", 1, 8);
/* 100 */     Graphics2D g2d = (Graphics2D)g;
/* 101 */     g2d.translate(pf.getImageableX(), pf.getImageableY());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 106 */     ImageIcon imgico = new ImageIcon(this.urlimage1);
/* 107 */     ImageIcon imgico1 = new ImageIcon(this.urlimage2);
/* 108 */     Image img = imgico.getImage();
/* 109 */     Image img1 = imgico1.getImage();
/* 110 */     int side_x = 0;int side_y = 0;int center_x = 0;int center_y = 0;int micr_x = 0;int micr_y = 0;
/* 111 */     side_x = Integer.parseInt(this.side_length);
/* 112 */     side_y = Integer.parseInt(this.side_height);
/* 113 */     int side_gap = Integer.parseInt(this.side_space);
/* 114 */     center_x = Integer.parseInt(this.center_length);
/* 115 */     center_y = Integer.parseInt(this.center_height);
/* 116 */     int center_gap = Integer.parseInt(this.center_space);
/* 117 */     micr_x = Integer.parseInt(this.chequeNum_len);
/* 118 */     micr_y = Integer.parseInt(this.chequeNum_heg);
/* 119 */     int micrstart_y = 234;
/* 120 */     int repeart_y = 264;
/* 121 */     int micrstart_imgy = 226;
/*     */     
/* 123 */     g.setFont(f1);
/* 124 */     g.drawString(this.side_address1, side_x, side_y);
/* 125 */     g.drawString(this.side_address2, side_x, side_y + side_gap);
/* 126 */     g.setFont(f3);
/* 127 */     g.drawString(this.center_address1, center_x, center_y);
/* 128 */     int center_y1 = center_y + center_gap;
/* 129 */     g.drawString(this.center_address2, center_x, center_y1);
/* 130 */     int center_y2 = center_y1 + center_gap;
/* 131 */     g.drawString(this.center_address3, center_x, center_y2);
/* 132 */     int center_y3 = center_y2 + center_gap;
/* 133 */     g.drawString(this.center_address4, center_x, center_y3);
/*     */     
/* 135 */     int micr_x4 = micr_x + 77;
/* 136 */     g.setFont(f2);
/* 137 */     g.drawString(this.bank_code, micr_x4, micrstart_y);
/* 138 */     int micr_x5 = micr_x4 + 85;
/* 139 */     g.drawImage(img1, micr_x5, micrstart_imgy, 7, 8, null);
/* 140 */     int micr_x6 = micr_x5 + 12;
/*     */     
/* 142 */     int micr_x7 = micr_x6 + 59;
/*     */     
/* 144 */     int micr_x8 = micr_x7 + 17;
/* 145 */     g.drawString(this.bank_code2, micr_x8, micrstart_y);
/*     */     
/* 147 */     g.setFont(f1);
/* 148 */     int side_y1 = side_y + repeart_y;
/* 149 */     g.drawString(this.side_address1, side_x, side_y1);
/* 150 */     g.drawString(this.side_address2, side_x, side_y1 + side_gap);
/* 151 */     g.setFont(f3);
/* 152 */     int center_2y = center_y + repeart_y;
/* 153 */     g.drawString(this.center_address1, center_x, center_2y);
/* 154 */     int center_2y1 = center_2y + center_gap;
/* 155 */     g.drawString(this.center_address2, center_x, center_2y1);
/* 156 */     int center_2y2 = center_2y1 + center_gap;
/* 157 */     g.drawString(this.center_address3, center_x, center_2y2);
/* 158 */     int center_2y3 = center_2y2 + center_gap;
/* 159 */     g.drawString(this.center_address4, center_x, center_2y3);
/*     */     
/* 161 */     g.setFont(f2);
/* 162 */     int micrstart_y2 = micrstart_y + repeart_y;
/* 163 */     int micrstart_imgy2 = micrstart_imgy + repeart_y;
/* 164 */     g.drawString(this.bank_code, micr_x4, micrstart_y2);
/* 165 */     g.drawImage(img1, micr_x5, micrstart_imgy2, 7, 8, null);
/*     */     
/*     */ 
/* 168 */     g.drawString(this.bank_code2, micr_x8, micrstart_y2);
/*     */     
/* 170 */     int side_y2 = side_y1 + repeart_y;
/* 171 */     g.setFont(f1);
/* 172 */     g.drawString(this.side_address1, side_x, side_y2);
/* 173 */     g.drawString(this.side_address2, side_x, side_y2 + side_gap);
/* 174 */     g.setFont(f3);
/* 175 */     int center_3y = center_2y + repeart_y;
/* 176 */     g.drawString(this.center_address1, center_x, center_3y);
/* 177 */     int center_3y1 = center_3y + center_gap;
/* 178 */     g.drawString(this.center_address2, center_x, center_3y1);
/* 179 */     int center_3y2 = center_3y1 + center_gap;
/* 180 */     g.drawString(this.center_address3, center_x, center_3y2);
/* 181 */     int center_3y3 = center_3y2 + center_gap;
/* 182 */     g.drawString(this.center_address4, center_x, center_3y3);
/*     */     
/* 184 */     g.setFont(f2);
/* 185 */     int micrstart_y3 = micrstart_y2 + repeart_y;
/* 186 */     int micrstart_imgy3 = micrstart_imgy2 + repeart_y;
/* 187 */     g.drawString(this.bank_code, micr_x4, micrstart_y3);
/* 188 */     g.drawImage(img1, micr_x5, micrstart_imgy3, 7, 8, null);
/*     */     
/*     */ 
/* 191 */     g.drawString(this.bank_code2, micr_x8, micrstart_y3);
/*     */     
/* 193 */     int y = 234;
/* 194 */     int imgy = 226;
/* 195 */     int start = pageindex == 0 ? 0 : this.pagebreak[(pageindex - 1)];
/* 196 */     int end = pageindex == this.pagebreak.length ? this.value.length : this.pagebreak[pageindex];
/* 197 */     System.out.println("Start==" + start);
/* 198 */     System.out.println("end==" + end);
/* 199 */     g.setFont(f2);
/*     */     
/* 201 */     for (int line = start; line < end; line++) {
/* 202 */       g.drawImage(img, micr_x, micrstart_imgy, 7, 8, null);
/* 203 */       int micr_x1 = micr_x + 6;
/* 204 */       g.drawString("" + String.format("%06d", new Object[] { Integer.valueOf(this.value[line]) }), micr_x1, micrstart_y);
/* 205 */       int micr_x2 = micr_x1 + 57;
/* 206 */       g.drawImage(img, micr_x2, micrstart_imgy, 7, 8, null);
/*     */       
/* 208 */       micrstart_imgy += 264;
/* 209 */       micrstart_y += 264;
/*     */     }
/* 211 */     return 0;
/*     */   }
/*     */ }


/* Location:              F:\MICR Printing\dist\checknoprint.jar!\checknoprint\printpagewobankcode1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */