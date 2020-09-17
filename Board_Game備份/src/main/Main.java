package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import component.base.GameFrame;
import component.card.*;

public class Main{
	
	private static GameFrame f = new GameFrame();
	private static Language l = new Language();

	public static void main(String[] args) {
		f.setVisible(true);
	}
	
	public static String getName(Card type) {
		return l.getLanguage(type)[0];
	}
	
	public static String getInfo(Card type) {
		return l.getLanguage(type)[1];
	}
	
	public static String getNumber(Card type) {
		return l.getLanguage(type)[2];
	}
	
	public static String getMoney(Card type) {
		return l.getLanguage(type)[3];
	}
	
	public static Image ColorToGray(Image i) {
		BufferedImage bi = (BufferedImage) i;
		int width = bi.getWidth(), height = bi.getHeight();
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height;y++) {
				Color color = new Color(bi.getRGB(x, y));
				int R = color.getRed(), G = color.getGreen(), B = color.getBlue();
				int gray = (int) (0.299*R+0.587*G+0.114*B);
				Color grayColor = new Color(gray, gray, gray);
				bi.setRGB(x, y, grayColor.getRGB());
			}
		}
		return bi;
	}
	
	public static void drawStringAtCenter(Graphics g, String s, int x, int y) {
		int i = getStringHalfWidth(g, s);
		g.drawString(s, Size.getX_Scale(x)-i, Size.getY_Scale(y));
	}
	
	public static int getStringHalfWidth(Graphics g, String s) {
		return (int) g.getFontMetrics().getStringBounds(s, g).getWidth()/2;
	}
}
