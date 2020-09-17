package Test;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ColorTest extends MyFrame{
	JButton btn ;
	Color color;
	Container c;
	
	
	public ColorTest() {
		btn = new JButton("Color choose");
		btn.addActionListener(new ActLis());

		c = getContentPane();
		add(btn);
		setVisible(true);
	}
	
	
	public class ActLis implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			color = JColorChooser.showDialog(btn,"Choose one color you like", color);
			c.setBackground(color);
		}
		
	}
	
	public static void main(String[] args) {
		ColorTest c = new ColorTest();
	}
}
