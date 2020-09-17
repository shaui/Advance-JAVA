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
	public static PaintPanel paint_pane;;
	Tool_Panel tool_list;
	Btn_Panel btn;
	
	public Painter_Frame()
	{
		/*�򥻳]�m*/
		setTitle("�p�e�a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,640);
		
		/*��Frame�m��*/
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);	
		
		tool_list = new Tool_Panel();
		btn = new Btn_Panel();
		tool_list.add(btn);
		paint_pane = new PaintPanel();

		/*�[�J�u��C�Mø�ϰ�*/
		add(tool_list, BorderLayout.NORTH);
		add(paint_pane);
		
		setVisible(true);
		
		/*Ū��Dialog��Icon*/
		show_icon = new ImageIcon(getClass().getResource("java-icon.png"));
		
		/*�Ȼs��Icon�j�p*/
		( (ImageIcon)show_icon ).setImage( ( (ImageIcon)show_icon ).getImage().getScaledInstance(40,50,Image.SCALE_DEFAULT) );
		
		/*���XDialog����*/
		JOptionPane.showMessageDialog(null, "Wellcome", "�T��", JOptionPane.PLAIN_MESSAGE ,show_icon);
		
	}

}