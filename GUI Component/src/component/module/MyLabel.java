package component.module;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyLabel extends JLabel{
	
	private static final long serialVersionUID = 1L;

	
	public MyLabel(String text,Icon image,int hAlign) {
		super(text,image,hAlign);
		
	}
	public void setOwnLayout(int x,int y)
	{
		setSize(100,100);
		setLocation(x,y);
	}
}
