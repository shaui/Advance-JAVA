/*���2B_106403540_���ӭ�*/
package gui_Lab_Painter;

import java.awt.BorderLayout;
import java.awt.Image;



import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*����ج[*/
public class Painter_Frame extends JFrame{
	
	private Icon show_icon;
	
	
	public Painter_Frame()
	{
		/*�򥻳]�m*/
		setTitle("�p�e�a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,640);
		
		/*��Frame�m��*/
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);	

		/*�[�J�u��C�Mø�ϰ�*/
		add(new Tool_Panel(), BorderLayout.NORTH);
		add(new PaintPanel());
		
		setVisible(true);
		
		/*Ū��Dialog��Icon*/
		show_icon = new ImageIcon(getClass().getResource("java-icon.png"));
		
		/*�Ȼs��Icon�j�p*/
		( (ImageIcon)show_icon ).setImage( ( (ImageIcon)show_icon ).getImage().getScaledInstance(40,50,Image.SCALE_DEFAULT) );
		
		/*���XDialog����*/
		JOptionPane.showMessageDialog(null, "Wellcome", "�T��", JOptionPane.PLAIN_MESSAGE ,show_icon);
		
	}

}