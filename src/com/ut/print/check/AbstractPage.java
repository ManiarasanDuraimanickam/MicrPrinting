package com.ut.print.check;

public abstract class AbstractPage extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected abstract void initPage();

	public void setVisible(boolean b) {
		super.setVisible(b);
		initPage();
	}

}
