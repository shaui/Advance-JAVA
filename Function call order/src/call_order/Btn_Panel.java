/*資管2B_106403540_陳志剛*/
package call_order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*景色按鈕*/
public class Btn_Panel extends JPanel{

	private JButton foreground;
	private JButton background;
	public static JButton clear;
	private JButton eraser;
	private String[] btn_name = {"前景色","背景色","清除畫面","橡皮擦"};
	public static String state = "";
	
	public Btn_Panel()
	{

		/*3個按鈕*/
		foreground = new JButton(btn_name[0]);
		background = new JButton(btn_name[1]);
		clear = new JButton(btn_name[2]);
		eraser = new JButton(btn_name[3]);
		
		BtnActionLis BtnLis = new BtnActionLis();
		
		/*加入監聽器*/
		foreground.addActionListener(BtnLis);
		background.addActionListener(BtnLis);
		clear.addActionListener(BtnLis);
		eraser.addActionListener(BtnLis);
		
		/*加入至Panel*/
		add(foreground);
		add(background);
		add(clear);
		add(eraser);
	}
	
	private class BtnActionLis implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.err.println("點選 " + e.getActionCommand());
			String last_state = state; //check last time whether is eraser
			
			state = e.getActionCommand();
			
			if(state == "清除畫面") {
				System.err.println(state);
				Painter_Frame.paint_pane.repaint(); //clear the pane
			}
			
			if(last_state == "橡皮擦") {
				System.err.println(123);
				state = ""; //close the eraser effect
			}
			
			
			
			
			
		}
		
	}
}
