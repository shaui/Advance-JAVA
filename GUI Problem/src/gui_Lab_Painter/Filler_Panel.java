/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*填滿按鈕*/
public class Filler_Panel extends JPanel{

	private JCheckBox filler ;
	private JLabel text;
	public Filler_Panel()
	{
		setLayout(new GridLayout(2,1));
		
		/*按鈕的文本*/
		text = new JLabel("填滿");
		
		/*按鈕*/
		filler = new JCheckBox("");
		filler.addItemListener(new CheckBoxItemLis());
		
		/*加入至Panel*/
		add(text);
		add(filler);
	}
	
	private class CheckBoxItemLis implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				System.out.println("選擇 填滿" );
			}
			else
			{
				System.out.println("取消 填滿");
			}
			
		}		
	}
}
