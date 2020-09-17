package component.module;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyComboBoxFrame extends MyFrame {
	private JComboBox<String> imageComboBox;
	private JLabel label;
	private String[] name = {"休比","里克","空","白"};
	private Icon[] icon = {
			new ImageIcon(getClass().getResource("img1.jpg")),
			new ImageIcon(getClass().getResource("img2.jpg")),
			new ImageIcon(getClass().getResource("img3.jpg")),
			new ImageIcon(getClass().getResource("img4.jpg"))
	};
	
	public MyComboBoxFrame()
	{
		imageComboBox = new JComboBox<String>(name);
		imageComboBox.addItemListener(new Itemhandler());
		imageComboBox.setMaximumRowCount(3);
		label = new JLabel(icon[0]);
		add(imageComboBox);
		add(label);
		
		
		setVisible(true);
	}
	
	private class Itemhandler implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				label.setIcon(icon[imageComboBox.getSelectedIndex()]);
			}	
		}
		
	}
}
