package MyFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class MyFrame extends JFrame{

	
	private static final long serialVersionUID = 1L;

	JButton btn;
	
	public MyFrame() {
		
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,640);
		setLocation((int)(ScreenSize.getX()*0.5)-320,(int)(ScreenSize.getY()*0.5)-320);
		
		JPanel p = new JPanel();
		add(p,BorderLayout.CENTER);
		
		btn = new JButton("btn");
		
		btn.setSize(50,1000);
		btn.setLocation(500, 500);
		
		add(btn);
		
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
