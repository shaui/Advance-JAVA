package main;
import java.awt.Toolkit;
import java.awt.Dimension;

public class ScreenSize {
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int getX() {  /*���ƻ�O����Ƨ��i�H�����եΡA���O�u��X���R�A����?*/
		return screenSize.width;
	}
	
	public static int getY() {
		return screenSize.height;
	}
}
