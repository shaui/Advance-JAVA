package main;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Size {
	
	private static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int getX() {
		return size.width;
	}
	
	public static int getX_Scale(int i) {
		return i*size.width/1920;
	}
	
	public static int getY() {
		return size.height;
	}
	
	public static int getY_Scale(int i) {
		return i*size.height/1080;
	}
}
