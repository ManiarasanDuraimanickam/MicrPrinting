package com.ut.print.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ut.print.check.Print;

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
		return Utils.class.getResource("/iMAGE/"+imageStr);
	}
	public static java.net.URL getImageURL(String imageStr) {
		return Utils.class.getResource(imageStr);
	}

}
