/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.naming.SizeLimitExceededException;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


//Brush Size
public class Brush_Size_Panel extends JPanel{
	
	//set the button
	private JRadioButton[] brush_size = new JRadioButton[3];
	private ButtonGroup single_select;
	
	//set the button text
	private JLabel[] text = new JLabel[3];
	
	//the tool size data
	public static int sizeX = 7;
	public static int sizeY = 7;

	public Brush_Size_Panel()
	{
		setLayout(new GridLayout(2,3));
		
		text[0] = new JLabel("筆刷大小");
		/*為了排版用的2個空白區塊*/
		text[1] = new JLabel();
		text[2] = new JLabel();
		
		/*three select of the size*/
		brush_size[0]= new JRadioButton("小",false);
		brush_size[1]= new JRadioButton("中",true);
		brush_size[2]= new JRadioButton("大",false);
		
		/*make then become single-select*/
		single_select = new ButtonGroup();
		single_select.add(brush_size[0]);
		single_select.add(brush_size[1]);
		single_select.add(brush_size[2]);
		
		/*add the Listenter*/
		brush_size[0].addItemListener(new RadioBoxItemLis(0));
		brush_size[1].addItemListener(new RadioBoxItemLis(1));
		brush_size[2].addItemListener(new RadioBoxItemLis(2));
		
		/*add to the panel*/
		for(int i=0; i<text.length; i++)
		{
			add(text[i]);
		}
		for(int i=0; i<brush_size.length; i++)
		{
			add(brush_size[i]);
		}
	}
	
	private class RadioBoxItemLis implements ItemListener
	{
		//the button order
		private int order;
		
		//get the order
		public RadioBoxItemLis(int order) {
			this.order = order;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				//asign the size's data
				switch(order) {
					case 0:
						sizeX = 4;
						sizeY = 4;
						break;
					case 1:
						sizeX = 7;
						sizeY = 7;
						break;
					case 2:
						sizeX = 10;
						sizeY = 10;
						break;
				}
			}	
		}	
	}

}
