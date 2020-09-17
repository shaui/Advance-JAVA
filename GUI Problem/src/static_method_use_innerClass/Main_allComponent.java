package static_method_use_innerClass;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import MyFrame.MyFrame;



public class Main_allComponent implements ItemListener{
	static JCheckBox check1;
	static JCheckBox check2;
	static JCheckBox check3;
	static JTextField text;
	static MyFrame frame;
	
	public static void main(String[] args) {
		//Icon img = new ImageIcon("C:\\Users\\Jonathan\\Desktop\\JAVAcourse\\Event\\Character\\img1.jpg");
		//Icon img2 = new ImageIcon("C:\\Users\\Jonathan\\Desktop\\JAVAcourse\\Event\\Character\\img2.jpg");
		frame = new MyFrame();
		
		text = new JTextField("The style");
		text.setFont(new Font("Serif",Font.ITALIC,18));
		
		check1 = new JCheckBox("Italic",true);
		check2 = new JCheckBox("Bold",false);
		
		
		Main_allComponent item =  new Main_allComponent();
		
		check1.addItemListener(item);
		check2.addItemListener(item);
	
		
		frame.add(text);
		frame.add(check1);
		frame.add(check2);
	
		
		frame.setVisible(true);
		
	
		}
	
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
