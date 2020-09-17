package component.module;

import javax.swing.Icon;
import javax.swing.JButton;

public class MyButton extends JButton{

	public MyButton(String text)
	{
		super(text);
	}
	public MyButton(Icon img)
	{
		super(img);
	}
	
	public MyButton(String text,Icon img)
	{
		super(text,img);
	}
	
	public void setOwnLayout(int x,int y)
	{
		setLayout(null); /*其實可以不用打*/
		setSize(100,100);
		setLocation(x,y);
	}
	
	/* setRolloverIcon(Icon img) : 
	  Display img whenever mouse is moved over the button,but only have the img in the button first*/
	/* Use the ActionListener */
}
