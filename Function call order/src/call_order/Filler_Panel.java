/*資管2B_106403540_陳志剛*/
package call_order;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*填滿按鈕*/
public class Filler_Panel extends JPanel{

	public static JCheckBox filler ;
	private JLabel text;
	public static boolean state = false;
	
	public Filler_Panel()
	{
		setLayout(new GridLayout(2,1));
		
		/*按鈕的文本*/
		text = new JLabel("填滿");
		
		/*按鈕*/
		filler = new JCheckBox("");
		filler.addItemListener(new CheckBoxItemLis());
		filler.setEnabled(false);
		
		
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
				state = true;
			}
			else
			{
				state = false;
			}
			
		}		
	}
}
