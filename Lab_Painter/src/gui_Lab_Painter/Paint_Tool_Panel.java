/*資管2B_106403540_陳志剛*/
package gui_Lab_Painter;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*繪圖工具*/
public class Paint_Tool_Panel extends JPanel{
	
	private JComboBox<String> paint_tool;
	private String[] brush_name = {"筆刷","直線","橢圓形","矩形","圓角矩形"};
	private JLabel text;
	
	public Paint_Tool_Panel()
	{	
		setLayout(new GridLayout(2,1));
			
		/*繪圖工具*/
		paint_tool = new JComboBox<String>(brush_name);
		paint_tool.setMaximumRowCount(3);
		paint_tool.addItemListener(new ItemLis());
		
		/*繪圖工具文本*/
		text = new JLabel("繪圖工具");
		
		/*加入至Panel*/
		add(text);
		add(paint_tool);
	}
	
	
	private class ItemLis implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				System.out.println("選擇 " + brush_name[paint_tool.getSelectedIndex()]);
			}	
			
		}
		
	}
}
