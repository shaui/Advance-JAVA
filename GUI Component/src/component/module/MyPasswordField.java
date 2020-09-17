package component.module;

import javax.swing.JPasswordField;


public class MyPasswordField extends JPasswordField{
	
		
	public MyPasswordField(int columns)
	{
		super(columns);
	}

	public MyPasswordField(String initial_text)
	{
		super(initial_text);
	}

	public MyPasswordField(String initial_text, int columns)
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
