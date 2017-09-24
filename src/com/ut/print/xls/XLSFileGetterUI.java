package com.ut.print.xls;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.ut.print.check.Login;
import com.ut.print.common.Utils;

public class XLSFileGetterUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jLabel1;
	private JPanel jPanel1;

	public XLSFileGetterUI() {
		initComponents();
		TitleImage();
	}

	private void initComponents() {
		this.jPanel1 = new JPanel();
		this.jLabel1 = new JLabel();
		setTitle("LOGIN");
		setBackground(new Color(111, 166, 255));
		setCursor(new java.awt.Cursor(0));
		setFont(new Font("Times New Roman", 0, 14));
		setForeground(new Color(1, 78, 127));
		setUndecorated(true);
		setResizable(false);

		this.jPanel1.setBackground(new Color(111, 166, 255));
		this.jPanel1.setForeground(new Color(1, 78, 127));
		this.jPanel1.setToolTipText("Enter Username and Password");
		this.jPanel1.setFocusCycleRoot(true);
		this.jPanel1.setFont(new Font("Times New Roman", 0, 14));
		this.jPanel1.setName("");

		this.jLabel1.setFont(new Font("Times New Roman", 0, 22));
		this.jLabel1.setForeground(new Color(255, 255, 255));
		this.jLabel1.setText("Login");
		this.jLabel1.setToolTipText("Enter Username");
		GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel3)
								.addGap(137, 137, 137))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(97, 97, 97)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jLabel6).addComponent(this.jLabel5).addComponent(this.jLabel1, -2,
										61, -2))
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33)
										.addComponent(this.btnLogin).addGap(35, 35, 35).addComponent(this.btnClose))
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup().addGap(21, 21, 21)
												.addGroup(jPanel1Layout
														.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addComponent(this.txtUsername, -1, 178, 32767)
														.addComponent(this.txtPassword))))
						.addContainerGap(-1, 32767))
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)
										.addComponent(this.jLabel4, -1, -1, 32767))
								.addContainerGap()));

		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(this.jLabel3).addGap(30, 30, 30).addComponent(this.jLabel1)
								.addGap(21, 21, 21)
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5)
												.addGap(35, 35, 35).addComponent(this.jLabel6).addGap(20, 20, 20))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(this.txtUsername, -2, 33, -2).addGap(18, 18,
														18)
												.addComponent(this.txtPassword, -2, 31, -2).addGap(18, 18, 18)))
								.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.btnLogin).addComponent(this.btnClose))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, 32767)
								.addComponent(this.jLabel4, -2, 27, -2)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1,
				GroupLayout.Alignment.TRAILING, -2, 492, 32767));

		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));

		pack();
		setLocationRelativeTo(null);
	}

	public void TitleImage() {
		getRootPane().setWindowDecorationStyle(8);
		setIconImages(Utils.getTitleImage());

	}

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new XLSFileGetterUI().setVisible(true);
			}
		});
	}

}
