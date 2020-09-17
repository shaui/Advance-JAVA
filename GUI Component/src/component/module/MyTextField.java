package component.module;

import javax.swing.JTextField;

public class MyTextField extends JTextField{
	
	public MyTextField(int columns)
	{
		super(columns);
	}
	
	public MyTextField(String initial_text)
	{
		super(initial_text);
	}
	
	public MyTextField(String initial_text, int columns)
	{
		super(initial_text,columns);
	}
	
	public void setOwnLayout(int x,int y)
	{
		setSize(50,200);
		setLocation(x,y);
	}
	
	/*setEditable(Boolean editable)*/
}
