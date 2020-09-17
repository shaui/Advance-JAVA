package main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import component.module.MyButton;
import component.module.MyCheckBox;
import component.module.MyFrame;
import component.module.MyLabel;
import component.module.MyPanel;
import component.module.MyPasswordField;
import component.module.MyTextField;
import event.listener.ActionLis;

public class Problem1 {
	static MyCheckBox check1;
	static MyCheckBox check2;
	static MyCheckBox check3;
	static MyTextField text;
	static MyFrame frame;
	
	public static void main(String[] args) {
		//Icon img = new ImageIcon("C:\\Users\\Jonathan\\Desktop\\JAVAcourse\\Event\\Character\\img1.jpg");
		//Icon img2 = new ImageIcon("C:\\Users\\Jonathan\\Desktop\\JAVAcourse\\Event\\Character\\img2.jpg");
		frame = new MyFrame();
		
		text = new MyTextField("The stytle");
		text.setFont(new Font("Serif",Font.ITALIC,18));
		
		check1 = new MyCheckBox("Italic",true);
		check2 = new MyCheckBox("Bold",false);
		
		
		MyItemLis item = new Problem1().new MyItemLis();
		
		check1.addItemListener(item);
		check2.addItemListener(item);
	
		
		frame.add(text);
		frame.add(check1);
		frame.add(check2);
	
		
		frame.setVisible(true);
		
	
		}
	private class MyItemLis implements ItemListener
	{
		@Override
		public void itemStateChanged(ItemEvent e) {
			Font font = null;
			if(check1.isSelected() && check2.isSelected())
			{
				font = new Font("Serif",Font.ITALIC+Font.BOLD,18);
			}
			
			else if(check1.isSelected())
			{
				font = new Font("Serif",Font.ITALIC,18);
			}
			
			else if(check2.isSelected())
			{
				font = new Font("Serif",Font.BOLD,18);
			}
			
			else
			{
				font = new Font("Serif",Font.PLAIN,18);
			}
			text.setFont(font);
			
		}
		
		
		
		
		
		
		
		
	}
}
