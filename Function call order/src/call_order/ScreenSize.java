/*���2B_106403540_���ӭ�*/
package call_order;

import java.awt.Toolkit;
import java.awt.Dimension;

/*�Ȼs�ƨ��o�ù��j�p*/
public class ScreenSize {
	
	/*���o�ù��j�p��class*/
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	/*���oX�y��*/
	public static int getX() {  /*���ƻ�O����Ƨ��i�H�����եΡA���O�u��X���R�A����?*/
		return screenSize.width;
	}
	
	/*����Y�y��*/
	public static int getY() {
		return screenSize.height;
	}
}
