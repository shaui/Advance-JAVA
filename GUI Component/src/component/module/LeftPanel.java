package component.module;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LeftPanel extends JPanel{
	
	private JLabel lb;
	private JTextField textField;
	public LeftPanel() {
		lb = new JLabel("Contacts");
		lb.setFont(new Font("Dialog", 1, 30));
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(350,20));
		
		setLayout(new GridLayout(2,1,0,10));
		add(lb);
		add(textField);
	}

}
