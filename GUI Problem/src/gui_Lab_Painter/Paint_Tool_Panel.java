/*���2B_106403540_���ӭ�*/
package gui_Lab_Painter;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*ø�Ϥu��*/
public class Paint_Tool_Panel extends JPanel{
	
	private JComboBox<String> paint_tool;
	private String[] brush_name = {"����","���u","����","�x��","�ꨤ�x��"};
	private JLabel text;
	
	public Paint_Tool_Panel()
	{	
		setLayout(new GridLayout(2,1));
			
		/*ø�Ϥu��*/
		paint_tool = new JComboBox<String>(brush_name);
		paint_tool.setMaximumRowCount(3);
		paint_tool.addItemListener(new ItemLis());
		
		/*ø�Ϥu��奻*/
		text = new JLabel("ø�Ϥu��");
		
		/*�[�J��Panel*/
		add(text);
		add(paint_tool);
	}
	
	
	private class ItemLis implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				System.out.println("��� " + brush_name[paint_tool.getSelectedIndex()]);
			}	
			
		}
		
	}
}
