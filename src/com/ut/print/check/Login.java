package com.ut.print.check;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ut.print.ApplicationConfig;
import com.ut.print.ComponentFactory;
import com.ut.print.common.Utils;
import com.ut.print.dao.CommonJDBCRepo;

@Repository
// @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Login extends AbstractPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(Login.class.getName());

	private JButton btnClose;
	private JButton btnLogin;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JPanel jPanel1;
	private JPasswordField txtPassword;
	private JTextField txtUsername;

	private CommonJDBCRepo commonJDBCRepo;

	public Login() {

		initComponents();
		TitleImage();

	}

	@Override
	protected void initPage() {
		commonJDBCRepo = ComponentFactory.getBeanByType(CommonJDBCRepo.class);
		/*
		 * initComponents(); TitleImage();
		 */
	}

	private void initComponents() {
		this.jPanel1 = new JPanel();
		this.jLabel1 = new JLabel();
		this.jLabel2 = new JLabel();
		this.jLabel3 = new JLabel();
		this.jLabel4 = new JLabel();
		this.jLabel5 = new JLabel();
		this.jLabel6 = new JLabel();
		this.txtUsername = new JTextField();
		this.btnLogin = new JButton();
		this.btnClose = new JButton();
		this.txtPassword = new JPasswordField();

		setDefaultCloseOperation(3);
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

		this.jLabel2.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iMAGE/specific.png")));

		this.jLabel3.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel3.setForeground(new Color(248, 248, 248));
		this.jLabel3.setText("Welcome To Cheque Print");
		this.jLabel3.setToolTipText("Greeting");

		this.jLabel4.setFont(new Font("Times New Roman", 0, 14));
		this.jLabel4.setForeground(new Color(1, 78, 127));
		this.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iMAGE/login_footer.png")));
		this.jLabel4.setToolTipText("Enter Username");

		this.jLabel5.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel5.setForeground(new Color(255, 255, 255));
		this.jLabel5.setText("Username");

		this.jLabel6.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel6.setForeground(new Color(255, 255, 255));
		this.jLabel6.setText("Password");

		this.btnLogin.setBackground(new Color(255, 255, 255));
		this.btnLogin.setFont(new Font("Times New Roman", 0, 18));
		this.btnLogin.setForeground(new Color(111, 166, 255));
		this.btnLogin.setText("Login");
		this.btnLogin.setToolTipText("Click Here");
		this.btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Login.this.btnLoginActionPerformed(evt);
			}

		});
		this.btnClose.setBackground(new Color(255, 255, 255));
		this.btnClose.setFont(new Font("Times New Roman", 0, 18));
		this.btnClose.setForeground(new Color(111, 166, 255));
		this.btnClose.setText("Close");
		this.btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Login.this.btnCloseActionPerformed(evt);
			}

		});
		this.txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				Login.this.txtPasswordKeyPressed(evt);
			}

		});
		GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel3)
								.addGap(137, 137, 137))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(97, 97, 97)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jLabel6).addComponent(this.jLabel5)
								.addComponent(this.jLabel1, -2, 61, -2))
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
												.addComponent(this.txtUsername, -2, 33, -2).addGap(18, 18, 18)
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

	private void btnCloseActionPerformed(ActionEvent evt) {
		log.info("Application Closed.");
		System.exit(0);
	}

	private void btnLoginActionPerformed(ActionEvent evt) {
		String userid = this.txtUsername.getText();
		String pass = new String(this.txtPassword.getPassword());
		CheckCredential(userid, pass);
	}

	private void txtPasswordKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == 10) {
			String userid = this.txtUsername.getText();
			String pass = new String(this.txtPassword.getPassword());
			CheckCredential(userid, pass);

		}
	}

	public void CheckCredential(String userid, String pass) {

		boolean isValideCredential = this.commonJDBCRepo.validateCredential(userid, pass);
		if (isValideCredential) {
			new Print().setVisible(true);
			dispose();
		} else {
			javax.swing.JOptionPane.showMessageDialog(null, "Wrong Username or Password..!");
		}

	}

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			log.error(null, ex);
		}
		ApplicationContext context = (ApplicationContext) new AnnotationConfigApplicationContext(
				ApplicationConfig.class);
		ComponentFactory.setContextComponent(context);
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}
}