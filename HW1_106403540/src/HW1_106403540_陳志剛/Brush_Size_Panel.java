/*資管2B_106403540_陳志剛*/
package HW1_106403540_陳志剛;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/*筆刷大小*/
public class Brush_Size_Panel extends JPanel{
	
	private JRadioButton[] brush_size = new JRadioButton[3];
	private ButtonGroup single_select;
	private JLabel[] text = new JLabel[3];
	
	public Brush_Size_Panel()
	{
		setLayout(new GridLayout(2,3));
		
		
		text[0] = new JLabel("筆刷大小");
		/*為了排版用的2個空白區塊*/
		text[1] = new JLabel();
		text[2] = new JLabel();
		
		/*3個選項*/
		brush_size[0]= new JRadioButton("小",false);
		brush_size[1]= new JRadioButton("中",false);
		brush_size[2]= new JRadioButton("大",false);
		
		/*製作成單選*/
		single_select = new ButtonGroup();
		single_select.add(brush_size[0]);
		single_select.add(brush_size[1]);
		single_select.add(brush_size[2]);
		
		/*加入監聽器*/
		brush_size[0].addItemListener(new RadioBoxItemLis(0));
		brush_size[1].addItemListener(new RadioBoxItemLis(1));
		brush_size[2].addItemListener(new RadioBoxItemLis(2));
		
		/*放進Panel裡面*/
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
		private int order;
		
		/*為了獲取文本內容而設定參數 :順序*/
		public RadioBoxItemLis(int order)
		{
			this.order = order;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				System.out.println("選擇 " + brush_size[order].getText() + " 筆刷");
			}	
		}	
	}

}
