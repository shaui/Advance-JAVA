/*資管2B_106403540_陳志剛*/
package call_order;

import java.awt.Toolkit;
import java.awt.Dimension;

/*客製化取得螢幕大小*/
public class ScreenSize {
	
	/*取得螢幕大小的class*/
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/*取得X座標*/
	public static int getX() {  /*為甚麼別的資料夾可以直接調用，不是只能訪問靜態成員?*/
		return screenSize.width;
	}
	
	/*取的Y座標*/
	public static int getY() {
		return screenSize.height;
	}
}
