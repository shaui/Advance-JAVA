/*���2B_106403540_���ӭ�*/
package call_order;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*�񺡫��s*/
public class Filler_Panel extends JPanel{

	public static JCheckBox filler ;
	private JLabel text;
	public static boolean state = false;
	
	public Filler_Panel()
	{
		setLayout(new GridLayout(2,1));
		
		/*���s���奻*/
		text = new JLabel("��");
		
		/*���s*/
		filler = new JCheckBox("");
		filler.addItemListener(new CheckBoxItemLis());
		filler.setEnabled(false);
		
		
		/*�[�J��Panel*/
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
