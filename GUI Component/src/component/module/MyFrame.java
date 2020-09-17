package component.module;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.ScreenSize;


public class MyFrame extends JFrame{

	
	private static final long serialVersionUID = 1L;

	
	
	public MyFrame() {
		setLayout(new FlowLayout());
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480,640);
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);	
		setVisible(true);
	}
	
	public void setFlowLayout()
	{
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,640);
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);
	}
	public void setOwnLayout()
	{
		setLayout(null);
		setSize(640,640);
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);
	}
}
