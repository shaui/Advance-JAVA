package component.module;



import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private int x = 200;
	private int y = 200;
	public MyPanel() {
		setLayout(new FlowLayout());
		setBackground(java.awt.Color.lightGray);	
		
	}
	public int getX() 
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	public void setOwnLayout(int x,int y)
	{
		setLayout(null);
		setSize(200,200);
		setLocation(x,y);
	}
}
