package com.ut.print.check;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ut.print.ComponentFactory;
import com.ut.print.common.Utils;
import com.ut.print.dao.CommonJDBCRepo;

public class AddNewBank extends AbstractPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1729591447265010438L;

	private static final Log log = LogFactory.getLog(AddNewBank.class);

	private JButton BankDelete;

	private JButton Savebankdetail;

	private JButton backbtn;
	private JTextField bankcode6digits;
	private JTextField bankcode9digits;
	private JTextField bankname;
	private JComboBox banknamesforedit;
	private JButton btnupdate;
	private JTextField center1;
	private JTextField center2;
	private JTextField center3;
	private JTextField center4;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JLabel jLabel14;
	private JLabel jLabel15;
	private JLabel jLabel16;
	private JLabel jLabel17;
	private JLabel jLabel18;
	private JLabel jLabel19;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JTextField side1;
	private JTextField side2;
	private JTextField txtAccNo;
	private JTextField txtHolderName;
	private JTextField txtOrganisation;

	private CommonJDBCRepo commonJDBCRepo;

	private Print print;

	public AddNewBank() {
		initComponents();
		TitleImage();
	}

	@Override
	protected void initPage() {
		commonJDBCRepo = ComponentFactory.getBeanByType(CommonJDBCRepo.class);
		print = new Print();
		GetBankList();
	}

	public void TitleImage() {
		getRootPane().setWindowDecorationStyle(8);
		setIconImages(Utils.getTitleImage());
	}

	private void initComponents() {
		this.jPanel1 = new JPanel();
		this.jLabel2 = new JLabel();
		this.jLabel4 = new JLabel();
		this.jLabel5 = new JLabel();
		this.jLabel6 = new JLabel();
		this.jLabel7 = new JLabel();
		this.jLabel8 = new JLabel();
		this.side1 = new JTextField();
		this.bankname = new JTextField();
		this.center3 = new JTextField();
		this.side2 = new JTextField();
		this.center1 = new JTextField();
		this.center2 = new JTextField();
		this.jLabel9 = new JLabel();
		this.bankcode9digits = new JTextField();
		this.jLabel10 = new JLabel();
		this.bankcode6digits = new JTextField();
		this.banknamesforedit = new JComboBox();
		this.jPanel2 = new JPanel();
		this.Savebankdetail = new JButton();
		this.btnupdate = new JButton();
		this.BankDelete = new JButton();
		this.backbtn = new JButton();
		this.jLabel11 = new JLabel();
		this.jLabel12 = new JLabel();
		this.jLabel13 = new JLabel();
		this.jLabel14 = new JLabel();
		this.jLabel15 = new JLabel();
		this.center4 = new JTextField();
		this.jLabel16 = new JLabel();
		this.jLabel17 = new JLabel();
		this.jLabel18 = new JLabel();
		this.jLabel19 = new JLabel();
		this.txtAccNo = new JTextField();
		this.txtHolderName = new JTextField();
		this.txtOrganisation = new JTextField();

		setDefaultCloseOperation(2);
		setUndecorated(true);
		setPreferredSize(new java.awt.Dimension(600, 560));
		setResizable(false);

		this.jPanel1.setBackground(new Color(111, 166, 255));
		this.jPanel1.setForeground(new Color(255, 255, 255));
		this.jPanel1.setToolTipText("");

		this.jLabel2.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel2.setForeground(new Color(255, 255, 255));
		this.jLabel2.setText("Side-2");

		this.jLabel4.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel4.setForeground(new Color(255, 255, 255));
		this.jLabel4.setText("Bank Name");

		this.jLabel5.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel5.setForeground(new Color(255, 255, 255));
		this.jLabel5.setText("Side-1");

		this.jLabel6.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel6.setForeground(new Color(255, 255, 255));
		this.jLabel6.setText("Center -1");

		this.jLabel7.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel7.setForeground(new Color(255, 255, 255));
		this.jLabel7.setText("Center -2");

		this.jLabel8.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel8.setForeground(new Color(255, 255, 255));
		this.jLabel8.setText("Center -3");

		this.center1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddNewBank.this.center1ActionPerformed(evt);
			}

		});
		this.jLabel9.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel9.setForeground(new Color(255, 255, 255));
		this.jLabel9.setText("Bank code(9-digits)");

		this.jLabel10.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel10.setForeground(new Color(255, 255, 255));
		this.jLabel10.setText("Bank code(6-digits)");

		this.banknamesforedit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Bank Name" }));
		this.banknamesforedit.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				AddNewBank.this.banknamesforeditItemStateChanged(evt);
			}

		});
		this.jPanel2.setBackground(new Color(111, 166, 255));
		this.jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(0));
		this.jPanel2.setForeground(new Color(255, 255, 255));

		this.Savebankdetail.setBackground(new Color(153, 153, 153));
		this.Savebankdetail.setIcon(Utils.getImageIcon("/iMAGE/save.png"));
		this.Savebankdetail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddNewBank.this.SavebankdetailActionPerformed(evt);
			}

		});
		this.btnupdate.setIcon(Utils.getImageIcon("/iMAGE/48x48-update.png"));
		this.btnupdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddNewBank.this.btnupdateActionPerformed(evt);
			}

		});
		this.BankDelete.setIcon(Utils.getImageIcon("/iMAGE/Delete.png"));
		this.BankDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddNewBank.this.BankDeleteActionPerformed(evt);
			}

		});
		this.backbtn.setIcon(Utils.getImageIcon("/iMAGE/backImg.png"));
		this.backbtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddNewBank.this.backbtnActionPerformed(evt);
			}

		});
		this.jLabel11.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel11.setForeground(new Color(255, 255, 255));
		this.jLabel11.setText("Save");

		this.jLabel12.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel12.setForeground(new Color(255, 255, 255));
		this.jLabel12.setText("Update");

		this.jLabel13.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel13.setForeground(new Color(255, 255, 255));
		this.jLabel13.setText("Delete");

		this.jLabel14.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel14.setForeground(new Color(255, 255, 255));
		this.jLabel14.setText("Back");

		GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
		this.jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup().addGap(68, 68, 68)
												.addComponent(this.jLabel13).addGap(17, 17, 17))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(39, 39, 39)
										.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanel2Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(this.backbtn, -2, 92, -2)
														.addGroup(GroupLayout.Alignment.TRAILING,
																jPanel2Layout.createSequentialGroup().addGap(33, 33, 33)
																		.addComponent(this.jLabel14)
																		.addGap(22, 22, 22)))
												.addGroup(jPanel2Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addComponent(this.btnupdate, -1, 92, 32767)
														.addComponent(this.BankDelete, -1, -1, 32767)
														.addComponent(this.Savebankdetail, -1, -1, 32767)
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(23, 23, 23).addComponent(this.jLabel11))))))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(63, 63, 63).addComponent(this.jLabel12)))
						.addContainerGap(48, 32767)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel2Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.Savebankdetail, -2, 39, -2)
						.addGap(2, 2, 2).addComponent(this.jLabel11, -2, 20, -2).addGap(28, 28, 28)
						.addComponent(this.btnupdate, -2, 39, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel12, -2, 20, -2)
						.addGap(27, 27, 27).addComponent(this.BankDelete, -2, 39, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13, -2, 20, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767)
						.addComponent(this.backbtn, -2, 39, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jLabel14, -2, 20, -2).addContainerGap()));
		this.jLabel15.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel15.setForeground(new Color(255, 255, 255));
		this.jLabel15.setText("Center -4");

		this.center4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AddNewBank.this.center4ActionPerformed(evt);
			}

		});
		this.jLabel16.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel16.setForeground(new Color(255, 255, 255));
		this.jLabel16.setText("Select bank");

		this.jLabel17.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel17.setForeground(new Color(255, 255, 255));
		this.jLabel17.setText("Acc No.");

		this.jLabel18.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel18.setForeground(new Color(255, 255, 255));
		this.jLabel18.setText("Organization Name");

		this.jLabel19.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel19.setForeground(new Color(255, 255, 255));
		this.jLabel19.setText("Holder Name");

		GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(47, 47, 47)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jLabel8, -2, 86, -2).addComponent(this.jLabel7, -2, 86, -2)
								.addComponent(this.jLabel6, -2, 86, -2)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(this.jLabel4).addComponent(this.jLabel16))
								.addComponent(this.jLabel15, -2, 86, -2).addComponent(this.jLabel2, -2, 59, -2)
								.addComponent(this.jLabel9, -2, 150, -2).addComponent(this.jLabel10, -2, 150, -2)
								.addComponent(this.jLabel18).addComponent(this.jLabel19).addComponent(this.jLabel17)
								.addComponent(this.jLabel5, -2, 86, -2))
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 333, 32767)
										.addComponent(this.banknamesforedit, -2, 185, -2))
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767)
												.addGroup(jPanel1Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addComponent(this.txtOrganisation).addComponent(this.txtAccNo)
														.addComponent(this.center4).addComponent(this.center3)
														.addComponent(this.center2).addComponent(this.txtHolderName)
														.addComponent(this.center1, -1, 188, 32767)
														.addComponent(this.side2, -1, 188, 32767)
														.addComponent(this.side1, -1, 188, 32767)
														.addComponent(this.bankname))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 133, 32767))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(jPanel1Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addComponent(this.bankcode6digits, -1, 190, 32767)
														.addComponent(this.bankcode9digits))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)))
										.addComponent(this.jPanel2, -2, -1, -2)))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabel16).addComponent(this.banknamesforedit, -2, -1, -2))
						.addGap(11, 11, 11)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel4).addComponent(this.bankname, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel5, -2, 19, -2)
												.addComponent(this.side1, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel2).addComponent(this.side2, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel6).addComponent(this.center1, -2, -1, -2))
										.addGap(18, 18, 18)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.jLabel7).addComponent(this.center2, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel8).addComponent(this.center3, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel15).addComponent(this.center4, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel17).addComponent(this.txtAccNo, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel19)
												.addComponent(this.txtHolderName, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel18)
												.addComponent(this.txtOrganisation, -2, -1, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabel9)
												.addComponent(this.bankcode9digits, -2, -1, -2)))
								.addComponent(this.jPanel2, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel10).addComponent(this.bankcode6digits, -2, -1, -2))
						.addContainerGap(40, 32767)));
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2));

		pack();
		setLocationRelativeTo(null);
	}

	private void center1ActionPerformed(ActionEvent evt) {
	}

	private void GetBankList() {
		List<String> bankList = commonJDBCRepo.getBankList();
		for (String bank : bankList) {
			this.banknamesforedit.addItem(bank);
		}
	}

	private void SavebankdetailActionPerformed(ActionEvent evt) {
		try {
			String bank = this.bankname.getText();
			String side = this.side1.getText();
			String nextside = this.side2.getText();
			String center_first = this.center1.getText();
			String center_second = this.center2.getText();
			String center_third = this.center3.getText();
			String center_four = this.center4.getText().trim();
			String bank_9digits = this.bankcode9digits.getText();
			String bank_6digits = this.bankcode6digits.getText();
			String accno = this.txtAccNo.getText();
			String holdername = this.txtHolderName.getText();
			String orgname = this.txtOrganisation.getText();

			if (bank == null || (bank.length() != 0) || (!bank.equals("")))
				JOptionPane.showMessageDialog(null, "Fill the bank Name and then save");
			Map<String, Object> bankDetails = this.commonJDBCRepo.getBank(bank);

			if (bankDetails != null && bankDetails.size() > 0)
				JOptionPane.showMessageDialog(null, "BankName Already Used.Change the Name");
			boolean insertStatus = this.commonJDBCRepo.insertBankName(bank, side, nextside, center_first, center_second,
					center_third, bank_9digits, bank_6digits, center_four, accno, holdername, orgname);
			if (insertStatus)
				JOptionPane.showMessageDialog(null, "Successfully Updated");
			else
				JOptionPane.showMessageDialog(null, "Error Occured...! Please contact The Developer.");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error occured on Database,Please contact The Developer.");
			log.fatal("Error on data Insert-====" + e.getMessage(), e);
		}
	}

	private void backbtnActionPerformed(ActionEvent evt) {
		this.print.setVisible(true);
		dispose();
	}

	private void banknamesforeditItemStateChanged(java.awt.event.ItemEvent evt) {
		try {
			String bank_name = this.banknamesforedit.getSelectedItem().toString();

			if (bank_name.equals("Select Bank Name")) {
				this.bankname.setText("");
				this.side1.setText("");
				this.side2.setText("");
				this.center1.setText("");
				this.center2.setText("");
				this.center3.setText("");
				this.center4.setText("");
				this.bankcode9digits.setText("");
				this.bankcode6digits.setText("");
				this.txtAccNo.setText("");
				this.txtHolderName.setText("");
				this.txtOrganisation.setText("");
			} else {

				Map<String, Object> bankDetails = this.commonJDBCRepo.getBank(bank_name);
				this.bankname.setText((String) bankDetails.get("bankname"));
				this.side1.setText((String) bankDetails.get("side1"));
				this.side2.setText((String) bankDetails.get("side2"));
				this.center1.setText((String) bankDetails.get("center1"));
				this.center2.setText((String) bankDetails.get("center2"));
				this.center3.setText((String) bankDetails.get("center3"));
				this.center4.setText((String) bankDetails.get("center4"));
				this.bankcode9digits.setText((String) bankDetails.get("bankcode9digits"));
				this.bankcode6digits.setText((String) bankDetails.get("bankcode6digits"));
				this.txtAccNo.setText((String) bankDetails.get("AccNo"));
				this.txtHolderName.setText((String) bankDetails.get("AccHolderName"));
				this.txtOrganisation.setText((String) bankDetails.get("AccHolderOrg"));
			}
		} catch (Exception e) {
			log.fatal(e.getMessage(), e);
		}
	}

	private void btnupdateActionPerformed(ActionEvent evt) {
		try {
			String bank_name = this.banknamesforedit.getSelectedItem().toString();

			String bank = this.bankname.getText();
			String side = this.side1.getText();
			String nextside = this.side2.getText();
			String center_first = this.center1.getText();
			String center_second = this.center2.getText();
			String center_third = this.center3.getText();
			String bank_9digits = this.bankcode9digits.getText();
			String bank_6digits = this.bankcode6digits.getText();
			String center_four = this.center4.getText();
			String Accno = this.txtAccNo.getText();
			String HolderName = this.txtHolderName.getText();
			String OrganisationName = this.txtOrganisation.getText();

			Map<String, Object> bankDetails = this.commonJDBCRepo.getBank(bank);

			if (bankDetails != null && bankDetails.size() > 0) {
				boolean updateSts = this.commonJDBCRepo.updateBankdetailsByBankName(side, nextside, center_first,
						center_second, center_third, bank_9digits, bank_6digits, center_four, Accno, HolderName,
						OrganisationName, bank_6digits);
				if (updateSts)
					JOptionPane.showMessageDialog(null, "Successfully Updated");
				else
					JOptionPane.showMessageDialog(null,
							"Error Occured while updating bank details, Please contact the Developer.");
			} else {
				boolean updateSts = this.commonJDBCRepo.updateBankAlldetailsByOldBankName(bank, side, nextside,
						center_first, center_second, center_third, bank_9digits, bank_6digits, center_four, Accno,
						HolderName, OrganisationName, bank_name);
				if (updateSts)
					JOptionPane.showMessageDialog(null, "Successfully Updated");
				else
					JOptionPane.showMessageDialog(null,
							"Error Occured while updating bank details, Please contact the Developer.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check your Db Connection");
			System.out.println("Error on data Insert-====" + e.getMessage());
		}
	}

	private void BankDeleteActionPerformed(ActionEvent evt) {
		try {
			String bank = this.bankname.getText();
			boolean deleteStatus = this.commonJDBCRepo.deleteBankDetails(bank);
			if (deleteStatus)
				JOptionPane.showMessageDialog(null, "Successfully Updated");
			else
				JOptionPane.showMessageDialog(null,
						"Error Occured while delete the bank details, Please contact the Developer.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check your Db Connection");
			System.out.println("Error on data Insert-====" + e.getMessage());
		}
	}

	private void center4ActionPerformed(ActionEvent evt) {
	}

	/*
	 * public static void main(String[] args) { try { for
	 * (javax.swing.UIManager.LookAndFeelInfo info :
	 * UIManager.getInstalledLookAndFeels()) { if ("Nimbus".equals(info.getName()))
	 * { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } }
	 * catch (ClassNotFoundException ex) {
	 * java.util.logging.Logger.getLogger(AddNewBank.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); } catch (InstantiationException ex) {
	 * java.util.logging.Logger.getLogger(AddNewBank.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); } catch (IllegalAccessException ex) {
	 * java.util.logging.Logger.getLogger(AddNewBank.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); } catch
	 * (javax.swing.UnsupportedLookAndFeelException ex) {
	 * java.util.logging.Logger.getLogger(AddNewBank.class.getName()).log(java.util.
	 * logging.Level.SEVERE, null, ex); } java.awt.EventQueue.invokeLater(new
	 * Runnable() { public void run() { new AddNewBank().setVisible(true); } }); }
	 */

}