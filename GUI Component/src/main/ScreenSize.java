package main;
import java.awt.Toolkit;
import java.awt.Dimension;

public class ScreenSize {
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int getX() {  /*為甚麼別的資料夾可以直接調用，不是只能訪問靜態成員?*/
		return screenSize.width;
	}
	
	public static int getY() {
		return screenSize.height;
	}
}
