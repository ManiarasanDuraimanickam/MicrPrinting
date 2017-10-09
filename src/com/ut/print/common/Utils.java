package com.ut.print.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ut.print.check.aligment_position_serialize;

public class Utils {
	private static final Log LOG = LogFactory.getLog("Utils");
	private static List<BufferedImage> imageList;

	public static List<BufferedImage> getTitleImage() {
		try {
			if (null != imageList)
				return imageList;
			imageList = new ArrayList<>();
			imageList.add(javax.imageio.ImageIO.read(Utils.class.getResource("/iMAGE/Durkesh_Title.png")));
			return imageList;
		} catch (IOException e) {
			LOG.fatal("Error on TitleImage", e);
		}
		return null;
	}

	public static ImageIcon getImageIcon(String imageStr) {
		return new javax.swing.ImageIcon(Utils.class.getResource(imageStr));
	}

	public static java.net.URL getImageURLFromDefaultLocation(String imageStr) {
		return Utils.class.getResource("/iMAGE/" + imageStr);
	}

	public static java.net.URL getImageURL(String imageStr) {
		return Utils.class.getResource(imageStr);
	}

	public static aligment_position_serialize getAligment_Position_Serialize() {
		aligment_position_serialize ali_ser = new aligment_position_serialize();
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
				return null;
			}
			FileInputStream fout;
			if (file_cur.exists()) {
				fout = new FileInputStream(filename);
			} else {
				fout = new FileInputStream(file_default);
			}
			ObjectInputStream obj_in = new ObjectInputStream(fout);
			// Throwable localThrowable2 = null;
			ali_ser = ((aligment_position_serialize) obj_in.readObject());
			obj_in.close();
			fout.close();
		} catch (java.awt.HeadlessException | java.io.IOException | ClassNotFoundException ex) {
			LOG.error(ex);
		}
		return ali_ser;
	}

}
