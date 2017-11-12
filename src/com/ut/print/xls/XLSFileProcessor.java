package com.ut.print.xls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ut.print.check.AbstractPage;
import com.ut.print.xls.XLSReader.ColumnNames;

public class XLSFileProcessor extends AbstractPage {

	/**
	 * 
	 */
	private static final Log log = LogFactory.getLog("XLSFileProcessor");
	private static final long serialVersionUID = 1L;
	public static final String DO_SELECT="Do Select";
	private JPanel contentPane;
	private JTextField selectedFileTxt;
	private File selectedFile = null;
	private JLabel messageLbl = null;
	private JTable table;
	private JScrollPane scrollPane = null;
	private Vector data = new Vector<>();
	private Vector header = new Vector<>();
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { XLSFileProcessor frame = new
	 * XLSFileProcessor(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
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
		panel.setPreferredSize(new Dimension(10, 535));
		panel.setBackground(new Color(111, 166, 255));
		contentPane.setBorder(BorderFactory.createBevelBorder(0));

		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Bulk Check Printing Using Excel File");
		lblNewLabel.setFont(new Font("Arial", 0, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		// lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.add(panel_4);

		JLabel lblNewLabel_1 = new JLabel("Select Your Input Excel File");
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_1.setFont(new Font("Arial", 0, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));

		selectedFileTxt = new JTextField();
		panel_4.add(selectedFileTxt);
		selectedFileTxt.setAlignmentY(Component.TOP_ALIGNMENT);
		selectedFileTxt.setEditable(false);
		selectedFileTxt.setColumns(30);

		JButton btnNewButton = new JButton("Select File");
		panel_4.add(btnNewButton);
		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setApproveButtonText("Upload");
				fileChooser.setDialogTitle("Select the File");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (fileChooser.getSelectedFile().isFile()) {
						selectedFile = fileChooser.getSelectedFile();
						selectedFileTxt.setText(selectedFile.getAbsolutePath());
						if (!isValidateFile(selectedFile)) {
							messageLbl.setText(
									"<html>Please select a .xls or .xlsx file to proceed..<br/> the selected file '"
											+ selectedFile.getName() + "' <br/>is not a valid file<html>");
							messageLbl.setForeground(new Color(255, 0, 0));
							return;
						}
						updateJDatable(selectedFile);
					}
				}

			}
		});
		// btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setFont(new Font("Times New Roman", 0, 18));
		btnNewButton.setForeground(new Color(111, 166, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel.add(panel_5);
		panel_5.setPreferredSize(new Dimension(800, 350));

		table = new JTable() {
			public TableCellEditor getCellEditor(int row, int column) {
				int modelColumn = convertColumnIndexToModel(column);

				if (row == 0)
					return new DefaultCellEditor(addDefaultOptions());
				else
					return super.getCellEditor(row, column);
			}
		};
		table.setRowHeight(50);
		table.setMinimumSize(new Dimension(2300, 340));
		table.setSize(new Dimension(2300, 340));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredSize(new Dimension(2300, 340));
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(table.getWidth(), 50));
		scrollPane = new JScrollPane(table);

		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setOpaque(true);
		scrollPane.setSize(new Dimension(800, 350));
		scrollPane.setPreferredSize(new Dimension(800, 350));

		panel_5.add(scrollPane);
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setBackground(new Color(111, 166, 255));
		panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3.setMinimumSize(new Dimension(100, 100));
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
					JTableReader reader = null;
					try {
						reader = new JTableReader(table);
						if (reader.isUploaded()) {
							((DefaultTableModel) table.getModel()).setRowCount(0);
							messageLbl.setText("Successfully uploaded.");
							messageLbl.setForeground(new Color(0, 250, 154));
						} else {
							messageLbl.setText(reader.getErrorMsg());
							messageLbl.setForeground(new Color(255, 0, 0));
						}
					} catch (Exception e1) {
						messageLbl.setText("Error occured-" + e1.getMessage());
						messageLbl.setForeground(new Color(255, 0, 0));
					}

				}
				selectedFileTxt.setText(null);
			}
		});
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewButton_1.setAlignmentY(Component.TOP_ALIGNMENT);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setBackground(new Color(111, 166, 255));
		panel_1.setPreferredSize(new Dimension(700, 50));

		messageLbl = new JLabel();
		messageLbl.setMinimumSize(new Dimension(400, 300));
		messageLbl.setSize(new Dimension(400, 300));
		messageLbl.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel_1.add(messageLbl);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new Print().setVisible(true);
				dispose();
			}
		});
	}

	protected void updateJDatable(File file) {
		fillData(file);
		model = new DefaultTableModel(data, header);
		table.setModel(model);
		for (int i = 0; i < header.size(); i++) {
			table.getColumnModel().getColumn(i).setMinWidth(150);
			table.getColumnModel().getColumn(i).setPreferredWidth(150);
			table.getColumnModel().getColumn(i).setMaxWidth(250);
		}
		Enumeration<TableColumn> enumeration = table.getColumnModel().getColumns();
		while (enumeration.hasMoreElements()) {
			TableColumn column = enumeration.nextElement();
			column.setPreferredWidth(150);
			column.setMaxWidth(250);
		}
	}

	private void fillData(File file) {
		XSSFWorkbook workbook = null;
		try {
			try {
				workbook = new XSSFWorkbook(new FileInputStream(file));
			} catch (IOException ex) {
				// log.
			}
			XSSFSheet sheet = workbook.getSheetAt(0);
			header.clear();
			data.clear();
			// dta
			Iterator<Row> rowIterator = sheet.rowIterator();
			Iterator<Cell> cellIterator;
			Row row;
			Cell cell;
			boolean headerCol = true;
			Vector excelDatas = null;
			while (rowIterator.hasNext()) {
				boolean allEmpty = true;
				row = rowIterator.next();
				cellIterator = row.cellIterator();
				excelDatas = new Vector<>();
				for (int i = 0; i < row.getLastCellNum(); i++) {
					cell = row.getCell(i);
					if (headerCol && (cell == null || cell.getCellTypeEnum() == CellType.BLANK
							|| cell.getCellTypeEnum() == CellType._NONE)) {
						continue;
					}
					if (cell == null) {
						excelDatas.add(null);
					} else if (cell.getCellTypeEnum().compareTo(CellType.STRING) == 0) {
						excelDatas.add(cell.getStringCellValue());
						allEmpty = false;
					} else if (cell.getCellTypeEnum().compareTo(CellType.BOOLEAN) == 0) {
						excelDatas.add(cell.getBooleanCellValue());
						allEmpty = false;
					} else if (cell.getCellTypeEnum().compareTo(CellType.NUMERIC) == 0) {
						excelDatas.add(((Double) cell.getNumericCellValue()).intValue());
						allEmpty = false;
					} else if (cell.getCellTypeEnum().compareTo(CellType.BLANK) == 0
							|| cell.getCellTypeEnum().compareTo(CellType._NONE) == 0) {
						excelDatas.add("");
					}
				}
				if (headerCol) {
					headerCol = false;
					if (!excelDatas.isEmpty() && !allEmpty) {
						header = excelDatas;
						Vector dummy = new Vector<>();
						for (Object obj : excelDatas) {
							dummy.add(DO_SELECT);
						}
						data.add(dummy);
					}
				} else {
					if (!excelDatas.isEmpty() && !allEmpty)
						data.add(excelDatas);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected boolean isValidateFile(File selectedFile) {
		if (selectedFile.getTotalSpace() == 0)
			return false;
		if (!selectedFile.canRead())
			return false;
		int lastIndex = selectedFile.getName().lastIndexOf(".");
		if (!selectedFile.getName().substring(lastIndex + 1).equalsIgnoreCase("xls")
				&& !selectedFile.getName().substring(lastIndex + 1).equalsIgnoreCase("xlsx"))
			return false;
		return true;
	}

	@Override
	protected void initPage() {
		// TODO Auto-generated method stub

	}

	protected JComboBox addDefaultOptions() {
		JComboBox defaultOptions = new JComboBox<>();
		defaultOptions.setFont(new Font("Times New Roman", 0, 12));
		defaultOptions.setForeground(new Color(102, 0, 102));
		ColumnNames[] columnNames = ColumnNames.values();
		String[] ColNames = new String[columnNames.length];
		for (int i = 0; i < columnNames.length; i++) {
			ColNames[i] = columnNames[i].getColValue();
		}
		Arrays.sort(ColNames);
		defaultOptions.setModel(new javax.swing.DefaultComboBoxModel(ColNames));
		return defaultOptions;
	}

}
