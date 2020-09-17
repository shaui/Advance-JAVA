/*資管2B_106403540_陳志剛*/
package HW1_106403540_陳志剛;

import java.awt.BorderLayout;
import java.awt.Image;



import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*整體框架*/
public class Painter_Frame extends JFrame{
	
	private Icon show_icon;
	
	
	public Painter_Frame()
	{
		/*基本設置*/
		setTitle("小畫家");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,640);
		
		/*把Frame置中*/
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);	

		/*加入工具列和繪圖區*/
		add(new Tool_Panel(), BorderLayout.NORTH);
		add(new PaintPanel());
		
		setVisible(true);
		
		/*讀取Dialog的Icon*/
		show_icon = new ImageIcon(getClass().getResource("java-icon.png"));
		
		/*客製化Icon大小*/
		( (ImageIcon)show_icon ).setImage( ( (ImageIcon)show_icon ).getImage().getScaledInstance(40,50,Image.SCALE_DEFAULT) );
		
		/*跳出Dialog視窗*/
		JOptionPane.showMessageDialog(null, "Wellcome", "訊息", JOptionPane.PLAIN_MESSAGE ,show_icon);
		
	}

}