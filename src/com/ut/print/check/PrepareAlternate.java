package com.ut.print.check;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ut.print.app.model.PrintingContent;
import com.ut.print.app.model.PrintingObject;
import com.ut.print.check.print.PrintChequeNo;
import com.ut.print.common.Utils;
import com.ut.print.dao.CommonJDBCRepo;

@Component
public class PrepareAlternate extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOG = LogFactory.getLog(PrepareAlternate.class.getName());

	private aligment_position_serialize ali_ser = new aligment_position_serialize();

	private PrintingContent printContent = null;

	private PrintingObject printData = new PrintingObject();
	private JButton BtnClose;
	private JButton Btnprint;
	private JTextField FirstSlipAccNo;
	private JTextField FirstSlipAccType;
	private JTextField FirstSlipHolderName;
	private JTextField FirstSlipOrgName;
	private JTextField SecondSlipAcc_no;
	private JTextField SecondSlipAcc_type;
	private JTextField SecondSlipHolder_name;
	private JTextField SecondSlipOrg_name;
	private JComboBox SelectBankName;
	private JTextField ThirdSlipAcc_no;
	private JTextField ThirdSlipAcc_type;
	private JTextField ThirdSlipHolder_name;
	private JTextField ThirdSlipOrg_name;
	private JLabel jLabel100;
	private JLabel jLabel101;
	private JLabel jLabel102;
	private JLabel jLabel29;
	private JLabel jLabel30;
	private JLabel jLabel73;
	private JLabel jLabel74;
	private JLabel jLabel75;
	private JLabel jLabel76;
	private JLabel jLabel77;
	private JLabel jLabel78;
	private JLabel jLabel89;
	private JLabel jLabel90;
	private JLabel jLabel91;
	private JLabel jLabel92;
	private JLabel jLabel93;
	private JLabel jLabel94;
	private JLabel jLabel95;
	private JLabel jLabel96;
	private JLabel jLabel97;
	private JLabel jLabel98;
	private JLabel jLabel99;
	private JPanel jPanel1;
	private JLabel jLabel79;
	private JLabel jLabel80;
	private JLabel jLabel81;
	private JLabel jLabel82;
	private JLabel jLabel83;
	private JLabel jLabel84;
	private JLabel jLabel85;
	private JLabel jLabel86;
	private JLabel jLabel87;
	private JLabel jLabel88;

	@Autowired
	private CommonJDBCRepo commonJDBCRepo;

	public PrepareAlternate() {
		initComponents();
		TitleImage();
		getBankList();
	}

	private void initComponents() {
		this.jPanel1 = new JPanel();
		this.jLabel29 = new JLabel();
		this.jPanel2 = new JPanel();
		this.jLabel73 = new JLabel();
		this.jLabel87 = new JLabel();
		this.slipFirstSide2 = new JTextField();
		this.slipFirstSide1 = new JTextField();
		this.jLabel76 = new JLabel();
		this.jLabel86 = new JLabel();
		this.jLabel74 = new JLabel();
		this.slipFirstCenter3 = new JTextField();
		this.slipFirstCenter1 = new JTextField();
		this.slipFirstCenter2 = new JTextField();
		this.slipFirstMicr1 = new JTextField();
		this.slipFirstMicr2 = new JTextField();
		this.slipFirstMicr3 = new JTextField();
		this.slipFirstMicr4 = new JTextField();
		this.slipFirstCenter4 = new JTextField();
		this.jLabel77 = new JLabel();
		this.jLabel92 = new JLabel();
		this.jLabel93 = new JLabel();
		this.jLabel94 = new JLabel();
		this.jLabel95 = new JLabel();
		this.FirstSlipAccNo = new JTextField();
		this.FirstSlipOrgName = new JTextField();
		this.FirstSlipHolderName = new JTextField();
		this.FirstSlipAccType = new JTextField();
		this.jPanel3 = new JPanel();
		this.jLabel75 = new JLabel();
		this.jLabel88 = new JLabel();
		this.slipThirdSide2 = new JTextField();
		this.slipThirdSide1 = new JTextField();
		this.jLabel78 = new JLabel();
		this.jLabel89 = new JLabel();
		this.jLabel79 = new JLabel();
		this.slipThirdCenter3 = new JTextField();
		this.slipThirdCenter1 = new JTextField();
		this.slipThirdCenter2 = new JTextField();
		this.slipThirdMicr1 = new JTextField();
		this.slipThirdMicr2 = new JTextField();
		this.slipThirdMicr3 = new JTextField();
		this.slipThirdMicr4 = new JTextField();
		this.slipThirdCenter4 = new JTextField();
		this.jLabel84 = new JLabel();
		this.jLabel100 = new JLabel();
		this.jLabel101 = new JLabel();
		this.jLabel102 = new JLabel();
		this.ThirdSlipAcc_no = new JTextField();
		this.ThirdSlipOrg_name = new JTextField();
		this.ThirdSlipHolder_name = new JTextField();
		this.ThirdSlipAcc_type = new JTextField();
		this.jLabel85 = new JLabel();
		this.jPanel4 = new JPanel();
		this.jLabel80 = new JLabel();
		this.jLabel90 = new JLabel();
		this.slipSecondSide2 = new JTextField();
		this.slipSecondSide1 = new JTextField();
		this.jLabel81 = new JLabel();
		this.jLabel91 = new JLabel();
		this.jLabel82 = new JLabel();
		this.slipSecondCenter3 = new JTextField();
		this.slipSecondCenter1 = new JTextField();
		this.slipSecondCenter2 = new JTextField();
		this.slipSecondMicr1 = new JTextField();
		this.slipSecondMicr2 = new JTextField();
		this.slipSecondMicr3 = new JTextField();
		this.slipSecondMicr4 = new JTextField();
		this.slipSecondCenter4 = new JTextField();
		this.jLabel83 = new JLabel();
		this.jLabel98 = new JLabel();
		this.jLabel96 = new JLabel();
		this.jLabel97 = new JLabel();
		this.jLabel99 = new JLabel();
		this.SecondSlipAcc_no = new JTextField();
		this.SecondSlipOrg_name = new JTextField();
		this.SecondSlipHolder_name = new JTextField();
		this.SecondSlipAcc_type = new JTextField();
		this.jLabel30 = new JLabel();
		this.SelectBankName = new JComboBox();
		this.Btnprint = new JButton();
		this.BtnClose = new JButton();

		setDefaultCloseOperation(3);
		setTitle("Prepare Alternate");
		setMaximumSize(new Dimension(800, 800));
		setMinimumSize(new Dimension(700, 700));
		setUndecorated(true);
		setPreferredSize(new Dimension(870, 700));
		setResizable(false);

		this.jPanel1.setBackground(new Color(111, 166, 255));
		this.jPanel1.setForeground(new Color(255, 255, 255));
		this.jPanel1.setPreferredSize(new Dimension(820, 800));

		this.jLabel29.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel29.setForeground(new Color(255, 255, 255));
		this.jLabel29.setText("Prepare Alternate");

		this.jPanel2.setBackground(new Color(111, 166, 255));
		this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
		this.jPanel2.setPreferredSize(new Dimension(676, 176));
		this.jPanel2.setRequestFocusEnabled(false);
		this.jPanel2.setVerifyInputWhenFocusTarget(false);

		this.jLabel73.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel73.setForeground(new Color(255, 255, 255));
		this.jLabel73.setText("Side Address");

		this.jLabel87.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel87.setForeground(new Color(255, 255, 255));
		this.jLabel87.setText("Side Address-2");

		this.jLabel76.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel76.setForeground(new Color(255, 255, 255));
		this.jLabel76.setText("Center Address");

		this.jLabel86.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel86.setForeground(new Color(255, 255, 255));
		this.jLabel86.setText("Center Address2");

		this.jLabel74.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel74.setForeground(new Color(255, 255, 255));
		this.jLabel74.setText("Center Address4");

		this.jLabel77.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel77.setForeground(new Color(255, 255, 255));
		this.jLabel77.setText("Center Address3");

		this.jLabel92.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel92.setForeground(new Color(255, 255, 255));
		this.jLabel92.setText("Account No");

		this.jLabel93.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel93.setForeground(new Color(255, 255, 255));
		this.jLabel93.setText("Organisation");

		this.jLabel94.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel94.setForeground(new Color(255, 255, 255));
		this.jLabel94.setText("Holder Name");

		this.jLabel95.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel95.setForeground(new Color(255, 255, 255));
		this.jLabel95.setText("Account Type");

		GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
		this.jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(
						jPanel2Layout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(72, 72, 72)
										.addGroup(jPanel2Layout
												.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
														jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
																.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(this.jLabel94)
																.addComponent(this.jLabel93, -2, 126, -2)
																.addComponent(this.jLabel92, -2, 114, -2)
																.addComponent(this.jLabel87, -2,
																		126, -2)
																.addComponent(this.jLabel73, -2, 107, -2))
																.addGap(45, 45, 45)
																.addGroup(jPanel2Layout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addComponent(this.slipFirstSide1,
																				GroupLayout.Alignment.TRAILING, -2, 132,
																				-2)
																		.addComponent(this.slipFirstSide2, -2, 132, -2)
																		.addComponent(this.FirstSlipAccNo,
																				GroupLayout.Alignment.TRAILING, -2, 132,
																				-2)
																		.addComponent(this.FirstSlipOrgName,
																				GroupLayout.Alignment.TRAILING, -2,
																				132, -2)
																		.addComponent(
																				this.FirstSlipHolderName,
																				GroupLayout.Alignment.TRAILING, -2, 132,
																				-2))
																.addGap(71, 71, 71)
																.addGroup(jPanel2Layout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addComponent(this.jLabel95, -2, 126, -2)
																		.addComponent(this.jLabel77, -2, 136, -2)
																		.addComponent(this.jLabel74, -2, 136, -2)
																		.addComponent(this.jLabel86, -2, 137, -2)
																		.addComponent(this.jLabel76, -2, 129, -2)))
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(this.slipFirstMicr1, -2, 126, -2)
														.addGap(45, 45, 45)
														.addComponent(this.slipFirstMicr2, -2, 132, -2)
														.addGap(71, 71, 71)
														.addComponent(this.slipFirstMicr3, -2, 131, -2)))
										.addGap(56, 56, 56)
										.addGroup(jPanel2Layout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(this.slipFirstMicr4, -1, 132, 32767)
												.addComponent(this.slipFirstCenter2, GroupLayout.Alignment.TRAILING)
												.addComponent(this.slipFirstCenter3).addComponent(this.slipFirstCenter4)
												.addComponent(this.FirstSlipAccType)
												.addComponent(this.slipFirstCenter1, GroupLayout.Alignment.TRAILING))
										.addContainerGap(-1, 32767)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel76).addComponent(this.slipFirstCenter1, -2, -1, -2)
								.addComponent(this.slipFirstSide1, -2, -1, -2).addComponent(this.jLabel73))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel86).addComponent(this.slipFirstCenter2, -2, -1, -2)
								.addComponent(this.slipFirstSide2, -2, -1, -2).addComponent(this.jLabel87))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.slipFirstCenter3, -2, -1, -2).addComponent(this.jLabel77)
								.addComponent(this.jLabel92).addComponent(this.FirstSlipAccNo, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.FirstSlipOrgName, -2, -1, -2)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.slipFirstCenter4, -2, -1, -2).addComponent(this.jLabel74)
										.addComponent(this.jLabel93)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.FirstSlipHolderName, -2, -1, -2).addGroup(jPanel2Layout
										.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel94)
										.addComponent(this.jLabel95).addComponent(this.FirstSlipAccType, -2, -1, -2)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.slipFirstMicr4, -2, -1, -2)
										.addComponent(this.slipFirstMicr3, -2, -1, -2)
										.addComponent(this.slipFirstMicr2, -2, -1, -2))
								.addComponent(this.slipFirstMicr1))
						.addContainerGap(45, 32767)));
		this.jPanel3.setBackground(new Color(111, 166, 255));
		this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
		this.jPanel3.setPreferredSize(new Dimension(810, 201));

		this.jLabel75.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel75.setForeground(new Color(255, 255, 255));
		this.jLabel75.setText("Side Address");

		this.jLabel88.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel88.setForeground(new Color(255, 255, 255));
		this.jLabel88.setText("Side Address-2");

		this.jLabel78.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel78.setForeground(new Color(255, 255, 255));
		this.jLabel78.setText("Center Address");

		this.jLabel89.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel89.setForeground(new Color(255, 255, 255));
		this.jLabel89.setText("Center Address2");

		this.jLabel79.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel79.setForeground(new Color(255, 255, 255));
		this.jLabel79.setText("Center Address3");

		this.slipThirdMicr4.setNextFocusableComponent(this.Btnprint);

		this.jLabel84.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel84.setForeground(new Color(255, 255, 255));
		this.jLabel84.setText("Center Address4");

		this.jLabel100.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel100.setForeground(new Color(255, 255, 255));
		this.jLabel100.setText("Account No");

		this.jLabel101.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel101.setForeground(new Color(255, 255, 255));
		this.jLabel101.setText("Organisation");

		this.jLabel102.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel102.setForeground(new Color(255, 255, 255));
		this.jLabel102.setText("Holder Name");

		this.jLabel85.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel85.setForeground(new Color(255, 255, 255));
		this.jLabel85.setText("Account Type");

		GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
		this.jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout
						.createSequentialGroup()
						.addContainerGap(-1, 32767).addGroup(jPanel3Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.jLabel100, -2, 114, -2)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(this.jLabel75, -2, 126, -2)
												.addComponent(this.jLabel88, -2, 126, -2))
										.addComponent(this.jLabel101, -2, 126, -2)
										.addComponent(this.jLabel102, -2, 126, -2))
										.addGap(39, 39, 39)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(this.slipThirdSide2, -2, 132, -2)
												.addComponent(this.slipThirdSide1, -2, 132, -2)
												.addComponent(this.ThirdSlipAcc_no, -2, 132, -2)
												.addComponent(this.ThirdSlipOrg_name, -2, 132, -2)
												.addComponent(this.ThirdSlipHolder_name, -2, 132, -2)))
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(this.slipThirdMicr1, -2, 126, -2).addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
										.addComponent(this.slipThirdMicr2, -2, 132, -2)))
						.addGap(68, 68, 68)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.jLabel89, -2, 137, -2)
										.addComponent(this.jLabel78, -2, 129, -2)
										.addComponent(this.jLabel79, -2, 136, -2)
										.addComponent(this.jLabel84, -2, 136, -2)
										.addComponent(this.jLabel85, -2, 129, -2))
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(this.slipThirdMicr3, -2, 131, -2).addGap(8, 8, 8)))
						.addGap(56, 56, 56)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(this.slipThirdMicr4, -1, 140, 32767)
								.addComponent(this.slipThirdCenter4, GroupLayout.Alignment.TRAILING)
								.addComponent(this.slipThirdCenter3, GroupLayout.Alignment.TRAILING)
								.addComponent(this.slipThirdCenter2, GroupLayout.Alignment.TRAILING)
								.addComponent(this.slipThirdCenter1, GroupLayout.Alignment.TRAILING)
								.addComponent(this.ThirdSlipAcc_type))
						.addGap(29, 29, 29)));

		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(
								jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.jLabel75).addComponent(this.slipThirdSide1, -2, -1,
												-2)
										.addComponent(this.jLabel78).addComponent(this.slipThirdCenter1, -2, -1, -2))
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel88)
												.addComponent(this.slipThirdSide2, -2, -1, -2)
												.addComponent(this.jLabel89)
												.addComponent(this.slipThirdCenter2, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel79).addComponent(this.jLabel100)
												.addComponent(this.ThirdSlipAcc_no, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.ThirdSlipOrg_name, -2, -1, -2)
												.addComponent(this.jLabel101)))
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(29, 29, 29)
										.addComponent(this.slipThirdCenter3, -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.slipThirdCenter4, -2, -1, -2)
												.addComponent(this.jLabel84))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jLabel85)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.jLabel102).addComponent(this.ThirdSlipHolder_name, -2, -1,
												-2))
								.addComponent(this.ThirdSlipAcc_type, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.slipThirdMicr4, -2, -1, -2)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.slipThirdMicr2, -2, -1, -2).addComponent(this.slipThirdMicr1,
												-2, -1, -2))
								.addComponent(this.slipThirdMicr3, -2, -1, -2))
						.addGap(21, 32, 32767)));

		this.jPanel4.setBackground(new Color(111, 166, 255));
		this.jPanel4.setBorder(BorderFactory.createEtchedBorder());

		this.jLabel80.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel80.setForeground(new Color(255, 255, 255));
		this.jLabel80.setText("Side Address");

		this.jLabel90.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel90.setForeground(new Color(255, 255, 255));
		this.jLabel90.setText("Side Address-2");

		this.jLabel81.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel81.setForeground(new Color(255, 255, 255));
		this.jLabel81.setText("Center Address");

		this.jLabel91.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel91.setForeground(new Color(255, 255, 255));
		this.jLabel91.setText("Center Address2");

		this.jLabel82.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel82.setForeground(new Color(255, 255, 255));
		this.jLabel82.setText("Center Address3");

		this.jLabel83.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel83.setForeground(new Color(255, 255, 255));
		this.jLabel83.setText("Center Address4");

		this.jLabel98.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel98.setForeground(new Color(255, 255, 255));
		this.jLabel98.setText("Holder Name");

		this.jLabel96.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel96.setForeground(new Color(255, 255, 255));
		this.jLabel96.setText("Account No");

		this.jLabel97.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel97.setForeground(new Color(255, 255, 255));
		this.jLabel97.setText("Organisation");

		this.jLabel99.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel99.setForeground(new Color(255, 255, 255));
		this.jLabel99.setText("Account Type");

		this.SecondSlipOrg_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PrepareAlternate.this.SecondSlipOrg_nameActionPerformed(evt);
			}

		});
		GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
		this.jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel4Layout.createSequentialGroup().addGap(71, 71, 71).addGroup(jPanel4Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel96, -2, 114, -2)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabel90, -2, 126, -2).addComponent(this.jLabel80, -2, 126, -2))
						.addComponent(this.jLabel97, -2, 126, -2).addComponent(this.jLabel98, -2, 126, -2)
						.addComponent(this.slipSecondMicr1, -2, 126, -2))
						.addGap(45, 45, 45)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.slipSecondSide2, -2, 132, -2)
								.addComponent(this.slipSecondSide1, -2, 132, -2)
								.addComponent(this.SecondSlipAcc_no, -2, 132, -2)
								.addComponent(this.SecondSlipOrg_name, -2, 132, -2)
								.addComponent(this.SecondSlipHolder_name, -2, 132, -2)
								.addComponent(this.slipSecondMicr2, -2, 132, -2))
						.addGap(72, 72, 72).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout
										.createSequentialGroup().addGroup(jPanel4Layout
												.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanel4Layout
														.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
														.addComponent(this.slipSecondMicr3,
																GroupLayout.Alignment.LEADING)
														.addComponent(this.jLabel99, GroupLayout.Alignment.LEADING, -1,
																126, 32767))
												.addComponent(this.jLabel83, -2, 136, -2))
										.addGap(55, 55, 55)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.SecondSlipAcc_type, -1, 142, 32767)
												.addComponent(this.slipSecondCenter4)
												.addComponent(this.slipSecondMicr4)))
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.jLabel82, -2, 136, -2)
												.addComponent(this.jLabel81, -2, 129, -2)
												.addComponent(this.jLabel91, -2, 137, -2))
										.addGap(54, 54, 54)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.slipSecondCenter3, GroupLayout.Alignment.TRAILING)
												.addComponent(this.slipSecondCenter2, GroupLayout.Alignment.TRAILING)
												.addComponent(this.slipSecondCenter1, GroupLayout.Alignment.TRAILING))))
						.addGap(29, 29, 29)));

		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.slipSecondSide1, GroupLayout.Alignment.TRAILING, -2, -1, -2)
								.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.jLabel81).addComponent(this.slipSecondCenter1, -2, -1, -2)
										.addComponent(this.jLabel80)))
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel91).addComponent(this.slipSecondCenter2, -2,
														-1, -2)))
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel90).addComponent(this.slipSecondSide2, -2, -1,
														-2))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel82).addComponent(this.slipSecondCenter3, -2,
														-1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel83).addComponent(this.slipSecondCenter4, -2,
														-1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel99).addComponent(this.SecondSlipAcc_type, -2,
														-1, -2)))
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel96)
												.addComponent(this.SecondSlipAcc_no, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel97)
												.addComponent(this.SecondSlipOrg_name, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel98)
												.addComponent(this.SecondSlipHolder_name, -2, -1, -2))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.slipSecondMicr4, -2, -1, -2)
								.addComponent(this.slipSecondMicr3, -2, -1, -2)
								.addComponent(this.slipSecondMicr2, -2, -1, -2)
								.addComponent(this.slipSecondMicr1, -2, -1, -2))
						.addGap(0, 8, 32767)));

		this.jLabel30.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel30.setForeground(new Color(255, 255, 255));
		this.jLabel30.setText("Select Bank");

		this.SelectBankName.setFont(new Font("Times New Roman", 0, 12));
		this.SelectBankName.setForeground(new Color(102, 0, 102));
		this.SelectBankName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Bank Name" }));
		this.SelectBankName.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				PrepareAlternate.this.SelectBankNameItemStateChanged(evt);
			}
		});
		this.SelectBankName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PrepareAlternate.this.SelectBankNameActionPerformed(evt);
			}

		});
		this.Btnprint.setFont(new Font("Arial", 1, 14));
		this.Btnprint.setForeground(new Color(42, 188, 217));
		this.Btnprint.setText("Print");
		this.Btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PrepareAlternate.this.BtnprintActionPerformed(evt);
			}

		});
		this.BtnClose.setFont(new Font("Arial", 1, 14));
		this.BtnClose.setForeground(new Color(42, 188, 217));
		this.BtnClose.setText("Close");
		this.BtnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PrepareAlternate.this.BtnCloseActionPerformed(evt);
			}

		});
		GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767)
										.addComponent(this.jLabel29, -2, 108, -2)
										.addGap(134, 134, 134).addComponent(this.jLabel30).addGap(18, 18, 18)
										.addComponent(this.SelectBankName, -2, 153, -2))
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, 812, 32767)
										.addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
										.addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, 812, 32767))
										.addGap(0, 31, 32767))))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(314, 314, 314)
						.addComponent(this.Btnprint, -2, 76, -2).addGap(70, 70, 70)
						.addComponent(this.BtnClose, -2, 76, -2).addGap(0, 0, 32767)));

		jPanel1Layout
				.setVerticalGroup(
						jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout
										.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel29).addComponent(this.jLabel30)
												.addComponent(this.SelectBankName, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.jPanel2, -1, 214, 32767)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(this.jPanel4, -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.jPanel3, -2, -1, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.Btnprint).addComponent(this.BtnClose))
										.addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, 853, 32767));

		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, 685, 32767));

		pack();
		setLocationRelativeTo(null);
	}

	private void BtnCloseActionPerformed(ActionEvent evt) {
		try {
			dispose();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void BtnprintActionPerformed(ActionEvent evt) {
		String java_home = System.getProperty("user.home");
		String alignment_file = java_home + "\\Cheque_MICRPrinting\\alignment";
		String filename = alignment_file + "\\Current_setting.txt";
		String default_filename = alignment_file + "\\position_default.txt";

		File file_cur = new File(filename);
		File file_default = new File(default_filename);
		try {
			if (!file_default.exists()) {
				javax.swing.JOptionPane.showMessageDialog(null,
						"Alignment is Empty value..\n So you can't take the printout..");
				return;
			}
			FileInputStream fout;
			if (file_cur.exists()) {
				fout = new FileInputStream(filename);
			} else {
				fout = new FileInputStream(file_default);
			}
			ObjectInputStream obj_in = new ObjectInputStream(fout);
			Throwable localThrowable2 = null;
			try {
				this.ali_ser = ((aligment_position_serialize) obj_in.readObject());
			} catch (Throwable localThrowable1) {
				localThrowable2 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (obj_in != null)
					if (localThrowable2 != null)
						try {
							obj_in.close();
						} catch (Throwable x2) {
							localThrowable2.addSuppressed(x2);
						}
					else
						obj_in.close();
			}
			fout.close();
		} catch (java.awt.HeadlessException | IOException | ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		SetPrintingData();
		new PrintChequeNo(this.printData).print();
	}

	private void SetPrintingData() {
		this.printContent = new PrintingContent();
		this.printContent.getAli_ser().clear();
		this.printData.getPrintingContent().clear();
		this.printContent.getAli_ser().add(this.ali_ser);
		java.net.URL urlimage1 = getClass().getResource("MICR121.gif");
		java.net.URL urlimage2 = getClass().getResource("MICR122.gif");

		this.printContent.setUrlimage1(urlimage1);
		this.printContent.setUrlimage2(urlimage2);
		this.printContent.setSideaddress1(this.slipFirstSide1.getText().trim());
		this.printContent.setSideaddress2(this.slipFirstSide2.getText().trim());
		this.printContent.setCenteraddress1(this.slipFirstCenter1.getText().trim());
		this.printContent.setCenteraddress2(this.slipFirstCenter2.getText().trim());
		this.printContent.setCenteraddress3(this.slipFirstCenter3.getText().trim());
		this.printContent.setCenteraddress4(this.slipFirstCenter4.getText().trim());
		this.printContent.setFirstMicr(this.slipFirstMicr1.getText().trim());
		this.printContent.setBankcode(this.slipFirstMicr2.getText().trim());
		this.printContent.setBankcode1(this.slipFirstMicr3.getText().trim());
		this.printContent.setBankcode2(this.slipFirstMicr4.getText().trim());
		this.printContent.setAccNo(this.FirstSlipAccNo.getText().trim());
		this.printContent.setAccOrganisation(this.FirstSlipOrgName.getText().trim());
		this.printContent.setAccHolderName(this.FirstSlipHolderName.getText().trim());
		this.printContent.setAccountType(this.FirstSlipAccType.getText().trim());
		this.printData.getPrintingContent().add(this.printContent);

		this.printContent = new PrintingContent();
		this.printContent.setSideaddress1(this.slipSecondSide1.getText().trim());
		this.printContent.setSideaddress2(this.slipSecondSide2.getText().trim());
		this.printContent.setCenteraddress1(this.slipSecondCenter1.getText().trim());
		this.printContent.setCenteraddress2(this.slipSecondCenter2.getText().trim());
		this.printContent.setCenteraddress3(this.slipSecondCenter3.getText().trim());
		this.printContent.setCenteraddress4(this.slipSecondCenter4.getText().trim());
		this.printContent.setFirstMicr(this.slipSecondMicr1.getText().trim());
		this.printContent.setBankcode(this.slipSecondMicr2.getText().trim());
		this.printContent.setBankcode1(this.slipSecondMicr3.getText().trim());
		this.printContent.setBankcode2(this.slipSecondMicr4.getText().trim());
		this.printContent.setAccNo(this.SecondSlipAcc_no.getText().trim());
		this.printContent.setAccOrganisation(this.SecondSlipOrg_name.getText().trim());
		this.printContent.setAccHolderName(this.SecondSlipHolder_name.getText().trim());
		this.printContent.setAccountType(this.SecondSlipAcc_type.getText().trim());
		this.printData.getPrintingContent().add(this.printContent);

		this.printContent = new PrintingContent();

		this.printContent.setSideaddress1(this.slipThirdSide1.getText().trim());
		this.printContent.setSideaddress2(this.slipThirdSide2.getText().trim());
		this.printContent.setCenteraddress1(this.slipThirdCenter1.getText().trim());
		this.printContent.setCenteraddress2(this.slipThirdCenter2.getText().trim());
		this.printContent.setCenteraddress3(this.slipThirdCenter3.getText().trim());
		this.printContent.setCenteraddress4(this.slipThirdCenter4.getText().trim());
		this.printContent.setFirstMicr(this.slipThirdMicr1.getText().trim());
		this.printContent.setBankcode(this.slipThirdMicr2.getText().trim());
		this.printContent.setBankcode1(this.slipThirdMicr3.getText().trim());
		this.printContent.setBankcode2(this.slipThirdMicr4.getText().trim());
		this.printContent.setAccNo(this.ThirdSlipAcc_no.getText().trim());
		this.printContent.setAccOrganisation(this.ThirdSlipOrg_name.getText().trim());
		this.printContent.setAccHolderName(this.ThirdSlipHolder_name.getText().trim());
		this.printContent.setAccountType(this.ThirdSlipAcc_type.getText().trim());
		this.printData.getPrintingContent().add(this.printContent);
		this.printData.setPrinttype(PrintingObject.PRINTTYPE.ALTERNATEPRINT);
	}

	private void SelectBankNameItemStateChanged(ItemEvent evt) {

		String bankname = this.SelectBankName.getSelectedItem().toString();
		if (bankname.equals("Select Bank Name")) {
			SetEmpty();
		} else {
			String str_side1 = null;
			String str_side2 = null;
			String str_center1 = null;
			String str_center2 = null;
			String str_center3 = null;
			String str_center4 = null;
			String str_bnk9digit = null;
			String Acc_No = null;
			String Org_name = null;
			String Holder_Name = null;
			Map<String, Object> bankDetails = this.commonJDBCRepo.getBank(bankname);
			str_side1 = (String) bankDetails.get("side1");
			str_side2 = (String) bankDetails.get("side2");
			str_center1 = (String) bankDetails.get("center1");
			str_center2 = (String) bankDetails.get("center2");
			str_center3 = (String) bankDetails.get("center3");
			str_center4 = (String) bankDetails.get("center4");
			str_bnk9digit = (String) bankDetails.get("bankcode9digits");
			Acc_No = (String) bankDetails.get("AccNo");
			Org_name = (String) bankDetails.get("AccHolderOrg");
			Holder_Name = (String) bankDetails.get("AccHolderName");

			SetValues(str_side1, str_side2, str_center1, str_center2, str_center3, str_center4, str_bnk9digit, Acc_No,
					Org_name, Holder_Name);
		}
	}

	private void SelectBankNameActionPerformed(ActionEvent evt) {
	}

	private void SecondSlipOrg_nameActionPerformed(ActionEvent evt) {
	}

	private void TitleImage() {
		getRootPane().setWindowDecorationStyle(8);
		setIconImages(Utils.getTitleImage());
	}

	private void getBankList() {

		List<String> bankList = this.commonJDBCRepo.getBankList();

		for (String bank : bankList) {
			this.SelectBankName.addItem(bank);
		}

	}

	private JPanel jPanel2;
	private JPanel jPanel3;

	private void SetEmpty() {
		this.slipFirstSide1.setText("");
		this.slipFirstSide2.setText("");
		this.slipFirstCenter1.setText("");
		this.slipFirstCenter2.setText("");
		this.slipFirstCenter3.setText("");
		this.slipFirstCenter4.setText("");
		this.slipFirstMicr2.setText("");
		this.FirstSlipAccNo.setText("");
		this.FirstSlipOrgName.setText("");
		this.FirstSlipHolderName.setText("");
		this.FirstSlipAccType.setText("");

		this.slipSecondSide1.setText("");
		this.slipSecondSide2.setText("");
		this.slipSecondCenter1.setText("");
		this.slipSecondCenter2.setText("");
		this.slipSecondCenter3.setText("");
		this.slipSecondCenter4.setText("");
		this.slipSecondMicr2.setText("");
		this.SecondSlipAcc_no.setText("");
		this.SecondSlipOrg_name.setText("");
		this.SecondSlipHolder_name.setText("");
		this.SecondSlipAcc_type.setText("");

		this.slipThirdSide1.setText("");
		this.slipThirdSide2.setText("");
		this.slipThirdCenter1.setText("");
		this.slipThirdCenter2.setText("");
		this.slipThirdCenter3.setText("");
		this.slipThirdCenter4.setText("");
		this.slipThirdMicr2.setText("");
		this.ThirdSlipAcc_no.setText("");
		this.ThirdSlipOrg_name.setText("");
		this.ThirdSlipHolder_name.setText("");
		this.ThirdSlipAcc_type.setText("");
	}

	private void SetValues(String str_side1, String str_side2, String str_center1, String str_center2,
			String str_center3, String str_center4, String str_bnk9digit, String Acc_No, String Org_name,
			String Holder_Name) {
		this.slipFirstSide1.setText(str_side1);
		this.slipFirstSide2.setText(str_side2);
		this.slipFirstCenter1.setText(str_center1);
		this.slipFirstCenter2.setText(str_center2);
		this.slipFirstCenter3.setText(str_center3);
		this.slipFirstCenter4.setText(str_center4);
		this.slipFirstMicr2.setText(str_bnk9digit);
		this.FirstSlipAccNo.setText(Acc_No);
		this.FirstSlipOrgName.setText(Org_name);
		this.FirstSlipHolderName.setText(Holder_Name);

		this.slipSecondSide1.setText(str_side1);
		this.slipSecondSide2.setText(str_side2);
		this.slipSecondCenter1.setText(str_center1);
		this.slipSecondCenter2.setText(str_center2);
		this.slipSecondCenter3.setText(str_center3);
		this.slipSecondCenter4.setText(str_center4);
		this.slipSecondMicr2.setText(str_bnk9digit);
		this.SecondSlipAcc_no.setText(Acc_No);
		this.SecondSlipOrg_name.setText(Org_name);
		this.SecondSlipHolder_name.setText(Holder_Name);

		this.slipThirdSide1.setText(str_side1);
		this.slipThirdSide2.setText(str_side2);
		this.slipThirdCenter1.setText(str_center1);
		this.slipThirdCenter2.setText(str_center2);
		this.slipThirdCenter3.setText(str_center3);
		this.slipThirdCenter4.setText(str_center4);
		this.slipThirdMicr2.setText(str_bnk9digit);
		this.ThirdSlipAcc_no.setText(Acc_No);
		this.ThirdSlipOrg_name.setText(Org_name);
		this.ThirdSlipHolder_name.setText(Holder_Name);
	}

	private JPanel jPanel4;
	private JTextField slipFirstCenter1;
	private JTextField slipFirstCenter2;
	private JTextField slipFirstCenter3;
	private JTextField slipFirstCenter4;
	private JTextField slipFirstMicr1;
	private JTextField slipFirstMicr2;

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PrepareAlternate.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PrepareAlternate().setVisible(true);
			}
		});
	}

	private JTextField slipFirstMicr3;
	private JTextField slipFirstMicr4;
	private JTextField slipFirstSide1;
	private JTextField slipFirstSide2;
	private JTextField slipSecondCenter1;
	private JTextField slipSecondCenter2;
	private JTextField slipSecondCenter3;
	private JTextField slipSecondCenter4;
	private JTextField slipSecondMicr1;
	private JTextField slipSecondMicr2;
	private JTextField slipSecondMicr3;
	private JTextField slipSecondMicr4;
	private JTextField slipSecondSide1;
	private JTextField slipSecondSide2;
	private JTextField slipThirdCenter1;
	private JTextField slipThirdCenter2;
	private JTextField slipThirdCenter3;
	private JTextField slipThirdCenter4;
	private JTextField slipThirdMicr1;
	private JTextField slipThirdMicr2;
	private JTextField slipThirdMicr3;
	private JTextField slipThirdMicr4;
	private JTextField slipThirdSide1;
	private JTextField slipThirdSide2;
}