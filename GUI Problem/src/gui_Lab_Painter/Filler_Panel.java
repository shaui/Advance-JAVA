/*���2B_106403540_���ӭ�*/
package gui_Lab_Painter;


import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*�񺡫��s*/
public class Filler_Panel extends JPanel{

	private JCheckBox filler ;
	private JLabel text;
	public Filler_Panel()
	{
		setLayout(new GridLayout(2,1));
		
		/*���s���奻*/
		text = new JLabel("��");
		
		/*���s*/
		filler = new JCheckBox("");
		filler.addItemListener(new CheckBoxItemLis());
		
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
				System.out.println("��� ��" );
			}
			else
			{
				System.out.println("���� ��");
			}
			
		}		
	}
}
