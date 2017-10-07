package com.ut.print.check;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ut.print.common.Utils;

@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PositionAlignment_setting extends AbstractPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(PositionAlignment_setting.class.getName());
	private JButton btn_alignmentDefault_position;
	private JButton btn_cancelPanel;
	private JButton btn_setAligment;
	private JLabel jLabel15;
	private JLabel jLabel16;
	private JLabel jLabel17;
	private JLabel jLabel18;
	private JLabel jLabel19;
	private JLabel jLabel20;
	private JLabel jLabel21;
	private JLabel jLabel22;
	private JLabel jLabel23;
	private JLabel jLabel24;
	private JLabel jLabel25;
	private JLabel jLabel26;
	private JLabel jLabel27;
	private JLabel jLabel28;
	private JLabel jLabel29;
	private JLabel jLabel30;
	private JLabel jLabel31;
	private JLabel jLabel32;
	private JLabel jLabel33;
	private JLabel jLabel34;
	private JLabel jLabel35;
	private JLabel jLabel36;
	private JLabel jLabel37;
	private JLabel jLabel51;
	private JLabel jLabel52;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JPanel jPanel6;
	private JPanel jPanel7;
	private JPanel jPanel8;
	private JTextField lbl_AccNo_height;
	private JTextField lbl_AccNo_length;
	private JTextField lbl_AccountType_height;
	private JTextField lbl_AccountType_length;
	private JTextField lbl_HolderName_height;
	private JTextField lbl_HolderName_length;
	private JTextField lbl_Organisation_charLen;
	private JTextField lbl_Organisation_height;
	private JTextField lbl_Organisation_length;
	private JTextField lbl_centerAddr_btspace;
	private JTextField lbl_centerAddr_height;
	private JTextField lbl_centerAddr_length;
	private JTextField lbl_chequeNum_heg;
	private JTextField lbl_chequeNum_len;
	private JTextField lbl_sideaddress_btSpace;
	private JTextField lbl_sideaddress_height;
	private JTextField lbl_sideaddress_length;
	private JSlider slider_AccNoHeg;
	private JSlider slider_AccNoLen;
	private JSlider slider_AccountTypeHeg;
	private JSlider slider_AccountTypeLen;
	private JSlider slider_HolderNameHeg;
	private JSlider slider_HolderNameLen;
	private JSlider slider_OrganisationCharLen;
	private JSlider slider_OrganisationHeg;
	private JSlider slider_OrganisationLen;
	private JSlider slider_centerGap;
	private JSlider slider_centerHeg;
	private JSlider slider_centerLen;
	private JSlider slider_chequeNumHeg;
	private JSlider slider_chequeNumLen;
	private JSlider slider_sideAddressGap;
	private JSlider slider_sideHeigth;
	private JSlider slider_sideLength;

	public PositionAlignment_setting() {
		/*
		 * TitleImage(); initComponents(); setDefaultAlignment();
		 */
	}

	@Override
	protected void initPage() {
		TitleImage();
		initComponents();
		setDefaultAlignment();
	}

	private void TitleImage() {
		getRootPane().setWindowDecorationStyle(8);
		setIconImages(Utils.getTitleImage());
	}

	private void setDefaultAlignment() {
		try {
			String user_home = System.getProperty("user.home");
			String alignment_file = user_home + "\\Cheque_MICRPrinting\\alignment";

			File file1 = new File(alignment_file);
			File file = new File(alignment_file + "\\Current_setting.txt");
			if (!file1.exists()) {
				file1.mkdirs();
			}
			if (!file.exists()) {

				aligment_position_serialize ali_ser = new aligment_position_serialize();
				ali_ser.setSd_Addr_leg11("76");
				ali_ser.setSd_Addr_heg12("22");
				ali_ser.setSd_Addr_spa13("10");

				ali_ser.setCn_Addr_leg11("310");
				ali_ser.setCn_Addr_heg12("10");
				ali_ser.setCn_Addr_spa123("10");

				ali_ser.setChquenum_img_leg11("163");
				ali_ser.setChequenum_img_heg12("226");

				ali_ser.setChequenum_len11("169");
				ali_ser.setChequenum_heg12("234");

				ali_ser.setChequenum_img2_len11("226");
				ali_ser.setChequenum_img2_heg12("226");

				ali_ser.setBankcode_9dig_len11("240");
				ali_ser.setBankcode_9dig_heg12("234");

				ali_ser.setBankcode_img_len11("325");
				ali_ser.setBankcode_img_heg12("226");

				ali_ser.setBankcode_6dig_len11("337");
				ali_ser.setBankcode_6dig_heg12("234");

				ali_ser.setBankcode_img2_len11("396");
				ali_ser.setBankcode_img2_heg12("226");

				ali_ser.setBankcode_2dig_len11("413");
				ali_ser.setBankcode_2dig_heg12("234");

				ali_ser.setAccNo_len("76");
				ali_ser.setAccNo_heg("150");

				ali_ser.setAccOrganisationName_len("413");
				ali_ser.setAccOrganisationName_heg("150");

				ali_ser.setAccHolderName_len("413");
				ali_ser.setAccHolderName_heg("190");

				ali_ser.setAccountType_len("240");
				ali_ser.setAccountType_heg("210");
				ali_ser.setOrgCharLen("40");

				String filename = alignment_file + "\\position_default.txt";
				FileOutputStream fout = new FileOutputStream(filename);
				ObjectOutputStream obj_out = new ObjectOutputStream(fout);
				obj_out.writeObject(ali_ser);
				obj_out.close();
				fout.close();
				obj_out = null;
				fout = null;
			} else {
				aligment_position_serialize ali_ser = null;
				FileInputStream fout = null;
				ObjectInputStream obj_in = null;

				String filename = alignment_file + "\\Current_setting.txt";
				File file_cur = new File(filename);
				if (file_cur.exists()) {
					fout = new FileInputStream(filename);
					obj_in = new ObjectInputStream(fout);
					ali_ser = (aligment_position_serialize) obj_in.readObject();

					String side_length = ali_ser.getSd_Addr_leg11().trim();

					String side_height = ali_ser.getSd_Addr_heg12().trim();
					String side_space = ali_ser.getSd_Addr_spa13().trim();

					String center_length = ali_ser.getCn_Addr_leg11().trim();
					String center_height = ali_ser.getCn_Addr_heg12().trim();
					String center_space = ali_ser.getCn_Addr_spa123().trim();

					String chequeNum_len = ali_ser.getChquenum_img_leg11().trim();
					String chequeNum_heg = ali_ser.getChequenum_img_heg12().trim();
					String AccNo_Len = ali_ser.getAccNo_len();
					String AccNo_Heg = ali_ser.getAccNo_heg();

					String HolderName_Len = ali_ser.getAccHolderName_len();
					String HolderName_Heg = ali_ser.getAccHolderName_heg();

					String Organisation_Len = ali_ser.getAccOrganisationName_len();
					String Organisation_Heg = ali_ser.getAccOrganisationName_heg();

					String AccountType_Len = ali_ser.getAccountType_len();
					String AccountType_Heg = ali_ser.getAccountType_heg();
					String OrgCharLen = ali_ser.getOrgCharLen();

					this.lbl_sideaddress_length.setText(side_length);
					this.slider_sideLength.setValue(Integer.parseInt(side_length));
					this.lbl_sideaddress_height.setText(side_height);
					this.slider_sideHeigth.setValue(Integer.parseInt(side_height));
					this.lbl_sideaddress_btSpace.setText(side_space);
					this.slider_sideAddressGap.setValue(Integer.parseInt(side_space));

					this.lbl_centerAddr_length.setText(center_length);
					this.lbl_centerAddr_height.setText(center_height);
					this.lbl_centerAddr_btspace.setText(center_space);
					this.slider_centerLen.setValue(Integer.parseInt(center_length));
					this.slider_centerHeg.setValue(Integer.parseInt(center_height));
					this.slider_centerGap.setValue(Integer.parseInt(center_space));

					this.lbl_chequeNum_len.setText(chequeNum_len);
					this.lbl_chequeNum_heg.setText(chequeNum_heg);
					this.slider_chequeNumLen.setValue(Integer.parseInt(chequeNum_len));
					this.slider_chequeNumHeg.setValue(Integer.parseInt(chequeNum_heg));

					this.lbl_AccNo_length.setText(AccNo_Len);
					this.lbl_AccNo_height.setText(AccNo_Heg);
					this.slider_AccNoLen.setValue(Integer.parseInt(AccNo_Len));
					this.slider_AccNoHeg.setValue(Integer.parseInt(AccNo_Heg));

					this.lbl_Organisation_length.setText(Organisation_Len);
					this.lbl_Organisation_height.setText(Organisation_Heg);
					this.slider_OrganisationLen.setValue(Integer.parseInt(Organisation_Len));
					this.slider_OrganisationHeg.setValue(Integer.parseInt(Organisation_Heg));

					this.lbl_HolderName_length.setText(HolderName_Len);
					this.lbl_HolderName_height.setText(HolderName_Heg);
					this.slider_HolderNameLen.setValue(Integer.parseInt(HolderName_Len));
					this.slider_HolderNameHeg.setValue(Integer.parseInt(HolderName_Heg));

					this.lbl_AccountType_length.setText(AccountType_Len);
					this.lbl_AccountType_height.setText(AccountType_Heg);
					this.slider_AccountTypeLen.setValue(Integer.parseInt(AccountType_Len));
					this.slider_AccountTypeHeg.setValue(Integer.parseInt(AccountType_Heg));
					this.slider_OrganisationCharLen.setValue(Integer.parseInt(OrgCharLen));
					obj_in.close();
					fout.close();
				} else {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Current Alignment is Empty value..\n So Loading Default Value..");
				}
			}
		} catch (java.awt.HeadlessException | java.io.IOException | ClassNotFoundException | NumberFormatException e) {
			System.out.println("ERRor on btn_alignmentDefault_positionActionPerformed==" + e.getMessage());
			log.error(e.getMessage());
		} finally {
		}
	}

	private void initComponents() {
		this.jPanel1 = new JPanel();
		this.jPanel2 = new JPanel();
		this.jLabel16 = new JLabel();
		this.slider_sideLength = new JSlider();
		this.jLabel17 = new JLabel();
		this.jLabel18 = new JLabel();
		this.slider_sideHeigth = new JSlider();
		this.lbl_sideaddress_length = new JTextField();
		this.lbl_sideaddress_height = new JTextField();
		this.jLabel19 = new JLabel();
		this.slider_sideAddressGap = new JSlider();
		this.lbl_sideaddress_btSpace = new JTextField();
		this.jLabel15 = new JLabel();
		this.jPanel3 = new JPanel();
		this.jLabel20 = new JLabel();
		this.slider_centerLen = new JSlider();
		this.jLabel21 = new JLabel();
		this.jLabel22 = new JLabel();
		this.slider_centerHeg = new JSlider();
		this.lbl_centerAddr_length = new JTextField();
		this.lbl_centerAddr_height = new JTextField();
		this.jLabel23 = new JLabel();
		this.slider_centerGap = new JSlider();
		this.lbl_centerAddr_btspace = new JTextField();
		this.jPanel8 = new JPanel();
		this.jLabel36 = new JLabel();
		this.slider_chequeNumLen = new JSlider();
		this.jLabel51 = new JLabel();
		this.jLabel52 = new JLabel();
		this.slider_chequeNumHeg = new JSlider();
		this.lbl_chequeNum_len = new JTextField();
		this.lbl_chequeNum_heg = new JTextField();
		this.btn_alignmentDefault_position = new JButton();
		this.btn_setAligment = new JButton();
		this.btn_cancelPanel = new JButton();
		this.jPanel4 = new JPanel();
		this.jLabel24 = new JLabel();
		this.slider_AccNoLen = new JSlider();
		this.jLabel25 = new JLabel();
		this.jLabel26 = new JLabel();
		this.slider_AccNoHeg = new JSlider();
		this.lbl_AccNo_length = new JTextField();
		this.lbl_AccNo_height = new JTextField();
		this.jPanel5 = new JPanel();
		this.jLabel27 = new JLabel();
		this.slider_HolderNameLen = new JSlider();
		this.jLabel28 = new JLabel();
		this.jLabel29 = new JLabel();
		this.slider_HolderNameHeg = new JSlider();
		this.lbl_HolderName_length = new JTextField();
		this.lbl_HolderName_height = new JTextField();
		this.jPanel6 = new JPanel();
		this.jLabel30 = new JLabel();
		this.slider_OrganisationLen = new JSlider();
		this.jLabel31 = new JLabel();
		this.jLabel32 = new JLabel();
		this.slider_OrganisationHeg = new JSlider();
		this.lbl_Organisation_length = new JTextField();
		this.lbl_Organisation_height = new JTextField();
		this.jLabel37 = new JLabel();
		this.slider_OrganisationCharLen = new JSlider();
		this.lbl_Organisation_charLen = new JTextField();
		this.jPanel7 = new JPanel();
		this.jLabel33 = new JLabel();
		this.slider_AccountTypeLen = new JSlider();
		this.jLabel34 = new JLabel();
		this.jLabel35 = new JLabel();
		this.slider_AccountTypeHeg = new JSlider();
		this.lbl_AccountType_length = new JTextField();
		this.lbl_AccountType_height = new JTextField();

		setDefaultCloseOperation(3);
		setAutoRequestFocus(false);
		setUndecorated(true);

		this.jPanel1.setBackground(new Color(111, 166, 255));
		this.jPanel1.setBorder(BorderFactory.createBevelBorder(0));
		this.jPanel1.setForeground(new Color(255, 255, 255));
		this.jPanel1.setFont(new Font("Times New Roman", 0, 18));

		this.jPanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(42, 188, 217)));

		this.jLabel16.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel16.setForeground(new Color(255, 0, 0));
		this.jLabel16.setText("Side Address");

		this.slider_sideLength.setBackground(new Color(42, 188, 217));
		this.slider_sideLength.setFont(new Font("Times New Roman", 0, 12));
		this.slider_sideLength.setForeground(new Color(255, 51, 204));
		this.slider_sideLength.setMaximum(500);
		this.slider_sideLength.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_sideLengthStateChanged(evt);
			}

		});
		this.jLabel17.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel17.setForeground(new Color(153, 0, 0));
		this.jLabel17.setText("Left Align");

		this.jLabel18.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel18.setForeground(new Color(153, 0, 0));
		this.jLabel18.setText("Top Align");

		this.slider_sideHeigth.setBackground(new Color(42, 188, 217));
		this.slider_sideHeigth.setFont(new Font("Times New Roman", 0, 12));
		this.slider_sideHeigth.setForeground(new Color(255, 51, 204));
		this.slider_sideHeigth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_sideHeigthStateChanged(evt);
			}

		});
		this.jLabel19.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel19.setForeground(new Color(153, 0, 0));
		this.jLabel19.setText("Line Gap");

		this.slider_sideAddressGap.setBackground(new Color(42, 188, 217));
		this.slider_sideAddressGap.setFont(new Font("Times New Roman", 0, 12));
		this.slider_sideAddressGap.setForeground(new Color(255, 51, 204));
		this.slider_sideAddressGap.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_sideAddressGapStateChanged(evt);
			}

		});
		GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
		this.jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup().addComponent(this.jLabel17, -1, -1, 32767)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.slider_sideLength, -2, 148, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.lbl_sideaddress_length, -2, 43, -2))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(1, 1, 1)
										.addComponent(this.jLabel19, -2, 57, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.slider_sideAddressGap, -2, 148, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.lbl_sideaddress_btSpace, -2, 43, -2).addGap(0, 0, 32767))
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup().addComponent(this.jLabel18, -2, 58, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.slider_sideHeigth, -2, 0, 32767)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.lbl_sideaddress_height, -2, 43, -2)))
						.addContainerGap())
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767)
						.addComponent(this.jLabel16, -2, 111, -2).addGap(70, 70, 70)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel16, -2, 20, -2)
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jLabel17, -1, -1, 32767)
										.addComponent(this.slider_sideLength, -2, 17, -2))
								.addComponent(this.lbl_sideaddress_length, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_sideaddress_height, -2, -1, -2)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel18, -1, -1, 32767).addComponent(this.slider_sideHeigth,
												GroupLayout.Alignment.LEADING, -2, -1, -2)))
						.addGap(32, 32, 32)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabel19, -2, 25, -2)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.lbl_sideaddress_btSpace, -2, -1, -2)
										.addComponent(this.slider_sideAddressGap, -2, -1, -2)))
						.addGap(27, 27, 27)));

		this.jLabel15.setBackground(new Color(111, 166, 255));
		this.jLabel15.setFont(new Font("Arial", 0, 18));
		this.jLabel15.setForeground(new Color(255, 255, 255));
		this.jLabel15.setText("Alignment Settings");

		this.jPanel3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(42, 188, 217)));

		this.jLabel20.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel20.setForeground(new Color(255, 0, 0));
		this.jLabel20.setText("Center Address");

		this.slider_centerLen.setBackground(new Color(42, 188, 217));
		this.slider_centerLen.setFont(new Font("Times New Roman", 0, 12));
		this.slider_centerLen.setForeground(new Color(255, 51, 204));
		this.slider_centerLen.setMaximum(500);
		this.slider_centerLen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_centerLenStateChanged(evt);
			}

		});
		this.jLabel21.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel21.setForeground(new Color(153, 0, 0));
		this.jLabel21.setText("Left Align");

		this.jLabel22.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel22.setForeground(new Color(153, 0, 0));
		this.jLabel22.setText("Top Align");

		this.slider_centerHeg.setBackground(new Color(42, 188, 217));
		this.slider_centerHeg.setFont(new Font("Times New Roman", 0, 12));
		this.slider_centerHeg.setForeground(new Color(255, 51, 204));
		this.slider_centerHeg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_centerHegStateChanged(evt);
			}

		});
		this.jLabel23.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel23.setForeground(new Color(153, 0, 0));
		this.jLabel23.setText("Line Gap");

		this.slider_centerGap.setBackground(new Color(42, 188, 217));
		this.slider_centerGap.setFont(new Font("Times New Roman", 0, 12));
		this.slider_centerGap.setForeground(new Color(255, 51, 204));
		this.slider_centerGap.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_centerGapStateChanged(evt);
			}

		});
		GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
		this.jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jLabel21).addComponent(this.jLabel22, -1, 62, 32767))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.slider_centerLen, -1, 148, 32767)
										.addComponent(this.slider_centerHeg, -2, 0, 32767))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.lbl_centerAddr_length, -2, 43, -2)
										.addComponent(this.lbl_centerAddr_height, -2, 43, -2)))
						.addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel23, -2, 58, -2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.slider_centerGap, -2, 148, -2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.lbl_centerAddr_btspace, -2, 43, -2))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.jLabel20,
								-2, 122, -2)))
						.addContainerGap(22, 32767)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel20, -2, 20, -2)
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jLabel21, -1, -1, 32767)
										.addComponent(this.slider_centerLen, -2, 17, -2))
								.addComponent(this.lbl_centerAddr_length, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_centerAddr_height, -2, -1, -2)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel22, -1, -1, 32767)
										.addComponent(this.slider_centerHeg, -2, -1, -2)))
						.addGap(31, 31, 31)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabel23, -2, 25, -2)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.lbl_centerAddr_btspace, -2, -1, -2)
										.addComponent(this.slider_centerGap, -2, -1, -2)))
						.addGap(26, 26, 26)));

		this.jPanel8.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(42, 188, 217)));

		this.jLabel36.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel36.setForeground(new Color(255, 0, 0));
		this.jLabel36.setText("Cheque Number");

		this.slider_chequeNumLen.setBackground(new Color(42, 188, 217));
		this.slider_chequeNumLen.setFont(new Font("Times New Roman", 0, 12));
		this.slider_chequeNumLen.setForeground(new Color(255, 51, 204));
		this.slider_chequeNumLen.setMaximum(500);
		this.slider_chequeNumLen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_chequeNumLenStateChanged(evt);
			}

		});
		this.jLabel51.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel51.setForeground(new Color(153, 0, 0));
		this.jLabel51.setText("Left Align");

		this.jLabel52.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel52.setForeground(new Color(153, 0, 0));
		this.jLabel52.setText("Top Align");

		this.slider_chequeNumHeg.setBackground(new Color(42, 188, 217));
		this.slider_chequeNumHeg.setFont(new Font("Times New Roman", 0, 12));
		this.slider_chequeNumHeg.setForeground(new Color(255, 51, 204));
		this.slider_chequeNumHeg.setMaximum(500);
		this.slider_chequeNumHeg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_chequeNumHegStateChanged(evt);
			}

		});
		GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
		this.jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
						.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jLabel52, -2, 58, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.slider_chequeNumHeg, -2, 0, 32767)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.lbl_chequeNum_heg, -2, 43, -2))
								.addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout
										.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap(108, 32767)
												.addComponent(this.jLabel36)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
										.addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jLabel51)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.slider_chequeNumLen, -2, 0, 32767).addGap(4, 4, 4)))
										.addComponent(this.lbl_chequeNum_len, -2, 43, -2).addGap(2, 2, 2)))
						.addContainerGap()));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jLabel36, -2, 20, -2)
						.addGap(18, 18, 18)
						.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(this.jLabel51).addComponent(this.lbl_chequeNum_len, -2, -1, -2))
								.addComponent(this.slider_chequeNumLen, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767)
						.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_chequeNum_heg, -2, -1, -2)
								.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel52, -1, -1, 32767).addComponent(
												this.slider_chequeNumHeg, GroupLayout.Alignment.LEADING, -2, -1, -2)))
						.addGap(84, 84, 84)));
		this.btn_alignmentDefault_position.setBackground(new Color(255, 255, 255));
		this.btn_alignmentDefault_position.setFont(new Font("Times New Roman", 0, 18));
		this.btn_alignmentDefault_position.setForeground(new Color(111, 166, 255));
		this.btn_alignmentDefault_position.setText("Default");
		this.btn_alignmentDefault_position.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PositionAlignment_setting.this.btn_alignmentDefault_positionActionPerformed(evt);
			}

		});
		this.btn_setAligment.setBackground(new Color(255, 255, 255));
		this.btn_setAligment.setFont(new Font("Times New Roman", 0, 18));
		this.btn_setAligment.setForeground(new Color(111, 166, 255));
		this.btn_setAligment.setText("New Setting");
		this.btn_setAligment.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PositionAlignment_setting.this.btn_setAligmentActionPerformed(evt);
			}

		});
		this.btn_cancelPanel.setBackground(new Color(255, 255, 255));
		this.btn_cancelPanel.setFont(new Font("Times New Roman", 0, 18));
		this.btn_cancelPanel.setForeground(new Color(111, 166, 255));
		this.btn_cancelPanel.setText("Cancel");
		this.btn_cancelPanel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PositionAlignment_setting.this.btn_cancelPanelActionPerformed(evt);
			}

		});
		this.jPanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(42, 188, 217)));

		this.jLabel24.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel24.setForeground(new Color(255, 0, 0));
		this.jLabel24.setText("Account Number");

		this.slider_AccNoLen.setBackground(new Color(42, 188, 217));
		this.slider_AccNoLen.setFont(new Font("Times New Roman", 0, 12));
		this.slider_AccNoLen.setForeground(new Color(255, 51, 204));
		this.slider_AccNoLen.setMaximum(500);
		this.slider_AccNoLen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_AccNoLenStateChanged(evt);
			}

		});
		this.jLabel25.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel25.setForeground(new Color(153, 0, 0));
		this.jLabel25.setText("Left Align");

		this.jLabel26.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel26.setForeground(new Color(153, 0, 0));
		this.jLabel26.setText("Top Align");

		this.slider_AccNoHeg.setBackground(new Color(42, 188, 217));
		this.slider_AccNoHeg.setFont(new Font("Times New Roman", 0, 12));
		this.slider_AccNoHeg.setForeground(new Color(255, 51, 204));
		this.slider_AccNoHeg.setMaximum(500);
		this.slider_AccNoHeg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_AccNoHegStateChanged(evt);
			}

		});
		GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
		this.jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
								.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabel24, -2, 134, -2).addGroup(GroupLayout.Alignment.LEADING,
										jPanel4Layout.createSequentialGroup().addComponent(this.jLabel25)
												.addGap(10, 10, 10).addComponent(this.slider_AccNoLen, -2, 148, -2)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.lbl_AccNo_length, -2, 43, -2).addGap(0, 0, 32767))
						.addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel26, -2, 64, -2)
								.addGap(2, 2, 2).addComponent(this.slider_AccNoHeg, -2, 0, 32767)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.lbl_AccNo_height, -2, 43, -2)))
						.addContainerGap()));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel24, -2, 20, -2)
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jLabel25, -1, -1, 32767)
										.addComponent(this.slider_AccNoLen, -2, 17, -2))
								.addComponent(this.lbl_AccNo_length, -2, -1, -2))
						.addGap(27, 27, 27)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_AccNo_height, -2, -1, -2)
								.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel26, -1, -1, 32767)
										.addComponent(this.slider_AccNoHeg, -2, -1, -2)))
						.addContainerGap(-1, 32767)));
		this.jPanel5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(42, 188, 217)));

		this.jLabel27.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel27.setForeground(new Color(255, 0, 0));
		this.jLabel27.setText("Holder Name ");

		this.slider_HolderNameLen.setBackground(new Color(42, 188, 217));
		this.slider_HolderNameLen.setFont(new Font("Times New Roman", 0, 12));
		this.slider_HolderNameLen.setForeground(new Color(255, 51, 204));
		this.slider_HolderNameLen.setMaximum(500);
		this.slider_HolderNameLen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_HolderNameLenStateChanged(evt);
			}

		});
		this.jLabel28.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel28.setForeground(new Color(153, 0, 0));
		this.jLabel28.setText("Left Align");

		this.jLabel29.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel29.setForeground(new Color(153, 0, 0));
		this.jLabel29.setText("Top Align");

		this.slider_HolderNameHeg.setBackground(new Color(42, 188, 217));
		this.slider_HolderNameHeg.setFont(new Font("Times New Roman", 0, 12));
		this.slider_HolderNameHeg.setForeground(new Color(255, 51, 204));
		this.slider_HolderNameHeg.setMaximum(500);
		this.slider_HolderNameHeg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_HolderNameHegStateChanged(evt);
			}

		});
		GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
		this.jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel28)
												.addGap(10, 10, 10).addComponent(this.slider_HolderNameLen, -2, 148, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
										.addGroup(GroupLayout.Alignment.TRAILING,
												jPanel5Layout.createSequentialGroup().addComponent(this.jLabel27)
														.addGap(38, 38, 38)))
								.addComponent(this.lbl_HolderName_length, -2, 43, -2).addGap(0, 0, 32767))
						.addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel29, -2, 64, -2)
								.addGap(2, 2, 2).addComponent(this.slider_HolderNameHeg, -2, 0, 32767)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.lbl_HolderName_height, -2, 43, -2)))
						.addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel27, -2, 20, -2)
						.addGap(18, 18, 18)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jLabel28, -1, -1, 32767)
										.addComponent(this.slider_HolderNameLen, -2, 17, -2))
								.addComponent(this.lbl_HolderName_length, -2, -1, -2))
						.addGap(27, 27, 27)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_HolderName_height, -2, -1, -2)
								.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel29, -1, -1, 32767)
										.addComponent(this.slider_HolderNameHeg, -2, -1, -2)))
						.addContainerGap(-1, 32767)));

		this.jLabel30.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel30.setForeground(new Color(255, 0, 0));
		this.jLabel30.setText("Organisation");

		this.slider_OrganisationLen.setBackground(new Color(42, 188, 217));
		this.slider_OrganisationLen.setFont(new Font("Times New Roman", 0, 12));
		this.slider_OrganisationLen.setForeground(new Color(255, 51, 204));
		this.slider_OrganisationLen.setMaximum(500);
		this.slider_OrganisationLen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_OrganisationLenStateChanged(evt);
			}

		});
		this.jLabel31.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel31.setForeground(new Color(153, 0, 0));
		this.jLabel31.setText("Left Align");

		this.jLabel32.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel32.setForeground(new Color(153, 0, 0));
		this.jLabel32.setText("Top Align");

		this.slider_OrganisationHeg.setBackground(new Color(42, 188, 217));
		this.slider_OrganisationHeg.setFont(new Font("Times New Roman", 0, 12));
		this.slider_OrganisationHeg.setForeground(new Color(255, 51, 204));
		this.slider_OrganisationHeg.setMaximum(500);
		this.slider_OrganisationHeg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_OrganisationHegStateChanged(evt);
			}

		});
		this.jLabel37.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel37.setForeground(new Color(153, 0, 0));
		this.jLabel37.setText("Character");

		this.slider_OrganisationCharLen.setBackground(new Color(42, 188, 217));
		this.slider_OrganisationCharLen.setFont(new Font("Times New Roman", 0, 12));
		this.slider_OrganisationCharLen.setForeground(new Color(255, 51, 204));
		this.slider_OrganisationCharLen.setMaximum(500);
		this.slider_OrganisationCharLen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_OrganisationCharLenStateChanged(evt);
			}

		});
		GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
		this.jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel31)
										.addGap(10, 10, 10).addComponent(this.slider_OrganisationLen, -2, 148, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel6Layout.createSequentialGroup().addComponent(this.jLabel30).addGap(50, 50,
												50)))
								.addComponent(this.lbl_Organisation_length, -2, 43, -2).addGap(0, 0, 32767))
						.addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel32, -2, 64, -2)
								.addGap(2, 2, 2).addComponent(this.slider_OrganisationHeg, -2, 0, 32767)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.lbl_Organisation_height, -2, 43, -2))
						.addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel37, -2, 64, -2)
								.addGap(2, 2, 2).addComponent(this.slider_OrganisationCharLen, -2, 0, 32767)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.lbl_Organisation_charLen, -2, 43, -2)))
						.addContainerGap()));

		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel30, -2, 20, -2)
						.addGap(18, 18, 18)
						.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jLabel31, -1, -1, 32767)
										.addComponent(this.slider_OrganisationLen, -2, 17, -2))
								.addComponent(this.lbl_Organisation_length, -2, -1, -2))
						.addGap(27, 27, 27)
						.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_Organisation_height, -2, -1, -2)
								.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel32, -1, -1, 32767)
										.addComponent(this.slider_OrganisationHeg, -2, -1, -2)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767)
						.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_Organisation_charLen, -2, -1, -2)
								.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel37, -1, -1, 32767)
										.addComponent(this.slider_OrganisationCharLen, -2, -1, -2)))));
		this.jPanel7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(42, 188, 217)));

		this.jLabel33.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel33.setForeground(new Color(255, 0, 0));
		this.jLabel33.setText("Account Type");

		this.slider_AccountTypeLen.setBackground(new Color(42, 188, 217));
		this.slider_AccountTypeLen.setFont(new Font("Times New Roman", 0, 12));
		this.slider_AccountTypeLen.setForeground(new Color(255, 51, 204));
		this.slider_AccountTypeLen.setMaximum(500);
		this.slider_AccountTypeLen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_AccountTypeLenStateChanged(evt);
			}

		});
		this.jLabel34.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel34.setForeground(new Color(153, 0, 0));
		this.jLabel34.setText("Left Align");

		this.jLabel35.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel35.setForeground(new Color(153, 0, 0));
		this.jLabel35.setText("Top Align");

		this.slider_AccountTypeHeg.setBackground(new Color(42, 188, 217));
		this.slider_AccountTypeHeg.setFont(new Font("Times New Roman", 0, 12));
		this.slider_AccountTypeHeg.setForeground(new Color(255, 51, 204));
		this.slider_AccountTypeHeg.setMaximum(500);
		this.slider_AccountTypeHeg.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				PositionAlignment_setting.this.slider_AccountTypeHegStateChanged(evt);
			}

		});
		GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
		this.jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
						.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel34)
										.addGap(10, 10, 10).addComponent(this.slider_AccountTypeLen, -2, 148, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.lbl_AccountType_length, -2, 43, -2).addGap(0, 0, 32767))
								.addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel35, -2, 64, -2)
										.addGap(2, 2, 2).addComponent(this.slider_AccountTypeHeg, -2, 0, 32767)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.lbl_AccountType_height, -2, 43, -2)))
						.addContainerGap())
				.addGroup(jPanel7Layout.createSequentialGroup().addGap(79, 79, 79).addComponent(this.jLabel33)
						.addContainerGap(-1, 32767)));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel33, -2, 20, -2)
						.addGap(18, 18, 18)
						.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jLabel34, -1, -1, 32767)
										.addComponent(this.slider_AccountTypeLen, -2, 17, -2))
								.addComponent(this.lbl_AccountType_length, -2, -1, -2))
						.addGap(27, 27, 27)
						.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.lbl_AccountType_height, -2, -1, -2)
								.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel35, -1, -1, 32767)
										.addComponent(this.slider_AccountTypeHeg, -2, -1, -2)))
						.addContainerGap(-1, 32767)));
		GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel4, -2, 270, -2)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 114, 32767)
												.addComponent(this.jLabel15, -2, 160, -2).addGap(364, 364, 364))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18)
												.addComponent(this.jPanel5, -2, 270, -2).addContainerGap(-1, 32767))))
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18)
										.addComponent(this.jPanel3, -2, -1, -2).addGap(18, 28, 32767)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.jPanel6, -2, 270, -2)
												.addComponent(this.jPanel8, -2, -1, -2)))
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767)
												.addComponent(this.btn_alignmentDefault_position).addGap(18, 18, 18)
												.addComponent(this.btn_setAligment).addGap(18, 18, 18)
												.addComponent(this.btn_cancelPanel))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel7, -2, 270, -2)
										.addGap(0, 0, 32767)))
								.addContainerGap()))));

		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(this.jLabel15, -2, 30, -2).addGap(39, 39, 39)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jPanel2, -1, -1, 32767)
										.addComponent(this.jPanel3, -2, -1, -2))
								.addComponent(this.jPanel8, -2, -1, -2))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.jPanel6, -1, -1, 32767)
								.addComponent(this.jPanel4, -1, -1, 32767))
						.addGap(8, 8, 8).addComponent(this.jPanel7, -2, -1, -2).addGap(4, 4, 4)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.btn_cancelPanel).addComponent(this.btn_setAligment)
								.addComponent(this.btn_alignmentDefault_position))));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)));

		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)));
		pack();
		setLocationRelativeTo(null);
	}

	private void slider_AccNoHegStateChanged(ChangeEvent evt) {
		int length = this.slider_AccNoHeg.getValue();
		this.lbl_AccNo_height.setText("" + length);
	}

	private void slider_AccNoLenStateChanged(ChangeEvent evt) {
		int length = this.slider_AccNoLen.getValue();
		this.lbl_AccNo_length.setText("" + length);
	}

	private void btn_cancelPanelActionPerformed(ActionEvent evt) {
		try {
			dispose();
		} catch (Exception e) {
			System.out.println("Error on exit==" + e.getMessage());
		}
	}

	private void btn_setAligmentActionPerformed(ActionEvent evt) {
		try {
			int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Click Ok to Set New Aligment",
					"Alignment Setting", 0);
			if (confirm == 1) {
				return;
			}
			String home_path = System.getProperty("user.home");
			String Save_location = "\\Cheque_MICRPrinting\\alignment";
			File file = new File(home_path + Save_location);
			if (!file.exists()) {
				file.mkdirs();
			}
			String side_length = this.lbl_sideaddress_length.getText();
			String side_height = this.lbl_sideaddress_height.getText();
			String side_space = this.lbl_sideaddress_btSpace.getText();

			String center_length = this.lbl_centerAddr_length.getText();
			String center_height = this.lbl_centerAddr_height.getText();
			String center_space = this.lbl_centerAddr_btspace.getText();

			String chequeNum_len = this.lbl_chequeNum_len.getText();
			String chequeNum_heg = this.lbl_chequeNum_heg.getText();

			String AccNo_Len = this.lbl_AccNo_length.getText().trim();
			String AccNo_Heg = this.lbl_AccNo_height.getText().trim();

			String Organisation_Len = this.lbl_Organisation_length.getText().trim();
			String Organisation_Heg = this.lbl_Organisation_height.getText().trim();

			String HolderName_Len = this.lbl_HolderName_length.getText().trim();
			String HolderName_Heg = this.lbl_HolderName_height.getText().trim();

			String AccountType_Len = this.lbl_AccountType_length.getText().trim();
			String AccountType_Heg = this.lbl_AccountType_height.getText().trim();

			String orgCharLen = this.lbl_Organisation_charLen.getText().trim();

			aligment_position_serialize ali_ser = new aligment_position_serialize();
			ali_ser.setSd_Addr_leg11(side_length.trim());
			ali_ser.setSd_Addr_heg12(side_height.trim());
			ali_ser.setSd_Addr_spa13(side_space.trim());

			ali_ser.setCn_Addr_leg11(center_length.trim());
			ali_ser.setCn_Addr_heg12(center_height.trim());
			ali_ser.setCn_Addr_spa123(center_space.trim());

			ali_ser.setChquenum_img_leg11(chequeNum_len);
			ali_ser.setChequenum_img_heg12(chequeNum_heg);

			ali_ser.setChequenum_len11(chequeNum_len);
			ali_ser.setChequenum_heg12(chequeNum_heg);
			ali_ser.setOrgCharLen(orgCharLen);

			ali_ser.setChequenum_img2_len11("226");
			ali_ser.setChequenum_img2_heg12("226");

			ali_ser.setBankcode_9dig_len11("240");
			ali_ser.setBankcode_9dig_heg12("234");

			ali_ser.setBankcode_img_len11("325");
			ali_ser.setBankcode_img_heg12("226");

			ali_ser.setBankcode_6dig_len11("337");
			ali_ser.setBankcode_6dig_heg12("234");

			ali_ser.setBankcode_img2_len11("396");
			ali_ser.setBankcode_img2_heg12("226");

			ali_ser.setBankcode_2dig_len11("413");
			ali_ser.setBankcode_2dig_heg12("234");

			ali_ser.setAccNo_len(AccNo_Len);
			ali_ser.setAccNo_heg(AccNo_Heg);

			ali_ser.setAccOrganisationName_len(Organisation_Len);
			ali_ser.setAccOrganisationName_heg(Organisation_Heg);

			ali_ser.setAccHolderName_len(HolderName_Len);
			ali_ser.setAccHolderName_heg(HolderName_Heg);

			ali_ser.setAccountType_len(AccountType_Len);
			ali_ser.setAccountType_heg(AccountType_Heg);
			String file_location = home_path + Save_location;

			String filename = file_location + "\\Current_setting.txt";

			FileOutputStream fout = new FileOutputStream(filename);
			Throwable localThrowable2 = null;
			try {
				ObjectOutputStream obj_out = new ObjectOutputStream(fout);
				obj_out.writeObject(ali_ser);
				obj_out.close();
			} catch (Throwable localThrowable1) {
				localThrowable2 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (fout != null)
					if (localThrowable2 != null)
						try {
							fout.close();
						} catch (Throwable x2) {
							localThrowable2.addSuppressed(x2);
						}
					else
						fout.close();
			}
			javax.swing.JOptionPane.showMessageDialog(null, "Alignment Set Succesfully");
		} catch (java.awt.HeadlessException | java.io.IOException e) {
			System.out.println("Error on Aligment Set----" + e.getMessage());
		}
	}

	private void btn_alignmentDefault_positionActionPerformed(ActionEvent evt) {
		try {
			String user_home = System.getProperty("user.home");
			String alignment_file = user_home + "\\Cheque_MICRPrinting\\alignment";
			System.out.println(alignment_file);
			String filename = alignment_file + "\\position_default.txt";
			File file = new File(filename);
			if (!file.exists()) {
				javax.swing.JOptionPane.showMessageDialog(null, "File Not Found.. Can't be Update.");
			}

			FileInputStream fout = new FileInputStream(filename);
			Throwable localThrowable2 = null;
			ObjectInputStream obj_in = null;
			aligment_position_serialize ali_ser = null;
			try {
				obj_in = new ObjectInputStream(fout);
				ali_ser = (aligment_position_serialize) obj_in.readObject();
				obj_in.close();
			} catch (Throwable localThrowable1) {
				localThrowable2 = localThrowable1;
				throw localThrowable1;
			} finally {
				if (fout != null)
					if (localThrowable2 != null)
						try {
							fout.close();
						} catch (Throwable x2) {
							localThrowable2.addSuppressed(x2);
						}
					else
						fout.close();
			}

			String side_length = ali_ser.getSd_Addr_leg11();
			String side_height = ali_ser.getSd_Addr_heg12();
			String side_space = ali_ser.getSd_Addr_spa13();

			String center_length = ali_ser.getCn_Addr_leg11();
			String center_height = ali_ser.getCn_Addr_heg12();
			String center_space = ali_ser.getCn_Addr_spa123();

			String chequeNum_len = ali_ser.getChquenum_img_leg11();
			String chequeNum_heg = ali_ser.getChequenum_img_heg12();

			String AccNo_Len = ali_ser.getAccNo_len();
			String AccNo_Heg = ali_ser.getAccNo_heg();

			String HolderName_Len = ali_ser.getAccHolderName_len();
			String HolderName_Heg = ali_ser.getAccHolderName_heg();

			String Organisation_Len = ali_ser.getAccOrganisationName_len();
			String Organisation_Heg = ali_ser.getAccOrganisationName_heg();

			String AccountType_Len = ali_ser.getAccountType_len();
			String AccountType_Heg = ali_ser.getAccountType_heg();
			String OrgCharLen = ali_ser.getOrgCharLen();

			ali_ser = null;
			this.lbl_sideaddress_length.setText(side_length);
			this.slider_sideLength.setValue(Integer.parseInt(side_length));
			this.lbl_sideaddress_height.setText(side_height);
			this.slider_sideHeigth.setValue(Integer.parseInt(side_height));
			this.lbl_sideaddress_btSpace.setText(side_space);
			this.slider_sideAddressGap.setValue(Integer.parseInt(side_space));

			this.lbl_centerAddr_length.setText(center_length);
			this.lbl_centerAddr_height.setText(center_height);
			this.lbl_centerAddr_btspace.setText(center_space);
			this.slider_centerLen.setValue(Integer.parseInt(center_length));
			this.slider_centerHeg.setValue(Integer.parseInt(center_height));
			this.slider_centerGap.setValue(Integer.parseInt(center_space));

			this.lbl_chequeNum_len.setText(chequeNum_len);
			this.lbl_chequeNum_heg.setText(chequeNum_heg);
			this.slider_chequeNumLen.setValue(Integer.parseInt(chequeNum_len));
			this.slider_chequeNumHeg.setValue(Integer.parseInt(chequeNum_heg));

			this.lbl_AccNo_length.setText(AccNo_Len);
			this.lbl_AccNo_height.setText(AccNo_Heg);
			this.slider_AccNoLen.setValue(Integer.parseInt(AccNo_Len));
			this.slider_AccNoHeg.setValue(Integer.parseInt(AccNo_Heg));

			this.lbl_Organisation_length.setText(Organisation_Len);
			this.lbl_Organisation_height.setText(Organisation_Heg);
			this.slider_OrganisationLen.setValue(Integer.parseInt(Organisation_Len));
			this.slider_OrganisationHeg.setValue(Integer.parseInt(Organisation_Heg));

			this.lbl_HolderName_length.setText(HolderName_Len);
			this.lbl_HolderName_height.setText(HolderName_Heg);
			this.slider_HolderNameLen.setValue(Integer.parseInt(HolderName_Len));
			this.slider_HolderNameHeg.setValue(Integer.parseInt(HolderName_Heg));

			this.lbl_AccountType_length.setText(AccountType_Len);
			this.lbl_AccountType_height.setText(AccountType_Heg);
			this.slider_AccountTypeLen.setValue(Integer.parseInt(AccountType_Len));
			this.slider_AccountTypeHeg.setValue(Integer.parseInt(AccountType_Heg));
			this.slider_OrganisationCharLen.setValue(Integer.parseInt(OrgCharLen));
		} catch (java.awt.HeadlessException | java.io.IOException | ClassNotFoundException | NumberFormatException e) {
			System.out.println("ERRor on btn_alignmentDefault_positionActionPerformed==" + e.getMessage());
		}
	}

	private void slider_chequeNumHegStateChanged(ChangeEvent evt) {
		int cheque_num_heg = this.slider_chequeNumHeg.getValue();
		this.lbl_chequeNum_heg.setText("" + cheque_num_heg);
	}

	private void slider_chequeNumLenStateChanged(ChangeEvent evt) {
		int cheque_numLen = this.slider_chequeNumLen.getValue();
		this.lbl_chequeNum_len.setText("" + cheque_numLen);
	}

	private void slider_centerGapStateChanged(ChangeEvent evt) {
		int centerGap = this.slider_centerGap.getValue();
		this.lbl_centerAddr_btspace.setText("" + centerGap);
	}

	private void slider_centerHegStateChanged(ChangeEvent evt) {
		int centerHeg = this.slider_centerHeg.getValue();
		this.lbl_centerAddr_height.setText("" + centerHeg);
	}

	private void slider_centerLenStateChanged(ChangeEvent evt) {
		int centerLen = this.slider_centerLen.getValue();
		this.lbl_centerAddr_length.setText("" + centerLen);
	}

	private void slider_sideAddressGapStateChanged(ChangeEvent evt) {
		int sidegap = this.slider_sideAddressGap.getValue();
		this.lbl_sideaddress_btSpace.setText("" + sidegap);
	}

	private void slider_sideHeigthStateChanged(ChangeEvent evt) {
		int side_height = this.slider_sideHeigth.getValue();
		this.lbl_sideaddress_height.setText("" + side_height);
	}

	private void slider_sideLengthStateChanged(ChangeEvent evt) {
		int length = this.slider_sideLength.getValue();
		this.lbl_sideaddress_length.setText("" + length);
	}

	private void slider_HolderNameLenStateChanged(ChangeEvent evt) {
		int length = this.slider_HolderNameLen.getValue();
		this.lbl_HolderName_length.setText("" + length);
	}

	private void slider_HolderNameHegStateChanged(ChangeEvent evt) {
		int length = this.slider_HolderNameHeg.getValue();
		this.lbl_HolderName_height.setText("" + length);
	}

	private void slider_OrganisationLenStateChanged(ChangeEvent evt) {
		int length = this.slider_OrganisationLen.getValue();
		this.lbl_Organisation_length.setText("" + length);
	}

	private void slider_OrganisationHegStateChanged(ChangeEvent evt) {
		int length = this.slider_OrganisationHeg.getValue();
		this.lbl_Organisation_height.setText("" + length);
	}

	private void slider_AccountTypeLenStateChanged(ChangeEvent evt) {
		int length = this.slider_AccountTypeLen.getValue();
		this.lbl_AccountType_length.setText("" + length);
	}

	private void slider_AccountTypeHegStateChanged(ChangeEvent evt) {
		int length = this.slider_AccountTypeHeg.getValue();
		this.lbl_AccountType_height.setText("" + length);
	}

	private void slider_OrganisationCharLenStateChanged(ChangeEvent evt) {
		int length = this.slider_OrganisationCharLen.getValue();
		this.lbl_Organisation_charLen.setText("" + length);
	}

	/*
	 * public static void main(String[] args) { try { for
	 * (javax.swing.UIManager.LookAndFeelInfo info :
	 * UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName()))
	 * { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } }
	 * catch (ClassNotFoundException ex) {
	 * java.util.logging.Logger.getLogger(PositionAlignment_setting.class.getName())
	 * .log(java.util.logging.Level.SEVERE, null, ex); } catch
	 * (InstantiationException ex) {
	 * java.util.logging.Logger.getLogger(PositionAlignment_setting.class.getName())
	 * .log(java.util.logging.Level.SEVERE, null, ex); } catch
	 * (IllegalAccessException ex) {
	 * java.util.logging.Logger.getLogger(PositionAlignment_setting.class.getName())
	 * .log(java.util.logging.Level.SEVERE, null, ex); } catch
	 * (javax.swing.UnsupportedLookAndFeelException ex) {
	 * java.util.logging.Logger.getLogger(PositionAlignment_setting.class.getName())
	 * .log(java.util.logging.Level.SEVERE, null, ex); }
	 * 
	 * java.awt.EventQueue.invokeLater(new Runnable() { public void run() { new
	 * PositionAlignment_setting().setVisible(true); } }); }
	 */

}
