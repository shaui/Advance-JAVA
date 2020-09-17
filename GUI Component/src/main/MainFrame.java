package main;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import component.module.MyFrame;
import javafx.scene.control.ComboBox;

public class MainFrame extends MyFrame{
	
	private JComboBox<String> imageComboBox;
	private JLabel label;
	private String[] name = {"���","���J","��","��"};
	private Icon[] icon = {
			new ImageIcon(getClass().getResource("img1.jpg")),
			new ImageIcon(getClass().getResource("img2.jpg")),
			new ImageIcon(getClass().getResource("img3.jpg")),
			new ImageIcon(getClass().getResource("img4.jpg"))
	};
	
	public MainFrame()
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
