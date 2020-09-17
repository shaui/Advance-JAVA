/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*景色按鈕*/
public class Btn_Panel extends JPanel{

	private JButton foreground;
	private JButton background;
	private JButton clear;
	private String[] btn_name = {"前景色","背景色","清除畫面"};
	
	public Btn_Panel()
	{

		/*3個按鈕*/
		foreground = new JButton(btn_name[0]);
		background = new JButton(btn_name[1]);
		clear = new JButton(btn_name[2]);
		
		BtnActionLis BtnLis = new BtnActionLis();
		
		/*加入監聽器*/
		foreground.addActionListener(BtnLis);
		background.addActionListener(BtnLis);
		clear.addActionListener(BtnLis);
		
		/*加入至Panel*/
		add(foreground);
		add(background);
		add(clear);
	}
	
	private class BtnActionLis implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("點選 " + e.getActionCommand());	
		}
		
	}
}
