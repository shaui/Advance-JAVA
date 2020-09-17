package btn_setRollerIcon;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import MyFrame.MyFrame;

public class BtnFrame extends MyFrame{

	JButton btn;
	
	public BtnFrame() {
		
		Icon icon1 = new ImageIcon(getClass().getResource("img1.jpg"));
		Icon icon2 = new ImageIcon(getClass().getResource("img2.jpg"));
		
		btn = new JButton("Btn",icon1);
		btn.setRolloverIcon(icon2);
		
		add(btn);
		setVisible(true);
	}
}
