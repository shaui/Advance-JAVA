/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;

import javax.swing.JPanel;

/*小畫家上排工具列*/
public class Tool_Panel extends JPanel{

	public Tool_Panel()
	{	
		/*加入至工具列的原件*/
		add(new Paint_Tool_Panel());
		add(new Brush_Size_Panel());
		add(new Filler_Panel());
		add(new Btn_Panel());
	}
}
