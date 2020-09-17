/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/*set the button*/
public class Btn_Panel extends JPanel{

	//the button data
	private JButton foreground;
	private JButton background;
	public static JButton clear;
	private JButton eraser;
	
	//the button text
	private String[] btn_name = {"前景色","背景色","清除畫面","橡皮擦"};
	
	//the button state
	public static String state = "";
	
	//the color data
	public static Color fg_color;
	public static Color bg_color;
	
	public Btn_Panel()
	{
		/*set the button*/
		foreground = new JButton(btn_name[0]);
		background = new JButton(btn_name[1]);
		clear = new JButton(btn_name[2]);
		eraser = new JButton(btn_name[3]);
		
		BtnActionLis BtnLis = new BtnActionLis();
		
		
		/*add the Listener*/
		foreground.addActionListener(new FgActListener());
		background.addActionListener(new BgActListener());
		clear.addActionListener(BtnLis);
		eraser.addActionListener(BtnLis);
		
		/*add to Panel*/
		add(foreground);
		add(background);
		add(clear);
		add(eraser);
	}
	
	private class BtnActionLis implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String last_state = state; //check last time whether is eraser
			state = e.getActionCommand();
			
			if(state == "清除畫面") {
				Painter_Frame.paint_pane.repaint(); //clear the pane
			}
			
			//Because the last time is eraser, close the eraser effect
			else if(last_state == "橡皮擦") { 
				state = ""; //close the eraser effect
			}	
			
			if(state == "橡皮擦") {
				eraser.setBackground(Color.LIGHT_GRAY);
			}
			else {
				eraser.setBackground(null);
			}
		}	
	}
	private class FgActListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			fg_color = JColorChooser.showDialog(foreground, "Choose the foreground color", fg_color);
			
		}	
	}
	
	private class BgActListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			bg_color = JColorChooser.showDialog(background, "Choose the background color", bg_color);
			
		}	
	}
}
