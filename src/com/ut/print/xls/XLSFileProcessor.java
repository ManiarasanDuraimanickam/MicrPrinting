package com.ut.print.xls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.ut.print.check.AbstractPage;
import com.ut.print.check.Print;
import java.awt.Insets;

public class XLSFileProcessor extends AbstractPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField selectedFileTxt;
	private File selectedFile = null;
	private JLabel messageLbl = null;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XLSFileProcessor frame = new XLSFileProcessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */
	/**
	 * Create the frame.
	 */
	public XLSFileProcessor() {
		setTitle("File Upload");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(2);
		setUndecorated(true);
		setPreferredSize(new java.awt.Dimension(600, 560));
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(111, 166, 255));
		contentPane.setBorder(BorderFactory.createBevelBorder(0));

		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Bulk Micr Number Generation Using Excel File");
		lblNewLabel.setFont(new Font("Arial", 0, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		//lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		JFileChooser fileChooser = new JFileChooser();

		// panel_1.add(fileChooser);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(111, 166, 255));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setVgap(50);
		flowLayout.setHgap(50);
		contentPane.add(panel_2, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(111, 166, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(37);
		flowLayout_1.setHgap(50);
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setPreferredSize(new Dimension(800, 100));
		panel_2.add(panel_4);

		JLabel lblNewLabel_1 = new JLabel("Select Your Input Excel File");
		lblNewLabel_1.setFont(new Font("Arial", 0, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));

		selectedFileTxt = new JTextField();
		panel_4.add(selectedFileTxt);
		selectedFileTxt.setEditable(false);
		selectedFileTxt.setColumns(30);

		JButton btnNewButton = new JButton("Select File");
		panel_4.add(btnNewButton);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fileChooser.setApproveButtonText("Upload");
				fileChooser.setDialogTitle("Select the File");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (fileChooser.getSelectedFile().isFile()) {
						selectedFile = fileChooser.getSelectedFile();
						selectedFileTxt.setText(selectedFile.getAbsolutePath());
					}
				}

			}
		});
		//btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setFont(new Font("Times New Roman", 0, 18));
		btnNewButton.setForeground(new Color(111, 166, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(111, 166, 255));
		panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3.setPreferredSize(new Dimension(200, 100));
		panel_3.setMinimumSize(new Dimension(100, 100));
		panel_2.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 3));
		JButton btnBack = new JButton("Back");
		btnBack.setAlignmentY(0.0f);
		btnBack.setHorizontalAlignment(SwingConstants.LEADING);
		btnBack.setFont(new Font("Times New Roman", 0, 18));
		btnBack.setForeground(new Color(111, 166, 255));
		btnBack.setBackground(new Color(255, 255, 255));
		panel_3.add(btnBack);
		
				JButton btnNewButton_1 = new JButton("Upload");
				panel_3.add(btnNewButton_1);
				btnNewButton_1.setFont(new Font("Times New Roman", 0, 18));
				btnNewButton_1.setForeground(new Color(111, 166, 255));
				btnNewButton_1.setBackground(new Color(255, 255, 255));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(contentPane, "Do you want to proceed?.", "Confirm",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							if (selectedFile == null) {
								messageLbl.setText("Please select the file and then upload.");
								messageLbl.setForeground(new Color(255, 0, 0));
								return;
							}
							XLSReader reader = null;
							try {
								if(!isValidateFile(selectedFile)) {
									messageLbl.setText("<html>Please select a .xls or .xlsx file to proceed..<br/> the selected file '"+selectedFile.getName()+"' <br/>is not a valid file<html>");
									messageLbl.setForeground(new Color(255, 0, 0));
									return;
								}
								reader = new XLSReader(selectedFile);
								selectedFile = null;
								if (reader.isUploaded()) {
									messageLbl.setText("Successfully uploaded.");
									messageLbl.setForeground(new Color(0, 250, 154));
								}
							} catch (IOException e1) {
								messageLbl.setText("Error occured while upload a file" + e1.getMessage());
								messageLbl.setForeground(new Color(255, 0, 0));
							}

						}
						selectedFileTxt.setText(null);
					}
				});
				btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
				btnNewButton_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				btnNewButton_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//new Print().setVisible(true);
				dispose();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(111, 166, 255));
		panel_1.setPreferredSize(new Dimension(700, 100));
		panel_2.add(panel_1);

		messageLbl = new JLabel("");
		messageLbl.setMinimumSize(new Dimension(400, 200));
		messageLbl.setSize(new Dimension(400, 200));
		messageLbl.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel_1.add(messageLbl);
	}

	protected boolean isValidateFile(File selectedFile) {
		if(selectedFile.getTotalSpace()==0) return false;
		if(!selectedFile.canRead())return false;
		int lastIndex=selectedFile.getName().lastIndexOf(".");
		if(!selectedFile.getName().substring(lastIndex+1).equalsIgnoreCase("xls") && !selectedFile.getName().substring(lastIndex+1).equalsIgnoreCase("xlsx"))return false;
		return true;
	}

	@Override
	protected void initPage() {
		// TODO Auto-generated method stub
		
	}

}
